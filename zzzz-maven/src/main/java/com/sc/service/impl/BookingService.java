package com.sc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sc.common.FlightException;
import com.sc.mapper.BookingMapper;
import com.sc.mapper.CustomerMapper;
import com.sc.mapper.FlightCarbinInfoMapper;
import com.sc.pojo.BookTicketInfo;
import com.sc.pojo.Customer;
import com.sc.pojo.FlightCarbinInfo;
import com.sc.service.BookingServiceIn;

@Service
public class BookingService implements BookingServiceIn{
	@Inject
	private FlightCarbinInfoMapper flightCarbinInfoMapper;
	@Inject
	private CustomerMapper customerMapper;
	@Inject
	private BookingMapper bookingMapper;
	
	@Transactional (propagation=Propagation.REQUIRED)//开启事务
	@Override
	public List<BookTicketInfo> booking(Long fid, Integer clid, String[] names, String[] idcards) {
		// TODO Auto-generated method stub
		FlightCarbinInfo condition = new FlightCarbinInfo();
		condition.setFid(fid);
		condition.setClid(clid);
		FlightCarbinInfo fc = null;
		while(true) {
		//根据航班编号和舱位等级编号查询出航班-舱位关系信息
		 fc = flightCarbinInfoMapper.selectOneByFidAndClid(condition);
		int seats = fc.getSeats();
		int buySeatsNum = names.length;
		//剩余座位数不够
		if(seats < buySeatsNum)
			throw new FlightException("error_seats");
		fc.setSeats(seats-buySeatsNum);
		//更新剩余座位数，加了乐观锁version判断
		int result = flightCarbinInfoMapper.updateSeatForVersion(fc);
		//表示更新成功
		if(result > 0) {
			break;
		}
		}
		List<BookTicketInfo> list = new ArrayList<>();
		//循环插入多个订单
		for (int i = 0; i < idcards.length; i++) {
			int count = customerMapper.selectCountByCardno(idcards[i]);
			long cid;
			Customer customer;
			//如果是新客户，需要加入客户表
			if(count == 0) {
			    customer = new Customer();
				customer.setCardno(idcards[i]);
				customer.setName(names[i]);
				 cid = customerMapper.sequenceNextVal();
				customer.setId(cid);
				customer.setVip("普通");
				//添加客户
				customerMapper.insertOne(customer);
			}
			//否则根据身份证号查询该客户的id
			else {
				 customer = customerMapper.selectOneByCardno(idcards[i]); 
			}
			BookTicketInfo bt = new BookTicketInfo();
			long id = bookingMapper.sequenceNextVal();
			bt.setId(id);
			bt.setBookDate(new Date());
			bt.setBtno("DD"+new Date().getTime());
			bt.setFcid(fc.getId());
			bt.setCustomer(customer);
			bt.setPayState(0);//表示未支付
			//机票原价
			double originalPrice = fc.getPrice();
			//实际价格
			double price;
			//计算会员价格
			switch(customer.getVip()) {
			case "钻石":price = originalPrice*0.6;
			break;
			case "白金":price = originalPrice*0.7;
			break;
			case "黄金":price = originalPrice*0.8;
			break;
			default:price = originalPrice;
			}
			bt.setPrice(price);
			//添加订单
			bookingMapper.insertOne(bt);
			list.add(bt);
		}
		return list;
	
	}
	
	@Override
	public Page<BookTicketInfo> queryListForPageCondition(int start, int pageSize,
			String orderColumn, String orderDir,
			String btno,Date bookDate,String fno,String cardno) {
		// MyBatis分页插件
		Page<BookTicketInfo> page = PageHelper.startPage(start/pageSize+1,pageSize);
		if(null != orderColumn) {
			page.setOrderBy(orderColumn+" "+orderDir);
		}
		Map<String,Object> map = new HashMap<>();
		map.put("btno", btno==null||btno.trim().equals("")?null:btno);
		map.put("bookDate", bookDate);
		map.put("fno", fno==null||fno.trim().equals("")?null:fno);
		map.put("cardno", cardno==null||cardno.trim().equals("")?null:cardno);
		bookingMapper.queryListByCondition(map);
		return page;
	}
	
    public void modPrice(BookTicketInfo bookTicket) {
    	bookingMapper.updatePrice(bookTicket);
   }

    @Override
	public void deleteOne(Long id) {
		bookingMapper.deleteOne(id);
	}
    
    @Override
   	public void deleteMany(List<Long> ids) {
   		bookingMapper.deleteMany(ids);
   	}
}

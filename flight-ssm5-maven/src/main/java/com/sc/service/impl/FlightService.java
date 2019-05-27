package com.sc.service.impl;

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
import com.sc.mapper.FlightCarbinInfoMapper;
import com.sc.mapper.FlightMapper;
import com.sc.pojo.BookTicketInfo;
import com.sc.pojo.FlightCarbinInfo;
import com.sc.pojo.FlightInfo;
import com.sc.service.FlightServiceIn;
@Service
public class FlightService implements FlightServiceIn{
	@Inject
    private FlightMapper flightMapper;
	@Inject
    private FlightCarbinInfoMapper flightCarbinInfoMapper;
	
	//条件查询
	@Override
	public List<FlightInfo> queryByCondition(String fromCity,String toCity,Date fromDate) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		map.put("fromCity", fromCity==null||fromCity.trim().equals("")?null:fromCity);
		map.put("toCity", toCity==null||toCity.trim().equals("")?null:toCity);
		map.put("fromDate", fromDate);
		return flightMapper.queryListByCondition(map);
	}
	//新增
	@Transactional (propagation=Propagation.REQUIRED)//开启事务
	public void insertOne(FlightInfo flight) {
		long fid = flightMapper.sequenceNextVal();
		flight.setId(fid);
		flightMapper.insertOne(flight);
		for (int i = 0; i < flight.getFcList().size(); i++) {
			FlightCarbinInfo fc = flight.getFcList().get(i);
			fc.setClid(3-i);
			fc.setFid(fid);
			fc.setVersion(0);
			flightCarbinInfoMapper.insertOne(fc);
		}
	}
	
	public boolean checkFno(String fno,Date fromDate) {
		Map<String,Object> map = new HashMap<>();
		map.put("fno", fno);
		map.put("fromDate", fromDate);
		int count = flightMapper.selectCountByFnoAndFromDate(map);
		return count == 0;
	}
	
	//查询单个
	@Override
	public FlightInfo queryById(Long id) {
		// TODO Auto-generated method stub
		return flightMapper.selectById(id);
	}
	
	//根据id和舱位id查询单个
    @Override
	public FlightInfo queryByIdAndClid(Long id,Integer clid) {
    	    Map<String,Object> map = new HashMap<String,Object>();
    	    map.put("id", id);
    	    map.put("clid", clid);
			return flightMapper.selectByIdAndClid(map);
	}
	
	//修改
	@Transactional (propagation=Propagation.REQUIRED)//开启事务
	public void modifyOne(FlightInfo flight) {
		flightMapper.updateOne(flight);
		//更新舱位信息
		for (int i = 0; i < flight.getFcList().size(); i++) {
			FlightCarbinInfo jingjiFc = flight.getFcList().get(i);
			jingjiFc.setClid(3-i);
			jingjiFc.setFid(flight.getId());
			jingjiFc.setSeats(flight.getFcList().get(i).getSeats());
			jingjiFc.setPrice(flight.getFcList().get(i).getPrice());
			flightCarbinInfoMapper.updateOne(jingjiFc);
		}
	}
	//删除多个
	@Transactional (propagation=Propagation.REQUIRED)//开启事务
	@Override
	public void deleteMany(List<Long> ids) {
		flightCarbinInfoMapper.deleteByFids(ids);
		flightMapper.deleteMany(ids);
	}
	//删除一个
	@Transactional (propagation=Propagation.REQUIRED)//开启事务
	@Override
	public void deleteOne(Long id) {
		flightCarbinInfoMapper.deleteByFid(id);
		flightMapper.deleteOne(id);
	}
	
	    //N+1条件查询
		@Override
		public Page<FlightInfo> queryByConditionN1(int start, int pageSize,
				String orderColumn, String orderDir,
				String fromCity,String toCity,Date fromDate) {
			// MyBatis分页插件
			Page<FlightInfo> page = PageHelper.startPage(start/pageSize+1,pageSize);
			if(null != orderColumn) {
				page.setOrderBy(orderColumn+" "+orderDir);
			}
			Map<String,Object> map = new HashMap<>();
			map.put("fromCity", fromCity==null||fromCity.trim().equals("")?null:fromCity);
			map.put("toCity", toCity==null||toCity.trim().equals("")?null:toCity);
			map.put("fromDate", fromDate);
		    flightMapper.queryListByConditionN1(map);
		    return page;
		}
}

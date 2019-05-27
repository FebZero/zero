package com.sc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.sc.common.DataTableEditorJSON;
import com.sc.common.DataTableJSON;
import com.sc.pojo.BookTicketInfo;
import com.sc.pojo.FlightInfo;
import com.sc.service.BookingServiceIn;
import com.sc.service.FlightServiceIn;
import com.sc.vo.BookingInfoVo;

@Controller
@RequestMapping("/booking")
public class BookingController {
	@Inject
    private FlightServiceIn flightService;
	@Inject
    private BookingServiceIn bookingService;
	
	@RequestMapping("/pre")
	public String preBooking(Long fid,Integer clid,Model model) {
		try {
			FlightInfo flight = flightService.queryByIdAndClid(fid, clid);
			model.addAttribute("f", flight);
			return "flight/bookticket";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/add")
	public String booking(BookingInfoVo biv, Long fid,Integer clid,String[] name,
			String[] idcard,Model model) {
		try {
			System.out.println(biv);
			List<BookTicketInfo> list = bookingService.booking(fid, clid, name, idcard);
			model.addAttribute("biv", biv);
			model.addAttribute("blist", list);
			return "flight/pay";
		} catch (Exception e) {
			e.printStackTrace();
			if("error_seats".equals(e.getMessage())) {
				model.addAttribute("info", "剩余座位数不够");
			}
			else{
				model.addAttribute("info", "系统内部异常");
			}
			return "error";
		}
	}
	
	@RequestMapping("/tomain")
	public String toquery() {
		return "booking/booking_mng";
	}
	
	@ResponseBody
	@RequestMapping("/query")
	public DataTableJSON<BookTicketInfo> query(int draw,int start,int length,
			@RequestParam(name="order[0][column]")String orderColumn, 
			@RequestParam(name="order[0][dir]")String orderDir,
			String btno,
			@DateTimeFormat(pattern="yyyy-MM-dd")
			Date bookDate,String fno,String cardno,
			Model model) {
		try {
			System.out.println("orderColumn="+orderColumn);
			System.out.println("start="+start);
			System.out.println("length="+length);
			System.out.println("btno="+btno);
			System.out.println("bookDate="+bookDate);
			System.out.println("fno="+fno);
			System.out.println("cardno="+cardno);
			 //定义列名-对应sql语句里的字段
		    String[] cols = {"btno", "bookDate", 
		    		"price","f.fno","fc.seats",
		    		"c.name","c.cardno"};
		    orderColumn = cols[Integer.parseInt(orderColumn)];
		    //MyBatis分页
		    Page<BookTicketInfo> page = bookingService.queryListForPageCondition(
		    		start, length, orderColumn, orderDir, btno, bookDate, fno, cardno);
		    DataTableJSON<BookTicketInfo> json = new DataTableJSON<>();
		    json.setDraw(draw);
		    json.setData(page.getResult());
		    //条件过滤后的总结果数
		    json.setRecordsFiltered(page.getTotal());
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 基于Datatables Editor插件 inline风格的数据修改和删除
	 * @param action
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/edit")
	public DataTableEditorJSON<BookTicketInfo> edit(String action,HttpServletRequest request) {
		DataTableEditorJSON<BookTicketInfo> json = new DataTableEditorJSON<>();
		try {
			Enumeration<String> names =  request.getParameterNames();
			List<BookTicketInfo> list = new ArrayList<>();
			/*
			 * 对于修改，提交的参数形式为
			 * action:edit
			 * data[1][price]:3333
			 */
			if("edit".equals(action)){
			while(names.hasMoreElements()) {
				String paramName = names.nextElement();
				if(paramName.startsWith("data")) {
					Long id = Long.valueOf(paramName.substring(paramName.indexOf("[")+1,
							paramName.indexOf("][")));
					System.out.println(id);
					Double price = Double.valueOf(request.getParameter(paramName));
					System.out.println(price);
					BookTicketInfo bookTicket = new BookTicketInfo();
					bookTicket.setId(id);
					bookTicket.setPrice(price);
					bookingService.modPrice(bookTicket);
					list.add(bookTicket);
				}
			}
			//需要将修改后的值传递回去，否则页面不会改变
			json.setData(list);
			}
			/*
			 * 对于删除，提交的参数形式为
			 * action:remove
			 *	data[1][id]:1
			 *	data[1][btno]:DD1544256828143
			 *	data[1][bookDate]:2018-12-08T08:13
			 *	data[1][payState]:0
			 *	data[1][fcid]:
			 *	data[1][cid]:
			 *	data[1][price]:444.3
			 *	data[1][custome
			 */
			else if("remove".equals(action)) {
				List<Long> ids = new ArrayList<>();
				while(names.hasMoreElements()) {
					String paramName = names.nextElement();
					if(paramName.startsWith("data") && paramName.indexOf("[id]")!=-1) {
						Long id = Long.valueOf(request.getParameter(paramName));
						System.out.println(id);
						ids.add(id);
					}
				}
				if(ids.size()==1) {
					bookingService.deleteOne(ids.get(0));
				}
				else {
					bookingService.deleteMany(ids);
				}
			}
			return json;
		} catch (Exception e) {
//			json.addfieldError("price", "必须是数字");      
			json.setError("删除失败,系统异常");
			return json;
		}
	}
}
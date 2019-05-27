package com.sc.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.sc.common.DataTableJSON;
import com.sc.common.JSONResult;
import com.sc.pojo.FlightInfo;
import com.sc.service.FlightServiceIn;

@Controller
@RequestMapping("/flight")
public class FlightController {
    @Inject
	private FlightServiceIn flightService;
	
    //跳到航班主页面
	@RequestMapping("/tomain")
	public String toquery() {
		return "flight/flight_mng";
	}
	
	//分页查询
	@ResponseBody
	@RequestMapping("/query")
	public DataTableJSON<FlightInfo> query(int draw,
			int start,int length,
			@RequestParam(name="order[0][column]")String orderColumn, 
			@RequestParam(name="order[0][dir]")String orderDir,
			String fromCity,
			String toCity,
			//Date类型格式化，如果不格式化对于空值将报错
			@DateTimeFormat(pattern="yyyy-MM-dd")
			Date fromDate,
			Model model) {
		try {
			 //定义列名-对应sql语句里的字段
		    String[] cols = {null, "fno", 
		    		"ftype","fromCity","toCity",
		    		"fromDate","toDate",null};
		    orderColumn = cols[Integer.parseInt(orderColumn)];
		    //MyBatis分页
		    Page<FlightInfo> page = flightService.queryByConditionN1(start, length, orderColumn,
		    		orderDir, fromCity, toCity, fromDate);
		    DataTableJSON<FlightInfo> json = new DataTableJSON<>();
		    json.setDraw(draw);//版本号，防止黑客非法访问
		    json.setData(page.getResult());
		    System.out.println(page.getResult());
		    //条件过滤后的总结果数
		    json.setRecordsFiltered(page.getTotal());
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//校验航班编号
	@RequestMapping("/checkfno")
	@ResponseBody
	public Map<String,Boolean> checkfno(String fno,
			@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	        Date fromDate) {
		Map<String,Boolean> jsonMap = new HashMap<>();
		try {
			System.out.println(fno);
			System.out.println(fromDate);
			boolean result = flightService.checkFno(fno, fromDate);
			System.out.println("result="+result);
			if(result) {
				jsonMap.put("valid", true);
			}
			else {
				jsonMap.put("valid", false);
			}
			return jsonMap;
		} catch (Exception e) {
			jsonMap.put("valid", false);
			e.printStackTrace();
			return jsonMap;
		}
	}
	
	//添加航班
	@RequestMapping("/add")
	@ResponseBody
	public JSONResult add(FlightInfo flight) {
		try {
			System.out.println(flight);
			System.out.println(flight.getFcList());
			flightService.insertOne(flight);
			JSONResult jr = new JSONResult();
			jr.setOk(true);
			jr.setInfo("添加成功");
			return jr;
		} catch (Exception e) {
			e.printStackTrace();
			JSONResult jr = new JSONResult();
			jr.setOk(false);
			jr.setInfo("添加失败");
			return jr;
		}
	}
	
	//修改航班
	@RequestMapping("/mod")
	@ResponseBody
	public JSONResult update(FlightInfo flight) {
		try {
			System.out.println(flight);
			System.out.println(flight.getFcList());
			flightService.modifyOne(flight);
			JSONResult jr = new JSONResult();
			jr.setOk(true);
			jr.setInfo("修改成功");
			return jr;
		} catch (Exception e) {
			e.printStackTrace();
			JSONResult jr = new JSONResult();
			jr.setOk(false);
			jr.setInfo("修改失败");
			return jr;
		}
	}
	
	//航班详情
	@RequestMapping("/detail")
	@ResponseBody
	public FlightInfo detail(Long id) {
		try {
			FlightInfo flight = flightService.queryById(id);
			return flight;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//删除航班
	@ResponseBody
	@RequestMapping("/del")
	public JSONResult del(Long[] id, Model model) {
		try {
			if(id.length == 1)
				flightService.deleteOne(id[0]);
			else
				flightService.deleteMany(Arrays.asList(id));
			JSONResult jr = new JSONResult();
			jr.setOk(true);
			jr.setInfo("删除成功");
			return jr;
		} catch (Exception e) {
			e.printStackTrace();
			JSONResult jr = new JSONResult();
			jr.setOk(false);
			jr.setInfo("删除失败");
			return jr;
		}
	}

	
}

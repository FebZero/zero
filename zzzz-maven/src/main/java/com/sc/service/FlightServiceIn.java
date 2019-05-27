package com.sc.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.sc.pojo.BookTicketInfo;
import com.sc.pojo.FlightCarbinInfo;
import com.sc.pojo.FlightInfo;

public interface FlightServiceIn {
	
	boolean checkFno(String fno,Date fromDate);
	
	List<FlightInfo> queryByCondition(String fromCity,String toCity,Date fromDate);
	@Transactional
	void insertOne(FlightInfo flight);
	
	FlightInfo queryById(Long id);
	
	void modifyOne(FlightInfo flight);
	
	void deleteMany(List<Long> ids);
	
	void deleteOne(Long id);
	
	FlightInfo queryByIdAndClid(Long id,Integer clid);
	
	Page<FlightInfo> queryByConditionN1(int start, int pageSize,
			String orderColumn, String orderDir,
			String fromCity,String toCity,Date fromDate);
}

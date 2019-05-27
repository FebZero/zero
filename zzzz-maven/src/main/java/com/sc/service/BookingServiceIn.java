package com.sc.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.Page;
import com.sc.pojo.BookTicketInfo;

public interface BookingServiceIn {

	List<BookTicketInfo> booking(Long fid,Integer clid,String[] name,String[] idcard);
	
	Page<BookTicketInfo> queryListForPageCondition(int start, int pageSize,
			String orderColumn, String orderDir,
			String btno,Date bookDate,String fno,String cardno);
	
	void modPrice(BookTicketInfo bookTicket);
	
	void deleteOne(Long id);
	
	void deleteMany(List<Long> ids);
}

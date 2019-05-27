package com.sc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sc.pojo.BookTicketInfo;

public interface BookingMapper {
	
	@Select("select se_bookticketinfo.nextval from dual")
	public long sequenceNextVal();

	@Insert("insert into bookticketinfo values(se_bookticketinfo.nextval,"
			+ "#{btno},#{bookDate},#{payState},#{fcid},#{customer.id},#{price})")
	void insertOne(BookTicketInfo bookTicket);
	
	List<BookTicketInfo> queryListByCondition(Map<String,Object> conditionMap);
	
	@Update("update bookticketinfo set price=#{price} where id=#{id}")
	void updatePrice(BookTicketInfo bookTicket);
	
	@Delete("delete from bookticketinfo where id=#{id}")
	public void deleteOne(Long id);
	
	void deleteMany(List<Long> ids);
}

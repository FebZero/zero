package com.sc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sc.pojo.FlightInfo;

public interface FlightMapper {

	 List<FlightInfo> queryListByCondition(Map<String,Object> conditionMap);

	 @Select("select count(1) from flightinfo where fno=#{fno} "
	 		+ " and trunc(fromdate,'DD') = trunc(#{fromDate},'DD')")
	 int selectCountByFnoAndFromDate(Map<String,Object> conditionMap);
	
	@Insert("insert into flightinfo values(#{id},#{fno},#{fromDate},"
			+ "#{toDate},#{routeId},#{planeId},#{type})")
     void insertOne(FlightInfo flight);
	

	@Update("update flightinfo set id=#{id},fno=#{fno},fromdate=#{fromDate},"
			+ "todate=#{toDate},routeid=#{routeId},planeid=#{planeId},type=#{type}"
			+ " where id=#{id}")
     void updateOne(FlightInfo flight);
	
	@Select("select se_flightinfo.nextval from dual")
	 long sequenceNextVal();
	
	 FlightInfo selectById(Long id);
	
	 void deleteMany(List<Long> ids);
	
	@Delete("delete from flightinfo where id=#{id}")
	public void deleteOne(Long id);
	
	FlightInfo selectByIdAndClid(Map<String,Object> map);
	
	List<FlightInfo> queryListByConditionN1(Map<String,Object> conditionMap);
	
}

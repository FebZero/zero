package com.sc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sc.pojo.FlightCarbinInfo;

public interface FlightCarbinInfoMapper {


	@Select("insert into flightcarbininfo values(#{fid},#{clid},#{seats,jdbcType=NUMERIC},"
			+ "#{price,jdbcType=NUMERIC},se_flightcarbininfo.nextval,#{version})")
    public void insertOne(FlightCarbinInfo fc);
	
	@Update("update flightcarbininfo set seats=#{seats,jdbcType=NUMERIC},"
			+ "price=#{price,jdbcType=NUMERIC} "
			+ "where fid=#{fid} and clid=#{clid}")
	public void updateOne(FlightCarbinInfo fc);
	
	public void deleteByFids(List<Long> fids);
	
	@Delete("delete from flightcarbininfo where fid=#{fid}")
	public void deleteByFid(Long fid);
	
	@Select("select id from flightcarbininfo where fid=#{fid} and clid=#{clid}")
	public Long selectIdByFidAndClid(FlightCarbinInfo fc);
	
	@Select("select id,fid,clid,seats,price,version from flightcarbininfo where"
			+ " fid=#{fid} and clid=#{clid}")
	public FlightCarbinInfo selectOneByFidAndClid(FlightCarbinInfo fc);
	
	//加了乐观锁
	@Update("update flightcarbininfo fc set seats=#{seats},version=version+1 where fc.id=#{id} and version=#{version}")
	int updateSeatForVersion(FlightCarbinInfo fc);
}

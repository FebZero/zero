package com.sc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sc.pojo.Customer;

public interface CustomerMapper {
	
	@Select("select se_customerinfo.nextval from dual")
	public long sequenceNextVal();

	@Insert("insert into customerinfo values(#{id},"
			+ "#{name},#{cardno},#{phone,jdbcType=VARCHAR},"
			+ "#{email,jdbcType=VARCHAR},#{address,jdbcType=VARCHAR},"
			+ "#{ctid,jdbcType=NUMERIC},#{vip,jdbcType=VARCHAR})")
	void insertOne(Customer customer);
	
	@Select("select count(1) from customerinfo where cardno=#{cardno}")
	int selectCountByCardno(String cardno);
	
	@Select("select * from customerinfo where cardno=#{cardno}")
	Customer selectOneByCardno(String cardno);
}


package com.sc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface PlaneMapper {

	@Select("select id as \"id\",planeno||'-'||type as \"text\" from planeinfo")
	public List<Map<String,Object>> queryAllPlaneForSelect();

}

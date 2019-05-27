package com.sc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface RouteMapper {
	//为了生成航线下拉框
	@Select("select id as \"id\",fromcity||'->'||tocity as \"text\" from routeinfo")
	public List<Map<String,Object>> queryAllRouteForSelect();

}

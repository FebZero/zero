package com.sc.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sc.mapper.RouteMapper;
import com.sc.service.RouteServiceIn;
@Service
public class RouteService implements RouteServiceIn{
	@Inject
	private RouteMapper routeMapper;
	@Override
	public List<Map<String,Object>> queryAllForFormSelect() {
		return routeMapper.queryAllRouteForSelect();
	}

	
}

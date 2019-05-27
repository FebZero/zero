package com.sc.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sc.mapper.PlaneMapper;
import com.sc.service.PlaneServiceIn;
@Service
public class PlaneService implements PlaneServiceIn{
	@Inject
	private PlaneMapper planeMapper;
	@Override
	public List<Map<String, Object>> queryAllForFormSelect() {
		return planeMapper.queryAllPlaneForSelect();
	}

}

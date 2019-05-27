package com.sc.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.service.RouteServiceIn;

@Controller
@RequestMapping("/route")
public class RouteController {
	
	@Inject
	private RouteServiceIn routeService;
	@ResponseBody
	@RequestMapping("/ajax4select2")
	public List<Map<String,Object>> query() {
		try {
			return routeService.queryAllForFormSelect();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

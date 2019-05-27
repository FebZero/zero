package com.sc.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.service.PlaneServiceIn;

@Controller
@RequestMapping("/plane")
public class PlaneController {
	
	@Inject
	private PlaneServiceIn planeService;
	@ResponseBody
	@RequestMapping("/ajax4select2")
	public List<Map<String,Object>> query() {
		try {
			return planeService.queryAllForFormSelect();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

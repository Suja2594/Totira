package com.example.MLSfinal.controller;

import java.util.ArrayList;



import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MLSfinal.model.MLSData;
import com.example.MLSfinal.service.MLSService;

@RestController
@RequestMapping("/api")
public class MLSController {
	
	@Autowired
	MLSService mlsService;
	
		
		//Search based on Criteria
		
		@GetMapping("/criteria")
		public List<MLSData> findByCriteria(@RequestParam(name="city")String city,@RequestParam(required = false) String bedroom, @RequestParam(required = false) String minRent,
				@RequestParam(required = false) String maxRent){
			
			return mlsService.getCriteria(city, bedroom, minRent, maxRent);
			
			
			
		
			
		}
		
		
	
	
}



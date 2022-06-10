package com.example.MLSfinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.MLSfinal.model.MLSData;
import com.example.MLSfinal.repo.MLSRepository;

@Service
public class MLSService {
	
	@Autowired
	MongoTemplate mongoTemplate;

	
//	@Autowired
//	private MLSRepository mlsRepository;

	public List<MLSData> getCriteria(String city, String bedroom, String minRent, String maxRent) {

		Query query= new Query();
		final List<Criteria> criterias=new ArrayList<>();
		if(city !=null && !city.isEmpty())
			criterias.add(Criteria.where("Area").is(city));
		if(bedroom !=null && !bedroom.isEmpty())
			criterias.add(Criteria.where("Br").is(Integer.parseInt(bedroom)));
		if(minRent !=null && !minRent.isEmpty())
			criterias.add(Criteria.where("Lp_dol").gte(Double.parseDouble(minRent)));
		//	query.with(Sort.by(Sort.Order.asc(minRent)));
		if(maxRent !=null && !maxRent.isEmpty())
			criterias.add(Criteria.where("Lp_dol").lte(Double.parseDouble(maxRent)));


		if(!criterias.isEmpty())
	
			query.addCriteria(new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()])));
		//query.addCriteria(Criteria.where("Lp_dol").is(minRent)).with(Sort.by(Sort.Direction.ASC,"Lp_dol"));
		
		return mongoTemplate.find(query, MLSData.class);

		
		
}
}

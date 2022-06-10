package com.example.MLSfinal.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.MLSfinal.model.MLSData;


public interface MLSRepository extends MongoRepository<MLSData, String> {

	
	
	
}



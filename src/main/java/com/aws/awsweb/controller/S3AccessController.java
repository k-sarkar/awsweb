package com.aws.awsweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.awsweb.services.S3Service;
import com.aws.awsweb.services.S3ServiceV1;

@RestController
public class S3AccessController {
	
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private S3ServiceV1 s3ServiceV1;
	
	@GetMapping("/s3/objectnames/v2")
	public List<String> getListofObjectsV2(){
		
		return s3Service.readS3BucketContent();
	}
	

	@GetMapping("/s3/objectnames/v1")
	public List<com.aws.awsweb.pojo.S3Objects> getListofObjectsV1(){
		
		return s3ServiceV1.readS3BucketContent();
	}

}

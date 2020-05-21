package com.aws.awsweb.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Component
public class S3ServiceV1 {
	
	
	public List<com.aws.awsweb.pojo.S3Objects> readS3BucketContent() {
		
		List<com.aws.awsweb.pojo.S3Objects> s3objects = new ArrayList<com.aws.awsweb.pojo.S3Objects>();
		
		
		  final AmazonS3 s3 =  AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
		  ListObjectsV2Result result = s3.listObjectsV2("sfassignment");
		  List<S3ObjectSummary> objects = result.getObjectSummaries();
		  
		  
		  for (S3ObjectSummary os : objects) {
			  // System.out.println("* " +  os.getKey()); // os. 
			  com.aws.awsweb.pojo.S3Objects s3obj = new com.aws.awsweb.pojo.S3Objects();
			  s3obj.setFileName(os.getKey()); 
			  s3obj.setSize(String.valueOf(os.getSize()));
			  if(os.getOwner() != null)s3obj.setOwner(os.getOwner().getDisplayName()); 
			  if(os.getETag() != null)s3obj.seteTag(os.getETag());
		  
		  try { 
			  S3Object o = s3.getObject("sfassignment", os.getKey());
			  S3ObjectInputStream s3is = o.getObjectContent(); 
			  
			  if(s3is != null) {
				  
				
				  String content = IOUtils.toString(s3is, StandardCharsets.UTF_8.name());
			
				  s3obj.setContent(content);
			  }
			  
			  s3is.close(); 
			   
			}catch  (AmazonServiceException e) {
				System.err.println(e.getErrorMessage());
				System.exit(1); 
			} catch (FileNotFoundException e) {
			  System.err.println(e.getMessage()); System.exit(1); 
			} catch (IOException e) {
			  System.err.println(e.getMessage()); System.exit(1); 
			}
		  
		  s3objects.add(s3obj);
		  
		}
		 
		
		return s3objects;
		
	}

}

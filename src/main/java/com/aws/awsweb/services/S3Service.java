package com.aws.awsweb.services;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/*import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.S3Object;*/

@Component
public class S3Service {

	//private S3Client s3;

	public List<String> readS3BucketContent() {

		List<String> contentList = new ArrayList<String>();

		
		/*
		 * Region region = Region.US_EAST_1;
		 * 
		 * s3 = S3Client.builder().region(region).build(); String bucketName =
		 * "sfassignment";
		 * 
		 * 
		 * ListObjectsV2Request listObjectsReqManual = ListObjectsV2Request.builder()
		 * .bucket(bucketName) .maxKeys(1) .build();
		 * 
		 * boolean done = false; while (!done) { ListObjectsV2Response listObjResponse =
		 * s3.listObjectsV2(listObjectsReqManual);
		 * 
		 * for (S3Object content : listObjResponse.contents()) { //content.
		 * contentList.add(content.key());
		 * 
		 * GetObjectResponse res =
		 * s3.getObject(GetObjectRequest.builder().bucket(bucketName).key(content.key())
		 * .build(), ResponseTransformer.toFile(Paths.get("multiPartKey"))); //res. }
		 * 
		 * if (listObjResponse.nextContinuationToken() == null) { done = true; }
		 * 
		 * listObjectsReqManual = listObjectsReqManual.toBuilder()
		 * .continuationToken(listObjResponse.nextContinuationToken()) .build(); }
		 */
		  
		return contentList;

		  
	}

}

package S3;



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;

import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;


public class Test {
	
	
	
	//auth
	String awsAccessKey = null;
	String awsSecretKey = null;
	AWSCredentials awsCredentials = null;
	S3Service s3Service = null;
	
	//s3bucket
	S3Bucket[] myBuckets = null;
	S3Bucket testBucket = null;
	
	//s3object
	S3Object object = null;
	
	//downloadObject
	S3Object objectDownload = null;
	
	public Test(){
		awsAccessKey = "AKIAJVABUHQ7XPW6LHPA";
		awsSecretKey = "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";
		awsCredentials = new AWSCredentials(awsAccessKey, awsSecretKey);
		s3Service = new RestS3Service(awsCredentials);
	}
	
	public void count() throws S3ServiceException{
		
		myBuckets = s3Service.listAllBuckets();
		System.out.println("How many buckets to I have in S3? " + myBuckets.length);
	}
	
	public void createBucket() throws S3ServiceException{
		testBucket = s3Service.createBucket("dsfdsfsdfsfsfsdsffsd");
		System.out.println("Created test bucket: " + testBucket.getName());
	}
	
	public void upoadObj() throws S3ServiceException, NoSuchAlgorithmException, IOException{
		File fileData = new File("/Users/yangbo/Desktop/people.xml");
		S3Object fileObject = new S3Object(fileData);
		testBucket = new S3Bucket("AnvatoTest");
		s3Service.putObject(testBucket, fileObject);
	}
	
	public void get() throws ServiceException, IOException{
		S3Object objectDownload = s3Service.getObject(new S3Bucket("AnvatoTest"), "people.xml");
		System.out.println("S3Object, complete: " + objectDownload);
		System.out.println("Greeting:");
		BufferedReader reader = new BufferedReader(
		    new InputStreamReader(objectDownload.getDataInputStream()));
		String data = null;
		while ((data = reader.readLine()) != null) {
		    System.out.println(data);
		}
	}
	
	public static void main(String [] args) throws NoSuchAlgorithmException, IOException, ServiceException {
		Test t = new Test();
		//t.createBucket();
		t.upoadObj();
		//t.count();
		t.get();
		
	}
}

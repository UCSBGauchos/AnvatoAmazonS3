package S3;



import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.security.AWSCredentials;


public class Test {
	public static void main(String [] args) throws S3ServiceException{
		String awsAccessKey = "AKIAJVABUHQ7XPW6LHPA";
		String awsSecretKey = "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";
		AWSCredentials awsCredentials = new AWSCredentials(awsAccessKey, awsSecretKey);
		S3Service s3Service = new RestS3Service(awsCredentials);
		S3Bucket[] myBuckets = s3Service.listAllBuckets();
		System.out.println("How many buckets to I have in S3? " + myBuckets.length);
	}
}

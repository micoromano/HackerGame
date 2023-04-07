package com.accenture.hacker.game.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accenture.hacker.game.entity.Credentials;
import com.accenture.hacker.game.entity.CredentialsRepository;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
public class DynamoDBConfig {

	@Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(AWSCredentialsProvider awsCredentialsProvider) {
        AmazonDynamoDB amazonDynamoDB 
          = AmazonDynamoDBClientBuilder.standard()
          .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint, "us-west-2"))
          .withCredentials(awsCredentialsProvider).build();

        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey));
    }
	
    @Bean()
    public CredentialsRepository repo() {
    	CredentialsRepository bean = new CredentialsRepository() {
			
			public <S extends Credentials> Iterable<S> saveAll(Iterable<S> entities) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public <S extends Credentials> S save(S entity) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Optional<Credentials> findById(String id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Iterable<Credentials> findAllById(Iterable<String> ids) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Iterable<Credentials> findAll() {
				// TODO Auto-generated method stub
				return null;
			}
			public boolean existsById(String id) {
				// TODO Auto-generated method stub
				return false;
			}
			
			public void deleteById(String id) {
				// TODO Auto-generated method stub
				
			}
			
			public void deleteAll(Iterable<? extends Credentials> entities) {
				// TODO Auto-generated method stub
				
			}
			
			public void deleteAll() {
				// TODO Auto-generated method stub
				
			}
			
			public void delete(Credentials entity) {
				// TODO Auto-generated method stub
				
			}
			
			public long count() {
				// TODO Auto-generated method stub
				return 0;
			}

			public void deleteAllById(Iterable<? extends String> ids) {
				// TODO Auto-generated method stub
				
			}
		};
		return bean;
    	
    }
    
}

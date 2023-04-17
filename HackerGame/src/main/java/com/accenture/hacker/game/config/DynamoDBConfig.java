package com.accenture.hacker.game.config;

import java.util.List;
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
				return null;
			}
			
			public <S extends Credentials> S save(S entity) {
				return null;
			}
			
			public Optional<Credentials> findById(String id) {
				return null;
			}
			
			public Iterable<Credentials> findAllById(Iterable<String> ids) {
				return null;
			}
			
			public Iterable<Credentials> findAll() {
				return null;
			}
			public boolean existsById(String id) {
				return false;
			}
			
			public void deleteById(String id) {
				
			}
			
			public void deleteAll(Iterable<? extends Credentials> entities) {
				
			}
			
			public void deleteAll() {
				
			}
			
			public void delete(Credentials entity) {
				
			}
			
			public long count() {
				return 0;
			}

			public void deleteAllById(Iterable<? extends String> ids) {				
			}

			@Override
			public List<Credentials> sqlInjection(String groupName) {
				return null;
			}
		};
		return bean;
    	
    }
    
}

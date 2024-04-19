package com.dm.springbootjpapostgresql.service.HttpClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class OkHttpClientService2 {

private static final Logger logger = LoggerFactory.getLogger(OkHttpClientService2.class);
    
//private final OkHttpClient client = new OkHttpClient(); 


public void RestTest1() throws IOException{

System.out.println("test");

OkHttpClient client = new OkHttpClient.Builder()
                                    .readTimeout(1000, TimeUnit.MILLISECONDS)
                                    .writeTimeout(1000, TimeUnit.MILLISECONDS)
                                    .build();

MediaType mediaType = MediaType.parse("application/vnd.ni-identity.v1+json");
@SuppressWarnings("deprecation")
RequestBody body = RequestBody.create(mediaType, "{\"grant_type\":\"client_credentials\",\"realmName\":\"ni\"}");
Request request = new Request.Builder()
  .url("https://api-gateway.sandbox.ngenius-payments.com/identity/auth/access-token")
  .post(body)
  .addHeader("accept", "application/vnd.ni-identity.v1+json")
  .addHeader("Authorization", "Basic ==")
  .addHeader("content-type", "application/vnd.ni-identity.v1+json")
  .build();

logger.info("request:",request.toString());
System.out.println("Request:"+request.toString());

Response response = client.newCall(request).execute();
logger.info("response:",response.toString());
System.out.println("response:"+response.toString());

logger.info("isSuccessful:",response.isSuccessful());
System.out.println("isSuccessful:"+response.isSuccessful());

logger.info("response code:",response.code());
System.out.println("response code:"+response.code());

String responseBody = response.body().string();
logger.info("body:",responseBody);
System.out.println("body:"+responseBody);

System.out.println("test");

}

public void RestTest2() throws IOException {
    String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

    // Create a new OkHttpClient for making HTTP requests
    OkHttpClient client = new OkHttpClient.Builder()
    .readTimeout(1000, TimeUnit.MILLISECONDS)
    .writeTimeout(1000, TimeUnit.MILLISECONDS)
    .build();

    // Build the request with URL
    Request request = new Request.Builder()
            .url(apiUrl)
            .build();

    
    logger.info("Request:", request.toString());
    System.out.println("Request:"+request.toString());

    try (Response response = client.newCall(request).execute()) {
        if (response.isSuccessful()) {
            
            // Get the response body as a string
            String responseBody = response.body().string();

            logger.info("Response code:", response.code());
            System.out.println("Response code:"+ response.code());
            logger.info("Response body:", responseBody);
            System.out.println("Response body:"+ responseBody);
        } else {
            logger.info("Error: Request failed with code:", response.code());
        }
    } catch (IOException e) {
        logger.error("Error executing request:", e);
    }
}
}

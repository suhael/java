package com.test.httpclient;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * Created by sakhtar on 24/08/2015.
 */
public class Post {
    public static void main(String[] args) throws IOException {



        for(int i = 1; i < 1500; i++) {

            HttpClient client = HttpClientBuilder.create().build();
            String value = String.format("%04d", i);

            String url = "http://localhost:9201/smithsnews/pendingCustomerPackage/7a87a2a6-09ee-469c-" + value + "-2c01bda06555/_create";

            String body = "{ " +
                    "\"packageId\": \"7a87a2a6-09ee-469c-" + value + "-2c01bda06555\"," +
                    "\"jobId\": \"d1928794-f833-44fe-b339-a4a43f652fa7\"," +
                    "\"barcode\": \"01180001235017202016\"," +
                    "\"created\": \"2015-08-20T10:45:00.000Z\"," +
                    "\"assigned\": \"driver\"," +
                    "\"driverJobId\": \"619bad77-c0d9-4cf2-9306-eac1acc35aac\"" +
                    "}";

            HttpPost httpost = new HttpPost(url);
            httpost.setEntity(new StringEntity(body));
            httpost.setHeader("Accept", "application/json");
            httpost.setHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");


            client.execute(httpost);
        }
    }
}

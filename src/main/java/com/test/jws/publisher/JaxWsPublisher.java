package com.test.jws.publisher;

import com.test.jws.service.JWSServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by sakhtar on 17/08/2015.
 */
public class JaxWsPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/hello", new JWSServiceImpl());
    }
}

package com.test.jws.service;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.test.jws.service.JWSService")
public class JWSServiceImpl implements JWSService {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }
}

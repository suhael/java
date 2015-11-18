package com.test.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/jersey")
public class JerseyResource {
    @GET()
    public String hello() {
        return "hello";
    }
}

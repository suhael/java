package com.test.jws.client;

import com.test.jws.service.JWSService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

@Path("/jwsclient")
public class JWSClient {
    @GET()
    public String hello() throws Exception{
        URL url = new URL("http://localhost:8080/javaTestScripts/jws/service?wsdl");
        QName qname = new QName("http://service.jws.test.com/", "JWSServiceImplService");
        Service service = Service.create(url, qname);
        JWSService jwsService = service.getPort(JWSService.class);
        return jwsService.getHelloWorldAsString("test");
    }
}

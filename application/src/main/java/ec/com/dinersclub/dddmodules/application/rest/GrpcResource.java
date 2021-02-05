package ec.com.dinersclub.dddmodules.application.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.com.dinersclub.dddmodules.application.services.HelloService;

@Path("/hello")
public class GrpcResource {
	
	@Inject
    HelloService client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
    
    @GET
    @Path("/{name}")
    public String hello(@PathParam("name") String name) {
        return client.hello(name);  
    }
}
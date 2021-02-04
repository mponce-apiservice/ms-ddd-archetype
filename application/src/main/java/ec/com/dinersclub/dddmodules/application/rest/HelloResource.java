package ec.com.dinersclub.dddmodules.application.rest;

//import ec.com.dinersclub.dddmodules.application.grpc.GreeterGrpc;
//import ec.com.dinersclub.dddmodules.application.grpc.HelloRequest;
//import io.quarkus.grpc.runtime.annotations.GrpcService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {
	
	//@Inject
    //@GrpcService("hello")                     
    //GreeterGrpc.GreeterBlockingStub client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
    
    //@GET
    //@Path("/{name}")
    //public String hello(@PathParam("name") String name) {
    //    return client.sayHello(HelloRequest.newBuilder().setName(name).build()).getMessage();  
    //}
}
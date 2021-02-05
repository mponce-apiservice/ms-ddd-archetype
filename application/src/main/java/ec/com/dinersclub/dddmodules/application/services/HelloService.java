package ec.com.dinersclub.dddmodules.application.services;

import ec.com.dinersclub.dddmodules.application.grpc.GreeterGrpc;
import ec.com.dinersclub.dddmodules.application.grpc.HelloRequest;
import io.quarkus.grpc.runtime.annotations.GrpcService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped  
public class HelloService {

	@Inject
    @GrpcService("hello")                     
    GreeterGrpc.GreeterBlockingStub client;
	
	public String hello(String name) {
		return client.sayHello(HelloRequest.newBuilder().setName(name).build()).getMessage();  
	}
	
}

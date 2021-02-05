package ec.com.dinersclub.dddmodules.application.grpc;

import javax.enterprise.context.ApplicationScoped;

import io.grpc.stub.StreamObserver;
import ec.com.dinersclub.dddmodules.application.grpc.GreeterGrpc;
import ec.com.dinersclub.dddmodules.application.grpc.HelloResponse;
import ec.com.dinersclub.dddmodules.application.grpc.HelloRequest;


@ApplicationScoped                                                                                    
public class HelloResource extends GreeterGrpc.GreeterImplBase {                               

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) { 
        String name = request.getName();
        String message = "Hello " + name;
        responseObserver.onNext(HelloResponse.newBuilder().setMessage(message).build());         
        responseObserver.onCompleted();                                                       
    }
}
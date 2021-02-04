package ec.com.dinersclub.dddmodules.application.grpc;

//import io.grpc.stub.StreamObserver;
//import ec.com.dinersclub.dddmodules.application.grpc.GreeterGrpc;
//import ec.com.dinersclub.dddmodules.application.grpc.HelloResponse;
//import ec.com.dinersclub.dddmodules.application.grpc.HelloRequest;

import javax.inject.Singleton;

@Singleton                                                                                    
public class HelloService {/*extends GreeterGrpc.GreeterImplBase {                               

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) { 
        String name = request.getName();
        String message = "Hello " + name;
        responseObserver.onNext(HelloResponse.newBuilder().setMessage(message).build());         
        responseObserver.onCompleted();                                                       
    }*/
}
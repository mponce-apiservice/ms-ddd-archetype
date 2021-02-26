package ec.com.dinersclub.dddmodules.application.grpc;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import io.grpc.stub.StreamObserver;
import ec.com.dinersclub.dddmodules.application.cqrs.commands.ITarjetaCommandService;
import ec.com.dinersclub.dddmodules.application.cqrs.commands.dto.CreateTarjetaCommand;
import ec.com.dinersclub.dddmodules.application.grpc.TarjetaGrpc;
import ec.com.dinersclub.dddmodules.application.grpc.TarjetaResponse;
import ec.com.dinersclub.dddmodules.application.grpc.TarjetaRequest;


@ApplicationScoped                                                                                    
public class TarjetaResource extends TarjetaGrpc.TarjetaImplBase {      
	
	@Inject
	ITarjetaCommandService writeService;

    @Override
    public void createTarjetaCommand(TarjetaRequest request, StreamObserver<TarjetaResponse> responseObserver) { 
    	
        CreateTarjetaCommand command = new CreateTarjetaCommand();
        command.setId(UUID.fromString(request.getId()));
        command.setNombre(request.getNombre());
        writeService.createTarjetaCommand(command);
        responseObserver.onNext(TarjetaResponse.newBuilder().setId(request.getId()).build());         
        responseObserver.onCompleted();   
        
    }
}
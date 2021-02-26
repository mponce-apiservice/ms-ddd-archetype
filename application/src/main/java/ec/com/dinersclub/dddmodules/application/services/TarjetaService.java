package ec.com.dinersclub.dddmodules.application.services;

import ec.com.dinersclub.dddmodules.application.cqrs.commands.dto.CreateTarjetaCommand;
import ec.com.dinersclub.dddmodules.application.grpc.TarjetaGrpc;
import ec.com.dinersclub.dddmodules.application.grpc.TarjetaRequest;
import io.quarkus.grpc.runtime.annotations.GrpcService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped  
public class TarjetaService {

	@Inject
    @GrpcService("tarjeta")                     
    TarjetaGrpc.TarjetaBlockingStub grpc;
	
	public String createTarjetaCommand(CreateTarjetaCommand command) {
		return grpc.createTarjetaCommand(TarjetaRequest.newBuilder().setId(command.getId().toString()).setNombre(command.getNombre()).build()).getId();  
	}
	
}

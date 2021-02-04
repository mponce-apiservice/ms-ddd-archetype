package ec.com.dinersclub.dddmodules.application.rest;

//import static io.quarkiverse.loggingjson.providers.KeyValueStructuredArgument.kv;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.com.dinersclub.dddmodules.application.cqrs.commands.IFruitCommandService;
import ec.com.dinersclub.dddmodules.application.cqrs.commands.dto.CreateFruitCommand;
import ec.com.dinersclub.dddmodules.application.cqrs.queries.IFruitQueryService;
import ec.com.dinersclub.dddmodules.application.cqrs.queries.dto.FruitQuery;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

	@Inject
	IFruitQueryService readService;
	
	@Inject
	IFruitCommandService writeService;

    @GET
    public List<FruitQuery> list() {
        return readService.getAll();
    }

    @POST
    public Response add(@Valid CreateFruitCommand command) {
    	writeService.createFruitCommand(command);
    	//logger.info("Test log of Created Fruit", kv("command", command), kv("created",new Date().toString()));
    	return Response.status(201).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@Digits(integer = 3, fraction = 0) @PathParam(value = "id") int id) {
    	writeService.removeFruitCommand(id);
    	return Response.status(200).build();
    }
}
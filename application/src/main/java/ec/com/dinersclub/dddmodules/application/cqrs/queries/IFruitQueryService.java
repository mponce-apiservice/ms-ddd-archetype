package ec.com.dinersclub.dddmodules.application.cqrs.queries;

import java.util.List;

import ec.com.dinersclub.dddmodules.application.cqrs.queries.dto.FruitQuery;

public interface IFruitQueryService {
	
	List<FruitQuery> getAll();

}

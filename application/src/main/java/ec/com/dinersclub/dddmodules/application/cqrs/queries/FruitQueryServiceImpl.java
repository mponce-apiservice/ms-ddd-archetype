package ec.com.dinersclub.dddmodules.application.cqrs.queries;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import ec.com.dinersclub.dddmodules.application.cqrs.queries.dto.FruitQuery;
import ec.com.dinersclub.dddmodules.domain.model.Fruit;
import ec.com.dinersclub.dddmodules.domain.repository.IPostgreSQLRepository;

@ApplicationScoped
public class FruitQueryServiceImpl implements IFruitQueryService{
	
	@Inject
	private IPostgreSQLRepository fruitRepository;
	
	public List<FruitQuery> getAll() {
        return map(fruitRepository.getFruits());
    }
	
    public List<FruitQuery> map(Optional<List<Fruit>> fruits) {
        if (fruits.isEmpty()) {
            return null;
        }

        List<FruitQuery> list = new ArrayList<FruitQuery>(fruits.get().size());
        for (Fruit fruit : fruits.get()) {
            list.add(entityToDto(fruit));
        }

        return list;
    }

    protected FruitQuery entityToDto(Fruit fruit) {
        if (fruit == null) {
            return null;
        }
        return new FruitQuery(fruit.getId(), fruit.getName());
    }

}

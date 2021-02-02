package ec.com.dinersclub.dddmodules.infrastructure.pgsql.repository;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import ec.com.dinersclub.dddmodules.domain.model.Fruit;
import ec.com.dinersclub.dddmodules.domain.repository.IPostgreSQLRepository;
import ec.com.dinersclub.dddmodules.infrastructure.pgsql.entities.FruitEntity;

@Transactional
@ApplicationScoped
public class PostgreSQLRepositoryImpl implements IPostgreSQLRepository{
	
	@Inject
	FruitRepository fruitRepository;
    
    @Override
	public Optional<List<Fruit>> getFruits() {
		List<FruitEntity> fruitEntityList = fruitRepository.listAll();
		if (!fruitEntityList.isEmpty()) {
			return Optional.of(FruitEntity
					.map(fruitEntityList));
		} else {
            return Optional.empty();
        }
	}
    
	@Override
	public Optional<Fruit> getFruit(int id) {
		FruitEntity fruitEntity = fruitRepository.findById(id);
        if (fruitEntity != null) {
            return Optional.of(fruitEntity.toFruit());
        } else {
            return Optional.empty();
        }
	}

	@Override
	public void createFruit(Fruit fruit) {
		FruitEntity.persist(new FruitEntity(fruit));
	}

	@Override
	public void deleteFruit(int id) {
		FruitEntity.deleteById(id);
	}
	
}

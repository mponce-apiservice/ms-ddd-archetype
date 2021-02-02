package ec.com.dinersclub.dddmodules.infrastructure.pgsql.repository;

import java.util.List;

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
	public List<Fruit> getFruits() {
		List<FruitEntity> fruitEntityList = fruitRepository.listAll();
		if (!fruitEntityList.isEmpty()) {
			return FruitEntity
					.map(fruitEntityList);
		} else {
            return null;
        }
	}
    
	@Override
	public Fruit getFruit(int id) {
		FruitEntity fruitEntity = fruitRepository.findById(id);
        if (fruitEntity != null) {
            return fruitEntity.toFruit();
        } else {
            return null;
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

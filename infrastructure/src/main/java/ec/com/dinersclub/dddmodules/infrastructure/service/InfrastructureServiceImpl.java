package ec.com.dinersclub.dddmodules.infrastructure.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import ec.com.dinersclub.dddmodules.domain.model.Fruit;
import ec.com.dinersclub.dddmodules.domain.repository.IRepository;
import ec.com.dinersclub.dddmodules.infrastructure.pgsql.entities.FruitEntity;
import ec.com.dinersclub.dddmodules.infrastructure.pgsql.repository.FruitRepository;
import ec.com.dinersclub.dddmodules.infrastructure.redis.RedisRepository;

@ApplicationScoped
public class InfrastructureServiceImpl implements IRepository {
	
	@Inject
	FruitRepository fruitRepository;
	
	@Inject
	RedisRepository redisRepository;

	@Override
	public void delCache(String key) {
		//redisRepository.del(key);
	}

	@Override
	public String getCache(String key) {
		//return redisRepository.get(key);
		return null;
	}

	@Override
	public void setCache(String key, String value) {
		//redisRepository.set(key, value);
	}

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
	@Transactional
	public void createFruit(Fruit fruit) {
		FruitEntity.persist(new FruitEntity(fruit));
	}

	@Override
	@Transactional
	public void deleteFruit(int id) {
		FruitEntity.delete("id", id);
	}

}

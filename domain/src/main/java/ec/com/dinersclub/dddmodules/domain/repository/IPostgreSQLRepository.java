package ec.com.dinersclub.dddmodules.domain.repository;

import java.util.List;
import java.util.Optional;

import ec.com.dinersclub.dddmodules.domain.model.Fruit;

public interface IPostgreSQLRepository {
	
	Optional<List<Fruit>> getFruits();
	
    Optional<Fruit> getFruit(int id);

    void createFruit(Fruit fruit);
    
    void deleteFruit(int id);
}
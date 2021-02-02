package ec.com.dinersclub.dddmodules.domain.repository;

import java.util.List;

import ec.com.dinersclub.dddmodules.domain.model.Fruit;

public interface IPostgreSQLRepository {
	
	List<Fruit> getFruits();
	
    Fruit getFruit(int id);

    void createFruit(Fruit fruit);
    
    void deleteFruit(int id);
}
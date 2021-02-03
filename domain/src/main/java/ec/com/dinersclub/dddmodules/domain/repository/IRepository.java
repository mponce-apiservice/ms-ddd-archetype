package ec.com.dinersclub.dddmodules.domain.repository;

import java.util.List;

import ec.com.dinersclub.dddmodules.domain.model.Fruit;

public interface IRepository {
	
	List<Fruit> getFruits();
	
    Fruit getFruit(int id);

    void createFruit(Fruit fruit);
    
    void deleteFruit(int id);
    
    void delCache(String key);

    String getCache(String key);

    void setCache(String key, String value);

}
package ec.com.dinersclub.dddmodules.domain.repository;

import java.util.List;

import ec.com.dinersclub.dddmodules.domain.model.Fruit;
import io.smallrye.mutiny.Uni;

public interface IRepository {
	
	List<Fruit> getFruits();
	
    Fruit getFruit(int id);

    void createFruit(Fruit fruit);
    
    void deleteFruit(int id);
    
    Uni<Void> delCache(String key);

    String getCache(String key);

    void setCache(String key, String value);

    Uni<List<String>> keysCache();
}
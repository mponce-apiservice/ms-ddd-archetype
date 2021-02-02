package ec.com.dinersclub.dddmodules.infrastructure.pgsql.repository;

import javax.enterprise.context.ApplicationScoped;

import ec.com.dinersclub.dddmodules.infrastructure.pgsql.entities.FruitEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<FruitEntity> {
	
	public FruitEntity findById(int id){
		return find("id", id).firstResult();
	}
	   
}

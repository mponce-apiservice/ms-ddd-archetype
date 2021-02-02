package ec.com.dinersclub.dddmodules.infrastructure.pgsql.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ec.com.dinersclub.dddmodules.domain.model.Fruit;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "fruits")
public class FruitEntity extends PanacheEntityBase {
	
	@Id
	private Integer id; 
    private String name;
    
    public FruitEntity() {
    }
    
    public FruitEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public FruitEntity(Fruit fruit) {
        this.id = fruit.getId();
        this.name = fruit.getName();
    }
    
    public static List<Fruit> map(List<FruitEntity> fruits) {
        if (fruits == null) {
            return null;
        }

        List<Fruit> list = new ArrayList<Fruit>(fruits.size());
        for (FruitEntity fruit : fruits) {
            list.add(fruit.toFruit());
        }

        return list;
    }

    public Fruit toFruit() {
        return new Fruit(getId(), getName());
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
package ec.com.dinersclub.dddmodules.domain.model;

public class Fruit {

	private int id; 
    private String name;
    
    public Fruit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Fruit() {
    }
    
    public int getId() {
		return id;
	}
    public String getName() {
        return name;
    }
    
}
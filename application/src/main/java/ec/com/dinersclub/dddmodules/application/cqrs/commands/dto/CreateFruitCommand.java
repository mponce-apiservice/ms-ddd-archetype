package ec.com.dinersclub.dddmodules.application.cqrs.commands.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

public class CreateFruitCommand {
	
	@Digits(integer = 3, fraction = 0)
	private int id;
	
	@NotBlank(message="name may not be blank")
    private String name;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}

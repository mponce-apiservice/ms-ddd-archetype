package ec.com.dinersclub.dddmodules.application.cqrs.commands;

import ec.com.dinersclub.dddmodules.application.cqrs.commands.dto.CreateFruitCommand;

public interface IFruitCommandService {
	
	void createFruitCommand(CreateFruitCommand command);
	
	void removeFruitCommand(int id);

}

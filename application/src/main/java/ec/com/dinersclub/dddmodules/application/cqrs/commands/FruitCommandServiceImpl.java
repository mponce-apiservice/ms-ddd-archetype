package ec.com.dinersclub.dddmodules.application.cqrs.commands;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import ec.com.dinersclub.dddmodules.application.cqrs.commands.dto.CreateFruitCommand;
import ec.com.dinersclub.dddmodules.domain.model.Fruit;
import ec.com.dinersclub.dddmodules.domain.repository.IPostgreSQLRepository;
//import ec.com.dinersclub.dddmodules.domain.repository.IRedisRepository;

@ApplicationScoped
public class FruitCommandServiceImpl implements IFruitCommandService{
	
	@Inject
	private IPostgreSQLRepository fruitRepository;
	
	//@Inject
	//private IRedisRepository redisRepository;
	
	public void createFruitCommand(CreateFruitCommand command) {
		fruitRepository.createFruit(new Fruit(command.getId(),command.getName()));
		//redisRepository.set(String.valueOf(command.getId()), command.getName());
    }
	
	public void removeFruitCommand(int id) {
		fruitRepository.deleteFruit(id);
		//redisRepository.del(String.valueOf(id));
    }
	
}

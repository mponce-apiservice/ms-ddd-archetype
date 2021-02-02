package ec.com.dinersclub.dddmodules.infrastructure.redis;

//import io.quarkus.redis.client.RedisClient;
//import io.quarkus.redis.client.reactive.ReactiveRedisClient;
import io.smallrye.mutiny.Uni;

//import io.vertx.mutiny.redis.client.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import ec.com.dinersclub.dddmodules.domain.repository.IRedisRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RedisRepositoryImpl implements IRedisRepository {

	@Override
	public Uni<Void> del(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(String key, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void increment(String key, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Uni<List<String>> keys() {
		// TODO Auto-generated method stub
		return null;
	}

    /*@Inject
    RedisClient redisClient;

    @Inject
    ReactiveRedisClient reactiveRedisClient;

    public Uni<Void> del(String key) {
        return reactiveRedisClient.del(Arrays.asList(key))
                .map(response -> null);
    }

    public String get(String key) {
        return redisClient.get(key).toString();
    }

    public void set(String key, String value) {
        redisClient.set(Arrays.asList(key, value));
    }

    public void increment(String key, String value) {
        redisClient.incrby(key, value);
    }

    public Uni<List<String>> keys() {
        return reactiveRedisClient
                .keys("*")
                .map(response -> {
                    List<String> result = new ArrayList<>();
                    for (Response r : response) {
                        result.add(r.toString());
                    }
                    return result;
                });
    }*/
}
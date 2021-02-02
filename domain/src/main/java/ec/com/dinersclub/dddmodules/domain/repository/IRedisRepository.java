package ec.com.dinersclub.dddmodules.domain.repository;

import java.util.List;

import io.smallrye.mutiny.Uni;

public interface IRedisRepository {
	
	Uni<Void> del(String key);

    String get(String key);

    void set(String key, String value);

    void increment(String key, String value);

    Uni<List<String>> keys();

}

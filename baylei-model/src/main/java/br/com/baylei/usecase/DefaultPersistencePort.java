package br.com.baylei.usecase;

import java.util.List;

public interface DefaultPersistencePort<T> {

    T save(T T);

    List<T> getAll();

    T getById(String id);

    T update(T client);

    void deleteById(String id);

    List<T> getAllById(List<String> ids);

}

package by.itacademy.javaenterprise.kotkovski.dao;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<K, E> {

    boolean delete(K id);

    E save(E entity);

    void update(E entity);

    List<E> findAll();

    Optional<E> findById(K id);
}

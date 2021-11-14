package by.itacademy.javaenterprise.kotkovski.dao;

import by.itacademy.javaenterprise.kotkovski.entity.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Integer, Car>{
    List<Car> findByCustomerId(Integer id);
}

package by.itacademy.javaenterprise.kotkovski.service;

import by.itacademy.javaenterprise.kotkovski.dao.impl.CarRepositoryImpl;
import by.itacademy.javaenterprise.kotkovski.entity.Car;
import by.itacademy.javaenterprise.kotkovski.dao.impl.CustomerRepository;
import by.itacademy.javaenterprise.kotkovski.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarService {

    @Autowired
    private CarRepositoryImpl carRepositoryImpl;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Car> getCarByCustomerId(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElse(null);
        if (customer == null) {
            return null;
        } else {
            return carRepositoryImpl.findByCustomerId(customer.getId());
        }
    }
}

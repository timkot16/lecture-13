package by.itacademy.javaenterprise.kotkovski;

import by.itacademy.javaenterprise.kotkovski.configuration.SpringConfig;
import by.itacademy.javaenterprise.kotkovski.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DaoRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        CarService carDAO = context.getBean("carService", CarService.class);
        for (int i = 0; i < 15; i++) {
            System.out.println(carDAO.getCarByCustomerId(i));
        }
    }
}

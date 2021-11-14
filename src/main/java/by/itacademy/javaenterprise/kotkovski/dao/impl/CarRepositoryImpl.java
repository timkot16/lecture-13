package by.itacademy.javaenterprise.kotkovski.dao.impl;

import by.itacademy.javaenterprise.kotkovski.dao.CarRepository;
import by.itacademy.javaenterprise.kotkovski.entity.Car;
import by.itacademy.javaenterprise.kotkovski.exception.DAOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CarRepositoryImpl implements CarRepository {

    private final static Logger logger = LoggerFactory.getLogger(CarRepositoryImpl.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private final CustomerRepository customerRepository = new CustomerRepository();

    private final static String FIND_BY_ID_SQL = "select id, car, vin, number, year, customer_id from Cars where id = ?";
    private final static String FIND_BY_CUSTOMER_ID = "select id, car, vin, number, year from Cars where customer_id = ?";

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Car save(Car car) {
        return null;
    }

    @Override
    public void update(Car car) {
    }

    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public Optional<Car> findById(Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            statement.setInt(1, id);
            connection.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery();
            Car car = null;
            if (resultSet.next()) {
                car = buildCar(resultSet);
            }
            connection.commit();
            return Optional.ofNullable(car);
        } catch (SQLException e) {
            logger.error("Failed to find car with current id {}", id, e);
            throw new DAOException(e);
        }
    }

    @Override
    public List<Car> findByCustomerId(Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_CUSTOMER_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<Car> carList = new ArrayList<>();
            while (resultSet.next()) {
                carList.add(buildCar(resultSet));
            }
            return carList;
        } catch (SQLException e) {
            logger.error("Failed to find cars with current customer id {}", id, e);
            throw new DAOException(e);
        }
    }

    private Car buildCar(ResultSet resultSet) throws SQLException {
        return new Car(
                resultSet.getInt("id"),
                resultSet.getString("car"),
                resultSet.getString("vin"),
                resultSet.getString("number"),
                resultSet.getInt("year"),
                customerRepository.findById(resultSet.getInt("id")).orElse(null)
        );
    }
}

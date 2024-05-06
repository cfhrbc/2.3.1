package dao;

import model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private final List<Car> cars;

    public CarDaoImpl() {
        // Инициализация данных
        cars = new ArrayList<>();
        cars.add(new Car("BMW", "M5g30", 2019));
        cars.add(new Car("Audi", "RS6 performance", 2016));
        cars.add(new Car("Porsche", "911 turbo", 2021));
        cars.add(new Car("Mercedes-Benz", "C63 AMG", 2014));
        cars.add(new Car("Mustang", "Shelby GT-500", 2012));
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public List<Car> findSome(int count) {
        if (count >= cars.size()) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
}

package service;

import model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAllCars();

    List<Car> findSomeCars(int count);
}

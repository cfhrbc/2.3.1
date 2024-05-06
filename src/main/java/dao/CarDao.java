package dao;

import model.Car;

import java.util.List;

public interface CarDao {
    List<Car> findAll();

    List<Car> findSome(int count);
}

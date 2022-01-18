package service;

import model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarService {

    List<Car> findSome();

    List<Car> findSomeCars(int count);
}

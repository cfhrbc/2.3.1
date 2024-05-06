package service;

import dao.CarDao;
import model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }


    @Override
    public List<Car> findAllCars() {
        return carDao.findAll();
    }

    @Override
    public List<Car> findSomeCars(int count) {
        return carDao.findSome(count);
    }
}


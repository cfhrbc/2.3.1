package service;

import model.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> findSome() {
        return listCars();
    }


    public List<Car> listCars() {

        List<Car> cars = new ArrayList<>();
        int i;
        String[] brands = {"BMW", "Audi", "Porsche", "Mercedes-Benz", "Mustang"};
        String[] models = {"M5g30", "RS6 performance", "911 turbo", "C63 AMG", "Shelby GT-500"};
        Integer[] years = {2019, 2016, 2021, 2014, 2012};
        for (i = 0; i < 5; i++) {
            cars.add(new Car(brands[i], models[i], years[i]));


        }
        return cars;

    }


    @Override
    public List<Car> findSomeCars(int count) {
        List<Car> allCars = listCars();
        if (count >= allCars.size()) {
            return allCars;
        } else {
            return allCars.subList(0, count);
        }

    }


}


package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import service.CarServiceImpl;

import java.util.List;

@Controller
@RequestMapping
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(Model model) {
        List<Car> cars = carService.findSome();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping(value = "/cars", params = "count")
    public String getSomeCars(Model model, @RequestParam("count") int count) {
        List<Car> cars = carService.findSomeCars(count);
        model.addAttribute("cars", cars);
        return "cars";
    }


}

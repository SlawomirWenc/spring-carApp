package com.example.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/cars")
public class CarApi {

    private CarController carController;

    @Autowired
    public CarApi(CarController carController) {
        this.carController = carController;
    }

    @GetMapping("/all")
    public Iterable<Car> getAll(){
        return carController.findAll();
    }

    @GetMapping
    public Optional<Car> getById(@RequestParam Long id){
        return carController.findById(id);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car){
        return carController.save(car);
    }

    @PutMapping
    public Car updateCar(@RequestBody Car car){
        return carController.save(car);
    }

    @DeleteMapping
    public void deleteCar(@RequestParam Long id){
        carController.deleteById(id);
    }

}

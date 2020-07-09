package com.example.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarController {

    private CarRepo carRepo;

    @Autowired
    public CarController(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Iterable<Car> findAll(){
        return carRepo.findAll();
    }

    public Optional<Car> findById(Long id){
        return carRepo.findById(id);
    }

    public Car save(Car car){
        return carRepo.save(car);
    }

    public void deleteById(Long id){
        carRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        carRepo.save(new Car(1L,"BMW","E46",Color.BLUE));
        carRepo.save(new Car(2L,"AUDI","A6",Color.BLACK));
    }

}

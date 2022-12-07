package java8.service.impl;

import java8.classes.Car;
import java8.classes.Person;
import java8.enums.Country;
import java8.service.CarService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarServiceImpl implements CarService {
    List<Car>cars= new ArrayList<>();
    @Override
    public String createCar(List<Car> cars) {
        this.cars.addAll(cars);
        return "Cars create successfully";
    }

    @Override
    public String removeCar(String name, List<Car> cars) {
        boolean isRemoved=this.cars.removeIf(car -> car.getName().equals(name));
        return isRemoved ?"Car: "+name+" is removed successfully!":"Removed failed: invalid name!";
    }

    @Override
    public List<Car> getAll() {
        System.out.println("==================== ALL CARS ========================");
        return this.cars;
    }

    @Override
    public List<Car> findCarByName(String name, List<Person> people) {
        List<Car> per = new ArrayList<>();
        for (Person person : people) {
            for (Car car : person.getCars()) {
                if (person.getName().equals(name)) {
                    per.add(car);
                    return per;
                }
            }
        }
        return null;
    }

    @Override
    public List<Car> findByCountry(String name, List<Person> persons) {
        ArrayList<Car>carArrayList=new ArrayList<>();
        for (Person person : persons) {
            for (Car car : person.getCars()){
                if (car.getCountryOfOrigin().name().contains(name)){
                    carArrayList.add(car);
                }
            }

        }

        return carArrayList;
    }
}

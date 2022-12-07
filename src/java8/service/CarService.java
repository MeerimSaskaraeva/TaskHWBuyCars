package java8.service;

import java8.classes.Car;
import java8.classes.Person;

import java.util.List;

public interface CarService {
    String createCar(List<Car> cars);

    String removeCar(String name,List<Car>cars);

    List<Car>getAll();

    List<Car>findCarByName(String name, List<Person>people);

    List<Car>findByCountry(String name,List<Person>persons);
}

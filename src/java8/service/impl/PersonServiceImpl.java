package java8.service.impl;

import java8.classes.Car;
import java8.classes.Person;
import java8.enums.Gender;
import java8.service.PersonService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    List<Person>people=new ArrayList<>();
    List<Car>cars= new ArrayList<>();


    @Override
    public String createPerson(List<Person> people) {
        this.people.addAll(people);
        return "Person created successfully";
    }

    @Override
    public String removePerson(String name, List<Person> people) {

        boolean isRemoved=this.people.removeIf(person -> person.getName().equals(name));
        return isRemoved ?"Person "+name+" is removed successfully!":"Removed failed : invalid name";
    }

    @Override
    public List<Person> getAll() {
        System.out.println("========================== ALL PEOPLE =====================");
        return this.people;
    }

    @Override
    public List<Person> findByName(String name, List<Person> people) {

            List<Person> per = new ArrayList<>();
            for (Person person : people) {
                if (person.getName().equals(name)) {
                    per.add(person);
                    return per;
                }
            }
            return null;}

    @Override
    public List<Person> findByCarName(String name, List<Person> people) {
        List<Person> per = new ArrayList<>();
        for (Person person : people) {
            for (Car car : person.getCars()) {
                if (car.getName().equals(name)) {
                    per.add(person);
                    return per;
                }
            }
        }
        return null;
    }

    @Override
    public String payCars(String name, List<Person> person, String carName, LinkedList<Car> cars) {

        LinkedList<Person>p=new LinkedList<>();
        LinkedList<Car>c=new LinkedList<>();
        for (Person person1 : person) {
            for (Car car : cars) {
                if (person1.getName().equals(name) && car.getName().equals(carName)) {

                    BigDecimal s = person1.getMoney();
                    System.out.println("A Person has: "+s);
                    BigDecimal d = car.getPrice();
                    System.out.println("Car cost: "+d);
                    if (s.compareTo(d) > 0) {
                        String cName= String.valueOf(car.getName().equals(carName));
                        CarServiceImpl carService=new CarServiceImpl();
                        System.out.println(carService.removeCar(cName, cars));

                        p.add(person1);
                        c.addLast(car);

                        boolean z = person1.getCars().addAll(c);

                        System.out.println(p + "" + c + "" + z);
                        return "Payment for the car was successful!";
                        }
                    else if (s.compareTo(d) < 0){
                        return "Not enough money!"; }
                }
            }

        }

        return "No person's name or car's name found!";
    }

    @Override
    public List<Person> sortPersonDateOfBirth(List<Person> persons) {
        persons.sort(Person.sortDateOfBirth);
        for (Person person : persons) {
            System.out.println(person.getDateOfBirth().getYear());
        }
        return new ArrayList<>(persons);
    }

    @Override
    public List<Person> sortPersonName(List<Person> persons) {
        persons.sort(Person.sortPersonName);
        return new ArrayList<>(persons);
    }

    @Override
    public String sortGender(List<Person> person) {
        List<Person>male=new ArrayList<>();
        List<Person>female=new ArrayList<>();
        for (Person person1 : person) {
            if (person1.getGender().equals(Gender.MALE)){
                male.add(person1);}
            else if (person1.getGender().equals(Gender.FEMALE)){
                female.add(person1);}
        }
        return "MALE: "+male+"\nFEMALE: "+female;
    }

    @Override
    public int getAge(Person person) {
        System.out.print("Name: "+person.getName().toString()+" is ");
        return Period.between(person.getDateOfBirth(),LocalDate.now()).getYears() ;

    }
}

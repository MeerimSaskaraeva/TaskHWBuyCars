import java8.classes.Car;
import java8.classes.Person;
import java8.enums.Colour;
import java8.enums.Country;
import java8.enums.Gender;
import java8.exception.MyException;
import java8.service.impl.CarServiceImpl;
import java8.service.impl.PersonServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);

            PersonServiceImpl personService = new PersonServiceImpl();
            CarServiceImpl carService = new CarServiceImpl();

            //Car car0=new Car();
            Car cars1 = new Car("6", "BMV", BigDecimal.valueOf(2450500), Year.of(2019), Colour.BLACK, Country.GERMAN);
            Car cars2 = new Car("500", "LEXUS", BigDecimal.valueOf(790000), Year.of(2020), Colour.RED, Country.JAPAN);
            Car cars3 = new Car("600", "AUDI", BigDecimal.valueOf(650000), Year.of(2016), Colour.YELLOW, Country.GERMAN);
            Car cars4 = new Car("CAMRY", "TOYOTA", BigDecimal.valueOf(600000), Year.of(2015), Colour.WHITE, Country.JAPAN);
            Car cars5 = new Car("RIO", "KIA", BigDecimal.valueOf(500000), Year.of(2021), Colour.BLACK, Country.KOREA);
            LinkedList<Car> cars = new LinkedList<>();
            //cars.add(car0);
            cars.add(cars1);
            cars.add(cars2);
            cars.add(cars3);
            cars.add(cars4);
            cars.add(cars5);


            Person person1 = new Person("BEK", LocalDate.of(2000, 6, 21), Gender.MALE, BigDecimal.valueOf(1000000), "+996700555666", new LinkedList<>(List.of(cars1)));
            Person person2 = new Person("SARA", LocalDate.of(1990, 4, 1), Gender.FEMALE, BigDecimal.valueOf(800000), "+996700777666", new LinkedList<>(List.of(cars2)));
            Person person3 = new Person("VICKA", LocalDate.of(1998, 5, 23), Gender.FEMALE, BigDecimal.valueOf(700000), "+996700555888", new LinkedList<>(List.of(cars3)));
            Person person4 = new Person("LERA", LocalDate.of(1990, 12, 30), Gender.FEMALE, BigDecimal.valueOf(900000), "+996700558666", new LinkedList<>(List.of(cars4)));
            Person person5 = new Person("MASHA", LocalDate.of(1989, 3, 12), Gender.FEMALE, BigDecimal.valueOf(609000), "+996700505666", new LinkedList<>(List.of(cars5)));
            LinkedList<Person> people = new LinkedList<>();
            people.add(person1);
            people.add(person2);
            people.add(person3);
            people.add(person4);
            people.add(person5);


            while (true) {
                System.out.println("\n\u001B[34m====================== COMMANDS ============================"+
                "\nPress 1 to CREATE person"+
                "\nPress 2 to REMOVE person" +
                        "\nPress 3 to get all person" +
                        "\nPress 4 to find by name person" +
                        "\nPress 5 to find by car name" +
                        "\nPress 6 to CREATE car" +
                        "\nPress 7 to REMOVE car" +
                        "\nPress 8 to get all car" +
                        "\nPress 9 to find car by person's name" +
                        "\nPress 10 to find by country" +
                        "\nPress 11 to sort person date of birth" +
                        "\nPress 12 to sort person's name" +
                        "\nPress 13 to sort gender" +
                        "\nPress 14 to get age" +
                        "\nPress 15 to pay for the car\u001B[0m");
                int pressNum= sc.nextInt();
                if (pressNum<0){
                    throw new MyException("Negative number");
                }
                switch (pressNum) {
                    case 1 -> System.out.println(personService.createPerson(people));
                    case 2 -> {
                        System.out.print("Write person's name: ");
                        System.out.println(personService.removePerson(sc.next().toUpperCase(), people));
                    }
                    case 3 -> System.out.println(personService.getAll());
                    case 4 -> {
                        System.out.print("Write person's name: ");
                        System.out.println(personService.findByName(sc.next().toUpperCase(), people));
                    }
                    case 5 -> {
                        System.out.print("Write car's name: ");
                        System.out.println(personService.findByCarName(sc.next().toUpperCase(), people));
                    }
                    case 6 -> System.out.println(carService.createCar(cars));
                    case 7 -> {
                        System.out.print("Write car's name: ");
                        System.out.println(carService.removeCar(sc.next().toUpperCase(), cars));
                    }
                    case 8 -> System.out.println(carService.getAll());
                    case 9 -> {
                        System.out.print("Write person's name: ");
                        System.out.println(carService.findCarByName(sc.next().toUpperCase(), people));
                    }
                    case 10 -> {
                        System.out.print("Write country: ");
                        System.out.println(carService.findByCountry(sc.next().toUpperCase(), people));
                    }
                    case 11 -> System.out.println(personService.sortPersonDateOfBirth(people));
                    case 12 -> System.out.println(personService.sortPersonName(people));
                    case 13 -> System.out.println(personService.sortGender(people));
                    case 14 -> {
                        for (Person person : people) {
                            System.out.println(personService.getAge(person) + " years old");
                        }
                    }
                    case 15 -> {

                        System.out.println("Write person's name");
                        String name = sc.next();
                        if (!name.matches("[a-zA-Zа-яА-Я]*")){
                            throw new MyException("Name can't be with numbers");
                        }
                        System.out.println("Write car's name");
                        String carName = sc.next();
                        System.out.println(personService.payCars(name.toUpperCase(), people, carName.toUpperCase(), cars));

                        //System.out.println(carService.removeCar(carName.toUpperCase(), cars));}}

                        //System.out.println(people.removeFirst().getMoney().remainder(cars.element().getPrice()));
                    }
                }
            }
        }catch ( MyException e){
            System.out.println(e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Press on a number, not a letter");
        }

    }}
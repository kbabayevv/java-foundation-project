package service;

import main.CarNotFoundException;
import model.Car;

import java.time.LocalDate;
import java.util.Scanner;

import static config.MockCarDatabase.cars;


public class CarConfigService {
    public void createCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter car's" + "\nID: \nName: \nModel: \nBrand:  \nColor: \nRelease Date (e.x: -> 2024-02-08): ");
        Long id = sc.nextLong();
        sc = new Scanner(System.in);
        String name = sc.nextLine();
        String model = sc.nextLine();
        String brand = sc.nextLine();
        String color = sc.nextLine();
        LocalDate releaseDate = LocalDate.parse(sc.nextLine());
        try {
            Car carById = findCarById(id);
            System.out.println("Car already exist with id " + carById.getId());
        } catch (CarNotFoundException carNotFoundException) {
            Car car = new Car(id, name, model, brand, color, releaseDate);
            cars.add(car);
            System.out.println(("Car added successfully!"));
        }
        System.out.println();
    }

    public void getAllCars() {
        if (cars.isEmpty()) {
            System.out.println("Please add a new car.You didn't add a car!");
        }
        cars.forEach(System.out::println);
        System.out.println();
    }

    public void getCarById() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter car's ID:");
            Long id = sc.nextLong();
            System.out.println(findCarById(id));
            System.out.println();
        } catch (CarNotFoundException carNotFoundException) {
            System.out.println(carNotFoundException.getMessage());
            System.out.println();
        }
    }

    public void updateCarByName() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Name:");
            String name = sc.nextLine();
            findCarByName(name);

            System.out.println("It is old name " + findCarByName(name).getName());
            System.out.println("Enter new name");
            sc = new Scanner(System.in);
            String newName = sc.nextLine();
            findCarByName(name).setName(newName);
            System.out.println("Name updated successfully!");
            System.out.println();
        } catch (CarNotFoundException carNotFoundException) {
            System.out.println(carNotFoundException.getMessage());
            System.out.println();
        }
    }

    public void deleteCarById() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter ID:");
            Long id = sc.nextLong();
            cars.remove(findCarById(id));
            System.out.println("Car removed successfully!");
            System.out.println();
        } catch (CarNotFoundException carNotFoundException) {
            System.out.println(carNotFoundException.getMessage());
            System.out.println();
        }
    }

    private Car findCarById(Long id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        throw new CarNotFoundException("Car not found with id " + id);
    }

    private Car findCarByName(String name) {
        for (Car car : cars) {
            if (car.getName().equals(name)) {
                return car;
            }
        }
        throw new CarNotFoundException("Car not found with name " + name);
    }
}

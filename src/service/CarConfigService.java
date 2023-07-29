package service;

import config.CarConfig;
import main.CarNotFoundException;
import model.Car;

import java.util.Scanner;

import static config.CarConfig.cars;

public class CarConfigService {
    public void createCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many cars will you add?");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            sc = new Scanner(System.in);
            System.out.println("Enter " + (i + 1) + " car's" + "\nName: \nModel: \nBrand: \nID: \nColor: \nRelease Date: ");
            String name = sc.nextLine();
            String model = sc.nextLine();
            String brand = sc.nextLine();
            String id = sc.nextLine();
            String color = sc.nextLine();
            Integer releaseDate = sc.nextInt();


            Car car = new Car();
            car.setName(name);
            car.setModel(model);
            car.setBrand(brand);
            car.setId(id);
            car.setColor(color);
            car.setReleaseDate(releaseDate);


            cars.add(car);
            System.out.println((i + 1) + ".car added successfully!");
            System.out.println();
        }
        System.out.println();
    }

    public void getAllCars() {
        try {
            if (cars.get(0) == null) {
            }
        } catch (RuntimeException runtimeException) {
            System.out.println("Please add a new car.You didn't add a car!");
        }
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
        System.out.println();
    }

    public void getCarByID() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter ID:");
            String id = sc.nextLine();
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

    public void deleteCarByID() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter ID:");
            String id = sc.nextLine();
            cars.remove(findCarById(id));
            System.out.println("Car removed successfully!");
            System.out.println();
        } catch (CarNotFoundException carNotFoundException) {
            System.out.println(carNotFoundException.getMessage());
            System.out.println();
        }
    }

    private Car findCarById(String id) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId().equals(id)) {
                return cars.get(i);
            }
        }
        throw new CarNotFoundException("This car doesn't found");
    }

    private Car findCarByName(String name) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getName().equals(name)) {
                return cars.get(i);
            }
        }
        throw new CarNotFoundException("This car doesn't found");
    }
}

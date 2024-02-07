package main;

import service.CarConfigService;

import java.util.Scanner;

public class Main {
    static CarConfigService carConfigService = new CarConfigService();

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Select menu" +
                    "\n1.Add a new Car" +
                    "\n2.Show all Cars" +
                    "\n3.Show car by ID" +
                    "\n4.Update Car by Name" +
                    "\n5.Delete car by ID" +
                    "\n6.Exit system");
            int menu = sc.nextInt();
            if (menu == 1) {
                carConfigService.createCar();
            } else if (menu == 2) {
                carConfigService.getAllCars();
            } else if (menu == 3) {
                carConfigService.getCarById();
            } else if (menu == 4) {
                carConfigService.updateCarByName();
            } else if (menu == 5) {
                carConfigService.deleteCarById();
            } else if (menu == 6) {
                System.exit(0);
                break;
            }
        }

    }
}

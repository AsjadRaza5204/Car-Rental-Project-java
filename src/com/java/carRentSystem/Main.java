package com.java.carRentSystem;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("A001", "Camry","Toyota",100);
        Car car2 = new Car("A002", "Civic","Honda",150);
        Car car3 = new Car("A003", "Thar","Mahindra",200);
        Car car4 = new Car("A004", "Scorpio","Mahindra",200);
        Car car5 = new Car("A005", "swift dzire","Maruti Suzuki",200);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.addCar(car5);

        rentalSystem.menu();
    }
}

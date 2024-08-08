package com.java.carRentSystem;

import java.beans.Customizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Costomer> costomers;
    private List<Rent> rentals;

    public CarRentalSystem(){
        cars = new ArrayList<>();
        costomers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCostomer(Costomer costomer){
        costomers.add(costomer);
    }

    public void rentCar(Car car, Costomer costomer, int days){
        if (car.isAvailable()){
            car.rent();
            rentals.add(new Rent(car,costomer,days));
        }else {
            System.out.println("Car is Not Available for Rent");
        }
    }

    public void returnCar(Car car){
        car.returnCar();
        Rent renatalToReview = null;
        for(Rent rental : rentals){
            if (rental.getCar() == car){
                renatalToReview = rental;
                break;
            }
        }
        if (renatalToReview != null){
            rentals.remove(renatalToReview);
        }else{
            System.out.println("Car was Not Rented");
        }
    }

    public void menu(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("**********  Welcome To Car RentShowRoom  **********");
            System.out.println("\t\t1. Rent a Car");
            System.out.println("\t\t2. Return a Car");
            System.out.println("\t\t3. Exit");
            System.out.println("Enter a Choice");

            int choice = sc.nextInt();
            sc.nextLine();
            if(choice ==1){
                System.out.println("\n\t*** Rent a Car ***");
                System.out.print("Enter a Costomer Name: ");
                String costomerName = sc.nextLine();
                System.out.print("Enter a Mobile Number: ");
                double mobile = sc.nextDouble();
                System.out.print("Enter a Adhar Number: ");
                int adhar = sc.nextInt();

                System.out.println("\nCar Available");
                for (Car car : cars){
                    if (car.isAvailable()){
                        System.out.println(car.getCarId()+" - "+ car.getCrBrand()+" - "+car.getCarModl());
                    }
                }
                sc.nextLine();
                System.out.print("\nEnter the Car ID You Want to Rent: ");
                String carId = sc.nextLine();

                System.out.print("Enter a number of Days for Rent: ");
                int rentDays = sc.nextInt();
                sc.nextLine();

                Costomer newCostomer = new Costomer(costomerName,"CUS" + (costomers.size() + 1), adhar,mobile);
                addCostomer(newCostomer);

                Car selectdCar = null;
                for (Car car : cars){
                    if (car.getCarId().equalsIgnoreCase(carId) && car.isAvailable()){
                        selectdCar = car;
                        break;
                    }
                }

                if (selectdCar != null){
                    double totalPrice = selectdCar.calculatePrice(rentDays);
                    System.out.println("\n\t\t*** Rental Information ***");
                    System.out.println("Costomer Id: "+newCostomer.getCostomerId());
                    System.out.println("Costomer Name: "+newCostomer.getCutomerName());
                    System.out.println("Costomer Mobile: "+newCostomer.getMobileNumber());
                    System.out.println("Costomer Adhar: "+newCostomer.getCustomerAdhar());
                    System.out.println("Rental Days: "+rentDays);
                    System.out.println("Total Price: $%.2f%n"+totalPrice);

                    System.out.println("\n Conform Rental (Y/N): ");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("y")){
                        rentCar(selectdCar, newCostomer,rentDays);
                        System.out.println("\nCar Rent Successfully");
                    }else {
                        System.out.println("Rental is Cancel");
                    }
                }else {
                    System.out.println("\nInvalid Car Selection or Car not Available for Rent");
                }
            } else if (choice == 2) {
                System.out.println("\n*** Return a Car ***");
                System.out.println("Enter a Car ID you Want to Return: ");
                String carId = sc.nextLine();

                Car carReturn = null;
                for (Car car: cars){
                    if (car.getCarId().equalsIgnoreCase(carId) && !car.isAvailable()){
                        carReturn = car;
                        break;
                    }
                }
                if(carReturn != null){
                    Costomer costomer = null;
                    for (Rent rent : rentals){
                        if (rent.getCar() == carReturn){
                            costomer = rent.getCostomer();
                            break;
                        }
                    }

                    if (costomer != null){
                        returnCar(carReturn);
                        System.out.println("Car Return Successfully by "+ costomer.getCutomerName());
                    }else {
                        System.out.println("Car was not Rented or Rental Information is Missing");
                    }
                }else {
                    System.out.println("Invalid car Id or Car is Not Rent");
                }
            } else if (choice == 3) {
                break;
            }else {
                System.out.println("Invalid choice, Please enter Valid Option");
            }
        }
        System.out.println("\nThank you for Using car Rental Show Room");
    }
}


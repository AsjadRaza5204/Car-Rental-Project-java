package com.java.carRentSystem;

public class Car {
    private String carId;
    private String carModl;
    private String crBrand;
    private double carPrice;
    private boolean isAvailable;

    public Car(String carId, String carModl, String crBrand, double carPrice) {
        this.carId = carId;
        this.carModl = carModl;
        this.crBrand = crBrand;
        this.carPrice = carPrice;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarModl() {
        return carModl;
    }

    public void setCarModl(String carModl) {
        this.carModl = carModl;
    }

    public String getCrBrand() {
        return crBrand;
    }

    public void setCrBrand(String crBrand) {
        this.crBrand = crBrand;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double calculatePrice(int numberDays){
        return carPrice * numberDays;
    }

    public void rent(){
        isAvailable = false;
    }

    public boolean iisAvailable(){
        return isAvailable;
    }

    public void returnCar(){
        isAvailable = true;
    }
}

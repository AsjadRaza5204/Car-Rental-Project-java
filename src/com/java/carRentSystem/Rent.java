package com.java.carRentSystem;

public class Rent {
    private Car car;
    private Costomer costomer;
    private int days;

    public Rent(Car car, Costomer costomer, int days) {
        this.car = car;
        this.costomer = costomer;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Costomer getCostomer() {
        return costomer;
    }

    public void setCostomer(Costomer costomer) {
        this.costomer = costomer;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }



}

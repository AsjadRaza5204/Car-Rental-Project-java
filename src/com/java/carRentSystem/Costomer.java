package com.java.carRentSystem;

public class Costomer {
    private String cutomerName;
    private int customerAdhar;
   private double mobileNumber;
   private String costomerId;

    public Costomer(String cutomerName, String costomerId, int customerAdhar, double mobileNumber) {
        this.cutomerName = cutomerName;
        this.customerAdhar = customerAdhar;
        this.mobileNumber = mobileNumber;
        this.costomerId = costomerId;
    }


    public String getCutomerName() {
        return cutomerName;
    }

    public void setCutomerName(String cutomerName) {
        this.cutomerName = cutomerName;
    }

    public int getCustomerAdhar() {
        return customerAdhar;
    }

    public void setCustomerAdhar(int customerAdhar) {
        this.customerAdhar = customerAdhar;
    }

    public double getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(double mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCostomerId() {
        return costomerId;
    }

    public void setCostomerId(String costomerId) {
        this.costomerId = costomerId;
    }
}

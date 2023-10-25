package com.minhvo.listviewlunchmenu;

public class Meal {
    private String tenFood;
    private double priceFood;
    private String desFood;
    private int imgFood;

    public Meal(String tenFood, double priceFood, String desFood, int imgFood) {
        this.tenFood = tenFood;
        this.priceFood = priceFood;
        this.desFood = desFood;
        this.imgFood = imgFood;
    }

    public String getTenFood() {
        return tenFood;
    }

    public void setTenFood(String tenFood) {
        this.tenFood = tenFood;
    }

    public double getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(double priceFood) {
        this.priceFood = priceFood;
    }

    public String getDesFood() {
        return desFood;
    }

    public void setDesFood(String desFood) {
        this.desFood = desFood;
    }

    public int getImgFood() {
        return imgFood;
    }

    public void setImgFood(int imgFood) {
        this.imgFood = imgFood;
    }

}

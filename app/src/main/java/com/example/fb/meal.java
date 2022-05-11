package com.example.fb;

public class meal {
    private String FirstMeal;
    private String MainMeal;
    private String AddOn;
    private String Dessert;
    private String Drink;
    private String id;

    public String getFirstMeal() {
        return FirstMeal;
    }

    public void setFirstMeal(String firstMeal) {
        FirstMeal = firstMeal;
    }

    public String getMainMeal() {
        return MainMeal;
    }

    public void setMainMeal(String mainMeal) {
        MainMeal = mainMeal;
    }

    public String getAddOn() {
        return AddOn;
    }

    public void setAddOn(String addOn) {
        AddOn = addOn;
    }

    public String getDessert() {
        return Dessert;
    }

    public void setDessert(String dessert) {
        Dessert = dessert;
    }

    public String getDrink() {
        return Drink;
    }

    public void setDrink(String drink) {
        Drink = drink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public meal(){}

    public meal (String FirstMeal, String MainMeal, String AddOn, String Dessert, String Drink, String id) {
        this.FirstMeal=FirstMeal;
        this.MainMeal=MainMeal;
        this.AddOn=AddOn;
        this.Dessert=Dessert;
        this.Drink=Drink;
        this.id = id;
    }
}

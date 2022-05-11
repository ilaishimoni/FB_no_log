package com.example.fb;

public class order {
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getHour() {
        return Hour;
    }

    public void setHour(int hour) {
        Hour = hour;
    }

    public String getWorker() {
        return Worker;
    }

    public void setWorker(String worker) {
        Worker = worker;
    }

    public String getMeal() {
        return Meal;
    }

    public void setMeal(String meal) {
        Meal = meal;
    }

    public String getDeliveringCompany() {
        return DeliveringCompany;
    }

    public void setDeliveringCompany(String deliveringCompany) {
        DeliveringCompany = deliveringCompany;
    }

    private String Date;
    private int Hour;
    private String Worker;
    private String Meal;
    private String DeliveringCompany;

    public order(){}


    public order (String Date, int Hour, String Worker, String Meal, String DeliveringCompany) {
        this.Date=Date;
        this.Hour=Hour;
        this.Worker=Worker;
        this.Meal=Meal;
        this.DeliveringCompany=DeliveringCompany;
    }
}

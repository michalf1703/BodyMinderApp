package com.example.zadanie_zajecia2;

import android.app.Application;

public class MyApplication extends Application {
    private double calories;

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories += calories;
    }
}


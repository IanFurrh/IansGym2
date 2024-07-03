package com.example.android.iansgym;

public class Exercise {

    String name;
    int min;
    int sec;

    public Exercise(String name, int min, int sec) {
        this.name = name;
        this.min = min;
        this.sec = sec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getDuration() {
        return this.min * 60 + this.sec;
    }
}

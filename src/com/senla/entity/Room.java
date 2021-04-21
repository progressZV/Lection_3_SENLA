package com.senla.entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private boolean freeStatus = false;
    private boolean fixStatus = false;
    private int number = 0;
    private double cost = 0;
    private int stars_count;
    private int rooms_count;

   public Room(int number, double cost, int stars_count, int rooms_count, boolean freeStatus, boolean fixStatus){
        this.number = number;
        this.cost = cost;
        this.freeStatus = freeStatus;
        this.fixStatus = fixStatus;
        this.stars_count = stars_count;
        this.rooms_count = rooms_count;
    }

    public double getCost() { return cost; }

    public void setCost(double cost){
        this.cost = cost;
    }

    public boolean getFreeStatus(){
        return freeStatus;
    }

    public void setFreeStatus(boolean freeStatus) {
        this.freeStatus = freeStatus;
    }

    public boolean getFixStatus() {
        return fixStatus;
    }

    public void setFixStatus(boolean fixStatus) {
        this.fixStatus = fixStatus;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStars_count() { return stars_count; }

    public void setStars_count(int stars_count) {
        this.stars_count = stars_count;
    }

    public int getRooms_count() { return rooms_count; }

    public void setRooms_count(int rooms_count) {
        this.rooms_count = rooms_count;
    }
    @Override
    public String toString(){
        return getNumber() + "\t" +
                getCost() + "\t" + getRooms_count() +
                "\t" + getStars_count() + "\t" + getFreeStatus() + "\t" + getFixStatus() + "\n";
    }
}

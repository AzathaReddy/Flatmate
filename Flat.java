package assignment_5;

import java.util.ArrayList;
import java.util.List;

public class Flat {
    private int flat_id;
    private List<Flatmate> flat_residents = new ArrayList<Flatmate>();
    private Grocery grocery;
    private double flat_budget;
    private double grocery_budget;
    private Chores chores;

    private double totalRent;

    private int numberOfRooms;

    public Flat(double totalRent, int numberOfRooms) {
        // Do not use read implicitly anywhere aside from the App class !!!!!!!
        this.flat_budget = flat_budget;
        this.grocery_budget = grocery_budget;
        this.totalRent = totalRent;
        this.numberOfRooms = numberOfRooms;
        this.generateFlatID();
        Database.createFlat(Integer.toString(this.flat_id), numberOfRooms);


    }

    public Flat() {
        this.flat_id = 0;
        this.flat_budget = 0;
        this.grocery_budget = 0;
        this.generateFlatID();
        Database.createFlat(Integer.toString(this.flat_id), numberOfRooms);

    }

    public double getTotalRent() {
        return this.totalRent;
    }

    public void setTotalRent(double totalRent) {
        this.totalRent = totalRent;
    }

    public int getNumberOfRooms() {
        return this.numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getFlat_id() {
        return this.flat_id;
    }

    private void setFlat_id(int flat_id) {
        this.flat_id = flat_id;
    }

    public List<Flatmate> getFlat_residents() {
        return this.flat_residents;
    }

    public void setFlat_residents(List<Flatmate> flat_residents) {
        this.flat_residents = flat_residents;
    }

    public Grocery getGrocery() {
        return this.grocery;
    }

    public void setGrocery(Grocery grocery) {
        this.grocery = grocery;
    }

    public double getFlat_budget() {
        return this.flat_budget;
    }

    public void setFlat_budget(double flat_budget) {
        this.flat_budget = flat_budget;
    }

    public double getGrocery_budget() {
        return this.grocery_budget;
    }

    public void setGrocery_budget(double grocery_budget) {
        this.grocery_budget = grocery_budget;
    }

    public Chores getChores() {
        return this.chores;
    }

    public void setChores(Chores chores) {
        this.chores = chores;
    }

    private void generateFlatID() {
        int flatID = (int) (Math.random() * 10000000);
        setFlat_id(flatID);
    }

    public void displayFlatInhabitants() {
        for (int i = 0; i < this.flat_residents.size(); i++) {
            System.out.println("Resident " + i + " name is: " + this.flat_residents.get(i).getUser_name());
        }

    }

    public void assignFlatMateToList(Flatmate new_flatmate) {
        this.flat_residents.add(new_flatmate);
    }

    public void assignGroceryToFlatmate() {
        for (int i = 0; i < this.flat_residents.size(); i++) {
            this.flat_residents.get(i).setGrocery(this.grocery);
        }

    }

    public void displayGrocery(){

    }


}

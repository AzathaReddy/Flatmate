package assignment_5;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class Flatmate {
    private String user_name;
    private String email_address;
    private String password;
    private Flat residence_flat;

    private List<String> assigned_chores = new ArrayList<String>();
    private List<String> finished_chores = new ArrayList<String>();

    public List<String> getAssigned_chores() {
        return this.assigned_chores;
    }

    public void setAssigned_chores(List<String> assigned_chores) {
        this.assigned_chores = assigned_chores;
    }

    private List<String> boughtGrocery = new ArrayList<String>();
    private double spent_money;
    private Grocery grocery;
    private Chores chores;

    private double rent;

    public Flatmate(String name, String email_address, String password, Flat residence_flat) {

        this.user_name = name;
        this.email_address = email_address;
        this.password = password;
        Database.createUser(name, password);
        this.residence_flat = residence_flat;
        this.residence_flat.assignFlatMateToList(this);
        this.residence_flat.assignGroceryToFlatmate();


    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail_address() {
        return this.email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    private String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Flat getResidence_flat() {
        return this.residence_flat;
    }

    public void setResidence_flat(Flat residence_flat) {
        this.residence_flat = residence_flat;
    }

    public List<String> getFinished_chores() {
        return this.finished_chores;
    }

    public void setFinished_chores(List<String> finished_chores) {
        this.finished_chores = finished_chores;
    }

    public List<String> getBoughtGrocery() {
        return this.boughtGrocery;
    }

    public void setBoughtGrocery(List<String> boughtGrocery) {
        this.boughtGrocery = boughtGrocery;
    }

    public double getSpent_money() {
        return this.spent_money;
    }

    public void setSpent_money(double spent_money) {
        this.spent_money = spent_money;
    }

    public Grocery getGrocery() {
        return this.grocery;
    }

    public void setGrocery(Grocery grocery) {
        this.grocery = grocery;
    }

    public Chores getChores() {
        return this.chores;
    }

    public void setChores(Chores chores) {
        this.chores = chores;
    }

    public void add_spent_money(double added_amount) {
        this.spent_money += added_amount;
    }

    public void add_bought_grocery(String grocery) {
        this.boughtGrocery.add(grocery);
    }

    public void finished_chores(String finished_chore) {
        this.finished_chores.add(finished_chore);
    }

    public void assign_chore(String chore){
        this.assigned_chores.add(chore);
    }

    public void print_assigned_chores(){

        for (int i =0; i< this.assigned_chores.size(); i++){
            System.out.print(this.assigned_chores.get(i)+ " ");
        }
        System.out.println();

    }




}





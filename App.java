package assignment_5;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static List<Flat> allCreatedFlats = new ArrayList<Flat>();
    public static List<Flatmate> allCreatedFlatmates = new ArrayList<Flatmate>();
    public static List<Grocery> allCreatedGrocery = new ArrayList<Grocery>();
    public static List<Chores> allCreatedChores = new ArrayList<Chores>();

    public static void flat_creation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Total Flat Rent: ");
        double total_rent = sc.nextDouble();
        System.out.print("Total number of rooms: ");
        int nor = sc.nextInt();
        allCreatedFlats.add(new Flat(total_rent, nor));
    }

    public static void flatmate_creation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter Name: ");
        String Name = sc.nextLine();
        System.out.print("Please Enter E-mail: ");
        String email = sc.nextLine();
        System.out.print("Please Enter Password: ");
        String password = sc.nextLine();
        System.out.print("Please Enter flat ( starting from 1): ");
        int flat_index = sc.nextInt() - 1;
        allCreatedFlatmates.add(new Flatmate(Name, email, password, allCreatedFlats.get(flat_index)));
    }

    public static void assignGroceryToflat(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter flat ( starting from 1): ");
        int flat_index = sc.nextInt() - 1;
        Grocery grocery = new Grocery(allCreatedFlats.get(flat_index));
        grocery.Chai_Grocery();

    }

    public static  void assignChoresToflat(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter flat ( starting from 1): ");
        int flat_index = sc.nextInt() - 1;
        Chores chore = new Chores(allCreatedFlats.get(flat_index));
        allCreatedChores.add(chore);
        chore.createChoresList();
        chore.assignChoresRandom();
    }
    
    public static void displayFlatGrocery(){
        for (int i =0; i< allCreatedFlatmates.size(); i++){
            System.out.print("Flat "+i+": " );
            allCreatedFlats.get(i).getGrocery().displayGrocery();
        }
    }
    
    public static void displayUsersChores(){

        for (int i = 0; i<allCreatedFlatmates.size(); i++){
            System.out.print(allCreatedFlatmates.get(i).getUser_name()+": ");
            allCreatedFlatmates.get(i).print_assigned_chores();
        }
    }

    public static void FlatProject() {
        Scanner sc = new Scanner(System.in);

        Database.setFolderPath();
        Database.readflatsDB(Database.flats_Path);
        Database.readFlatmateDB(Database.flatmate_Path);
        System.out.println("Welcome To the Flat project this project sole purpose is to organize the shared stuff between the flatmates.");

        System.out.println("How many flat account do you wanna create");

        int flat_number = sc.nextInt();
        for (int i = 0; i < flat_number; i++) {
            flat_creation();
        }


        System.out.println("How many flatmate account do you wanna create");
        int flatmate_number = sc.nextInt();
        for (int i = 0; i < flatmate_number; i++) {
            flatmate_creation();
        }

        /*System.out.print("Do you want to create Groccery list? (1 for yes/ 0 for no) ");
        int flag = sc.nextInt();

        if (flag == 1){
            assignGroceryToflat();
        }

        System.out.print("Do you want to create chores and assign it to flatmates list? (1 for yes/ 0 for no) ");
         flag = sc.nextInt();

        if (flag == 1){
            assignChoresToflat();
       }

        displayFlatGrocery();
       displayUsersChores();

       Database.writeFlatmateDB(Database.flatmate_Path);
       Database.writeFlatsCSV(Database.flats_Path);
*/
        Database.writeFlatmateDB(Database.flatmate_Path);
        Database.writeFlatsCSV(Database.flats_Path);

    }

    public static void main(String[] args) {
    	
    	Display a = new Display();
    	a.Display1();
        //App.FlatProject();
        //GUIFlattie flattie = new GUIFlattie();

    }
}
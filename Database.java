package assignment_5;

import com.opencsv.CSVWriter;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class Database {


    public static List<List<String>> data2D = new ArrayList<List<String>>();
    public static List<List<String>> flat2D = new ArrayList<List<String>>();
    public static String[][] csv, flatCSV;
    public static String[][] reducingChoresList;

   // protected static String flatmate_Path = Paths.get("src/main/resources/Flats DB.csv").getParent() + "\\" + "Flatmates DB.csv";

   // protected static String flats_Path = Paths.get("src/main/resources/Flats DB.csv").getParent() + "\\" + "Flats DB.csv";
    protected static String flatmate_Path;
    protected static String flats_Path;
    /*
     * "readCSV()" read the csv DB readCSV(full path of te DB)
     * "createUser(userID , password)" Create new user and add it to the DB "
     * "setFlat(userID,flatID)" set the flat number for the user by using user ID
     * "setRoom(userID,room number)" set the room number for user by using user ID
     * "writeCSV()" rewrites all the DB along with the new data to the CSV file
     * "payRent(userID,rent)" set the paid rent per user
     * "payContributions(userID,paid contribution)" set the paid amount of money for a user
     * "getTenant(userID)" get an array of all the information related to a user from the DB
     * "getFlatRent(flatID)" get the total amount of paid rent for a given flat
     * "getTotalFlatTenants(flatID)" return the count of tenants living in a given flat
     * "getIndex(UseID)" return the row where a given user is stored in DB
     * "flatAvailability(flatID)" return a boolean value if the flat is fully occupied
     * "availableRooms(flatID)" return ana array of available rooms numbers , if the value in the array is zero, it means the room is occupied
     * "addItem(flat ID,item name)" add a new item to the grocery list of the specified flat
     * "removeItem(flat ID,item name)" remove the specified  item to the grocery list of the specified flat
     * "writeFlatsCSV()"rewrites all the flats DB along with the new data to the CSV file
     * "readflatsDB(DB full path)" reads the flats DB
     * "getFlatIndex(flat ID)" return the row where the flat ID is stored in the flat's DB
     * "getShoppingList(flat ID)" return an array of the shopping list of the specified list
     * "createFlat(flat ID, max capacity)" enter new apartment (flat) to the DB by entering flat ID and max number of rooms
     * "getChoresList(flat ID)" return a 9 in length array with chores for the specified flat
     * "getTenantRent(User ID)" returns the paid rent by the specified tenant
     * "addChore(flat ID, chore)" enter a new chore to specific flat
     * Note: All data in DB is case sensitive
     * */

    public static void setFolderPath(){

        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("PLease enter the project's parent folder path:");
			String parentPath = scanner.nextLine().toString();

			String p = String.valueOf(Paths.get(parentPath));

			flats_Path = p +"\\app"+ "\\"+Paths.get("java\\com\\software\\Flats DB.csv").getParent() + "\\" + "Flats DB.csv";
			flatmate_Path = p+ "\\app"+"\\"+Paths.get("java\\com\\software\\Flats DB.csv").getParent() + "\\" + "Flatmates DB.csv";
		}

    }
    public static void readFlatmateDB(String CSV_Path) {
        String line = "";


        try {
            try (BufferedReader buffer = new BufferedReader(new FileReader(CSV_Path))) {
				while ((line = buffer.readLine()) != null) {
				    String[] data1D = line.split(",");
				    data2D.add(Arrays.asList(data1D));
				}
			}
        } catch (FileNotFoundException var5) {
            throw new RuntimeException(var5);
        } catch (IOException var6) {
            throw new RuntimeException(var6);
        }

        csv = data2D.stream().map((l) -> {
            return l.stream().toArray((x$0) -> {
                return new String[x$0];
            });
        }).toArray((x$0) -> {
            return new String[x$0][];
        });

    }

    public static void readflatsDB(String CSV_Path) {
        String line = "";


        try {
            try (BufferedReader buffer = new BufferedReader(new FileReader(CSV_Path))) {
				while ((line = buffer.readLine()) != null) {
				    String[] data1D = line.split(",");
				    flat2D.add(Arrays.asList(data1D));
				}
			}
        } catch (FileNotFoundException var5) {
            throw new RuntimeException(var5);
        } catch (IOException var6) {
            throw new RuntimeException(var6);
        }

        flatCSV = flat2D.stream().map((l) -> {
            return l.stream().toArray((x$0) -> {
                return new String[x$0];
            });
        }).toArray((x$0) -> {
            return new String[x$0][];
        });

    }

    public static void createUser(String userID, String password) {

        if (getIndex(userID) != -1) {
            System.out.println("The user ID is already used!");
        } else {
            var copy = new String[csv.length + 1][csv[0].length + 1];
            for (int i = 0; i < csv.length; i++)
                for (int j = 0; j < csv[i].length; j++)
                    copy[i][j] = csv[i][j];
            for (int i = 0; i < csv[0].length; i++)
                copy[csv.length][i] = "null";

            copy[csv.length][0] = userID;
            copy[csv.length][2] = password;
            csv = copy;
        }

    }

    public static void createFlat(String flatID, int maxCapacity) {

        if (getFlatIndex(flatID) != -1) {
            System.out.println("The flat ID is already used!");
        } else {
            var copy = new String[flatCSV.length + 1][flatCSV[0].length + 1];
            for (int i = 0; i < flatCSV.length; i++)
                for (int j = 0; j < flatCSV[i].length; j++)
                    copy[i][j] = flatCSV[i][j];
            for (int i = 0; i < flatCSV[0].length; i++)
                copy[flatCSV.length][i] = "null";

            copy[flatCSV.length][0] = flatID;
            copy[flatCSV.length][3] = Integer.toString(maxCapacity);
            flatCSV = copy;
        }

    }

    // set the flat number for the user by using user ID
    public static void setFlat(String userID, String flatID) {

        csv[getIndex(userID)][1] = flatID;


    }

    public static void setRoom(String userID, String roomNumber) {

        csv[getIndex(userID)][3] = roomNumber;


    }

    // set the paid rent by a specific user
    public static void payRent(String userID, String rent) {

        csv[getIndex(userID)][4] = rent;


    }

    // set the amount of paid contributions by a certain user
    public static void payContributions(String userID, String contributions) {

        csv[getIndex(userID)][5] = contributions;


    }

    // get an array of all the details related to a specific user
    public static String[] getTenant(String userID) {

        String[] tenant = new String[csv[0].length];
        System.arraycopy(csv[getIndex(userID)], 0, tenant, 0, csv[getIndex(userID)].length);

        return tenant;
    }

    // get the total flat rent for a specific flat ID
    public static double getFlatRent(String FlatID) {

        double totalRent = 0;

        for (int i = 0; i < csv.length; i++) {

            if (csv[i][1].equals(FlatID)) totalRent += Double.parseDouble(csv[i][4]);

        }

        return totalRent;
    }


    public static void writeFlatmateDB(String path) {


        List<String[]> replica = new ArrayList<String[]>();
        try {
            // https://mkyong.com/java/how-to-export-data-to-csv-file-java/
            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(path);
            // https://stackoverflow.com/questions/13969254/unwanted-double-quotes-in-generated-csv-file
            // https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputFile, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.RFC4180_LINE_END);


            for (int i = 0; i < csv.length; i++) {

                replica.add(csv[i]);
            }

            writer.writeAll(replica);
            writer.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }


    public static void writeFlatsCSV(String path2) {


        List<String[]> replica = new ArrayList<String[]>();
        try {
            // https://mkyong.com/java/how-to-export-data-to-csv-file-java/
            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(path2);
            // https://stackoverflow.com/questions/13969254/unwanted-double-quotes-in-generated-csv-file
            // https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputFile, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.RFC4180_LINE_END);


            for (int i = 0; i < flatCSV.length; i++) {

                replica.add(flatCSV[i]);
            }

            writer.writeAll(replica);
            writer.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    // search and return the place "index" of a specific user in the DB
    public static int getIndex(String userID) {
        int index = -1;

        for (int i = 1; i < csv.length; i++) {

            if (csv[i][0].equalsIgnoreCase(userID)) return i;
        }

        return index;
    }

    // get the total tenants living in the same flat for a specific flat ID
    public static int getTotalFlatTenants(String flatID) {

        int totalFlatTenants = 0;

        for (int i = 0; i < csv.length; i++) {

            if (csv[i][1].equals(flatID)) totalFlatTenants++;
        }

        return totalFlatTenants;
    }

    // return if the flat has avaialbe rooms or not by using flatID and maximum capacity of the flat
    public static boolean flatAvailability(String flatID) {
        boolean availability = true;
        int tenantsCount = 0;

        for (int i = 0; i < csv.length; i++) {

            if (csv[i][1].equals(flatID)) tenantsCount++;
        }

        if (tenantsCount >= Integer.valueOf(flatCSV[getFlatIndex(flatID)][3])) return false;

        return availability;
    }

    // given a flat ID and max capacity of a flat, the function will return an array of all available flats numbers,otherwise, if the room number is 0 then it is occupied!
    public static String[] availableRooms(String flatID) {

        int maxCapacity = Integer.valueOf(flatCSV[getFlatIndex(flatID)][3]);

        String[] rooms = new String[maxCapacity];
        for (int i = 0; i < maxCapacity; i++) {

            rooms[i] = String.valueOf(i + 1);
        }
        for (int i = 0; i < csv.length; i++) {
            for (int j = 0; j < maxCapacity; j++) {
                if (csv[i][1].equals(flatID) && csv[i][3].equals(rooms[j])) rooms[j] = "0";

            }

        }
        return rooms;
    }


    public static void addItem(String flatID, String item) {

        String[] shoppingList = getShoppingList(flatID);
        boolean existance = false;
        for (int i = 0; i < shoppingList.length; i++) {

            if (item.equalsIgnoreCase(shoppingList[i].toLowerCase())) {
                existance = true;
            }

            if (shoppingList[i].equalsIgnoreCase("null")) removeItem(flatID, "null");

        }

        if (existance == false) {
            flatCSV[getFlatIndex(flatID)][1] = flatCSV[getFlatIndex(flatID)][1] + "/" + item;
        }

    }

    public static String[] getShoppingList(String flatID) {

        String[] shoppingList = flatCSV[getFlatIndex(flatID)][1].split("/");
        return shoppingList;

    }

    public static void removeItem(String flatID, String item) {

        String[] oldList = getShoppingList(flatID);
        String[] newList = new String[oldList.length - 1];
        int counter = 0;
        for (int i = 0; i < newList.length; i++) {

            if (item.equalsIgnoreCase(oldList[counter])) {
                counter++;
                continue;
            }
            newList[i] = oldList[counter];
            counter++;
        }
        String str = "";

        for (int i = 0; i < newList.length; i++) {

            if (newList[i] == null) continue;
            str = str + "/" + newList[i];
        }
        flatCSV[getFlatIndex(flatID)][1] = str;
    }

    private static int getFlatIndex(String flatID) {
        int index = -1;

        for (int i = 1; i < flatCSV.length; i++) {

            if (flatCSV[i][0].equalsIgnoreCase(flatID.toLowerCase())) return i;
        }

        return index;
    }

    public static String getTenantRent(String userID) {

        return csv[getIndex(userID)][4];

    }

    public static String[] getChoresList(String flatID) {

        String[] chores = new String[9];
        chores = flatCSV[getFlatIndex(flatID)][2].split("/");
        return chores;
    }

    public static void addChore(String flatID, String chore) {

        String[] chores = getChoresList(flatID);
        boolean existance = false;
        for (int i = 0; i < chores.length; i++) {

            if (chore.equalsIgnoreCase(chores[i].toLowerCase())) {
                existance = true;
            }

            if (chores[i].equalsIgnoreCase("null")) removeItem(flatID, "null");

        }

        if (existance == false) {
            flatCSV[getFlatIndex(flatID)][2] = flatCSV[getFlatIndex(flatID)][2] + "/" + chore;
        }

    }


    public static void removeChore(String flatID, String item) {

        String[] oldList = getChoresList(flatID);
        String[] newList = new String[oldList.length - 1];
        int counter = 0;
        for (int i = 0; i < newList.length; i++) {

            if (item.equalsIgnoreCase(oldList[counter])) {
                counter++;
                continue;
            }
            if (!oldList[i].equalsIgnoreCase("/")) {
                newList[i] = oldList[counter];
                counter++;
            }
        }
        String str = "";

        for (int i = 0; i < newList.length; i++) {

            if (oldList[i].equalsIgnoreCase("null")) continue;
            str = str + "/" + newList[i];
        }
        flatCSV[getFlatIndex(flatID)][2] = str;
    }

    public static void setChoreForUser(String userID,String[] chores){

        String chore = "";

        for (int i=0;i < chores.length;i++){

            chore += "/"+chores[i];

        }

        csv[getIndex(userID)][7]=chore;

    }

    public static String getChoreForUser(String userID){

        return csv[getIndex(userID)][7] ;
    }

}

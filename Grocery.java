package assignment_5;

import javax.xml.crypto.Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class Grocery {
    private List<String> grocery = new ArrayList<String>();
    private Flat flat;


    public Grocery(Flat flat) {
        this.flat = flat;
        this.grocery = Arrays.asList(Database.getShoppingList(Integer.toString(this.flat.getFlat_id())));
    }

    public Grocery() {
    }

    public List<String> getGrocery() {
        return this.grocery;
    }

    public void setGrocery(List<String> grocery) {
        this.grocery = grocery;
    }

    public Flat getFlat() {
        return this.flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public void addGroceryToList(String new_grocery) {
        String flat_id = Integer.toString(this.flat.getFlat_id());
        System.out.println(new_grocery);
        Database.addItem(flat_id, new_grocery);

    }

    public void deleteGroceryFromList(String grocery) {
        String flat_id = Integer.toString(this.flat.getFlat_id());
        Database.removeItem(flat_id, grocery);
    }

    public void cleanGroceryList() {
        String flat_id = Integer.toString(this.flat.getFlat_id());
        for (int i = 0; i < this.grocery.size(); i++) {
            String item = this.grocery.get(i);
            Database.removeItem(item, flat_id);
        }

    }

    public void createGroceryList() {

        String flat_id = Integer.toString(this.flat.getFlat_id());
        Scanner gr = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter the item to add (press enter to finish)");
            String item = gr.nextLine();
            if (item == "") {
                break;
            } else {
                this.grocery.add(item);
            }

        }

    }


    public void Chai_Grocery() {
    	System.out.println("Enter the Item to be added");
    	try (   Scanner in = new Scanner(System.in);
                FileOutputStream file = new FileOutputStream("java\\com\\software\\Grocery.csv",true);
                OutputStreamWriter out = new OutputStreamWriter(file, "UTF-8");
                BufferedWriter buf = new BufferedWriter(out);
                PrintWriter writer = new PrintWriter(buf)) {

            String first = in.nextLine();
                        
            writer.print(first);
            
            writer.println();
            in.close();
            
        } catch (Throwable t) {
            t.printStackTrace();
        }

        System.out.println("done.");

    }
    
    public boolean isEmpty() {
        return this.grocery.isEmpty();
    }

    public boolean isContainGrocery(String grocery) {
        return this.grocery.contains(grocery);
    }

    //THis method assign the flat grocery to the attribute grocery of the object
    public void assignFlatGrocery() {
        this.grocery = Arrays.asList(Database.getShoppingList(Integer.toString(this.flat.getFlat_id())));
    }

    public void assignFlat(Flat flat) {
        this.flat = flat;
    }

    public void displayGrocery(){
      /*  String flat_id = Integer.toString(this.flat.getFlat_id());
        grocery = this.grocery;
        for (int i = 0 ; i< grocery.size(); i++){
            System.out.print(grocery.get(i)+" ");
        }
        System.out.println();
*/
    	try{
    		Scanner sc = new Scanner(new File("C:\\Users\\saira\\OneDrive\\Desktop\\group19\\t4_testing\\Testing\\java-gradle-template-main\\app\\src\\main\\resources\\Grocery.csv"));
    	
    	//parsing a CSV file into the constructor of Scanner class 
	    sc.useDelimiter(",");
	    //setting comma as delimiter pattern
	    while (sc.hasNext()) {
	      System.out.print(sc.next());
	    }
	    sc.close();
	    //closes the scanner  
    }
    catch (Exception e) {
    	
    }

}
}
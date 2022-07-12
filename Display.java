package assignment_5;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Display {
     void Display1() {
        try (Scanner scanner = new Scanner(System.in)) {
			boolean exit = false;
			int option;

			while (!exit){

				System.out.println("1. Create Flat and Flatmate accounts");
			    System.out.println("2. View Information Board");
			    System.out.println("3. Leave a message on Information Board");
			    System.out.println("4. View Grocery List");
			    System.out.println("5. Add an item on grocery list");
			    System.out.println("6. Exit");
			    
			    try {

			    	System.out.println("Choose an option");
			    	option = scanner.nextInt();

			        switch (option){
			        
			        	case 1: App.FlatProject(); break;
			            case 2: Info_view(); break;
			            case 3: Info_write(); break;
			            case 4: Grocery_view(); break;
			            case 5: Grocery_add(); break;
			            case 6: exit = true; break;
			            default: System.out.println("Only numbers between 1 and 6");
			        }
			    }
			    catch (InputMismatchException ex){
			        System.out.println("Please enter an integer value between 1 and 6");
			        scanner.next();
			    }
			}
		}
    }

    public static void Info_view() {
	    try {
	    	Scanner sc = new Scanner(new File("C:\\Users\\saira\\OneDrive\\Desktop\\group19\\t4_testing\\Testing\\java-gradle-template-main\\app\\src\\main\\resources\\Information_1.csv"));
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
    
    
    public static void Info_write() {
    	System.out.println("Welcome to Information board. Please enter your name. ");

        try (   Scanner in = new Scanner(System.in);
                FileOutputStream file = new FileOutputStream("C:\\Users\\saira\\OneDrive\\Desktop\\group19\\t4_testing\\Testing\\java-gradle-template-main\\app\\src\\main\\resources\\Information_1.csv",true);
                OutputStreamWriter out = new OutputStreamWriter(file, "UTF-8");
                BufferedWriter buf = new BufferedWriter(out);
                PrintWriter writer = new PrintWriter(buf)) {

            String first = in.nextLine();
            System.out.println("Please enter today's date.");
            String second = in.nextLine();
            System.out.println("Please leave your message.");
            String third = in.nextLine();
                        
            writer.print(first);
            writer.print("\t");
            writer.print(second);
            writer.print("\t");
            writer.print(third);
            
            writer.println();
            in.close();
            
        } catch (Throwable t) {
            t.printStackTrace();
        }

        System.out.println("done.");
    }

public static void Grocery_add() {
	System.out.print("Do you want to create Groccery list? (1 for yes/ 0 for no) ");
	Scanner in = new Scanner(System.in);
    int flag = in.nextInt();

    if (flag == 1){
        App.assignGroceryToflat();

}
}

public void Grocery_view(){
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

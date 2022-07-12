package assignment_5;

import java.lang.reflect.Array;
import java.util.*;


public class Chores {
    private List<String> chores = new ArrayList<>();
    private Flat flat;

    public Chores(Flat flat) {
        this.flat = flat;
    }

    public List<String> getChores() {
        return this.chores;
    }

    public void setChores(List<String> chores) {
        this.chores = chores;
    }

    public Flat getFlat() {
        return this.flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public void assignChoreList() {

        this.chores = Arrays.asList(Database.getChoresList(Integer.toString(this.flat.getFlat_id())));
    }

    public void addChore(String chore) {
        String flat_id = Integer.toString(this.flat.getFlat_id());
        Database.addChore(flat_id, chore);
    }

    public void removeChore(String chore) {
        String flat_id = Integer.toString(this.flat.getFlat_id());
        Database.removeChore(flat_id, chore);
    }

    public void createChoresList(){

        String flat_id = Integer.toString(this.flat.getFlat_id());
        Scanner ch = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter the chore to add (press enter to finish)");
            String item = ch.nextLine();
            if (item == "") {
                break;
            } else {
                this.chores.add(item);
            }

        }

/*
       this.chores.add("Cleaning");
        this.chores.add("Garbage throw");
        this.chores.add("kitchen clean");
        this.chores.add("toilet clean");
        this.chores.add("dishes");
        this.chores.add("landury");
        this.chores.add("Balacony clean");
*/


    }



    public void assignChoresRandom(){
        String flat_id = Integer.toString(this.flat.getFlat_id());
        List<Flatmate> flat_resident = this.flat.getFlat_residents();
        List<String > chores = this.chores;

        for (int counter =0; counter <chores.size(); counter++){
            Flatmate rand =this.flat.getFlat_residents().get(new Random().nextInt(this.flat.getFlat_residents().size()));
            rand.assign_chore(chores.get(counter));
        }
    }


}

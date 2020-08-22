import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in); //creating a scanner object to read values from keyboard
        String inventoryId;
        int maximumAmount;
        int currentAmount;
        int threshold;
        Inventory[] obj = new Inventory[4]; //creating 4 objects using Inventory class
        for(int i=0; i<obj.length; i++){
            inventoryId = s.nextLine();
            maximumAmount = s.nextInt();
            currentAmount = s.nextInt();
            threshold = s.nextInt();
            s.nextLine();
            obj[i] = new Inventory(inventoryId, maximumAmount, currentAmount, threshold); //creating each object with these variable values
        }
        int limit = s.nextInt(); //reading a limit value
        Inventory[] res = replenish(limit, obj); //calling replenish method from main method
        for(Inventory i: res){ //Iteration
            if(i.getThreshold() >= 75)
                System.out.println(i.getInventoryId()+" Critical Filling");
            else if(i.getThreshold() >= 50)
                System.out.println(i.getInventoryId()+" Moderate Filling");
            else
                System.out.println(i.getInventoryId()+" Non-Critical Filling");
        }
        s.close();
    }
 
    public static Inventory[] replenish(int limit, Inventory[] obj){
        int count=0, j=0; //we have taken count to count how many objects are there to satisfy the condition given in question
        for(Inventory i: obj){
            if(i.getThreshold() <= limit) //If the threshold value of the objects is less than or equal to limit value, then we need to increment count
                count++;
        }
        Inventory[] res = new Inventory[count]; //creating another array of objects
        for(Inventory i: obj){
            if(i.getThreshold() <= limit){
                res[j] = i; //storing them in new array
                j++;
            }
        }
        return res; //returning array
    }
}
 
class Inventory{
    private String inventoryId;
    private int maximumAmount;
    private int currentAmount;
    private int threshold;
    public Inventory(String inventoryId, int maximumAmount, int currentAmount, int threshold){ //parameterized constructor
        super();
        this.inventoryId = inventoryId;
        this.maximumAmount = maximumAmount;
        this.currentAmount = currentAmount;
        this.threshold = threshold;
    }
    public String getInventoryId(){
        return inventoryId;
    }
    public int getThreshold(){
        return threshold;
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
 
public class Main{
    public static void main(String[] args){
        //Creating variables
        String iMEICode; //iMEICode is of String type 
        boolean isSingleSIM; //isSingleSIM is of Boolean type
        String processor; //processor is of String type
        double price; //price is of double type
        String manufacturer; //manufacturer is of String type
         
        //creating a scanner 's' object to read values from the keyboard and the syntax is shown below
        Scanner s = new Scanner(System.in); 
         
        //creating array of Mobile Class objects by using the below statement
        Mobile[] mobile = new Mobile[5]; 
         
        //reading each variable for each object using a for loop
        for(int i=0; i<5; i++){
            //reading iMEICode from keyboard using nextLine()
            iMEICode = s.nextLine(); 
            //reading isSingleSIM using nextBoolean()
            isSingleSIM = s.nextBoolean();s.nextLine(); 
            //here we need to use one more s.nextLine() statement inorder to read string correctly
            //reading processor using nextLine()
            processor = s.nextLine(); 
            // reading price using nextDouble()
            price = s.nextDouble();s.nextLine(); 
            //reading manufacturer using nextLine()
            manufacturer = s.nextLine(); 
            //assigning all variables to each object 'm'
            mobile[i] = new Mobile(iMEICode, isSingleSIM, processor, price, manufacturer); 
        }
        //reading discountPercentage
        double discountPercentage = s.nextDouble();s.nextLine(); 
        //reading manufacturerName
        String manufacturerName = s.nextLine(); 
         
        //Calling function getCountOfValidIMEIMobiles
        int countOfValidIMEIMobiles = getCountOfValidIMEIMobiles(mobile);
        //Calling function findMobileWithMaxPrice
        Mobile result = findMobileWithMaxPrice(mobile, discountPercentage, manufacturerName);
         
        //Printing results on the screen using System.out.println()
        System.out.println(countOfValidIMEIMobiles);
        if(result == null) //checking whether result object is null or not
            System.out.println("No Mobile Found");
        else
            System.out.println(result.getIMEICode()+"@"+result.getPrice());
    }
     
    public static int getCountOfValidIMEIMobiles(Mobile[] listOfMobiles){
        //count variable to count number of Mobiles which have 15 digit IMEI code
        int count = 0; 
        for(int i=0; i<listOfMobiles.length; i++){
            //checking IMEI code length and Single SIM status
            if(listOfMobiles[i].getIMEICode().length() == 15 && listOfMobiles[i].getIsSingleSIM() == true)
                count++; //If above condition true, then count increments
        }
        return count; //returning count of valid sims to main method
    }
     
    public static Mobile findMobileWithMaxPrice(Mobile[] listOfMobiles, double discountPercentage, String manufacturerName){
        //creating a mobile object 
        Mobile mobile = new Mobile(); 
        //Creating newPrice variable to get newPrice after applying discountPercentage
        double newPrice; 
        for(int i=0;i<listOfMobiles.length;i++){
            //checking manufacturerName variable with manufacturer in all objects by ignoring case 
            if(manufacturerName.equalsIgnoreCase(listOfMobiles[i].getManufacturer())){
                //formula for newPrice from the question
                newPrice = listOfMobiles[i].getPrice() - ((listOfMobiles[i].getPrice()*discountPercentage)/100);
                //setting newPrice for the mobile object which matches with manufacturer
                listOfMobiles[i].setPrice(newPrice); 
                //assigning that object to 'mobile' object
                mobile = listOfMobiles[i]; 
                return mobile; //returning mobile object to main function
            }
        }
        return null;
    }
}
 
class Mobile{
    String iMEICode;
    boolean isSingleSIM;
    String processor;
    double price;
    String manufacturer;
    //creating an empty constructor because we are creating an object in findMobileWithMaxPrice function
    Mobile(){} 
    //creating parameterized constructor
    Mobile(String iMEICode, boolean isSingleSIM, String processor, double price, String manufacturer){
        //if we have same variable names, we should use this keyword to store valules
        this.iMEICode = iMEICode; 
        this.isSingleSIM = isSingleSIM;
        this.processor = processor;
        this.price = price;
        this.manufacturer = manufacturer;
    }
    //creating getters and setters
    String getIMEICode(){
        return iMEICode;
    }
    boolean getIsSingleSIM(){
        return isSingleSIM;
    }
    String getProcessor(){
        return processor;
    }
    void setPrice(double price){ //we need a setter to assign new price to object
        this.price = price;
    }
    double getPrice(){
        return price;
    }
    String getManufacturer(){
        return manufacturer;
    }
}

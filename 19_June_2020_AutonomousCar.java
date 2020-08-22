import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
 
public class Main
{
 
 public static void main(String[] args)
 {
  //code to read values 
  int carId, noOfTestsConducted, noOfTestsPassed;
  String brand, environment, grade;
  Scanner s = new Scanner(System.in);
  AutonomousCar[] ac = new AutonomousCar[4]; //creating array of objects
  for(int i=0;i<4;i++){
    carId = s.nextInt();s.nextLine();
    brand = s.nextLine();
    noOfTestsConducted = s.nextInt();
    noOfTestsPassed = s.nextInt();s.nextLine();
    environment = s.nextLine();
    ac[i] = new AutonomousCar(carId, brand, noOfTestsConducted, noOfTestsPassed, environment); //assigning values to each object
    }
    String getEnv = s.nextLine();
    String getBrand = s.nextLine();
    int sumEnv = findTestPassedByEnv(ac, getEnv); //calling method
    if(sumEnv==0)
        System.out.println("There are no tests passed in this particular environment");
    else
        System.out.println(sumEnv);
    AutonomousCar acar = updateCarGrade(ac, getBrand);
    if(acar==null)
        System.out.println("No Car is available with the specified brand");
    else
        System.out.println(acar.getBrand()+"::"+acar.getGrade());
  }
  
 
 public static int findTestPassedByEnv(AutonomousCar[] acArray, String env) 
  {
   //method logic
   int sum = 0;
   for(int i=0;i<acArray.length; i++){
       if(env.equalsIgnoreCase(acArray[i].getEnvironment())){
           sum = sum+acArray[i].getNoOfTestsPassed(); //finding total number of tests passed by that car
       }
   }
   return sum;
  }
 
public static AutonomousCar updateCarGrade(AutonomousCar[] acArray, String brand) 
  {
   //method logic
    AutonomousCar ac = new AutonomousCar();
    int rating;
    for(int i=0;i<acArray.length;i++){
        if(brand.equalsIgnoreCase(acArray[i].getBrand())){
            rating = (acArray[i].getNoOfTestsPassed()*100)/acArray[i].getNoOfTestsConducted(); //setting grades to cars based on constraints given in question.
            if(rating>=80) acArray[i].setGrade("A1");
            else acArray[i].setGrade("B2");
            ac = acArray[i];
            return ac;
        }
    }
    return null;
  }
}
 
class AutonomousCar 
{
  //code to build the class
  int carId, noOfTestsConducted, noOfTestsPassed;
  String brand, environment, grade;
  AutonomousCar(){};
  AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment){ //parameterized constructor
      super();
      this.carId = carId;
      this.brand = brand;
      this.noOfTestsConducted = noOfTestsConducted;
      this.noOfTestsPassed = noOfTestsPassed;
      this.environment = environment;
  }
  int getCarId(){
      return carId;
  }
  String getBrand(){
      return brand;
  }
  int getNoOfTestsConducted(){
      return noOfTestsConducted;
  }
  int getNoOfTestsPassed(){
      return noOfTestsPassed;
  }
  String getEnvironment(){
      return environment;
  }
  void setGrade(String grade){
      this.grade = grade;
  }
  String getGrade(){
      return grade;
  }
}

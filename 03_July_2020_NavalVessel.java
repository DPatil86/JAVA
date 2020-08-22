import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
 
public class Solution
{
 
 public static void main(String[] args)
 {
  //code to read values 
  Scanner s = new Scanner(System.in);
  int vesselId, noOfVoyagesPlanned, noOfVoyagesCompleted;
  String vesselName, purpose;
  NavalVessel[] nv = new NavalVessel[4]; //creating array of objects
  for(int i=0;i<nv.length;i++){
      vesselId = s.nextInt();s.nextLine();
      vesselName = s.nextLine();
      noOfVoyagesPlanned = s.nextInt();
      noOfVoyagesCompleted = s.nextInt();s.nextLine();
      purpose = s.nextLine();
      nv[i] = new NavalVessel(vesselId, vesselName, noOfVoyagesPlanned, noOfVoyagesCompleted, purpose); //assigning the values to each object
  }
  int getPercentageValue = s.nextInt();s.nextLine();
  String getPurposeValue = s.nextLine();
  //code to call required method
  int avgOfVoyagesCompleted = findAvgVoyagesByPct(nv, getPercentageValue);
   
  if(avgOfVoyagesCompleted>0)
    System.out.println(avgOfVoyagesCompleted);
    else
        System.out.println("There are no voyages completed with this percentage");
  //code to display the result
 
    NavalVessel navalvessel = findVesselByGrade(nv, getPurposeValue);
    if(navalvessel == null)
        System.out.println("No Naval Vessel is available with the specified purpose");
    else
        System.out.println(navalvessel.getVesselName()+"%"+navalvessel.getClassification());
 }
 
 public static int findAvgVoyagesByPct(NavalVessel[] nvArray, int percentage)
  {
   //method logic
   int avg = 0,count=0;
   for(int i=0;i<nvArray.length;i++){
       int percent = (nvArray[i].getNoOfVoyagesCompleted()*100)/nvArray[i].getNoOfVoyagesPlanned();
       if(percent >= percentage){
           avg += nvArray[i].getNoOfVoyagesCompleted();
           count++;
       }
   }
   if(avg == 0)
        return 0;
    else
        return avg/count;
  }
 
public static NavalVessel findVesselByGrade(NavalVessel[] nvArray, String purpose)
  {
   //method logic
   NavalVessel nv = new NavalVessel();
   for(int i=0;i<nvArray.length;i++){
       if(purpose.equalsIgnoreCase(nvArray[i].getPurpose())){
           int percentage = (nvArray[i].getNoOfVoyagesCompleted()*100)/nvArray[i].getNoOfVoyagesPlanned(); //finding percentage
           if(percentage==100) nvArray[i].setClassification("Star"); 
           else if(percentage >=80 && percentage <=99) nvArray[i].setClassification("Leader");
           else if(percentage >=55 && percentage <=79) nvArray[i].setClassification("Inspirer");
           else
            nvArray[i].setClassification("Striver");
            nv = nvArray[i];
            return nv;
       }
   }
   return null;
  }
}
 
class NavalVessel 
{
  //code to build the class
  int vesselId, noOfVoyagesPlanned, noOfVoyagesCompleted;
  String vesselName, purpose, classification;
  NavalVessel(){}
  NavalVessel(int vesselId, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted, String purpose){
      super();
      this.vesselId = vesselId;
      this.vesselName = vesselName;
      this.noOfVoyagesPlanned = noOfVoyagesPlanned;
      this.noOfVoyagesCompleted = noOfVoyagesCompleted;
      this.purpose = purpose;    
    }
    int getVesselId(){
        return vesselId;
    }
    String getVesselName(){
        return vesselName;
    }
    int getNoOfVoyagesPlanned(){
        return noOfVoyagesPlanned;
    }
    int getNoOfVoyagesCompleted(){
        return noOfVoyagesCompleted;
    }
    String getPurpose(){
        return purpose;
    }
    void setClassification(String classification){
        this.classification = classification;
    }
    String getClassification(){
        return classification;
    }
}

import java.util.*;
 
public class Solution{
    public static void main(String[] args){
        int wardNo;
        String personName;
        int age;
        String village;
        String taluk;
        Scanner s = new Scanner(System.in); //creating a scanner object 
        People[] people = new People[4]; //creating array of objects using People Calss
        for(int i=0; i<4; i++){
            wardNo = s.nextInt();s.nextLine();
            personName = s.nextLine();
            age = s.nextInt();s.nextLine();
            village = s.nextLine();
            taluk = s.nextLine();
            people[i] = new People(wardNo, personName, age, village, taluk); //assigning all the read values to the people objects one by one
        }
        String getVillageName = s.nextLine();
        int getWardNumber = s.nextInt();
        s.close();
         
        int eligiblePeopleAvg = findAvgAgeOfEligiblePeopleByVillage(people, getVillageName); //calling methods
        People[] p = searchPeopleByWardNo(getWardNumber, people);
         
        if(eligiblePeopleAvg == 0)
            System.out.println("There are no eligible people in the given village");
        else
            System.out.println(eligiblePeopleAvg);
        if(p == null)
            System.out.println("There are no people in the given ward");
        else
            for(int i=0; i<p.length; i++){
                System.out.println(p[i].getPersonName());
            }
    }
     
    public static int findAvgAgeOfEligiblePeopleByVillage(People[] people, String village){
        int count = 0, sum = 0;
        for(int i=0; i<people.length; i++){
            if(village.equalsIgnoreCase(people[i].getVillage()) && people[i].getAge()>=18){ //condition to check the people whose age is >= 18 in the given village.
                sum += people[i].getAge();
                count++;
            }
        }
        if(count == 0)
            return 0;
        else
            return sum / count; //returning average age of eligible persons in that given village
         
    }
     
    public static People[] searchPeopleByWardNo(int wardNo, People[] people){
        int count = 0;
        for(int i=0; i<people.length; i++){
            if(people[i].getWardNo() == wardNo) count++;
        }
        if(count == 0) return null;
        People[] p = new People[count];
        int x = 0;
        for(int i=0; i<people.length; i++){
            if(people[i].getWardNo() == wardNo){
                p[x++] = people[i];
            }
        }
        for(int i=0; i<x; i++){ //sorting people age of the given ward number
            for(int j=i+1; j<x; j++){
                if(p[i].getAge() > p[j].getAge()){
                    People temp = p[i];
                    p[i] = p[x];
                    p[x] = temp;
                }
            }
        }
        return p; //returning the array of objects
    }
}
 
class People{
    int wardNo;
    String personName;
    int age;
    String village;
    String taluk;
    People(int wardNo, String personName, int age, String village, String taluk){ //parameterized constructor
        this.wardNo = wardNo;
        this.personName = personName;
        this.age = age;
        this.village = village;
        this.taluk = taluk;
    }
    //creating getters
    int getWardNo(){
        return wardNo;
    }
    String getPersonName(){
        return personName;
    }
    int getAge(){
        return age;
    }
    String getVillage(){
        return village;
    }
    String getTaluk(){
        return taluk;
    }
}

import java.util.Scanner; //importing scanner to read data from keyboard
public class Main{ //this program is executed in Onlinegdb, so class name is Main
    public static void main(String[] args){
        Scanner s = new Scanner(System.in); //creating scanner object for reading data
         
        int regNo;
        String agencyName;
        String packageType;
        int price;
        boolean flightFacility; //variable names given in question
         
        TravelAgencies[] ta = new TravelAgencies[4]; //creating array of objects
 
        for(int i=0;i<4;i++){ //reading values from keyboard for each variable
            regNo = s.nextInt();s.nextLine();
            agencyName = s.nextLine();
            packageType = s.nextLine();
            price = s.nextInt();
            flightFacility = s.nextBoolean();
            ta[i] = new TravelAgencies(regNo, agencyName, packageType, price, flightFacility); //assigning values for each object
        }
         
        int getRegNo = s.nextInt();s.nextLine(); //constraint 1 from question
        String getPackageType = s.nextLine(); //constraint 2 from question
        s.close(); //closing scanner object
         
        int highestPackagePrice = findAgencyWithHighestPackagePrice(ta);
        TravelAgencies travelAgencies = agencyDetailsForGivenIdAndType(ta, getRegNo, getPackageType); //calling static methods from main function
         
        System.out.println(highestPackagePrice); //printing highest price
        if(travelAgencies == null)
            System.out.println("A string value should be printed here!");
        else
          System.out.println(travelAgencies.getAgencyName()+":"+travelAgencies.getPrice());
          //printing agencyName and price with required constraints from question
    }
    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] agencies){
        int maxPrice = agencies[0].getPrice(); //taking object1 price value as max
        for(int i=1;i<agencies.length;i++){
            if(agencies[i].getPrice() > maxPrice)
                maxPrice = agencies[i].getPrice(); //comparing all prices to get maximum
        }
        return maxPrice; // returning maximum price from all objects
    }
    public static TravelAgencies agencyDetailsForGivenIdAndType(TravelAgencies[] agencies, int regNo, String packageType){
        TravelAgencies ta = new TravelAgencies(); //creating an object
        for(int i=0;i<agencies.length;i++){
            if(agencies[i].getFlightFacility()){ //condition 1 checking
                if(agencies[i].getRegNo()==regNo && packageType.equalsIgnoreCase(agencies[i].getPackageType())){ //condition 2 checking
                    ta = agencies[i]; //if 2 conditions satisfy, assigning object
                    return ta; //returning required object to main function
                }
            }
        }
        return null; //if no conditions satisfy, null value is returned
    }
}
 
class TravelAgencies{
    int regNo;
    String agencyName;
    String packageType;
    int price;
    boolean flightFacility;
    TravelAgencies(){} //empty constuctor
    TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility){ //parameterized constructor
        super();
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }
    int getRegNo(){ //getter for regNo
        return regNo;
    }
    String getAgencyName(){ //getter for agencyName
        return agencyName;
    }
    String getPackageType(){ //getter for packageType
        return packageType;
    }
    int getPrice(){ //getter for price
        return price;
    }
    boolean getFlightFacility(){ //getter for flightFacility
        return flightFacility;
    }
}

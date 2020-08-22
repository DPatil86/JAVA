import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); 
        Sims[] obj = new Sims[5]; //creating array of Sims objects
        String circle1, circle2;
        for(int i=0;i<obj.length;i++){
            int simId = s.nextInt();s.nextLine();
            String customerName = s.nextLine();
            double balance = s.nextDouble();
            double ratePerSecond = s.nextDouble();s.nextLine();
            String circle = s.nextLine();
            obj[i] = new Sims(simId, customerName, balance, ratePerSecond, circle); //assigning values
        }
        circle1 = s.nextLine();
        circle2 = s.nextLine();
        s.close();
        Sims[] result = findCircleAndChangeSimCard(obj, circle1, circle2); //calling method from main method
        for(Sims sim : result){
            System.out.println(sim.getSimId()+" "+sim.getCustomerName()+" "+sim.getRatePerSecond()+" "+sim.getCircle());
        }
    }
    public static Sims[] findCircleAndChangeSimCard(Sims[] obj, String circle1, String circle2){
        int count = 0, x = 0;
        for(Sims s : obj)
            if((s.getCircle()).equals(circle1)) //if the circle1 value equals to the circle of that object, then count value increments
                count++;
        Sims[] res = new Sims[count]; //creating number of objects which satisfies above condition
        for(Sims s : obj){
            if((s.getCircle()).equals(circle1)){
                s.setCircle(circle2); //setting new circle value upon existing
                res[x] = s;
                x++;
            }
        }
        for(int i=0;i<res.length;i++){
            for(int j=i=1;j<res.length;j++){
                if(res[i].getRatePerSecond()<res[j].getRatePerSecond()){ //sorting the values
                    Sims temp = res[i];
                    res[i] = res[j];
                    res[j] = temp;
                }
            }
        }
        return res;
    }
}
 
class Sims{
    private int simId;
    private String customerName;
    private double balance;
    private double ratePerSecond;
    private String circle;
    public Sims(int simId, String customerName, double balance, double ratePerSecond, String circle){
        this.simId = simId;
        this.customerName = customerName;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }
    public int getSimId(){
        return simId;
    }
    public void setSimId(int simId){
        this.simId = simId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public double getRatePerSecond(){
        return ratePerSecond;
    }
    public void setRatePerSecond(double ratePerSecond){
        this.ratePerSecond = ratePerSecond;
    }
    public String getCircle(){
        return circle;
    }
    public void setCircle(String circle){
        this.circle = circle;
    }
}

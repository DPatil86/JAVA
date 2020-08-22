import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Medicine[] medicine = new Medicine[4]; //creating array of medicine objects
        for(int i=0; i<medicine.length; i++){
            String medicineName = s.nextLine();
            String batchNo = s.nextLine();
            String disease = s.nextLine();
            int price = s.nextInt();s.nextLine();
            medicine[i] = new Medicine(medicineName, batchNo, disease, price); //assigning all the read values to each object one by one
        }
        String requiredDisease = s.nextLine();
        s.close(); //closing scanner object
        Integer[] result = getPriceOfRequiredDisease(medicine, requiredDisease); //calling method
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
    public static Integer[] getPriceOfRequiredDisease(Medicine[] medicine, String disease){
        int count = 0, x = 0;
        for(int i=0; i<medicine.length; i++){
            if(medicine[i].getDisease().equals(disease)) //If required disease value matches will existing disease values, then count increments.
                count++;
        }
        Integer[] obj = new Integer[count]; //creating number of objects required
        for(int i=0; i<medicine.length; i++){
            if(medicine[i].getDisease().equals(disease))
                obj[x++] = medicine[i].getPrice(); //storing the prices according to conditions given in question.
        }
        for(int i=0; i<obj.length; i++){
            for(int j=i+1; j<obj.length; j++){ //sorting all the prices that are stored in new array
                if(obj[i]>obj[j]){
                    int temp = obj[i];
                    obj[i] = obj[j];
                    obj[j] = temp;
                }
            }
        }
        return obj;
    }
}
class Medicine{
    String medicineName;
    String batchNo;
    String disease;
    int price;
    Medicine(String medicineName, String batchNo, String disease, int price){
        super();
        this.medicineName = medicineName;
        this.batchNo = batchNo;
        this.disease = disease;
        this.price = price;
    }
    String getMedicineName(){
        return medicineName;
    }
    void setMedicineName(String medicineName){
        this.medicineName = medicineName;
    }
    String getBatchNo(){
        return batchNo;
    }
    void setBatchNo(String batchNo){
        this.batchNo = batchNo;
    }
    String getDisease(){
        return disease;
    }
    void setDisease(String disease){
        this.disease = disease;
    }
    int getPrice(){
        return price;
    }
    void setPrice(int price){
        this.price = price;
    }
}

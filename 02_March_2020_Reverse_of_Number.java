import java.util.Scanner;
 
public class Main
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long number = s.nextLong(); //reading the number using long datatype
        long sum = 0; //creating another long variable to save reversed number
        while(number > 0){
            long rem = number % 10; //By performing this condition, the last value of the number will gets saved into 'rem' variable
            sum = sum*10 + rem; //We need to multiply it by 10 because to increment it's units place
            number /= 10; //now, remove that last number as it is already saved. so the remaining numbers will be there to done the same process as stated above.
        }
        System.out.println("Reverse of the number is "+sum);
    }
}

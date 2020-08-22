import java.util.*;
import java.lang.*;
 
public class Main
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //creating a scanner object to read values from keyboard
        String str = s.nextLine(); //reading a string from keyboard and storing in 'str' variable
        str = str.toLowerCase(); //converting all the characters in the string to lowerCase
        int vowelCount = 0, consonantCount = 0; //creating variables for storing vowelCount and consonantCount in the String
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a' && str.charAt(i)<='z'){ //checking whether the character in the string is between 'a' and 'z'
                if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u')
                    vowelCount += 1; //if the character is 'a' or 'e' or 'i' or 'o' or 'u', then vowelCount will increment
                else
                    consonantCount += 1; //else consonantCount will increment
            }
        }
        //Displaying the values of both vowelCount and consonantCount to the output screen
        System.out.println("Vowels count is "+vowelCount);
        System.out.println("Consonant Count is "+consonantCount);
    }
}

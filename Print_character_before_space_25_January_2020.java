import java.util.*; //Importing all the packages that resides in util package

public class Solution{ //Creating a class Solution with public Access Specifier
    public static void main(String[] args){
        Scanner s = new Scanner(System.in); //Creating a Scanner object to read values from keyboard.
        String str = s.nextLine(); //Reading a string from keyboard and storing in 'str' variable
        for(int i=0;i<str.length();i++){ //Iterating for loop until the last character of the string
            if(str.charAt(i) == ' ') //Checking condition: if the character in String is ' ' or not
                System.out.print(str.charAt(i-1)); //If the above expression is true, then print the character before ' '
        }
        System.out.print(str.charAt(i-1)); //after all iterations, we need to print the last character also
    }
}

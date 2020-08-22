import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        char min = 'z'; //firstly assuming the minimal vowel is 'z'
        for(int i=0;i<str.length();i++){
            Character.toLowerCase(str.charAt(i));
            if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                if(str.charAt(i) < min) //comparing the character with minimal vowel which is previously assigned to 'z'
                    min = str.charAt(i); //finally the minimal vowel will be the output
            }
        }
        System.out.println(min);
    }
}

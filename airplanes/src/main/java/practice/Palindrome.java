package practice;
import java.util.Arrays;


public class Palindrome {

    public boolean isPalindrome(String word) {
        char[] letters = word.toCharArray();
        int length = letters.length-1;
        int iteration = length/2;
        char temp;

        for(int i=0 ; i<=iteration ; i++){
            temp = letters[i];
            letters[i] = letters[length-i];
            letters[length-i]=temp;
        }
            return Arrays.equals(word.toCharArray(),letters);
    }
}

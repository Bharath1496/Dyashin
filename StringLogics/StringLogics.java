package Practice;
import java.util.*;

public class StringLogics {
	
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    
    public static int countVowels(String str) {
        int count = 0;
        for (char ch : str.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    
    public static boolean areAnagrams(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    
    public static char firstNonRepeatingChar(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str.toCharArray()) {
            if (charCount.get(ch) == 1) {
                return ch;
            }
        }
        return '\0'; 
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println("Reversed: " + reverseString(str));
        System.out.println("Is Palindrome: " + isPalindrome("madam"));
        System.out.println("Vowel Count: " + countVowels(str));
        System.out.println("Are Anagrams: " + areAnagrams("listen", "silent"));
        System.out.println("First Non-Repeating: " + firstNonRepeatingChar("swiss"));
    }
}

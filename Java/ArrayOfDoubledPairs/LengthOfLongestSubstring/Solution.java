import java.util.*;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> usedChars = new HashSet();
        int maxLength = 0;
        int currentLength = 0;
        int i = 0;
        int j = 0;
        while(i < s.length() && j < s.length()){
            char currentChar = s.charAt(j);
            if(!usedChars.contains(currentChar)){
                currentLength++;
                usedChars.add(currentChar);
                j++;
            }
            else{
                usedChars.remove(s.charAt(i));
                i++;
                currentLength--;
            }
            if(currentLength > maxLength){
                maxLength = currentLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] args){
        System.out.println("Length of longest substring: " + Integer.toString(lengthOfLongestSubstring(args[0])));
    }
}
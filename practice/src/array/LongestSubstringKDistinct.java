package array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }

    private static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();
        Map<Character, Integer> charFreqMap = new HashMap<>();
        int maxLength = 0;
        for(int windowStart=0, windowEnd=0; windowEnd < str.length(); windowEnd++){
            Character rightChar = str.charAt(windowEnd);
            charFreqMap.put(rightChar,  (charFreqMap.getOrDefault(rightChar, 0) + 1));
            while(charFreqMap.size() > k){
                Character leftChar = str.charAt(windowStart);
                charFreqMap.put(leftChar,  (charFreqMap.get(leftChar) - 1));
                if(charFreqMap.get(leftChar) ==0 ){
                    charFreqMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd -windowStart+1);
        }
        return maxLength;
    }
}

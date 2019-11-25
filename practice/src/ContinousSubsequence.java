import java.util.HashMap;
import java.util.Map;

/**
 * Given a pixel sequence consisting of red, green and blue pixels find the count of all contiguous subsequences such that each subsequence has a minimum length of 3 and the sequence cycles between red r, green g and blue b. For eg. if the sequence starts with g then the next character in the sequence should be b and the next should be r and so on.
 *
 * Input Format
 * First line of test case consists of an integer t denoting the number of test cases. Next t test cases follow. Each test case consists of two lines. First line of each test case is the length of the pixel sequence. Second line is the pixel sequence.
 *
 * Sample Input
 * 5
 * 3
 * rgb
 * 4
 * brgb
 * 2
 * rg
 * 1
 * b
 * 16
 * rgbrbbrgbgbrgrgb
 * Sample Output
 * 1
 * 3
 * 0
 * 0
 * 10
 * Explanation
 * For the character sequence rgbrbbrgbgbrgrgb, there are 10 possible contiguous subsequences viz. rgb, rgbr, gbr, brg, brgb, rgb, gbr, gbrg, brg, rgb which satisfy the condition.
 */
public class ContinousSubsequence {

    private static void printSequences(char[] arr, Map<Character, Character> sequence) {
        int start, end, count=0;
        for(start=0, end=0; end<arr.length ; ){
            char current = arr[end];
            if(end - start >= 2){
                for(int i=start; i<end+1; i++){
                    System.out.print(arr[i]);
                }
               /* int innerStart = start + 1;
                int innerEnd =end - 1;
                for(int loop = (end-start)/3;loop>0; loop--){
                    for(int i=start+1, j=end;)
                }*/

                count++;
                System.out.print(", ");
            }

            if(end+1 < arr.length && sequence.get(current) == arr[end+1]){
                end++;
            } else if(start < end){
                start++;
            }
            //g r g b r g b g b g  g  b  g  r  r  r  g  g  r  b  g  r  r  b
            //0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
            if(start == end){
                end++;
                if(start<arr.length && end<arr.length && sequence.get(arr[start])!=arr[end]){
                    start++;
                }
            }
        }
        System.out.println("count::"+count);
    }

    public static void main(String args[]){
        Map<Character, Character> sequence = new HashMap<>();
        sequence.put('r', 'g');
        sequence.put('g', 'b');
        sequence.put('b', 'r');
        printSequences("grgbrgbgbggbgrrrggrbgrrb".toCharArray(), sequence);
        printSequences("rgbrg".toCharArray(), sequence);
    }



}

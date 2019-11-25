package array;

public class MinSizeSubArraySumK {
    public static int findMinSubArray(int k, int[] arr) {
        int windowSum = arr[0], minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length ;windowEnd++ ) {
             // add the next element
            windowSum += arr[windowEnd];
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            while (windowSum >= k) {
                minLength = Math.min(minLength, (windowEnd-windowStart)+1);
                windowSum -= arr[windowStart]; // subtract the element going out
                 // slide the window ahead
                windowStart++;

            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySumK.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySumK.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySumK.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}

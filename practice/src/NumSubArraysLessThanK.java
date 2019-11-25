/**
 * Given an array of non-negative numbers and a non-negative number k, find the number of subarrays having sum less than k. We may assume that there is no overflow.
 *
 * Examples :
 *
 * Input : arr[] = {2, 5, 6}
 *         K = 10
 * Output : 4
 * The subarrays are {2}, {5}, {6} and
 * {2, 5},
 *
 * Input : arr[] = {1, 11, 2, 3, 15}
 *         K = 10
 * Output : 4
 * {1}, {2}, {3} and {2, 3}
 */
public class NumSubArraysLessThanK {


    // Function to find number
    // of subarrays having sum
    // less than k.
    static int countSubarray(int arr[],
                             int n, int k) {
        int start = 0, end = 0;
        int count = 0, sum = arr[0];

        while (start < n && end < n) {

            // If sum is less than k,
            // move end by one position.
            // Update count and sum
            // accordingly.
            if (sum < k) {
                end++;

                if (end >= start)
                    count += end - start;

                // For last element,
                // end may become n.
                if (end < n)
                    sum += arr[end];
            }

            // If sum is greater than or
            // equal to k, subtract
            // arr[start] from sum and
            // decrease sliding window by
            // moving start by one position
            else {
                sum -= arr[start];
                start++;
            }
        }

        return count;
    }

     // Driver Code
    public static void main(String[] args) {
        int array[] = {1, 10, 2, 3, 4,5,9};
        int k = 15;
        int size = array.length;
        int count = countSubarray(array, size, k);
        System.out.println(count);

        int arr[] = { 1, 4, 6 };
        int n = array.length;

        int L = 2;
        int R = 10;

        //System.out.println(findSubSumLtoR(array, n, L, R));
    }

    // Function to find number
    // of subarrays having sum
    // in the range L to R.
    static int findSubSumLtoR(int arr[], int n,
                              int L, int R)
    {

        // Number of subarrays
        // having sum less than
        // or equal to R.
        int Rcnt = countSubarray(arr, n, R);

        // Number of subarrays
        // having sum less than
        // or equal to L-1.
        int Lcnt = countSubarray(arr, n, L - 1);

        return Rcnt - Lcnt;
    }
}


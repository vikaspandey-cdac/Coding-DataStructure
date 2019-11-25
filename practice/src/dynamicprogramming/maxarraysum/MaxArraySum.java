package dynamicprogramming.maxarraysum;

public class MaxArraySum {
    public static void main(String[] args) {
        int arr[] = {-2, 1, 3, -4, 5};
        //int arr[] = { 12, 9, 7, 33 };
       // System.out.println(findMaxArraySum(arr, 0));
        System.out.println(maxSum(arr, 0, arr.length));
    }

    private static int findMaxArraySum(int[] arr, int index) {
        if (index >= arr.length)
            return 0;
        int firstSum = findMaxArraySum(arr, index + 1);
        int secondSum = arr[index] + findMaxArraySum(arr, index + 2);
        return Math.max(firstSum, secondSum);
    }

    // variable to store states of dp
    static int dp[] = new int[10];

    // variable to check if a given state
    // has been solved
    static boolean v[] = new boolean[10];

    // Function to find the maximum sum subsequence
    // such that no two elements are adjacent
    static int maxSum(int arr[], int i, int n) {
        // Base case
        if (i >= n)
            return 0;

        // To check if a state has
        // been solved
        if (v[i])
            return dp[i];
        v[i] = true;

        // Required recurrence relation
        dp[i] = Math.max(maxSum(arr, i + 1, n),
                arr[i] + maxSum(arr, i + 2, n));

        // Returning the value
        return dp[i];
    }
}


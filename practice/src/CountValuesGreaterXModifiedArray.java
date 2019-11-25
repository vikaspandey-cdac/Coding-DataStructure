/**
 * Count the values greater than X in the modified array
 * Given an array Arr of positive intergers and a value X. The task is to find the number of values that is greater than or equal to X.
 *
 * But the twist is that the values of the array are kept changing after every operation. There are two possibilies:
 *
 * If the current value is picked then all the remaining values in the array will be decreased by 1.
 * If the current value is not picked then all the remaining values in the array will be increased by 1.
 * Examples:
 * Input: arr[] = {10, 5, 5, 4, 9}, X = 10
 * Output: 2
 *
 * Explanation:
 * Arr = {10, 5, 5, 4, 9}, pos = 0
 * 10 is picked
 *
 * Arr = {10, 4, 4, 3, 8}, pos = 1
 * 4 is not picked
 *
 * Arr = {10, 4, 5, 4, 9}, pos = 2
 * 5 is not picked
 *
 * Arr = {10, 4, 5, 5, 10}, pos = 3
 * 5 is not picked
 *
 * Arr = {10, 4, 5, 5, 11}, pos = 4
 * 11 is picked
 *
 * Hence two elements are picked.
 *
 * Input: arr[] = {5, 4, 3, 2, 1}, X = 4
 * Output: 1
 *
 * Efficient Approach:
 *
 * 1. This problem can further be optimized to O(N).
 * 2. Here the main idea is to check by how much this index value should change.
 * 3. This can be done by using a temporary variable, here it is currentStatus that will keep the net effect on the current index by the previous decisions.
 * 4. The effect will be added to the value of that index and that will tell us the updated original value of the array.
 */

public class CountValuesGreaterXModifiedArray {


    // Function to count number
    // of students got selected
    static int increaseDecreaseValue(int arr[], int x) {
        int currentStatus = 0;
        int totalValue = 0;

        int i;
        int len = arr.length;

        for (i = 0; i < len; i++) {

            // Adding currentStatus to the
            // value of that index to get
            // the original value

            // if it is less than X
            if (arr[i] + currentStatus < x)
                currentStatus += 1;

            else {
                currentStatus -= 1;
                totalValue += 1;
            }
        }
        return totalValue;
    }

    // Driver Code
    public static void main(String[] args) {
        int x = 4;
        int arr[] = {5, 4, 3, 2, 1};
        int countValue = increaseDecreaseValue(arr, x);
        System.out.println(countValue);
    }
}


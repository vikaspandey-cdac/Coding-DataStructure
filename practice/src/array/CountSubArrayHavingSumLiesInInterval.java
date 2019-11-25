package array;

/**
 * Number of subarrays having sum in a given range
 * Given an array arr[] of positive integers and a range (L, R). Find number of subarrays having sum in the range L to R.
 *
 * Examples:
 *
 * Input : arr[] = {1, 4, 6}, L = 3, R = 8
 * Output : 3
 * The subarrays are {1, 4}, {4}, {6}.
 *
 * Input : arr[] = {2, 3, 5, 8}, L = 4, R = 13
 * Output : 6
 * The subarrays are {2, 3}, {2, 3, 5}, {3, 5},
 * {5}, {5, 8}, {8}.
 */
public class CountSubArrayHavingSumLiesInInterval {
    public static void main (String[] args)
    {
        int arr[] = {2, 3, 5, 8, 3, 2, 6, 1, 7};
        int leftWindow = 3, rightWindow = 12;
        System.out.println(findSubSumLtoR(arr, leftWindow, rightWindow));
    }

    private static int findSubSumLtoR(int[] arr, int leftWindow, int rightWindow) {
        int count = 0, sum = arr[0] ;
        int left=0, right = 0;
        try {
            while (right < arr.length && left < arr.length) {
                if ((sum > leftWindow && sum < rightWindow && (sum + arr[right+1] - sum) < leftWindow) || sum == leftWindow) {
                    printAll(arr, left, right);
                    count++;
                    if(right < arr.length-1)
                        sum += arr[++ right];
                } else if (sum == rightWindow) {
                    count++;
                    printAll(arr, left, right);
                    sum -= arr[left++];
                } else if (sum > rightWindow) {
                    sum -= arr[left++];
                } else {
                    if(right < arr.length-1)
                        sum += arr[++ right];
                }
            }
        } catch(Exception e){
            System.out.println("Exception :: ");
            System.out.println("left :: " + left + ", right :: "+ right);
        }
        return count;
    }

    public static void printAll(int[] arr, int left, int right){
        System.out.print("{ ");
        while(left <= right) {
            System.out.print(arr[left]+" ");
            left++;
        }
        System.out.print("}");
        System.out.println("");
    }
}

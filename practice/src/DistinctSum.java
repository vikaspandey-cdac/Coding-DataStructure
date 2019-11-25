import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DistinctSum {
    public static int countPairs(List<Integer> arr, long k) {
        int count = 0;
        Collections.sort(arr);
        int l = 0;
        int r = arr.size()-1;
        while(l < r && r < arr.size()){
            if(arr.get(r)+arr.get(l) == k){
                count++;
                r--;
            } else if(arr.get(r)+arr.get(l) > k) {
                r--;
            } else {
                l++;
            }
        }
        return count;

    }

    static int countPairsWithDiffK(int arr[], int n,
                                   int k)
    {
        int count = 0;
        Arrays.sort(arr); // Sort array elements

        int l = 0;
        int r = 0;
        while(r < n)
        {
            if(arr[r] - arr[l] == k)
            {
                count++;
                l++;
                r++;
            }
            else if(arr[r] - arr[l] > k)
                l++;
            else // arr[r] - arr[l] < sum
                r++;
        }
        return count;
    }
    public static void main(String args[]){
        //List<Integer> arr = new ArrayList<>( Arrays.asList(5, 7, 9,13,11,6,6,3,3));
        List<Integer> arr = new ArrayList<>( Arrays.asList(3, 3, 5, 6, 6, 7, 9, 11, 13));
        System.out.println(countPairs(arr, 12));
        //System.out.println(countPairsWithDiffK(arr.stream().mapToInt(i -> i).toArray(), arr.size(), 5));
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeArrayList {
    public static void main(String args[])
    {

        List<String> listA = new ArrayList<String>();

        listA.add("A");
        listA.add("B");

        List<String> listB = new ArrayList<String>();

        listB.add("B");
        listB.add("C");
        listB.contains("C");

        Set<String> newSet = new HashSet<String>(listA);

        newSet.addAll(listB);
        List<String> newList = new ArrayList<String>(newSet);

        System.out.println("New List :"+newList);
        callmethod();

    }

    static int removeDuplicates(int arr[], int n)
    {
        if (n == 0 || n == 1)
            return n;

        // To store index of next unique element
        int j = 0;

        // Doing same as done in Method 1
        // Just maintaining another updated index i.e. j
        for (int i = 0; i < n-1; i++)
            if (arr[i] != arr[i+1])
                arr[j++] = arr[i];

        arr[j++] = arr[n-1];

        return j;
    }

    public static void callmethod ()
    {
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = arr.length;

        n = removeDuplicates(arr, n);

        // Print updated array
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
}

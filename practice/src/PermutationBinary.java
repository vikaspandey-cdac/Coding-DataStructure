import java.util.Arrays;

public class PermutationBinary {
    static boolean shouldSwap(int str[], int start, int curr) {
        for (int i = start; i < curr; i++) {
            if (str[i] == str[curr]) {
                return false;
            }
        }
        return true;
    }

    private static long convertToDecimal(int[] binary){
        int dec = 0;
        for(int i = binary.length -1, j = 0; i >= 0; i--) {
            dec += binary[i] << j++;
        }
        return dec;
    }

    // Prints all distinct permutations in str[0..n-1]
    static long findPermutations(int str[], int index, int n, long sum) {
        if (index >= n) {
            System.out.println(Arrays.toString(str) + " :: " + convertToDecimal(str));
            return sum + convertToDecimal(str);
        }

        for (int i = index; i < n; i++) {

            // Proceed further for str[i] only if it
            // doesn't match with any of the intacters
            // after str[index]
            boolean check = shouldSwap(str, index, i);
            if (check) {
                swap(str, index, i);
                sum = findPermutations(str, index + 1, n, sum);
                swap(str, index, i);
            }
        }
        return sum;
    }

    static void swap(int[] str, int i, int j) {
        int c = str[i];
        str[i] = str[j];
        str[j] = c;
    }

    private static int countBits(int number)
    {
        // log function in base 2 take only integer part
        return (int)(Math.log(number) / Math.log(2) + 1);
    }

    private static int[] convertToBinary(int n) {
        // Size of an integer is assumed to be 32 bits
        int nBits = countBits(n);
        int[] array = new int[nBits];
        boolean ones = false;
        for (int i = nBits, index =0; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0) {
                array[index++]= 1;
                ones = true;
            }
            else {
                if(ones) array[index++] = 0 ;
            }
        }
        return array;
    }

    // Driver code
    public static void main(String[] args) {

        int str[] = {1, 0, 1, 0, 1};
        int n = str.length;
        System.out.println(findPermutations(str, 0, n,0));
    }
}

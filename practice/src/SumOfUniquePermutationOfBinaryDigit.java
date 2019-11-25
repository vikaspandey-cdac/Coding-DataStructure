public class SumOfUniquePermutationOfBinaryDigit {
    public static void main(String args[]){
       System.out.println(SumOfUniquePermutationOfBinaryDigit(convertToBinary(21)));
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

    private static int countBits(int number)
    {
        // log function in base 2 take only integer part
        return (int)(Math.log(number) / Math.log(2) + 1);
    }

    private static long convertToDecimal(int[] binary){
        int dec = 0;
        for(int i = binary.length -1, j = 0; i >= 0; i--) {
            dec += binary[i] << j++;
        }
        return dec;
    }

    public static long SumOfUniquePermutationOfBinaryDigit(int[] binary){
        return sumOfAllPermutations(binary,0,binary.length,0);
    }

    private static boolean shouldSwap(int arr[], int start, int curr) {
        for (int i = start; i < curr; i++) {
            if (arr[i] == arr[curr]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }


    private static long sumOfAllPermutations(int arr[], int index, int n, long sum) {
        if (index >= n) {
            return sum + convertToDecimal(arr);
        }

        for (int i = index; i < n; i++) {
            boolean check = shouldSwap(arr, index, i);
            if (check) {
                swap(arr, index, i);
                sum = sumOfAllPermutations(arr, index + 1, n, sum);
                swap(arr, index, i);
            }
        }
        return sum;
    }


}

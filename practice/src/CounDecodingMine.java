public class CounDecodingMine {
    // Driver program to test above function
    public static void main(String[] args)
    {
        char digits[] = {'2', '1', '1', '2'};
        int n = digits.length;
        System.out.println("Count is "+ countDecoding(digits, 0, digits.length));

        char digits1[] = {'1', '1', '9', '2','0','5'};
        //(1)(1)(9)(2)(0)(5)
        //(11)(9)(20)(5)
        //(1)(19)(20)(5)
        //
        int n1 = digits1.length;
        System.out.println("Count is "+ countDecoding(digits1, 0, n1));

    }
    static int countDecoding(char[] digits, int start, int end){
        if(start==digits.length|| start == digits.length-1){
            return 1;
        }
        int count =0;
        if(digits[start]>'0'){
            count = countDecoding(digits, start +1, end);
        }
        if(digits[start]=='1' || (digits[start]=='2' && digits[start+1] < '7')) {
            count += countDecoding(digits, start + 2, end);
        }
        return count;
    }
}

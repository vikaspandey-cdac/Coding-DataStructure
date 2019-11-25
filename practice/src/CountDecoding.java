public class CountDecoding {
    static int countDecoding(char[] digits, int n)
    {
        // base cases
        if (n == 0 || n == 1)
            return 1;
        if(digits[0]=='0')   //for base condition "01123" should return 0
            return 0;

        // Initialize count
        int count = 0;

        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);

        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n - 2] == '1' ||
                (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);

        return count;
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        char digits[] = {'2', '1', '1', '2'};
        int n = digits.length;
        //System.out.println("Count is "+ countDecoding(digits, n));

        char digits1[] = {'1', '1', '9', '2','0','5'};
        //(1)(1)(9)(2)(0)(5)
        //(11)(9)(20)(5)
        //(1)(19)(20)(5)
        //
        int n1 = digits1.length;
        System.out.println("Count is "+ countDecoding(digits1, n1));

    }

    // A Dynamic Programming based function to count decodings
    static int countDecodingDP(char digits[], int n)
    {
        // A table to store results of subproblems
        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        if(digits[0]=='0')   //for base condition "01123" should return 0
            return 0;
        for (int i = 2; i <= n; i++)
        {
            count[i] = 0;

            // If the last digit is not 0, then last digit must add to the number of words
            if (digits[i - 1] > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller than 2 and last digit is smaller than 7, then last two digits form a
            // valid character
            if (digits[i - 2] == '1' ||
                    (digits[i - 2] == '2' &&
                            digits[i - 1] < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }
}

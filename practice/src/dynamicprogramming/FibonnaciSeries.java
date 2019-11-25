package dynamicprogramming;

public class FibonnaciSeries {
    public static void main(String args[]){
        int[] memoize = new int[11];
        System.out.println(fibonnaciAux(memoize,9));
        //System.out.println(fib(4));
    }

    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }

    static int fibonnaciAux(int[] memoize, int n){
        if (n < 1 || n == 1 ) return 0;
        if (n == 2) return 1;

        if(memoize[n] == 0){
            memoize[n] = fibonnaciAux(memoize, n-1)+fibonnaciAux(memoize,n-2);
        }
        return memoize[n];
    }
}

package dynamicprogramming.stockbuysellktransaction;

public class MaxProfitWithKTransactions {
    public static int maxProfitWithKTransactions(int[] prices, int k) {
        int T[][] = new int[k+1][prices.length];
        for(int i= 1; i< T.length; i++){
            for (int j = 1; j < T[0].length; j++){
                int max_value = 0;
                for(int m = 0; m < j; m++){
                    max_value = Math.max(prices[j] - prices[m] + T[i-1][m], max_value);
                }
                T[i][j] = Math.max(T[i][j-1], max_value);
            }
        }
        return T[k][prices.length-1];
    }
    public static void main(String args[]) {
            int prices[] = {5,11,3,50,60,90};
            System.out.println(maxProfitWithKTransactions(prices,2));
    }
}

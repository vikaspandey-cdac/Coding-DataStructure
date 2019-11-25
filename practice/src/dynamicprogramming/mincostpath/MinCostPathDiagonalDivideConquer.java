package dynamicprogramming.mincostpath;

public class MinCostPathDiagonalDivideConquer {
    public static void main(String args[]){
        int cost[][] = { {1, 2, 3, 4},
                         {4, 8, 2, 5},
                         {1, 5, 3, 6},
                         {3, 5, 9, 7}};
        int [][]dp = new int[cost.length][cost.length];

        System.out.println(minCost(dp, cost, 3, 3));
    }

    private static int minCost(int[][] dp, int[][] cost, int row, int col) {
        if(row ==-1 || col == -1) {
            return Integer.MAX_VALUE;
        }
        if(row ==0 && col ==0) {
            return cost[0][0];
        }
        if(dp[row][col] == 0) {
            int minCostUp = minCost(dp,cost, row - 1, col);
            int minCostLeft = minCost(dp, cost, row, col - 1);
            int mincostDiagonal = minCost(dp, cost, row - 1, col - 1);
            int minCost = Integer.min(Integer.min(minCostUp, minCostLeft), mincostDiagonal);
            int currentCost = cost[row][col];
            dp[row][col]=minCost + currentCost;
        }
        return dp[row][col];
    }
}

import java.util.Arrays;

/**
 * Given a matrix of integers, task is to find out number of positional elements.
 * A positional element is one which is either minimum or maximum in a row or in a column.
 *
 * Examples:
 *
 * Input : a = {{1, 3, 4},
 *              {5, 2, 9},
 *              {8, 7, 6}}
 * Output : 7
 * There are total 7 elements min elements are 1, 2, 6 and 4. And max elements are 9, 8 and 7.
 *
 * Input : a = {{1, 1}, {1, 1}, {1, 1}}
 * Output : 4
 */
public class NumOfPositionalElements {

    public static void main(String args[]){
        int a[][] = new int[][] { { 1, 3, 4 },
                                  { 5, 2, 9 },
                                  { 8, 7, 6 } };

        int a1[][] = new int[][] { { 1, 1 },
                                   { 5, 1 },
                                   { 8, 1 } };
        int m = 3, n = 2;
        System.out.println(countPositional(a1, m, n));
    }

    private static int countPositional(int[][] a, int m, int n) {
        int rmin , rmax, cmin, cmax;
        int []rowMin= new int[m];
        int []rowMax = new int[m];
        int []colMin= new int[n];
        int []colMax = new int[n];
        for(int i = 0; i<n; i++){
            colMax[i] = Integer.MIN_VALUE;
            colMin[i] = Integer.MAX_VALUE;
        }
        for (int i=0;i<m; i++){
            rmin = Integer.MAX_VALUE;
            rmax = Integer.MIN_VALUE;
            for(int j = 0; j < n; j++){
                cmax = colMax[j];
                cmin = colMin[j];
                if(a[i][j] < rmin) {
                    rmin = a[i][j];
                    rowMin[i] = a[i][j];
                }
                if(a[i][j] <cmin) {
                    cmin = a[i][j];
                    colMin[j] = a[i][j];
                }
                if(a[i][j] > rmax) {
                    rmax = a[i][j];
                    rowMax[i] = a[i][j];
                }
                if(a[i][j] > cmax) {
                    cmax = a[i][j];
                    colMax[j] = a[i][j];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == rowMax[i]) {
                    count++;
                    System.out.print("rowMax :: " +a[i][j]);
                }
                else if(a[i][j] == rowMin[i]) {
                    count++;
                    System.out.print("rowMin :: " +a[i][j]);
                }
                else if(a[i][j] == colMax[j]) {
                    count++;
                    System.out.print("colMax :: " +a[i][j]);
                }
                else if(a[i][j] == colMin[j]) {
                    count++;
                    System.out.print("colMin :: " +a[i][j]);
                }
            }
        }


        printArray("rowMin", rowMin);
        printArray("rowMax",rowMax);
        printArray("colMin", colMin);
        printArray("colMax", colMax);

        return count;
    }

    private static void printArray(String s, int[] a){
        System.out.println(s + " :: " +Arrays.toString(a));
    }
}

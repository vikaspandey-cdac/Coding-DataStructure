import java.util.Scanner;

public class SpiralFill {
    static int MAX = 100;
    static void spiralFill(int endRow, int endcolumn, char[][] a, char[] chars) {
        // Initialize value to be filled in matrix
        int val = 0;

        /*  startRow - starting row index
        endRow - ending row index
        startColumn - starting column index
        endcolumn - ending column index */
        int startRow = 0, startColumn = 0;
        while (startRow < endRow && startColumn < endcolumn) {
            /* Print the first row from the remaining
          rows */
            for (int i = startColumn; i < endcolumn; ++i) {
                if(val>=chars.length) val=0;
                a[startRow][i] = chars[val++];
            }

            startRow++;

            /* Print the last column from the remaining columns */
            for (int i = startRow; i < endRow; ++i) {
                if(val>=chars.length) val=0;
                a[i][endcolumn - 1] = chars[val++];
            }
            endcolumn--;

            /* Print the last row from the remaining rows */
            if (startRow < endRow) {
                for (int i = endcolumn - 1; i >= startColumn; --i) {
                    if(val>=chars.length) val=0;
                    a[endRow - 1][i] = chars[val++];
                }
                endRow--;
            }

            /* Print the first column from the remaining columns */
            if (startColumn < endcolumn) {
                for (int i = endRow - 1; i >= startRow; --i) {
                    if(val>=chars.length) val=0;
                    a[i][startColumn] = chars[val++];
                }
                startColumn++;
            }
        }
    }


    public static void main(String[] args) {
        int m = 4, n = 8;
        char a[][] = new char[m][n];
        String str = "abcdef";

        spiralFill(m, n, a, str.toCharArray());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

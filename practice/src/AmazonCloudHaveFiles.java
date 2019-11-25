// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
import java.util.stream.Collectors;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class AmazonCloudHaveFiles
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    private static final int HASFILE = 1;
    private static final int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static int minimumHours(int rows, int columns, List<List<Integer> > grid)
    {
        int notFile = 0;
        Queue<Point> hasFiles = new ArrayDeque<>();
        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid.get(0).size(); c++) {
                if(grid.get(r).get(c) == HASFILE) {
                    hasFiles.add(new Point(r, c));
                } else {
                    notFile++;
                }
            }
        }

        if(notFile == 0) return 0;

        for (int hours = 1; !hasFiles.isEmpty(); hours++){
            for(int sz = hasFiles.size(); sz > 0; sz--) {
                Point file = hasFiles.poll();
                for(int[] dir : DIRS) {
                    int r = file.r + dir[0];
                    int c = file.c + dir[1];

                    if(isNotHavingFile(grid, r, c)) {
                        notFile --;
                        if(notFile ==0) return hours;
                        grid.get(r).set(c, HASFILE);
                        hasFiles.add(new Point(r,c));
                    }
                }
            }
        }
        return -1;

    }

    private static boolean isNotHavingFile(List<List<Integer> > grid , int r, int c) {
        return r >= 0 && r < grid.size() && c >=0 && c< grid.get(0).size() && grid.get(r).get(c) != HASFILE;
    }

    private static class Point {
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    // METHOD SIGNATURE ENDS
    public static void main(String args[]) {
        Integer[][] grid = {{0, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}};
        List<List<Integer>> list = Arrays.stream(grid)
                                            .map(Arrays::asList)
                                            .collect(Collectors.toList());
        System.out.println(minimumHours(4,5, list));
    }
}

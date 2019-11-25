package tree.traversal;

public class LevelOrderTraversalIsMinHeap {
    public static void main(String[] args) {
        // Level order traversal
        int[] level = new int[]{10, 15, 14, 25, 30};
        int[] level2 = new int[]{30, 56, 22, 49, 30, 51, 2, 67};
        System.out.println(isMinHeap(level));
        System.out.println(isMinHeap(level2));
    }

    private static boolean isMinHeap(int[] level) {
        int n = level.length-1;
        for(int i= (n/2-1) ; i>=0; i--){
            if(level[i]> level[2*i+1]) return false;
            if((2*i + 2) < n){
                if(level[i]>level[2*i + 2]) return false;
            }
        }
        return true;
    }
}

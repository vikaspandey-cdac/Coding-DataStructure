package tree.traversal;

import java.util.Arrays;

class PrintPostOrderFromInAndPreorder {

    // A utility function to search x in arr[] of size n
    static int search(int arr[], int x, int n) {
        for (int i = 0; i < n; i++)
            if (arr[i] == x)
                return i;
        return -1;
    }

    // Prints postorder traversal from given inorder and preorder traversals
    static void printPostOrder(int in1[],
                               int pre[], int n) {
        // The first element in pre[] is always root, search it in in[] to find left and right subtrees
        int root = search(in1, pre[0], n);
        //printAllvalue(in1, pre, n, root);
        // If left subtree is not empty, print left subtree
        if (root != 0)
            printPostOrder(in1, Arrays.copyOfRange(pre, 1, n), root);

        // If right subtree is not empty, print right subtree
        if (root != n - 1)
            printPostOrder(Arrays.copyOfRange(in1, root + 1, n),
                    Arrays.copyOfRange(pre, 1 + root, n), n - root - 1);

        // Print root
        System.out.print(pre[0] + " ");
    }

    private static void printAllvalue(int[] in1, int[] pre, int n, int root) {
        System.out.println("inorder:: "+ Arrays.toString(in1) + ", preorder:: " + Arrays.toString(pre)+", n :: " + n + ", root :: "+ root);
    }

    // Driver code
    public static void main(String args[]) {
        int in1[] = {4, 2, 5, 1, 3, 6};
        int pre[] = {1, 2, 4, 5, 3, 6};
        int n = in1.length;
        System.out.println("Postorder traversal ");
        //printPostOrder(in1, pre, n);

        printPost(in1, pre, 0, n - 1);
    }
    static int preIndex = 0;
    static void printPost(int[] in, int[] pre, int inStrt, int inEnd)
    {
        if (inStrt > inEnd)
            return;

        // Find index of next item in preorder traversal in
        // inorder.
        int inIndex = search(in, inStrt, inEnd, pre[preIndex++]);

        // traverse left tree
        printPost(in, pre, inStrt, inIndex - 1);

        // traverse right tree
        printPost(in, pre, inIndex + 1, inEnd);

        // print root node at the end of traversal
        System.out.print(in[inIndex] + " ");
    }

    static int search(int[] in, int startIn, int endIn, int data)
    {
        int i = 0;
        for (i = startIn; i < endIn; i++)
            if (in[i] == data)
                return i;
        return i;
    }
}

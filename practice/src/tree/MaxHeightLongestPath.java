package tree;

import java.util.*;

public class MaxHeightLongestPath {
    /* Driver program to test above functions
    *             1
    *           /  \
    *          /    \
    *         2     3
    *        / \   / \
    *       4  5  6   7
    *              \   \
    *               8   9
    *
    * */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.right.right = new Node(9);
        tree.root.right.left.right = new Node(8);

        System.out.println("Height of tree is : " +
                tree.maxDepth(tree.root));

        tree.printPaths(tree.root);
    }
}
class Node {
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    Map<Integer, List<String>> paths = new HashMap<>();
    int maxDepth(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
    void printPaths(Node node)
    {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
        Integer maxKey = paths.keySet().stream().max(Comparator.comparing(Integer::valueOf)).get();
        for(String str:paths.get(maxKey)){
            System.out.println(str);
        }
    }

    /* Recursive helper function -- given a node, and an array containing
       the path from the root node up to but not including this node,
       print out all the root-leaf paths. */
    void printPathsRecur(Node node, int path[], int pathLen) {
        if (node == null)
            return;

        /* append this node to the path array */
        path[pathLen] = node.data;
        pathLen++;

        /* it's a leaf, so print the path that led to here */
        if (node.left == null && node.right == null) {
            List<String> pathList;
            StringBuilder builder = new StringBuilder();
            for(int i=0; i<pathLen; i++){
                builder.append(path[i]+ " ");
            }
            if(paths.get(pathLen)!= null){
               pathList = paths.get(pathLen);
            }else {
                pathList = new ArrayList<>();
            }
            pathList.add(builder.toString());
            paths.put(pathLen, pathList);
            printArray(path, pathLen);

        } else {
            /* otherwise try both subtrees */
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }
    /* Utility that prints out an array on a line */
    void printArray(int ints[], int len)
    {
        int i;
        for (i = 0; i < len; i++)
            System.out.print(ints[i] + " ");
        System.out.println("");
    }
}
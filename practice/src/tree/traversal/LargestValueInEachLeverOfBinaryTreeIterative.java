package tree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class LargestValueInEachLeverOfBinaryTreeIterative {
    static class Node
    {
        int val;
        Node left, right;
    };

    /* Helper function that allocates a
    new node with the given data and
    NULL left and right pointers. */
    static Node newNode(int data)
    {
        Node temp = new Node();
        temp.val = data;
        temp.left = temp.right = null;
        return temp;
    }
    // Driver code
    public static void main(String[] args)
    {
    /* Let us construct a Binary Tree
             4
          /    \
        /        \
       9          2
     /   \       /   \
    3     5     8     7
   / \   / \   / \   / \
 14  15 23 54 2  33 8 65


     */
        Node root = null;
        root = newNode(4);
        root.left = newNode(9);
        root.right = newNode(2);
        root.left.left = newNode(3);
        root.left.right = newNode(5);
        root.right.left = newNode(8);
        root.right.right = newNode(7);
        root.left.left.left = newNode(14);
        root.left.left.right = newNode(15);
        root.left.right.left = newNode(23);
        root.left.right.right = newNode(54);
        root.right.left.left = newNode(2);
        root.right.left.right = newNode(33);
        root.right.right.left = newNode(8);
        root.right.right.right = newNode(65);

        largestValueInEachLevel(root);

    }

    static void largestValueInEachLevel(Node root){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<Node>();

        int max = Integer.MIN_VALUE, totalCountLevel;
        queue.add(root);
        while (!queue.isEmpty()) {
            totalCountLevel = queue.size();
            max = Integer.MIN_VALUE;
            while(totalCountLevel != 0) {
                Node node = queue.poll();
                if(max < node.val) {
                    max = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                totalCountLevel--;
            }
            System.out.print(max +" ");
        }
    }
}

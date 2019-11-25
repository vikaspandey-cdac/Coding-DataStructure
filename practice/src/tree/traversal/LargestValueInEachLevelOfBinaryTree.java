/**
 * Given a binary tree, find the largest value in each level.
 *
 * Examples :
 *
 * Input :
 *         1
 *        / \
 *       2   3
 * Output : 1 3
 *
 * Input :
 *         4
 *        / \
 *       9   2
 *      / \   \
 *     3   5   7
 * Output : 4 9 7
 */
package tree.traversal;

import java.util.Vector;

public class LargestValueInEachLevelOfBinaryTree {
    static class Node
    {
        int val;
        Node left, right;
    };

    /* Recursive function to find
    the largest value on each level */
    static void helper(Vector<Integer> res, Node root, int d)
    {
        if (root == null)
            return;

        // Expand list size
        if (d == res.size())
            res.add(root.val);

        else

            // to ensure largest value
            // on level is being stored
            res.set(d, Math.max(res.get(d), root.val));

        // Recursively traverse left and
        // right subtrees in order to find
        // out the largest value on each level
        helper(res, root.left, d + 1);
        helper(res, root.right, d + 1);
    }

    // function to find largest values
    static Vector<Integer> largestValues(Node root)
    {
        Vector<Integer> res = new Vector<>();
        helper(res, root, 0);
        return res;
    }

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
        / \
       9   2
      / \   \
    3    5   7 */

        Node root = null;
        root = newNode(4);
        root.left = newNode(9);
        root.right = newNode(2);
        root.left.left = newNode(3);
        root.left.right = newNode(5);
        root.right.right = newNode(7);

        Vector<Integer> res = largestValues(root);
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i)+" ");
    }
}

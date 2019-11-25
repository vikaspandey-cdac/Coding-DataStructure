package tree.traversal;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafSumBinaryTree {
    public static boolean rootToLeafSum(Node root, int sum, List<Integer> result){
        if(root == null){return false;}
        if(root.left == null && root.right == null){
            if(root.data == sum){
                result.add(root.data);
                return true;
            } else {
                return false;
            }
        }
        if(rootToLeafSum(root.left, sum - root.data, result)){
            result.add(root.data);
            return true;
        }

        if(rootToLeafSum(root.right, sum - root.data, result)){
            result.add(root.data);
            return true;
        }

        return false;
    }
    public static void main(String args[]){
        Node root = new Node(10);
        root.left = new Node(16);
        root.right = new Node(5);
        //root.left.left = new TreeNode(2);
        root.left.right = new Node(-3);
        root.right.left = new Node(6);
        root.right.right = new Node(11);
        //root.left.right.left = new TreeNode(9);
        //root.left.right.right = new TreeNode(5);
        //root.right.right.left = new TreeNode(7);
        List<Integer> result = new ArrayList<>();
        System.out.println(rootToLeafSum(root,26, result));
        System.out.println(result);
    }
}

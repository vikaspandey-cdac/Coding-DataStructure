package tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class NaryTree {
    static class Node {
        int key;
        public Node left;
        public Node right;
        public int parentIndex;
        public Node(int key) {
            this.key = key;
        }
    }
    public static int sumOfAllChildNthParentIsEven(int n, Node root){
        List<Node> parentIndexList = new ArrayList<>();
        int sum = 0, currentIndex = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.parentIndex = -1;
        parentIndexList.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            //check whether nth parent is even
            int parentIndex = node.parentIndex;
            Node parent= null;
            if(node.parentIndex>=0) {
                for(int i=0; i<n; i++){
                    if(parentIndex >= 0) {
                        parent = parentIndexList.get(parentIndex);
                        parentIndex = parent.parentIndex;
                    } else {
                        parent = null;
                        break;
                    }
                }
            }

            if(parent != null && parent.key % 2 == 0) {
                sum += node.key;
            }

            if(node.left != null){
                queue.add(node.left);
                node.left.parentIndex = currentIndex;
                parentIndexList.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
                node.right.parentIndex = currentIndex;
                parentIndexList.add(node.right);
            }
            currentIndex++;
        }
        return sum;
    }

    public static void main(String args[]){
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);

        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);

        root.left.left.left = new Node(9);
        root.left.left.right = new Node(10);
        //root.left.right.left = new Node(11);
        root.left.right.right = new Node(12);

        root.right.left.left = new Node(13);
        //root.right.left.right = new Node(14);
        root.right.right.left = new Node(15);
        root.right.right.right = new Node(16);

        //root.left.right.left.left = new Node(17);
        //root.left.right.left.right = new Node(18);

        //root.right.left.right.right = new Node(19);
        //root.right.right.right.left = new Node(20);
        //root.right.right.right.right = new Node(21);
        System.out.println(sumOfAllChildNthParentIsEven(1, root));
    }
}

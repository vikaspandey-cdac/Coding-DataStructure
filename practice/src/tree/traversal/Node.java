package tree.traversal;

/* A binary tree node has data, pointer to left child
and a pointer to right child */
class Node {
    int data;
    int hd;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

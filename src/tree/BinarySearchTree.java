package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public Node root;

    class Node{
        int value ;
        Node left;
        Node right;

        private Node(int value){
            this.value = value;
        }
    }

    public boolean insert(int value){
        Node newNode = new Node(value);

        if(this.root == null){
            this.root = newNode;
            return true;
        }else{

            Node temp = this.root;

            while(true){
                if(newNode.value == temp.value) return false;

                if(newNode.value < temp.value){
                    if(temp.left == null){
                        temp.left = newNode;
                        return true;
                    }
                    temp = temp.left;

                }else{
                    if(temp.right == null){
                        temp.right = newNode;
                        return true;
                    }
                    temp = temp.right;
                }
            }
        }
    }

    public boolean contains(int value){

        if(this.root == null) return false;

        Node temp = this.root;

        while(temp != null){
            if(value < temp.value){
                temp = temp.left;
            }
            else if(value > temp.value){
                temp = temp.right;
            }else{
                return true;
            }
        }

        return false;
    }

    // Returns -1 if is not balanced.
    public boolean isBalanced() {
        return checkBalance(this.root) != -1;
    }

    /*
    checkBalance is a recursive method:
        - evaluate the height of the subtree
        - returns -1 if is not balanced
     */
    private int checkBalance(Node node) {
        if (node == null) return 0;

        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Print the tree in order
    public void printInOrder() {
        printInOrder(this.root);
        System.out.println();
    }

    // Recursive method used to print the node
    private void printInOrder(Node node) {
        if (node == null) return;

        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }

    public void delete(int value){
        this.root = recursiveDelete(this.root, value);
    }

    private Node recursiveDelete(Node root, int value) {
        if (root == null) return this.root;

        // Find the node to be deleted
        if (value < root.value) {
            root.left = recursiveDelete(root.left, value);
        } else if (value > root.value) {
            root.right = recursiveDelete(root.right, value);
        } else {
            // Case 1 and 2: node with zero or one leaf
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Case 3: two leafs, find the min value in the right subtree
            root.value = minValue(root.right);

            // Remove the duplicated node
            root.right = recursiveDelete(root.right, root.value);
        }

        return root;
    }

    // Find the min value in a subtree
    private int minValue(Node node) {
        int min = node.value;
        while (node.left != null) {
            min = node.left.value;
            node = node.left;
        }
        return min;
    }

    public void printBFS() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
    }

    public void printInOrderDFS(Node node) {
        if (node != null) {
            printInOrderDFS(node.left);
            System.out.print(node.value + " ");
            printInOrderDFS(node.right);
        }
    }
}

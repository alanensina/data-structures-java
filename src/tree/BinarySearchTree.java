package tree;

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
}

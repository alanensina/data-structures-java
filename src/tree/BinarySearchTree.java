package tree;

public class BinarySearchTree {

    private Node root;

    class Node{
        int value ;
        Node left;
        Node right;

        private Node(int value){
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }
}

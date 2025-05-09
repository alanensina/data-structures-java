package tree;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(52);
        bst.insert(82);
        bst.insert(27);

        System.out.println(bst.root.left.right.value); // Check if the value 27 was added.

        System.out.println(bst.contains(18)); // true
        System.out.println(bst.contains(89)); // false

        BinarySearchTree balancedTree = new BinarySearchTree();
        balancedTree.insert(8);
        balancedTree.insert(4);
        balancedTree.insert(12);
        balancedTree.insert(2);
        balancedTree.insert(6);
        balancedTree.insert(10);
        balancedTree.insert(14);
        balancedTree.insert(1);
        balancedTree.insert(3);
        balancedTree.insert(15);

        System.out.println(balancedTree.isBalanced());
        System.out.println("Original tree in order:");
        balancedTree.printInOrder();
        balancedTree.delete(8);
        System.out.println("After delete the element 8: ");
        balancedTree.printInOrder();
        System.out.println("BFS: ");
        balancedTree.printBFS();
        System.out.println();
        System.out.println("DFS: ");
        balancedTree.printInOrderDFS(balancedTree.root);
    }
}

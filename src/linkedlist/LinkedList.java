package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        increaseLength();
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }

        decreaseLength();
    }

    public boolean insert(int value, int index) {

        if (index < 0 || index > this.length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == this.length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value); // new node to be added
        Node previousNode = get(index - 1); // get the previous node of the index desired
        newNode.next = previousNode.next; // point the new node to the node that the previous are pointing
        previousNode.next = newNode; // point the previous node to the new node

        increaseLength();

        return true;
    }

    public Node remove(int index) {

        if (index < 0 || index > this.length) return null;

        if (index == 0) return removeFirst();
        if (index == this.length - 1) return removeLast();

        Node previousNode = get(index - 1); // get the previous node
        Node node = previousNode.next; // get the node that will be removed
        previousNode.next = node.next; // point the previous node to the next node of the node that will be removed
        node.next = null; // unlink the node removed of other element
        decreaseLength();

        return node;
    }

    public Node removeLast() {

        // If the LinkedList is empty, there's no need to remove a Node
        if (this.length == 0) return null;

        Node pre = this.head;
        Node temp = this.head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        this.tail = pre;
        this.tail.next = null;
        decreaseLength();

        // If the LinkedList has one element and this element is removed, we need to set the head and tail to null.
        if (this.length == 0) {
            this.tail = null;
            this.head = null;
        }

        // Return the Node removed.
        return temp;
    }

    public Node removeFirst() {
        Node node;

        if (this.length == 0) return null;

        node = this.head;
        this.head = this.head.next;
        node.next = null;
        decreaseLength();

        if (this.length == 0) {
            this.tail = null;
        }

        return node;
    }

    public Node get(int index) {

        if (index < 0 || index >= this.length) return null;

        Node temp = this.head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp != null) {
            temp.value = value;
            return true;
        }

        return false;
    }

    public void reverse() {

        // Invert the head and tail first
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        // Set 2 nodes in the beginning of the List
        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < this.length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    // Floyd's Tortoise and Hare algorithm: 
    // The key idea is to have two pointers, one that moves twice as fast as the other. 
    // By the time the fast pointer reaches the end of the linked list, the slow pointer will be at the middle.
    public Node findMiddleNode() {

        Node turtle = this.head;
        Node rabbit = this.head;

        while (rabbit != null && rabbit.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
        }

        return turtle;
    }

    // Floyd's Tortoise and Hare algorithm: 
    // The key idea is to have two pointers, one that moves twice as fast as the other. 
    // If the turtle is equal then rabbit, has a loop, if they don't, doesn't have a loop.
    public boolean hasLoop() {

        Node turtle = this.head;
        Node rabbit = this.head;

        while (rabbit != null && rabbit.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;

            if (turtle == rabbit) return true;
        }

        return false;
    }

    public Node findKthFromEnd(int k) {
        Node fast = this.head;
        Node slow = this.head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // This method will rearrange the list based on X value. 
    // Values < than X will become in the beginning of the list, values >= will be in the end of the list.
    public void partitionList(int x){

        if(this.head == null) return;

        Node lessHead = null;
        Node lessTail = null;
        Node greaterHead = null;
        Node greaterTail = null;
        Node currentNode = this.head;
        Node nextNode = null;


        while(currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = null;

            if(currentNode.value < x){
                if (lessHead == null) {
                    lessHead = currentNode;
                    lessTail = currentNode;
                } else {
                    lessTail.next = currentNode;
                    lessTail = currentNode;
                }
            }else{
                if (greaterHead == null) {
                    greaterHead = currentNode;
                    greaterTail = currentNode;
                } else {
                    greaterTail.next = currentNode;
                    greaterTail = currentNode;
                }
            }

            currentNode = nextNode;
        }

        if(lessHead == null){
            this.head = greaterHead;
        }else{
            lessTail.next = greaterHead;
            this.head = lessHead;
        }

        if(greaterTail != null){
            this.tail = greaterTail;
        }
    }

    public void removeDuplicates() {
        if (this.head == null) return;

        Set<Integer> values = new HashSet<>();
        Node currentNode = this.head;
        Node previousNode = null;

        while (currentNode != null) {
            if (values.contains(currentNode.value)) {
                previousNode.next = currentNode.next;
                currentNode.next = null;
                this.length--;
            } else {
                values.add(currentNode.value);
                previousNode = currentNode;
            }

            if (currentNode == this.tail && values.contains(currentNode.value)) {
                this.tail = previousNode;
            }

            currentNode = currentNode.next;
        }
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;
    }

    public void printList() {
        Node temp = this.head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll(){
        System.out.println("Head: " + this.head.value);
        System.out.println("Tail: " + this.tail.value);
        System.out.println("Length: " + this.length);
        System.out.println("Values: ");
        printList();
    }

    private void increaseLength() {
        this.length++;
    }

    private void decreaseLength() {
        this.length--;
    }
}

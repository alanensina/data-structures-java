package linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void append(int value){
        Node newNode = new Node(value);

        if(this.length == 0){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.length++;
    }

    public void prepend(int value){
        Node newNode = new Node(value);

        if(this.length == 0){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }

        this.length++;
    }

    public boolean insert(int value, int index){

        if(index < 0 || index > this.length) return false;

        if(index == 0){
            prepend(value);
            return true;
        }

        if(index == this.length){
            append(value);
            return true;
        }

        Node newNode = new Node(value); // new node to be added
        Node previousNode = get(index - 1); // get the previous node of the index desired
        newNode.next = previousNode.next; // point the new node to the node that the previous are pointing
        previousNode.next = newNode; // point the previous node to the new node

        this.length++;

        return true;
    }

    public Node remove(int index){

        if(index < 0 || index > this.length) return null;

        if(index == 0) return removeFirst();
        if(index == this.length - 1) return removeLast();

        Node previousNode = get(index - 1); // get the previous node
        Node node = previousNode.next; // get the node that will be removed
        previousNode.next = node.next; // point the previous node to the next node of the node that will be removed
        node.next = null; // unlink the node removed of other element
        this.length--;

        return node;
    }

    public void printList(){
        Node temp = this.head;

        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node removeLast(){

        // If the LinkedList is empty, there's no need to remove a Node
        if(this.length == 0) return null;

        Node pre = this.head;
        Node temp = this.head;

        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }

        this.tail = pre;
        this.tail.next = null;
        this.length--;

        // If the LinkedList has one element and this element is removed, we need to set the head and tail to null.
        if(this.length == 0){
            this.tail = null;
            this.head = null;
        }

        // Return the Node removed.
        return temp;
    }

    public Node removeFirst(){
        Node node;

        if(this.length == 0) return null;

        node = this.head;
        this.head = this.head.next;
        node.next = null;
        this.length--;

        if(this.length == 0){
            this.tail = null;
        }

        return node;
    }

    public Node getHead() {
        System.out.println("Head: " + this.head.value);
        return head;
    }

    public Node get(int index){

        if(index < 0 || index >= this.length) return null;

        Node temp = this.head;

        for(int i = 0 ; i < index ; i++){
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);

        if(temp != null){
            temp.value = value;
            return true;
        }

        return false;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        System.out.println("Tail: " + this.tail.value);
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getLength() {
        System.out.println("Length: " + this.length);
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

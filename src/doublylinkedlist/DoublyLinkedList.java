package doublylinkedlist;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node previous;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    private void increaseLength() {
        this.length++;
    }

    private void decreaseLength() {
        this.length--;
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

    public void append(int value) {
        Node newNode = new Node(value);

        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.previous = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }

        increaseLength();
    }

    public Node removeLast(){

        if(this.length == 0) return null;

        Node temp = this.tail;

        if(this.length == 1) {
            this.head = null;
            this.tail = null;
        }else{
            this.tail = temp.previous;
            tail.next = null;
        }

        temp.next = null;
        temp.previous = null;

        decreaseLength();
        return temp;
    }

    public void prepend(int value){

        if(this.length == 0){
            append(value);
        }else{
            Node newNode = new Node(value);
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
            increaseLength();
        }
    }

    public Node removeFirst(){

        if(this.length == 0) return null;

        Node temp = this.head;

        if(this.length == 1) {
            this.head = null;
            this.tail = null;
        }else{
            this.head = temp.next;
            this.head.previous = null;
        }

        temp.next = null;
        temp.previous = null;

        decreaseLength();
        return temp;
    }
}

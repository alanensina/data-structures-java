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

    public Node get(int index){

        if(this.length == 0 || index >= this.length) return null;

        Node temp = this.head;

        if(index < this.length/2){
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        }else{
            temp = this.tail;
            for(int i = this.length-1; i > index; i--){
                temp = temp.previous;
            }
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

    public boolean insert(int index, int value){

        if(index < 0 || index >= this.length) return false;

        if(index == 0){
            prepend(value);
            return true;
        }
        else if(index == this.length-1){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index);
        newNode.previous = temp.previous;
        newNode.next = temp.next;
        temp.previous = newNode;

        Node previousNode = newNode.previous;
        previousNode.next = newNode;

        increaseLength();
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= this.length) return null;

        if(index == 0){
            return removeFirst();
        } else if (index == this.length - 1) {
            return removeLast();
        }

        Node removedNode = get(index);
        Node before = removedNode.previous;
        Node after = removedNode.next;
        before.next = after;
        after.previous = before;

        removedNode.next = null;
        removedNode.previous = null;

        decreaseLength();
        return removedNode;
    }

    public void swapFirstWithLast(){
        if(this.length >= 2){
            int temp = head.value;
            head.value = tail.value;
            tail.value = temp;
        }
    }

    // TODO: WIP
    public void reverse(){
        if(this.length >= 2){

            for(int i = 0 ; i < this.length/2 ; i++){
                Node start = get(i); // Get the most left node
                Node end = get(this.length-1-i); // Get the most right node

                Node after = start.next; // Get the next node of the most left node
                Node before = end.previous; // Get the previous node of the most right node

                Node swapperStart = start; // Save the reference of the start
                Node swapperEnd = end; // Save the reference of the end

                Node swapper = start;
                start = end;
                end = swapper;

                start.previous = swapperStart.previous;
                end.next = swapperEnd.next;

                after.previous = start;
                before.next = end;
            }

            // Invert the head and tail.
            Node temp = this.head;
            this.head = this.tail;
            this.tail = temp;
        }
    }
}

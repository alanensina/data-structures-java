package doublylinkedlist;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node previousious;

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
            newNode.previousious = this.tail;
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
            this.tail = temp.previousious;
            tail.next = null;
        }

        temp.next = null;
        temp.previousious = null;

        decreaseLength();
        return temp;
    }

    public void prepend(int value){

        if(this.length == 0){
            append(value);
        }else{
            Node newNode = new Node(value);
            newNode.next = this.head;
            this.head.previousious = newNode;
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
            this.head.previousious = null;
        }

        temp.next = null;
        temp.previousious = null;

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
                temp = temp.previousious;
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
        newNode.previousious = temp.previousious;
        newNode.next = temp.next;
        temp.previousious = newNode;

        Node previousiousNode = newNode.previousious;
        previousiousNode.next = newNode;

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
        Node before = removedNode.previousious;
        Node after = removedNode.next;
        before.next = after;
        after.previousious = before;

        removedNode.next = null;
        removedNode.previousious = null;

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
    
    public void reverse(){
        if(this.length >= 2) {
	      Node currentNode = this.head; // Set a pointer to the beggining of the list
	      Node temp = null;
	      
	      while(currentNode != null){ // Iterate the list while the pointer is not null
	          temp = currentNode.previousious; // Store the previousious node of the pointer in a temporary node
	          currentNode.previousious = currentNode.next; // Invert the pointer of the previousious with next
	          currentNode.next = temp; // Invert the pointer of the next with previousious
	          currentNode = currentNode.previousious; // Move the pointer to the previousious node
	      }

        // Invert the head with tail
	      temp = this.head;
	      this.head = this.tail;
	      this.tail = temp;
	    }
    }

	
    public boolean isPalindrome(){
	    
    	if(this.length < 2) return true;
	   
	    Node start = this.head;
	    Node end = this.tail;
	    
	    for(int i = 0 ; i < this.length/2 ; i++){
	        if(start.value != end.value) return false;
	        
	        start = start.next;
	        end = end.previousious;
	    }
	    
	    return true;
	}
    }

public void swapPairs() {
        if (head == null || head.next == null) return;
            
	Node current = head; // The pointer

        while (current != null && current.next != null) {
            Node first = current;
            Node second = current.next;
            Node nextPair = second.next;

            // Update the connection between the previous node
            second.previous = first.previous;
            if (first.previous != null) {
                first.previous.next = second;
            } else {
                head = second; // Update the head if is the first pair
            }

            // Swap nodes
            first.previous = second;
            first.next = nextPair;
            second.next = first;

            if (nextPair != null) {
                nextPair.previous = first;
            } else {
                tail = first; // Update the tail if is the last node
            }

            // Move the pointer to the next position
            current = nextPair;
        }
    }



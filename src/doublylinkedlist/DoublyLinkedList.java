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

    public void printAll() {
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

    public Node removeLast() {

        if (this.length == 0) return null;

        Node temp = this.tail;

        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = temp.previous;
            tail.next = null;
        }

        temp.next = null;
        temp.previous = null;

        decreaseLength();
        return temp;
    }

    public void prepend(int value) {

        if (this.length == 0) {
            append(value);
        } else {
            Node newNode = new Node(value);
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
            increaseLength();
        }
    }

    public Node removeFirst() {

        if (this.length == 0) return null;

        Node temp = this.head;

        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = temp.next;
            this.head.previous = null;
        }

        temp.next = null;
        temp.previous = null;

        decreaseLength();
        return temp;
    }

    public Node get(int index) {

        if (this.length == 0 || index >= this.length) return null;

        Node temp = this.head;

        if (index < this.length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for (int i = this.length - 1; i > index; i--) {
                temp = temp.previous;
            }
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

    public boolean insert(int index, int value) {

        if (index < 0 || index >= this.length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        } else if (index == this.length - 1) {
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

    public Node remove(int index) {
        if (index < 0 || index >= this.length) return null;

        if (index == 0) {
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

    public void swapFirstWithLast() {
        if (this.length >= 2) {
            int temp = head.value;
            head.value = tail.value;
            tail.value = temp;
        }
    }

    public void reverse() {
        if (this.length >= 2) {
            Node currentNode = this.head; // Set a pointer to the beggining of the list
            Node temp = null;

            while (currentNode != null) { // Iterate the list while the pointer is not null
                temp = currentNode.previous; // Store the previous node of the pointer in a temporary node
                currentNode.previous = currentNode.next; // Invert the pointer of the previous with next
                currentNode.next = temp; // Invert the pointer of the next with previous
                currentNode = currentNode.previous; // Move the pointer to the previous node
            }

            // Invert the head with tail
            temp = this.head;
            this.head = this.tail;
            this.tail = temp;
        }
    }


    public boolean isPalindrome() {

        if (this.length < 2) return true;

        Node start = this.head;
        Node end = this.tail;

        for (int i = 0; i < this.length / 2; i++) {
            if (start.value != end.value) return false;

            start = start.next;
            end = end.previous;
        }

        return true;
    }

    // Swaps the values of adjacent nodes in the list
    public void swapPairs() {
        if (head == null || head.next == null) return;

        Node current = head; // The pointer

        while (current != null && current.next != null) {
            Node first = current;
            Node second = current.next;
            Node nextPair = second.next;

            // Connect the second node with the previous of the first node
            second.previous = first.previous;
            if (first.previous != null) {
                first.previous.next = second;
            } else {
                head = second; // Update the head in the first loop
            }

            // Swap first and second
            second.next = first;
            first.previous = second;

            // Connect the first with the rest of the list
            first.next = nextPair;
            if (nextPair != null) {
                nextPair.previous = first;
            } else {
                tail = first; // Update the tail if is the end of the list
            }

            // Move the pointer to the next step
            current = nextPair;
        }
    }
}



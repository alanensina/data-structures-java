package queue;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public Queue(int value){
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }

    private int getLength() {
        return length;
    }

    private void increaseLength(){
        this.length++;
    }

    public void decreaseLength(){
        this.length--;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public void printQueue(){
        if(getLength() > 0){
            Node temp = this.first;

            while(temp != null){
                System.out.println(temp.value);
                temp = temp.next;
            }
        }
    }

    public void print(){
        if(getLength() == 0) {
            System.out.println("The queue is empty.");
        }else{
            System.out.println("----------");
            System.out.println("First: " + getFirst().value);
            System.out.println("----------");
            System.out.println("Last: " + getLast().value);
            System.out.println("----------");
            System.out.println("Length: " + getLength());
            System.out.println("----------");
            System.out.println("Values:");
            System.out.println("----------");
            printQueue();
            System.out.println("----------");
        }
    }

    public void enqueue(int value){
        Node newNode = new Node(value);

        if(getLength() == 0){
            this.first = newNode;
            this.last = newNode;
        }else{
            this.last.next = newNode;
            this.last = newNode;
        }

        increaseLength();
    }

    public Node dequeue(){
        if(getLength() == 0) return null;

        Node removedNode = this.first;

        if(getLength() == 1){
            this.first = null;
            this.last = null;
        }else{
            this.first = this.first.next;
            removedNode.next = null;
        }

        decreaseLength();
        return removedNode;
    }
}

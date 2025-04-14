package stack;

public class Stack {

    private Node top;
    private int heigth;

    public Stack(int value){
        this.top = new Node(value);
        this.heigth = 1;
    }

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public void printStack(){
        Node temp = this.top;

        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void print(){
        System.out.println("----------");
        System.out.println("Heigth: " + this.heigth);
        System.out.println("----------");

        if (heigth > 0) {
            System.out.println("Top: " + this.top.value);
            System.out.println("----------");
            printStack();
            System.out.println("----------");
        }
    }

    public void push(int value){
        Node newNode = new Node(value);

        if(isEmpty()){
            this.top = newNode;
        }else{
            newNode.next = this.top;
            this.top = newNode;
        }
        this.heigth++;
    }

    public Node pop(){
        if(isEmpty()) return null;

        Node removedNode = this.top;
        this.top = removedNode.next;

        this.heigth--;
        return removedNode;
    }

    public Node peek(){
        return this.top;
    }

    public boolean isEmpty(){
        return this.heigth == 0;
    }
}

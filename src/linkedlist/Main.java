package linkedlist;

public class Main {

    public static void main(String[] args) {

       LinkedList myLinkedList = new LinkedList(5);
        myLinkedList.removeFirst();

        System.out.println(myLinkedList.get(0));

    }
}

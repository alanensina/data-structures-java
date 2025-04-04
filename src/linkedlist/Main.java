package linkedlist;

public class Main {

    public static void main(String[] args) {

       LinkedList myLinkedList = new LinkedList(5);

       myLinkedList.append(10);
       myLinkedList.append(2);
       myLinkedList.append(11);
       myLinkedList.append(14);
       myLinkedList.append(145);
       myLinkedList.append(102);

        System.out.println("Initial list:");
        myLinkedList.printList();
        myLinkedList.reverse();
        System.out.println("----------");
        System.out.println("Reversed list:");
        myLinkedList.printList();
    }
}

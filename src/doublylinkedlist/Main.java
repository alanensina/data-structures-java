package doublylinkedlist;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList(8);
        list.append(9);
       // list.append(2);
       // list.append(3);

        //list.removeLast();
        //list.prepend(10);
        //list.removeFirst();

        //list.printAll();

        //list.insert(4, 6);
        list.remove(0);
        list.printAll();
    }
}

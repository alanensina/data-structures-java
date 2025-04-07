package doublylinkedlist;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList(8);
        list.append(9);
        list.append(2);
        list.append(3);
        list.printAll();
    }
}

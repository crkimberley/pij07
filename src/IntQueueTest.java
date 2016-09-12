/**
 * @author crkimberley on 12/09/2016.
 */
public class IntQueueTest {
    public static void main(String[] args) {
        IntQueueTest test = new IntQueueTest();
        test.launch();
    }

    private void launch() {
        System.out.println("Queue of integers implemented using a circular singly-linked list");
        IntQueue queue = new IntQueue();

        queue.printList();

        System.out.println("Insert 5 numbers: 0 7 9 5 7");
        queue.insert(0);
        queue.insert(7);
        queue.insert(9);
        queue.insert(5);
        queue.insert(7);
        queue.printList();
        System.out.println("size = " + queue.size() + "\n");

        System.out.println("retrieve..." + queue.retrieve());
        System.out.println("retrieve..." + queue.retrieve());
        System.out.println("retrieve..." + queue.retrieve());
        queue.printList();
        System.out.println("size = " + queue.size() + "\n");

        System.out.println("Insert 3 numbers: 3 4 6");
        queue.insert(3);
        queue.insert(4);
        queue.insert(6);
        queue.printList();
        System.out.println("size = " + queue.size() + "\n");

        System.out.println("retrieve..." + queue.retrieve());
        System.out.println("retrieve..." + queue.retrieve());
        queue.printList();
        System.out.println("size = " + queue.size() + "\n");

        System.out.println("retrieve..." + queue.retrieve());
        System.out.println("retrieve..." + queue.retrieve());
        System.out.println("retrieve..." + queue.retrieve());
        queue.printList();
        System.out.println("size = " + queue.size() + "\n");

        System.out.println("Attempt to retrieve from an empty queue");
        System.out.println("retrieve..." + queue.retrieve());
        queue.printList();
        System.out.println("size = " + queue.size() + "\n");

        System.out.println("Insert 3 numbers: 1 9 9");
        queue.insert(1);
        queue.insert(9);
        queue.insert(9);
        queue.printList();
        System.out.println("size = " + queue.size() + "\n");
    }
}

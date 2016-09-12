/**
 * @author crkimberley on 12/09/2016.
 */
public class IntStackTest {
    public static void main(String[] args) {
        IntStackTest test = new IntStackTest();
        test.launch();
    }

    private void launch() {
        System.out.println("Queue of integers implemented using a circular singly-linked list");
        IntStack stack = new IntStack();

        stack.printList();

        System.out.println("push 5 numbers: 0 7 9 5 7");
        stack.push(0);
        stack.push(7);
        stack.push(9);
        stack.push(5);
        stack.push(7);
        stack.printList();
        System.out.println("empty = " + stack.empty() + "\n");

        System.out.println("pop..." + stack.pop());
        System.out.println("pop..." + stack.pop());
        System.out.println("pop..." + stack.pop());
        stack.printList();
        System.out.println("empty = " + stack.empty() + "\n");

        System.out.println("push 3 numbers: 3 4 6");
        stack.push(3);
        stack.push(4);
        stack.push(6);
        stack.printList();
        System.out.println("empty = " + stack.empty() + "\n");

        System.out.println("pop..." + stack.pop());
        System.out.println("pop..." + stack.pop());
        stack.printList();
        System.out.println("empty = " + stack.empty() + "\n");

        System.out.println("pop..." + stack.pop());
        System.out.println("pop..." + stack.pop());
        System.out.println("pop..." + stack.pop());
        stack.printList();
        System.out.println("empty = " + stack.empty() + "\n");

        System.out.println("Attempt to pop from an empty stack");
        System.out.println("pop..." + stack.pop());
        stack.printList();
        System.out.println("empty = " + stack.empty() + "\n");

        System.out.println("push 3 numbers: 1 9 9");
        stack.push(1);
        stack.push(9);
        stack.push(9);
        stack.printList();
        System.out.println("empty = " + stack.empty() + "\n");
    }
}

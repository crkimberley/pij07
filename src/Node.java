/**
 * @author crkimberley on 13/09/2016.
 */
public class Node {
    private int number;
    private Node next;

    public Node(int number) {
        this.number = number;
        next = null;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Node getNext() {
        return next;
    }

    public void addNode(Node newNode) {
        if (next == null) {
            next = newNode;
        } else {
            next.addNode(newNode);
        }
    }

    public void addIntToSortedList(int number) {
        addNodeToSortedList(new Node(number));
    }

    public void addNodeToSortedList(Node newNode) {
        // if new number < listStart.number
        if (newNode.number < number) {
            int temp = number;
            number = newNode.number;
            newNode.number = temp;
            newNode.next = next;
            next = newNode;
        } else {
            addNodeToSortedListRecursive(newNode);
        }
    }

    private void addNodeToSortedListRecursive(Node newNode) {
        if (next == null) {
            next = newNode;
        } else if (newNode.number > next.number) {
            if (next.next == null) {
                next.next = newNode;
            } else {
                next.addNodeToSortedList(newNode);
            }
        } else {
            newNode.next = next;
            next = newNode;
        }
    }

    public String toString() {
        return listStringBuilder(this, new StringBuilder());
    }

    private String listStringBuilder(Node node, StringBuilder sb) {
        if (node == null) {
            return "Linked List: " + sb;
        }
        sb.append(node.number);
        sb.append(node.next != null ? "," : "");
        return listStringBuilder(node.next, sb);
    }

    public void printList() {
        Node currentNode = this;
        do {
            System.out.print(currentNode.next != null ? currentNode.number + ", " : currentNode);
            currentNode = currentNode.next;
        } while (currentNode != null);
        System.out.println();
    }
}

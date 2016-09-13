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

    public void addNode(Node newNode) {
        if (next == null) {
            next = newNode;
        } else {
            next.addNode(newNode);
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
        sb.append(node.next != null ? ", " : "");
        return listStringBuilder(node.next, sb);
    }

    /*
    public void printList() {
        Node currentNode = this;
        do {
            System.out.print(currentNode.next != null ? currentNode.number + ", " : currentNode);
            currentNode = currentNode.next;
        } while (currentNode != null);
        System.out.println();
    }
    */
}

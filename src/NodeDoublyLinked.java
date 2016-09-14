/**
 * @author crkimberley on 13/09/2016.
 */
public class NodeDoublyLinked {
    private int number;
    private NodeDoublyLinked next;
    private NodeDoublyLinked previous;

    public NodeDoublyLinked(int number) {
        this.number = number;
        next = null;
        previous = null;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public NodeDoublyLinked getNext() {
        return next;
    }

    public NodeDoublyLinked getPrevious() {
        return previous;
    }

    public void addNode(NodeDoublyLinked newNode) {
        if (next == null) {
            next = newNode;
            newNode.previous = this;
        } else {
            next.addNode(newNode);
        }
    }

    public String toString() {
        return listStringBuilder(this, new StringBuilder());
    }

    private String listStringBuilder(NodeDoublyLinked node, StringBuilder sb) {
        if (node == null) {
            return "Linked List: " + sb;
        }
        sb.append(node.number);
        sb.append(node.next != null ? "," : "");
        return listStringBuilder(node.next, sb);
    }

    public void printList() {
        NodeDoublyLinked currentNode = this;
        do {
            System.out.print(currentNode.next != null ? currentNode.number + ", " : currentNode);
            currentNode = currentNode.next;
        } while (currentNode != null);
        System.out.println();
    }
}

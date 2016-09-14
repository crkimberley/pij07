/**
 * @author crkimberley on 12/09/2016.
 */
public class ListUtilities {
    public static Node intArrayToList(int[] intArray) {
        Node listStart = new Node(intArray[0]);
        for (int i=1; i<intArray.length; i++) {
            listStart.addNode(new Node(intArray[i]));
        }
        return listStart;
    }

    public static NodeDoublyLinked intArrayToDoublyLinkedList(int[] intArray) {
        NodeDoublyLinked listStart = new NodeDoublyLinked(intArray[0]);
        for (int i=1; i<intArray.length; i++) {
            listStart.addNode(new NodeDoublyLinked(intArray[i]));
        }
        return listStart;
    }

    public static Node intArrayToSortedList(int[] intArray) {
        Node listStart = new Node(intArray[0]);
        for (int i=1; i<intArray.length; i++) {
            listStart.addNodeToSortedList(new Node(intArray[i]));
        }
        return listStart;
    }

    public static void intArrayPrint(int[] intArray) {
        StringBuilder sb = new StringBuilder("[");
        for (int i : intArray) {
            sb.append(i);
            sb.append(",");
        }
        // Remove final comma
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println("Array: " + sb);
    }

    public static Node bubbleSort(Node list) {
        boolean done;
        do {
            // Done variable will stay true if no swaps are done - when sorting is finished
            done = true;
            // Return to start of list for each pass
            Node currentNode = list;
            while (currentNode.getNext() != null) {
                // Swap pair if out of order
                if (currentNode.getNumber() > currentNode.getNext().getNumber()) {
                    done = false;
                    int temp = currentNode.getNumber();
                    currentNode.setNumber(currentNode.getNext().getNumber());
                    currentNode.getNext().setNumber(temp);
                }
                currentNode = currentNode.getNext();
            }
        } while (!done);
        return list;
    }

    public static NodeDoublyLinked cocktailSort(NodeDoublyLinked list) {
        boolean done;
        do {
            // Done variable will stay true if no swaps are done - when sorting is finished
            done = true;
            // Return to start of list for each pass
            NodeDoublyLinked currentNode = list;
            while (currentNode.getNext() != null) {
                // Swap pair if out of order
                if (currentNode.getNumber() > currentNode.getNext().getNumber()) {
                    done = false;
                    int temp = currentNode.getNumber();
                    currentNode.setNumber(currentNode.getNext().getNumber());
                    currentNode.getNext().setNumber(temp);
                }
                currentNode = currentNode.getNext();
            }
            while (currentNode.getPrevious() != null) {
                if (currentNode.getNumber() < currentNode.getPrevious().getNumber()) {
                    done = false;
                    int temp = currentNode.getNumber();
                    currentNode.setNumber(currentNode.getPrevious().getNumber());
                    currentNode.getPrevious().setNumber(temp);
                }
                currentNode = currentNode.getPrevious();
            }
        } while (!done);
        return list;

    }
}
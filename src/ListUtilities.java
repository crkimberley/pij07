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
        System.out.print(intArrayToString(intArray));
    }

    public static String intArrayToString(int[] intArray) {
        StringBuilder sb = new StringBuilder("[");
        for (int i : intArray) {
            sb.append(i);
            sb.append(",");
        }
        // Remove final comma
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public static void intArrayEndsPrint(int[] intArray) {
        System.out.print(intArrayEndsToString(intArray));
    }

    public static String intArrayEndsToString(int[] intArray) {
        if (intArray.length <=10) {
            return intArrayToString(intArray);
        } else {
            int[] top = new int[5];
            int[] tail = new int[5];
            System.arraycopy(intArray, 0, top, 0, 5);
            System.arraycopy(intArray, intArray.length - 5, tail, 0, 5);
            StringBuilder sb = new StringBuilder("[");
            for (int i : top) {
                sb.append(i);
                sb.append(",");
            }
            // Remove final comma
            sb.deleteCharAt(sb.length() - 1);
            sb.append("...");
            for (int i : tail) {
                sb.append(i);
                sb.append(",");
            }
            // Remove final comma
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            return sb.toString();
        }
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
        // Bidirectional version of bubbleSort
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
            // traverse in opposite direction
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

    public static NodeDoublyLinked insertionSort1(NodeDoublyLinked list) {
        NodeDoublyLinked nodeI = list;
        for (NodeDoublyLinked i = list; i != null; i = i.getNext()) {
            for (NodeDoublyLinked j = i; j != list && j.getPrevious().getNumber() > j.getNumber(); j = j.getPrevious()) {
                int temp = j.getNumber();
                j.setNumber(j.getPrevious().getNumber());
                j.getPrevious().setNumber(temp);
            }
        }
        return list;
    }

    public static void printDoublyLinkedListNumbers(NodeDoublyLinked list) {
        for (NodeDoublyLinked i = list; i != null; i = i.getNext()) {
            System.out.print(i.getNumber() + " ");
        }
        System.out.println();
    }
}
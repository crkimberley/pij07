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
        System.out.print(intArrayToString(intArray) + "\n");
    }

    public static String intArrayToString(int[] intArray) {
        StringBuilder sb = new StringBuilder("[");
        for (int i=0; i<intArray.length; i++) {
            sb.append(intArray[i]);
            sb.append(i < intArray.length - 1 ? "," : "]");
        }
        return sb.toString();
    }

    public static void intArrayEndsPrint(int[] intArray) {
        System.out.print(intArrayEndsToString(intArray));
    }

    public static String intArrayEndsToString(int[] intArray) {
        if (intArray.length <=20) {
            return intArrayToString(intArray);
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i=0; i<10; i++) {
                sb.append(intArray[i]);
                sb.append(i < 9 ? "," : "...");
            }
            for (int i=10; i>0; i--) {
                sb.append(intArray[intArray.length - i]);
                sb.append(i > 1 ? "," : "]");
            }
            return sb.toString();
        }
    }

    public static int lengthOfDoublyLinkedList(NodeDoublyLinked list) {
        int length = 0;
        for (NodeDoublyLinked i = list; i != null; i = i.getNext()) {
            length++;
        }
        return length;
    }

    public static NodeDoublyLinked endOfDoublyLinkedList(NodeDoublyLinked list) {
        while (list.getNext() != null) {
            list = list.getNext();
        }
        return list;
    }

    public static String intDoublyLinkedListEndsToString(NodeDoublyLinked list) {
        if (lengthOfDoublyLinkedList(list) <= 20) {
            return list.toString();
        }
        StringBuilder sb = new StringBuilder();
        NodeDoublyLinked temp = list;
        for (int i = 0; i<10 ; i++) {
            sb.append(temp.getNumber());
            sb.append(i < 9 ? "," : "...");
            temp = temp.getNext();
        }
        StringBuilder sb2 = new StringBuilder();
        temp = endOfDoublyLinkedList(list);
        for (int i = 0; i<10 ; i++) {
            sb2.insert(0, i > 0 ? "," : "");
            sb2.insert(0, temp.getNumber());
            temp = temp.getPrevious();
        }
        sb.append(sb2);
        return sb.toString();
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

    public static NodeDoublyLinked bubbleSort(NodeDoublyLinked list) {
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
        for (NodeDoublyLinked i = list; i != null; i = i.getNext()) {
            for (NodeDoublyLinked j = i; j != list && j.getPrevious().getNumber() > j.getNumber(); j = j.getPrevious()) {
                int temp = j.getNumber();
                j.setNumber(j.getPrevious().getNumber());
                j.getPrevious().setNumber(temp);
            }
        }
        return list;
    }

    public static NodeDoublyLinked insertionSort2(NodeDoublyLinked list) {
        for (NodeDoublyLinked i = list; i != null; i = i.getNext()) {
            int temp = i.getNumber();
            NodeDoublyLinked j;
            for (j = i; j != list && j.getPrevious().getNumber() > temp; j = j.getPrevious()) {
                j.setNumber(j.getPrevious().getNumber());
            }
            j.setNumber(temp);
        }
        return list;
    }

    public static void quickSort1(NodeDoublyLinked list) {
        quickSort1(list, endOfDoublyLinkedList(list));
    }

    public static void quickSort1(NodeDoublyLinked lowerLimit, NodeDoublyLinked upperLimit) {
        if (lowerLimit == null || upperLimit == null) {
            return;
        }
        // if (lowerLimit >= upperLimit) {return;}
        for (NodeDoublyLinked x = upperLimit; x != null; x = x.getNext() ) {
            if (x == lowerLimit) {
                return;
            }
        }
        NodeDoublyLinked middle = lowerLimit;
        NodeDoublyLinked i = lowerLimit;
        boolean upperLimitReached = false;
        while (!upperLimitReached) {
            i = i.getNext();
            if (i.getNumber() <= lowerLimit.getNumber()) {
                middle = middle.getNext();
                swap(middle, i);
            }
            if (i == upperLimit) {
                upperLimitReached = true;
            }
        }
        swap(lowerLimit, middle);
        quickSort1(lowerLimit, middle.getPrevious());
        quickSort1(middle.getNext(), upperLimit);
    }

    private static void swap(NodeDoublyLinked x, NodeDoublyLinked y) {
        int temp = x.getNumber();
        x.setNumber(y.getNumber());
        y.setNumber(temp);
    }

    private static void qSort1(NodeDoublyLinked l, NodeDoublyLinked u) {
        //System.out.println("Just arrived in qSort1 and l = " + l.getNumber() + " and u = " + u.getNumber());
        for (NodeDoublyLinked x = u; x != null; x = x.getNext()) {
            System.out.println("x = " + x.getNumber());
            if (x == l) {
                return ;
            }
        }
        NodeDoublyLinked m = l;
        //System.out.println("l = " + l.getNumber() + ", m = " + m.getNumber() + ", u = " + u.getNext());
        for (NodeDoublyLinked i = l.getNext(); i.getNext() != u; i = i.getNext()) {
            if (i.getNumber() < l.getNumber()) {
                m = m.getNext();
                System.out.println("l = " + l.getNumber() + ", m = " + m.getNumber() + ", u = " + u.getNext());
                int temp = i.getNumber();
                i.setNumber(m.getNumber());
                m.setNumber(temp);
                System.out.println("l = " + l.getNumber() + ", m = " + m.getNumber() + ", u = " + u.getNext());
            }
        }
        int temp = l.getNumber();
        l.setNumber(m.getNumber());
        //System.out.println("l = " + l.getNumber() + ", m = " + m.getNumber() + ", u = " + u.getNext());
        m.setNumber(temp);
        //System.out.println("l = " + l.getNumber() + ", m = " + m.getNumber() + ", u = " + u.getNext());
        qSort1(l, m.getPrevious());
        qSort1(m.getNext(), u);
    }

    public static void qSort1(int[] array, int l, int u) {
        if (l >= u) {
            return;
        }
        int m = l;
        for (int i=l+1; i<=u; i++) {
            if (array[i] < array[l]) {
                m++;
                int temp = array[m];
                array[m] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[l];
        array[l] = array[m];
        array[m] = temp;
        qSort1(array, l, m-1);
        qSort1(array, m+1, u);
    }

    public static void printDoublyLinkedListNumbers(NodeDoublyLinked list) {
        for (NodeDoublyLinked i = list; i != null; i = i.getNext()) {
            System.out.print(i.getNumber() + " ");
        }
        System.out.println();
    }
}
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
}

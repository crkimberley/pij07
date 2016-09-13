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
}

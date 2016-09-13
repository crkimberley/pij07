/**
 * @author crkimberley on 12/09/2016.
 */
public class IntArrayToListTest {

    public static void main(String[] args) {
        new IntArrayToListTest().launch();
    }

    private void launch() {
        int[] testArray = {0, 7, 9, 5, 7, 3, 4, 6, 1, 9, 9};
        ListUtilities.intArrayPrint(testArray);
        System.out.println(ListUtilities.intArrayToList(testArray));
    }
}

/**
 * @author crkimberley on 12/09/2016.
 */
public class IntArrayToListTest {

    public static void main(String[] args) {
        new IntArrayToListTest().launch();
    }

    private void launch() {
        System.out.println(ListUtilities.intArrayToList(new int[] {0, 7, 9, 5, 7, 3, 4, 6, 1, 9, 9}));
    }
}

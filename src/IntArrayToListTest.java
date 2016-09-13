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
        System.out.println("Array to linked list...");
        Node testList = ListUtilities.intArrayToList(testArray);
        System.out.println(testList);
        System.out.println("Array to  sorted linked list...");
        testList = ListUtilities.intArrayToSortedList(testArray);
        System.out.println(testList);
        System.out.println();

        System.out.println("Add a couple more numbers: 17, -25");
        testList.addIntToSortedList(17);
        testList.addIntToSortedList(-25);
        System.out.println(testList);
        System.out.println();

        System.out.println("New list - add some individual numbers: 1989, 371, 29465, 19");
        Node testList2 = new Node(1989);
        System.out.println(testList2);
        testList2.addIntToSortedList(371);
        System.out.println(testList2);
        testList2.addIntToSortedList(29465);
        System.out.println(testList2);
        testList2.addIntToSortedList(19);
        System.out.println(testList2);


    }
}

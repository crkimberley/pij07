/**
 * @author crkimberley on 12/09/2016.
 */
public class IntArrayToListTest {

    public static void main(String[] args) {
        new IntArrayToListTest().launch();
    }

    private void launch() {
        /*
        int[] testArray = {0, 7, 9, 5, 7, 3, 4, 6, 1, 9, 9};
        ListUtilities.intArrayPrint(testArray);
        System.out.println("Array to linked list...");
        Node testList = ListUtilities.intArrayToList(testArray);
        System.out.println(testList);
        System.out.println("Bubble Sort");
        System.out.println(ListUtilities.bubbleSort(testList));
        System.out.println();
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

        int[] testArray2 = {23,3565,1,9458,41,24,3,67367,45,344,234,2,5,2,4,123,94654};
        ListUtilities.intArrayPrint(testArray);
        System.out.println("Array to linked list...");
        testList = ListUtilities.intArrayToList(testArray2);
        System.out.println(testList);
        System.out.println("Bubble Sort");
        System.out.println(ListUtilities.bubbleSort(testList));
        System.out.println();
*/
        int[] backwards15953 = new int[15953];
        for (int i=0; i<15953; i++) {
            backwards15953[i] = 15953 - i;
        }
        Node backwards15953List = ListUtilities.intArrayToList(backwards15953);
        System.out.println(backwards15953List);
        System.out.println("Bubble Sort");
        System.out.println(ListUtilities.bubbleSort(backwards15953List));
        System.out.println();

    }
}

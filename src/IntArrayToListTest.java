/**
 * @author crkimberley on 12/09/2016.
 */
public class IntArrayToListTest {

    public static void main(String[] args) {
        new IntArrayToListTest().launch();
    }

    private void launch() {
        System.out.println("Create array then convert to linked list - ListUtilities.intArrayToList...");
        int[] array1 = {0, 7, 9, 5, 7, 3, 4, 6, 1, 9, 9};
        ListUtilities.intArrayPrint(array1);
        Node list1 = ListUtilities.intArrayToList(array1);
        System.out.println(list1);
        System.out.println();
        System.out.println("Bubble Sort the linked list...");
        System.out.println(ListUtilities.bubbleSort(list1));
        System.out.println();
        System.out.println("Convert original array to sorted linked list - ListUtilities.intArrayToSortedList...");
        Node list1a = ListUtilities.intArrayToSortedList(array1);
        System.out.println(list1a);
        System.out.println();

        System.out.println("Add a couple more numbers to the sorted list - addIntToSortedList: 17, -25");
        list1.addIntToSortedList(17);
        list1.addIntToSortedList(-25);
        System.out.println(list1);
        System.out.println();

        System.out.println("Create new list - add individual numbers to sorted list - addIntToSortedList: 1989, 371, 29465, 19");
        Node list2 = new Node(1989);
        System.out.println(list2);
        list2.addIntToSortedList(371);
        System.out.println(list2);
        list2.addIntToSortedList(29465);
        System.out.println(list2);
        list2.addIntToSortedList(19);
        System.out.println(list2);
        System.out.println();

        System.out.println("Create new array then convert to linked list - ListUtilities.intArrayToList...");
        int[] array3 = {23,3565,1,9458,41,24,3,67367,45,344,234,2,5,2,4,123,94654};
        ListUtilities.intArrayPrint(array3);
        Node list3 = ListUtilities.intArrayToList(array3);
        System.out.println(list3);
        System.out.println();
        System.out.println("Bubble Sort the linked list...");
        System.out.println(ListUtilities.bubbleSort(list3));
        System.out.println();

        System.out.println("Create large array - from 15000 down to 1 - then convert to linked list - ListUtilities.intArrayToList");
        int[] backwards = new int[15000];
        for (int i=0; i<15000; i++) {
            backwards[i] = 15000 - i;
        }
        Node backwardsList = ListUtilities.intArrayToList(backwards);
        System.out.println(backwardsList);
        System.out.println();
        System.out.println("Bubble Sort the linked list...");
        long startTime = System.currentTimeMillis();
        System.out.println(ListUtilities.bubbleSort(backwardsList));
        System.out.println("Sort duration = " + (double) (System.currentTimeMillis() - startTime) / 1000 + " seconds");
        System.out.println();
    }
}

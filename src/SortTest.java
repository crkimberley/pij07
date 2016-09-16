/**
 * @author crkimberley on 16/09/2016.
 */
public class SortTest {
    public static void main(String[] args) {
        new SortTest().launch();
    }

    private void launch() {
        int[] array1 = {0,7,9,5,7,3,4,6,1,9,9,0,7,8,0,8,7,2,3,5,9,8};
        ListUtilities.intArrayPrint(array1);
        ListUtilities.intArrayEndsPrint(array1);
        NodeDoublyLinked list1 = ListUtilities.intArrayToDoublyLinkedList(array1);
        System.out.println();
        System.out.println("Insertion Sort (1)...");
        System.out.println(ListUtilities.insertionSort1(list1));
        System.out.println();

        int[] array2 = new int[15000];
        for (int i=0; i<15000; i++) {
            array2[i] = 15000 - i;
        }
        ListUtilities.intArrayEndsPrint(array2);
        NodeDoublyLinked list2 = ListUtilities.intArrayToDoublyLinkedList(array2);
        System.out.println(list2);
        System.out.println("Insertion Sort (1) the linked list...");
        System.out.println(ListUtilities.insertionSort1(list2));
        System.out.println();
    }
}

/**
 * @author crkimberley on 12/09/2016.
 */
public class CocktailSortTest {

    public static void main(String[] args) {
        new CocktailSortTest().launch();
    }

    private void launch() {
        System.out.println("Create array then ListUtilities.intArrayToDoublyLinkedList...");
        int[] array1 = {0, 7, 9, 5, 7, 3, 4, 6, 1, 9, 9};
        ListUtilities.intArrayPrint(array1);
        NodeDoublyLinked list1 = ListUtilities.intArrayToDoublyLinkedList(array1);
        System.out.println(list1);
        System.out.println();
        System.out.println("Cocktail Sort the linked list...");
        System.out.println(ListUtilities.cocktailSort(list1));
        System.out.println();

        System.out.println("Create new array then ListUtilities.intArrayToDoublyLinkedList...");
        int[] array3 = {23,3565,1,9458,41,24,3,67367,45,344,234,2,5,2,4,123,94654};
        ListUtilities.intArrayPrint(array3);
        NodeDoublyLinked list3 = ListUtilities.intArrayToDoublyLinkedList(array3);
        System.out.println(list3);
        System.out.println();
        System.out.println("Cocktail Sort the linked list...");
        System.out.println(ListUtilities.cocktailSort(list3));
        System.out.println();

        System.out.println("Create large array - from 15000 down to 1 - then ListUtilities.intArrayToDoublyLinkedList");
        int[] backwards = new int[15000];
        for (int i=0; i<15000; i++) {
            backwards[i] = 15000 - i;
        }
        NodeDoublyLinked backwardsList = ListUtilities.intArrayToDoublyLinkedList(backwards);
        System.out.println(backwardsList);
        System.out.println();
        System.out.println("Cocktail Sort the linked list...");
        long startTime = System.currentTimeMillis();
        System.out.println(ListUtilities.cocktailSort(backwardsList));
        System.out.println("Sort duration = " + (double) (System.currentTimeMillis() - startTime) / 1000 + " seconds");
        System.out.println();
    }
}

import java.util.Random;

/**
 * @author crkimberley on 16/09/2016.
 */
public class SortTest {
    int LARGE_ARRAY_LENGTH = 15000;
    int RANDOM_NUMBER_RANGE = 1000;
    int IDENTICAL_VALUE = 999983;
    int[] array;

    private enum SortAlgorithm {
        BUBBLE, INSERTION1
    }

    public static void main(String[] args) {
        new SortTest().launch();
    }

    private void launch() {
        System.out.println("Short array");
        array = new int[] {0,7,9,5,7,3,4,6,1,9,9,0,7,8,0,8,7,2,3,5,9,8};
        compareSortAlgorithms();

        System.out.println("Large array of descending numbers");
        array = new int[LARGE_ARRAY_LENGTH];
        for (int i=0; i<LARGE_ARRAY_LENGTH; i++) {
            array[i] = LARGE_ARRAY_LENGTH - i;
        }
        compareSortAlgorithms();

        System.out.println("Large array of random numbers");
        Random rand = new Random();
        array = new int [LARGE_ARRAY_LENGTH];
        for (int i=0; i<LARGE_ARRAY_LENGTH; i++) {
            array[i] = rand.nextInt(RANDOM_NUMBER_RANGE);
        }
        compareSortAlgorithms();

        System.out.println("Large array of identical numbers");
        array = new int[LARGE_ARRAY_LENGTH];
        for (int i=0; i<LARGE_ARRAY_LENGTH; i++) {
            array[i] = IDENTICAL_VALUE;
        }
        compareSortAlgorithms();
    }

    private void arrayToListThenSortAndMeasureTime(SortAlgorithm algo) {
        System.out.print(algo + " ");
        NodeDoublyLinked list = ListUtilities.intArrayToDoublyLinkedList(array);
        long sortTime = System.currentTimeMillis();
        switch (algo) {
            case BUBBLE: ListUtilities.bubbleSort(list);
                break;
            case INSERTION1: ListUtilities.insertionSort1(list);
                break;
        }
        sortTime = System.currentTimeMillis() - sortTime;
        System.out.println("Sort time = " + sortTime + " ms");
        System.out.println(ListUtilities.intDoublyLinkedListEndsToString(list));
    }

    private void compareSortAlgorithms() {
        System.out.println("Array length " + array.length + " --- " + ListUtilities.intArrayEndsToString(array));
        arrayToListThenSortAndMeasureTime(SortAlgorithm.BUBBLE);
        arrayToListThenSortAndMeasureTime(SortAlgorithm.INSERTION1);
        System.out.println();
    }
}

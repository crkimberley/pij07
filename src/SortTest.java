import java.util.Arrays;
import java.util.Random;

/**
 * @author crkimberley on 16/09/2016.
 */
public class SortTest {
    int LARGE_ARRAY_LENGTH = 20000;
    int RANDOM_NUMBER_RANGE = 20000;
    int IDENTICAL_VALUE = 13;
    int[] array;
    Random rand = new Random();

    private enum SortAlgorithm {
        BUBBLE, COCKTAIL, INSERTION1, INSERTION2, QUICK1, QUICK2, QUICK3
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
            case COCKTAIL: ListUtilities.cocktailSort(list);
                break;
            case INSERTION1: ListUtilities.insertionSort1(list);
                break;
            case INSERTION2: ListUtilities.insertionSort2(list);
                break;
            case QUICK1: ListUtilities.quickSort1(list);
                break;
        }
        sortTime = System.currentTimeMillis() - sortTime;
        System.out.println("Sort time = " + sortTime + " ms");
        System.out.println(ListUtilities.intDoublyLinkedListEndsToString(list));
    }

    private void arrayCopySortAndMeasureTime(SortAlgorithm algo) {
        int[] copiedArray = Arrays.copyOf(array, array.length);
        System.out.print("(Array) " + algo + " ");
        long sortTime = System.currentTimeMillis();
        switch (algo) {
            case BUBBLE: ArraySortAlgorithms.bubbleSort(copiedArray);
                break;
            case COCKTAIL: ArraySortAlgorithms.cocktailSort(copiedArray);
                break;
            case INSERTION1: ArraySortAlgorithms.insertionSort1(copiedArray);
                break;
            case INSERTION2: ArraySortAlgorithms.insertionSort2(copiedArray);
                //break;
            case QUICK1: ArraySortAlgorithms.quickSort1(copiedArray);
                break;
            case QUICK2: ArraySortAlgorithms.quickSort2(copiedArray);
                break;
            case QUICK3: ArraySortAlgorithms.quickSort3(copiedArray);
                break;
        }
        sortTime = System.currentTimeMillis() - sortTime;
        System.out.println("Sort time = " + sortTime + " ms");
        System.out.println(ListUtilities.intArrayEndsToString(copiedArray));
    }

    private void compareSortAlgorithms() {
        System.out.println("Array length " + array.length + " --- " + ListUtilities.intArrayEndsToString(array));
        arrayToListThenSortAndMeasureTime(SortAlgorithm.BUBBLE);
        arrayCopySortAndMeasureTime(SortAlgorithm.BUBBLE);
        arrayToListThenSortAndMeasureTime(SortAlgorithm.COCKTAIL);
        arrayCopySortAndMeasureTime(SortAlgorithm.COCKTAIL);
        arrayToListThenSortAndMeasureTime(SortAlgorithm.INSERTION1);
        arrayCopySortAndMeasureTime(SortAlgorithm.INSERTION1);
        arrayToListThenSortAndMeasureTime(SortAlgorithm.INSERTION2);
        arrayCopySortAndMeasureTime(SortAlgorithm.INSERTION2);
        arrayToListThenSortAndMeasureTime(SortAlgorithm.QUICK1);
        arrayCopySortAndMeasureTime(SortAlgorithm.QUICK1);
        arrayCopySortAndMeasureTime(SortAlgorithm.QUICK2);
        arrayCopySortAndMeasureTime(SortAlgorithm.QUICK3);
        System.out.println();
    }
}

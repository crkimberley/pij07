import java.util.Arrays;
import java.util.Random;

/**
 * @author crkimberley on 17/09/2016.
 */
public class ArraySortAlgorithms {

    public static void bubbleSort(int[] array) {
        boolean done;
        do {
            // Done variable will stay true if no swaps are done - when sorting is finished
            done = true;
            for (int i=0; i<array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    done = false;
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        } while (!done);
    }

    public static void cocktailSort(int[] array) {
        // Bidirectional version of bubbleSort
        boolean done;
        do {
            // Done variable will stay true if no swaps are done - when sorting is finished
            done = true;
            int i, temp;
            for (i=0; i<array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    done = false;
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            for (; i>1; i--) {
                if (array[i] < array[i-1]) {
                    done = false;
                    temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                }
            }
        } while (!done);
    }

    public static void insertionSort1(int[] array) {
        for (int i=1; i<array.length; i++) {
            for (int j=i; j>0 && array[j-1] > array[j]; j--) {
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
            }
        }
    }

    public static void insertionSort2(int[] array) {
        for (int i=1; i<array.length; i++) {
            int temp = array[i];
            int j;
            for (j=i; j>0 && array[j-1] > temp; j--) {
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
    }

    public static void quickSort1(int[] array, int lowerLimit, int upperLimit) {
        if (lowerLimit >= upperLimit) {
            return;
        }
        int middleIndex = partition(array, lowerLimit, upperLimit);
        quickSort1(array, lowerLimit, middleIndex - 1);
        quickSort1(array, middleIndex + 1, upperLimit);
    }

    private static int partition(int[] array, int lowerLimit, int upperLimit) {
        int middleIndex = lowerLimit;
        for (int i = lowerLimit + 1; i <= upperLimit; i++) {
            // move ith element if less than partition pivot element
            if (array[i] <= array[lowerLimit]) {
                // increment middleIndex - which will index the location of the new small element
                middleIndex++;
                //swap ith element with middleIndex element
                swap(array, i, middleIndex);
            }
        }
        // swap lowerLimit element into correct place
        swap(array, lowerLimit, middleIndex);
        return middleIndex;
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void quickSort1(int[] array) {
        quickSort1(array, 0, array.length - 1);
    }

    public static void quickSort2(int[] array) {
        quickSort2(array, 0, array.length - 1);
    }

    public static void quickSort2(int[] array, int l, int u) {
        if (l >= u) {
            return;
        }
        int t = array[l];
        int i = l;
        int j = u + 1;
        while (true) {
            do {
                i++;
            } while (i <= u && array[i] < t);
            do {
                j--;
            } while (array[j] > t);
            if (i > j) {
                break;
            }
            t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
        t = array[l];
        array[l] = array[j];
        array[j] = t;
        quickSort2(array, l, j-1);
        quickSort2(array, j+1, u);
    }

    public static void quickSort3(int[] array) {
        quickSort3(array, 0, array.length - 1);
        insertionSort2(array);
    }

    public static void quickSort3(int[] array, int l, int u) {
        int CUTOFF = 10;
        Random rand = new Random();
        if ((u - l) < CUTOFF) {
            return;
        }
        int temp = array[l];
        int randomPosition = l + rand.nextInt(u - l);
        array[l] = array[randomPosition];
        array[randomPosition] = temp;
        int t = array[l];
        int i = l;
        int j = u + 1;
        while (true) {
            do {
                i++;
            } while (i <= u && array[i] < t);
            do {
                j--;
            } while (array[j] > t);
            if (i > j) {
                break;
            }
            t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
        t = array[l];
        array[l] = array[j];
        array[j] = t;
        quickSort3(array, l, j-1);
        quickSort3(array, j+1, u);
    }
}

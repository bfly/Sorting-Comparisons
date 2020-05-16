package sortingalgos;

/**
 * QuickSort or partition-exchange sort, is a fast sorting algorithm, which is
 * using divide and conquer algorithm. QuickSort first divides a large list into
 * two smaller sub-lists: the low elements and the high elements. QuickSort can
 * then recursively sort the sub-lists.
 *
 */
public class QuickSort {

    private int[] array;

    private void quickSort(int lowerIndex, int higherIndex) {
        int low = lowerIndex;
        int high = higherIndex;

        int midPoint_As_Pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (low <= high) {
            /*
             * In each iteration, we will identify a number from left side which is greater
             * then the pivot value, and also we will identify a number from right side
             * which is less then the pivot value. Once the search is done, then we exchange
             * both numbers.
             */
            while (array[low] < midPoint_As_Pivot) {
                low++;
            }
            while (array[high] > midPoint_As_Pivot) {
                high--;
            }
            if (low <= high) {
                swapNumbers(low, high);
                // move index to next position on both sides
                low++;
                high--;
            }
        }

        // call quickSort() method recursively
        if (lowerIndex < high) {
            quickSort(lowerIndex, high);
        }

        if (low < higherIndex) {
            quickSort(low, higherIndex);
        }
    }

    public void sortAsc(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        int length = inputArr.length;
        quickSort(0, length - 1);
    }

    private void swapNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}

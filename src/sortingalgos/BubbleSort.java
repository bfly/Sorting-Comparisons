package sortingalgos;

/**
 * Bubble sort works by swapping adjacent elements if they're not in the desired
 * order. This process repeats from the beginning of the array until all
 * elements are in order.
 *
 * We know that all elements are in order when we manage to do the whole
 * iteration without swapping at all - then all elements we compared were in the
 * desired order with their adjacent elements, and by extension, the whole
 * array.
 *
 *
 */
public class BubbleSort {

    public boolean isOutOfOrder( int frontNumber, int backNumber ) {
        return frontNumber > backNumber;
    }

    public void sortAsc(int[] numberArray) {
        int temp = 0;

        for (int i = 0; i < numberArray.length; i++) {
            for (int j = 1; j < (numberArray.length - i); j++) {
                if (isOutOfOrder(numberArray[j - 1], numberArray[j])) {
                    temp = numberArray[j - 1];
                    numberArray[j - 1] = numberArray[j];
                    numberArray[j] = temp;
                }
            }
        }
    }
}


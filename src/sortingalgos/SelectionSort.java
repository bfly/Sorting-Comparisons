package sortingalgos;

/**
 * Selection Sort divides the array into a sorted and unsorted sub-array. The
 * sorted sub-array is formed by inserting the minimum element of the unsorted
 * sub-array at the end of the sorted array
 *
 */
public class SelectionSort {

    private int findMinimumFromUnSortedPart(int[] numberArray, int startIndexOfUnSorted) {
        // Find the minimum element's index in unsorted array
        int minIndex = startIndexOfUnSorted;

        // each find will scan the unsorted array only
        for (int j = startIndexOfUnSorted + 1; j < numberArray.length; j++) {
            if (numberArray[j] < numberArray[minIndex]) {
                minIndex = j;
            }
        }
        return minIndex;
    }

    public void sortAsc( int[] numberArray ) {
        // One by one move boundary of unsorted sub-array
        for (int i = 0; i < numberArray.length - 1; i++) {
            int minIndex = findMinimumFromUnSortedPart(numberArray, i);

            // Swap the found minimum element with the element,
            // so the front part of array is sorted
            int temp = numberArray[minIndex];
            numberArray[minIndex] = numberArray[i];
            numberArray[i] = temp;
        }
    }
}

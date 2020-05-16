package sortingalgos;

/**
 * The idea behind Insertion Sort is dividing the array into the sorted and
 * unsorted sub-arrays.
 *
 * The sorted part is of length 1 at the beginning and is corresponding to the
 * first (left-most) element in the array. We iterate through the array and
 * during each iteration, we expand the sorted portion of the array by one
 * element.
 *
 * Upon expanding, we place the new element into its proper place within the
 * sorted sub-array. We do this by shifting all of the elements to the right
 * until we encounter the first element we don't have to shift.
 *
 *
 */
public class InsertionSort {

    public boolean isOutOfOrder( int sortedValue, int checkValue ) {
        return sortedValue > checkValue;
    }

    public void sortAsc( int[] numberArray ) {
        for (int i = 1; i < numberArray.length; ++i) {
            // the elements from index 0 to sortedIndex are sorted ascending
            int whereShouldIBe = i - 1;

            int checkValue = numberArray[i];
            while (whereShouldIBe >= 0 && isOutOfOrder(numberArray[whereShouldIBe], checkValue)) {
                numberArray[whereShouldIBe + 1] = numberArray[whereShouldIBe];
                whereShouldIBe = whereShouldIBe - 1;
            }

            // reposition the checkValue in the sorted part
            numberArray[whereShouldIBe + 1] = checkValue;
        }
    }
}


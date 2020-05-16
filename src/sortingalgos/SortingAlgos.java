/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgos;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

import static java.time.Duration.between;

/**
 *
 * @author mtsguest
 */
public class SortingAlgos {

    private static final int[] myOriginalUnsortedArray1 = new int[20000];
    private static int[] myCopyUnsortedArray2 = new int[20000];
    private static final int RANGE = 5000;
    private static long bubbleSortDuration, quickSortDuration, selectionSortDuration, insertionSortDuration, mergeSortDuration;
    private static Instant start;
    private static Random random = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        generateRanNums();
        
        copyRanNums();
        quickSort();  //Extra Credit!
        
        copyRanNums();
        mergeSort();  //Extra Credit!
        
        copyRanNums();
        selectionSort();
        
        copyRanNums();
        insertionSort();
        
        copyRanNums();
        bubbleSort();
        
        compareSortTimes();
    }

    private static void compareSortTimes() {
        System.out.printf("%-20s%10s\n", "Sort type", "Duration ms.");
        System.out.printf("%-20s%10d\n", "Quick Sort", quickSortDuration);
        System.out.printf("%-20s%10d\n", "Merge Sort", mergeSortDuration);
        System.out.printf("%-20s%10d\n", "Selection Sort", selectionSortDuration);
        System.out.printf("%-20s%10d\n", "Insertion Sort", insertionSortDuration);
        System.out.printf("%-20s%10d\n", "Bubble Sort", bubbleSortDuration);
    }

    private static void quickSort() {

        QuickSort quickSort = new QuickSort();
        start = Instant.now();
        quickSort.sortAsc(myCopyUnsortedArray2);
        quickSortDuration = between(start, Instant.now()).toMillis();
    }

    private static void mergeSort() {
        MergeSort mergeSort = new MergeSort();
        start = Instant.now();
        mergeSort.sortAsc(myCopyUnsortedArray2);
        mergeSortDuration = between(start, Instant.now()).toMillis();
    }

    private static void selectionSort() {
        SelectionSort selectionSort = new SelectionSort();
        start = Instant.now();
        selectionSort.sortAsc(myCopyUnsortedArray2);
        selectionSortDuration = between(start, Instant.now()).toMillis();
    }

    private static void insertionSort() {
        InsertionSort insertionSort = new InsertionSort();
        start = Instant.now();
        insertionSort.sortAsc(myCopyUnsortedArray2);
        insertionSortDuration = between(start, Instant.now()).toMillis();
    }

    private static void bubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        start = Instant.now();
        bubbleSort.sortAsc(myCopyUnsortedArray2);
        bubbleSortDuration = Duration.between(start, Instant.now()).toMillis();
    }

    private static void generateRanNums() {
        for ( int i = 0; i < myOriginalUnsortedArray1.length; i++ ) {
            myOriginalUnsortedArray1[i] = random.nextInt(RANGE);
        }
    }

    private static void copyRanNums() {
        myCopyUnsortedArray2 = Arrays.copyOf(myOriginalUnsortedArray1, myOriginalUnsortedArray1.length);
    }

}

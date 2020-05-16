package sortingalgos;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Arrays;
import java.util.Random;


@Execution(ExecutionMode.CONCURRENT)
class SortTests {
    private static final int[] myOriginalUnsortedArray1 = new int[20000];
    private static int[] myCopyUnsortedArray2 = new int[20000];
    private static final int RANGE = 5000;
    private static final Random random = new Random();
    private static long startTime = 0L;

    @RegisterExtension
    LogTestExecutionTime logTestExecutionTime = new LogTestExecutionTime();

    @Test
    void testBubbleSort() {
        System.out.print("Bubble sort: ");
        new BubbleSort().sortAsc(myCopyUnsortedArray2);
    }

    @Test
    void testInsertionSort() {
        System.out.print("Insertion sort: ");
        new InsertionSort().sortAsc(myCopyUnsortedArray2);
    }

    @Test
    void testMergeSort() {
        System.out.print("Merge sort: ");
        new MergeSort().sortAsc(myCopyUnsortedArray2);
    }

    @Test
    void testQuickSort() {
        System.out.print("Quick sort: ");
        new QuickSort().sortAsc(myCopyUnsortedArray2);
    }

    @Test
    void testSelectionSort() {
        System.out.print("Selection sort: ");
        new SelectionSort().sortAsc(myCopyUnsortedArray2);
    }

    @BeforeAll
    private static void generateRanNums() {
        Arrays.setAll(myOriginalUnsortedArray1, i -> random.nextInt(RANGE));
        startTime = System.currentTimeMillis();
    }

    @AfterAll
    private static void teardown() {
        System.out.printf("%nTotal Sort Test Execution took %d ms%n", System.currentTimeMillis() - startTime);
    }

    @BeforeEach
    private void copyRanNums() {
        myCopyUnsortedArray2 = Arrays.copyOf(myOriginalUnsortedArray1, myOriginalUnsortedArray1.length);
    }

}
package playground;

import org.example.MatrixMethods;
import org.example.ArrayMethods;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int[] added = new ArrayMethods(array).add(4);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(added));

        int[][] biVector = {
                {1, 2, 3},
                {1, 2, 4},
        };
        MatrixMethods matrixMethods = new MatrixMethods(biVector);

        matrixMethods.addToRow(0, 4);
        System.out.println(Arrays.deepToString(biVector));
        System.out.println(Arrays.deepToString(matrixMethods.getBiDimensionalVector()));
        System.out.println(Arrays.deepToString(matrixMethods.addToRow(0, 4)));
    }

    // sorting algorithms
    private void runSortAscLoop(int[] sortedArray) {
        int temp;
        for (int i = sortedArray.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) { //TODO: mutation to kill
                    temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
    }

    private void runSortDescLoop(int[] sortedArray) {
        int temp;
        for (int i = sortedArray.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (sortedArray[j] < sortedArray[j + 1]) { //TODO: mutation to kill
                    temp = sortedArray[j + 1];
                    sortedArray[j + 1] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }
    }
}

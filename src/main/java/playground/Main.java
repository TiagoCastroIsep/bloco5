package playground;

import org.example.BiDimensionalVector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(-4 % 2);
        int[][] biVector = {
                {1, 2, 3},
                {1, 2},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(biVector);
        System.out.println(Arrays.deepToString(biDimensionalVector.addToRow(1, 4)));
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

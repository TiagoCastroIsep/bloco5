package org.example;

import java.util.*;

public class BiDimensionalVector {
    private final int[][] biDimensionalVector;

    public BiDimensionalVector() {
        biDimensionalVector = new int[0][0];
    }

    public BiDimensionalVector(int[][] biDimensionalVector) {
        this.biDimensionalVector = biDimensionalVector;
    }

    public int[][] getBiDimensionalVector() {
        return biDimensionalVector;
    }

    public int[][] addToRow(int rowNumber, int number) throws ArrayIndexOutOfBoundsException {
        Vector vector = new Vector(biDimensionalVector[rowNumber]);
        biDimensionalVector[rowNumber] = vector.add(number);
        return biDimensionalVector;
    }

    public int[][] removeAtRow(int rowNumber, int index) throws ArrayIndexOutOfBoundsException {
        Vector vector = new Vector((biDimensionalVector[rowNumber]));
        biDimensionalVector[rowNumber] = vector.removeAt(index);
        return biDimensionalVector;
    }

    public boolean isEmpty() {
        return biDimensionalVector.length == 0;
    }

    public int getMax() {
        if (biDimensionalVector.length == 0) throw new NullPointerException();
        int max = biDimensionalVector[0][0];
        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            max = Math.max(vector.getMax(), max);
        }
        return max;
    }

    public int getMin() {
        // TODO: custom exception
        if (biDimensionalVector.length == 0) throw new NullPointerException();
        int min = biDimensionalVector[0][0];
        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            min = Math.min(vector.getMin(), min);
        }
        return min;
    }

    public double getAverage() {
        if (biDimensionalVector.length == 0) throw new NullPointerException();
        List<Double> rowAverage = new ArrayList<>();
        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            rowAverage.add(vector.getAverage(row));
        }
        return rowAverage.stream().reduce(0.0, (el, acc) -> el + acc) / rowAverage.size();
    }

    public int[] getEachRowSum() {
        if (biDimensionalVector.length == 0) throw new NullPointerException();
        List<Integer> rowSum = new ArrayList<>();
        for (int[] row : biDimensionalVector) {
            rowSum.add(Arrays.stream(row).sum());
        }
        return rowSum.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] getEachColumnSum() {
        if (biDimensionalVector.length == 0) throw new NullPointerException();
        if (!columnSumIsPossible()) throw new IllegalArgumentException();

        List<Integer> columnSum = new ArrayList<>();
        for (int column = 0; column < biDimensionalVector[0].length; column++) {
            int sum = 0;
            for (int[] row : biDimensionalVector) {
                sum += row[column];
            }
            columnSum.add(sum);
        }
        return columnSum.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean columnSumIsPossible() {
        Set<Integer> rowLength = new HashSet<>();
        for (int[] row : biDimensionalVector) {
            rowLength.add(row.length);
        }
        return rowLength.size() == 1;
    }

    public int getRowIndexFromMaxSum() {
        int[] rowSum = getEachRowSum();
        Vector vector = new Vector(rowSum);

        return vector.indexOf(vector.getMax());
    }

    //TODO: l)

}

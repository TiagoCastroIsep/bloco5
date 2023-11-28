package org.example;

import java.util.*;

public class BiDimensionalVector {
    private final int[][] biDimensionalVector;

    public BiDimensionalVector() {
        biDimensionalVector = new int[0][0];
    }

    public BiDimensionalVector(int[][] biDimensionalVector) throws EmptyArrayException {
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

    public int[][] removeAtRow(int rowNumber, int index) {
        if (biDimensionalVector.length == 0) throw new EmptyArrayException();
        Vector vector = new Vector((biDimensionalVector[rowNumber]));
        biDimensionalVector[rowNumber] = vector.removeAt(index);
        return biDimensionalVector;
    }

    public boolean isEmpty() {
        return biDimensionalVector.length == 0;
    }

    public int getMax() {
        if (biDimensionalVector.length == 0) throw new EmptyArrayException();
        int max = biDimensionalVector[0][0];
        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            max = Math.max(vector.getMax(), max);
        }
        return max;
    }

    public int getMin() {
        if (biDimensionalVector.length == 0) throw new EmptyArrayException();
        int min = biDimensionalVector[0][0];
        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            min = Math.min(vector.getMin(), min);
        }
        return min;
    }

    public double getAverage() {
        if (biDimensionalVector.length == 0) throw new EmptyArrayException();
        List<Double> rowAverage = new ArrayList<>();
        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            rowAverage.add(vector.getAverage(row));
        }
        return rowAverage.stream().reduce(0.0, (el, acc) -> el + acc) / rowAverage.size();
    }

    public int[] getEachRowSum() {
        if (biDimensionalVector.length == 0) throw new EmptyArrayException();
        List<Integer> rowSum = new ArrayList<>();
        for (int[] row : biDimensionalVector) {
            rowSum.add(Arrays.stream(row).sum());
        }
        return rowSum.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] getEachColumnSum() {
        if (biDimensionalVector.length == 0) throw new EmptyArrayException();
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

    public boolean checkIfMatrixIsSquare() {
        if (biDimensionalVector.length == 0) return false;
        if (!checkIfMatrixIsRegular()) return false;

        for (int[] row : biDimensionalVector) {
            if (row.length != biDimensionalVector.length) return false;
        }

        return true;
    }

    public boolean checkIfMatrixIsRegular() {
        if (biDimensionalVector.length == 0) return false;

        int firstRowLength = biDimensionalVector[0].length;
        for (int i = 1; i < biDimensionalVector.length; i++) {
            if (biDimensionalVector[i].length != firstRowLength) return false;
        }

        return true;
    }

    public boolean isSymmetrical() {
        if (!checkIfMatrixIsSquare()) return false;

        for (int row = 0, column = 1; row < biDimensionalVector.length; row++, column++) {
            if (biDimensionalVector[row][column] != biDimensionalVector[row + 1][column - 1]) {
                return false;
            }
            row++;
            column++;
        }
        return true;
    }

    public int countNotZeroPrincipalDiagonal() {
        if (biDimensionalVector.length == 0) return -1;
        if (!checkIfMatrixIsSquare()) return -1;
        int count = 0;
        for (int i = 0; i < biDimensionalVector.length; i++) {
            if (biDimensionalVector[i][i] != 0) count++;
        }
        return count;
    }

    public boolean isPrincipalDiagonalEqualsSecondaryDiagonal() {
        if (biDimensionalVector.length == 0) return false;
        if (!checkIfMatrixIsSquare()) return false;
        List<Integer> principalDiagonal = getPrincipalDiagonalElements();
        List<Integer> secondDiagonal = getSecondDiagonalElements();

        return principalDiagonal.equals(secondDiagonal);
    }

    private List<Integer> getPrincipalDiagonalElements() {
        List<Integer> principalDiagonal = new ArrayList<>();
        for (int i = 0; i < biDimensionalVector.length; i++) {
            principalDiagonal.add(biDimensionalVector[i][i]);
        }
        return principalDiagonal;
    }

    private List<Integer> getSecondDiagonalElements() {
        List<Integer> secondDiagonal = new ArrayList<>();
        for (int i = biDimensionalVector.length - 1, j = 0; i >= 0; i--, j++) {
            secondDiagonal.add(biDimensionalVector[j][i]);
        }
        return secondDiagonal;
    }
    //TODO: p)
    //TODO: q)

    public int[][] invertValuesEachRow() {
        if (biDimensionalVector.length == 0) throw new EmptyArrayException();
        if (!checkIfMatrixIsRegular()) throw new IllegalArgumentException();

        int[][] reversedMatrix = new int[biDimensionalVector.length][biDimensionalVector[0].length];
        int index = 0;
        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            reversedMatrix[index] = vector.reversedOrder();
            index++;
        }

        return reversedMatrix;
    }

    //TODO: s)
    //TODO: t)
    //TODO: u)
    //TODO: v)
}

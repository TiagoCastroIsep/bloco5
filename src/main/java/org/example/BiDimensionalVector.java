package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class BiDimensionalVector {
    private final int[][] biDimensionalVector;

    public BiDimensionalVector() {
        biDimensionalVector = new int[0][0];
    }

    public BiDimensionalVector(int[][] biDimensionalVector) {
        if (biDimensionalVector == null) throw new EmptyArrayException();
        if (biDimensionalVector.length == 0) throw new EmptyArrayException();
        this.biDimensionalVector = getDeepCopy(biDimensionalVector);
    }

    private int[][] getDeepCopy(int[][] biDimensionalVector) {
        if (biDimensionalVector.length == 0) throw new EmptyArrayException();
        int[][] matrixCopy = new int[biDimensionalVector.length][biDimensionalVector[0].length];
        int index = 0;
        for (int[] row : biDimensionalVector) {
            matrixCopy[index] = row;
            index++;
        }

        return matrixCopy;
    }

    public int[][] getBiDimensionalVector() {
        return getDeepCopy(biDimensionalVector);
    }

    public int[][] addToRow(int rowNumber, int number) throws ArrayIndexOutOfBoundsException {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        Vector vector = new Vector(biDimensionalVector[rowNumber]);
        int[][] biDimenVectorCopy = new int[biDimensionalVector.length][biDimensionalVector[0].length];
        int index = 0;
        for (int[] row : biDimensionalVector) {
            biDimenVectorCopy[index] = row;
            index++;
        }
        biDimenVectorCopy[rowNumber] = vector.add(number);
        return biDimenVectorCopy;
    }

    public int[][] removeAtRow(int rowNumber, int index) {
        Vector vector = new Vector((biDimensionalVector[rowNumber]));
        int[][] biDimenCopy = getDeepCopy(biDimensionalVector);
        biDimenCopy[rowNumber] = vector.removeAt(index);
        return biDimenCopy;
    }

    public boolean isEmpty(int[][] array) {
        return array.length == 0;
    }

    public int getMax() {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        int max = biDimensionalVector[0][0];
        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            max = Math.max(vector.getMax(), max);
        }
        return max;
    }

    public int getMin() {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        int min = biDimensionalVector[0][0];
        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            min = Math.min(vector.getMin(), min);
        }
        return min;
    }

    public double getAverage() {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        List<Double> rowAverage = new ArrayList<>();
        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            rowAverage.add(vector.getAverage(row));
        }
        return rowAverage.stream().reduce(0.0, (el, acc) -> el + acc) / rowAverage.size();
    }

    public int[] getEachRowSum() {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        List<Integer> rowSum = new ArrayList<>();
        for (int[] row : biDimensionalVector) {
            rowSum.add(Arrays.stream(row).sum());
        }
        return rowSum.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] getEachColumnSum() {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        if (!isRegular()) throw new IllegalArgumentException();

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

    public int getRowIndexFromMaxSum() {
        int[] rowSum = getEachRowSum();
        Vector vector = new Vector(rowSum);

        return vector.indexOf(vector.getMax());
    }

    public boolean isSquare() {
        if (biDimensionalVector.length == 0) return false;
        if (!isRegular()) return false;

        for (int[] row : biDimensionalVector) {
            if (row.length != biDimensionalVector.length) return false;
        }

        return true;
    }

    public boolean isRegular() {
        if (biDimensionalVector.length == 0) return false;

        int firstRowLength = biDimensionalVector[0].length;
        for (int i = 1; i < biDimensionalVector.length; i++) {
            if (biDimensionalVector[i].length != firstRowLength) return false;
        }

        return true;
    }

    public boolean isSymmetrical() {
        if (!isSquare()) return false;

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
        if (!isSquare()) return -1;
        int count = 0;
        for (int i = 0; i < biDimensionalVector.length; i++) {
            if (biDimensionalVector[i][i] != 0) count++;
        }
        return count;
    }

    public boolean isPrincipalDiagonalEqualsSecondaryDiagonal() {
        if (biDimensionalVector.length == 0) return false;
        if (!isSquare()) return false;
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

    /** START: p) **/
    private int getTotalDigits(boolean gettingJustEven) {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();

        int count = 0;
        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            if (!gettingJustEven) count += vector.getDigitsCountFromVector();
            else count += vector.getEvenDigitsInVector(row).length;
        }
        return count;
    }

    private int getElementsTotal() {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        return biDimensionalVector.length * biDimensionalVector[0].length;
    }

    private double getDigitsAverage(boolean gettingJustEven) {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        return (double) getTotalDigits(gettingJustEven) / getElementsTotal();
    }

    public int[] getNumbersWithGreaterDigitsThanAverage(boolean gettingJustEven) {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();

        List<Integer> greaterDigits = new ArrayList<>();
        double average = getDigitsAverage(gettingJustEven);

        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            for (int number : row) {
                if (!gettingJustEven) {
                    if (vector.getDigits(number).length > average) greaterDigits.add(number);
                } else {
                    int[] digits = vector.getDigits(number);
                    int count = 0;
                    for (int digit : digits) {
                        if (digit % 2 == 0) count++;
                        if (count > average) greaterDigits.add(number);
                    }
                }
            }
        }
        return greaterDigits.stream().mapToInt(Integer::intValue).toArray();
    }
    /** END: p) & q) **/

    public int[][] invertValuesEachRow() {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        if (!isRegular()) throw new IllegalArgumentException();

        int[][] reversedMatrix = new int[biDimensionalVector.length][biDimensionalVector[0].length];
        int index = 0;
        for (int[] row : biDimensionalVector) {
            Vector vector = new Vector(row);
            reversedMatrix[index] = vector.reversedOrder();
            index++;
        }

        return reversedMatrix;
    }

    // done by mistake, not requested but keeping the code
    public int[][] invertMatrixByColumn() {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        if (!isRegular()) throw new IllegalArgumentException();

        int[][] reversedMatrix = new int[biDimensionalVector[0].length][biDimensionalVector.length];

        for (int index = 0; index < biDimensionalVector[0].length; index++) {
            int[] tempRow = new int[biDimensionalVector.length];
            for (int row = 0; row < biDimensionalVector.length; row++) {
                tempRow[row] = biDimensionalVector[row][index];
            }
            reversedMatrix[index] = tempRow;
        }

        return reversedMatrix;
    }

    public int[][] invertColumn() {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        if (!isRegular()) throw new IllegalArgumentException();

        int[][] reversedMatrix = new int[biDimensionalVector.length][biDimensionalVector[0].length];

        for (int index = 0; index < biDimensionalVector[0].length; index++) {
            for (int row = 0; row < biDimensionalVector.length; row++) {
                reversedMatrix[row][index] = biDimensionalVector[biDimensionalVector.length - 1 - row][index];
            }
        }

        return reversedMatrix;
    }

    public int[][] rotate90() {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        if (!isRegular()) throw new IllegalArgumentException();

        // TODO: limit to square
        int[][] rotated = new int[biDimensionalVector.length][biDimensionalVector.length];

        for (int i = 0; i < biDimensionalVector.length; i++) {
            for (int row = 0; row < biDimensionalVector.length; row++) {
                rotated[row][i] = biDimensionalVector[i][biDimensionalVector.length - 1 - row];
            }
        }
        return rotated;
    }

    public int[][] rotate180(int[][] array) {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();
        // TODO: limit to square
        int[][] rotated = new int[array.length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                rotated[i][j] = array[biDimensionalVector.length - 1 - i][array.length - 1 - j];
            }
        }

        return rotated;
    }

    public int[][] rotateMinus90() {
        if (isEmpty(biDimensionalVector)) throw new EmptyArrayException();

        int[][] rotate90 = rotate90();
        return rotate180(rotate90);
    }
}

package org.example;

import org.example.utils.EmptyArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixMethodsTest {
    @Test
    public void shouldCreateBiDimensionalEmptyArray() {
        MatrixMethods matrixMethods = new MatrixMethods();
    }

    @Test
    public void shouldCreateBiDimensionalArray() {
        int[][] array = {{1, 2}, {1, 2}};
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertArrayEquals(array, matrixMethods.getBiDimensionalVector());
    }

    @Test
    public void shouldAddElementToSelectedRowLastPosition() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = 0;
        int number = 3;
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int[][] expected = {{1, 2, 3}, {1, 2}};
        assertArrayEquals(expected, matrixMethods.addToRow(rowNumber, number));
    }

    @Test
    public void shouldThrowExceptionForRowNumberLessThanZero_addToRow() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = -1;
        int number = 3;
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrixMethods.addToRow(rowNumber, number));
    }

    @Test
    public void shouldThrowExceptionForRowNumberMoreThanRowLength_addToRow() throws EmptyArrayException {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = 2;
        int number = 3;
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrixMethods.addToRow(rowNumber, number));
    }

    @Test
    public void shouldRemoveElementToSelectedRowAtSelectedIndex() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = 0;
        int index = 0;
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int[][] expected = {{2}, {1, 2}};
        assertArrayEquals(expected, matrixMethods.removeAtRow(rowNumber, index));
    }

    @Test
    public void shouldThrowExceptionForRowNumberLessThanZero_removeAtRow() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = -1;
        int index = 0;
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrixMethods.removeAtRow(rowNumber, index));
    }

    @Test
    public void shouldThrowExceptionForRowNumberMoreThanRowLength_removeAtRow() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = 2;
        int index = 0;
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrixMethods.removeAtRow(rowNumber, index));
    }

    @Test
    public void shouldThrowExceptionForColumnNumberMoreThanColumnLength_removeAtRow() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = 0;
        int index = 2;
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrixMethods.removeAtRow(rowNumber, index));
    }

    @Test
    public void shouldThrowExceptionForColumnNumberLessThanColumnLength_removeAtRow() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = 0;
        int index = -1;
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrixMethods.removeAtRow(rowNumber, index));
    }

    @Test
    public void shouldReturnFalseForNotEmptyMatrix() {
        int[][] array = {{1, 2}, {1, 2}};
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertFalse(matrixMethods.isEmpty(array));
    }

    @Test
    public void shouldReturnTrueForEmptyMatrix() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertTrue(matrixMethods.isEmpty(new int[0][]));
    }

    @Test
    public void shouldReturnMaxAllElementsDifferent() {
        int[][] array = {
                {1, 2},
                {3, 4}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int expected = 4;
        assertEquals(expected, matrixMethods.getMax());
    }

    @Test
    public void shouldReturnMaxAllElementsDifferentInvertedRows() {
        int[][] array = {
                {1, 2},
                {2, 1}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int expected = 2;
        assertEquals(expected, matrixMethods.getMax());
    }

    @Test
    public void shouldReturnMaxSomeElementsRepeated() {
        int[][] array = {
                {1, 1},
                {0, 4}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int expected = 4;
        assertEquals(expected, matrixMethods.getMax());
    }

    @Test
    public void shouldReturnMaxFirstElementIsMax() {
        int[][] array = {
                {4, 1},
                {2, 3}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int expected = 4;
        assertEquals(expected, matrixMethods.getMax());
    }

    @Test
    public void shouldReturnMaxAllElementsRepeated() {
        int[][] array = {
                {0, 0},
                {0, 0}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int expected = 0;
        assertEquals(expected, matrixMethods.getMax());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertThrows(EmptyArrayException.class, matrixMethods::getMax);
    }

    @Test
    public void shouldReturnMinAllElementsDifferent() {
        int[][] array = {
                {4, 2},
                {3, 1}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int expected = 1;
        assertEquals(expected, matrixMethods.getMin());
    }

    @Test
    public void shouldReturnMaxFirstElementIsMin() {
        int[][] array = {
                {1, 4},
                {2, 3}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int expected = 1;
        assertEquals(expected, matrixMethods.getMin());
    }

    @Test
    public void shouldReturnMinAllElementsRepeated() {
        int[][] array = {
                {0, 0},
                {0, 0}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int expected = 0;
        assertEquals(expected, matrixMethods.getMin());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getMin() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertThrows(EmptyArrayException.class, matrixMethods::getMin);
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getAverage() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertThrows(EmptyArrayException.class, matrixMethods::getAverage);
    }

    @Test
    public void shouldGetAverageOfBiDimensionalArray() {
        int[][] array = {
                {1, 2},
                {3, 4}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        double expected = 2.5;
        assertEquals(expected, matrixMethods.getAverage());
    }

    @Test
    public void shouldGetAverageOfBiDimensionalArrayAllZeros() {
        int[][] array = {
                {0, 0},
                {0, 0}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        double expected = 0.0;
        assertEquals(expected, matrixMethods.getAverage());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getEachRowSum() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertThrows(EmptyArrayException.class, matrixMethods::getEachRowSum);
    }

    @Test
    public void shouldGetEachRowSumOfBiDimensionalArray() throws EmptyArrayException {
        int[][] array = {
                {1, 2},
                {3, 4}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int[] expected = {3, 7};
        assertArrayEquals(expected, matrixMethods.getEachRowSum());
    }

    @Test
    public void shouldGetEachRowSumOfBiDimensionalArrayAllElementsZero() {
        int[][] array = {
                {0, 0},
                {0, 0}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int[] expected = {0, 0};
        assertArrayEquals(expected, matrixMethods.getEachRowSum());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getEachColumnSum() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertThrows(EmptyArrayException.class, matrixMethods::getEachColumnSum);
    }

    @Test
    public void shouldThrowExceptionForDifferentColumnsCountMatrix_getEachColumnSum() {
        int[][] array = {
                {0, 0},
                {0, 0, 0}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertThrows(IllegalArgumentException.class, matrixMethods::getEachColumnSum);
    }

    @Test
    public void shouldReturnArrayWithColumnSums_getEachColumnSum() throws EmptyArrayException {
        int[][] array = {
                {1, 2, 1},
                {2, 1, 1}
        };
        int[] expected = {3, 3, 2};
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertArrayEquals(expected, matrixMethods.getEachColumnSum());
    }

    @Test
    public void shouldReturnArrayWithColumnSumsVerticalArray_getEachColumnSum() {
        int[][] array = {
                {1, 2},
                {1, 1},
                {1, 1}
        };
        int[] expected = {3, 4};
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertArrayEquals(expected, matrixMethods.getEachColumnSum());
    }

    @Test
    public void shouldReturnArrayWithColumnSumsAllElementsZero_getEachColumnSum() {
        int[][] array = {
                {0, 0},
                {0, 0}
        };
        int[] expected = {0, 0};
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertArrayEquals(expected, matrixMethods.getEachColumnSum());
    }

    @Test
    public void shouldThrowExceptionForEmptyMatrix_getIndexFromMaxSum() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertThrows(EmptyArrayException.class, matrixMethods::getRowIndexFromMaxSum);
    }

    @Test
    public void shouldReturnIndexFromMaxSum_getIndexFromMaxSum() {
        int[][] array = {
                {1, 3},
                {2, 4}
        };
        int expected = 1;
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertEquals(expected, matrixMethods.getRowIndexFromMaxSum());
    }

    @Test
    public void shouldReturnIndexFromMaxSumAllZeros_getIndexFromMaxSum() {
        int[][] array = {
                {0, 0},
                {0, 0}
        };
        int expected = 0;
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertEquals(expected, matrixMethods.getRowIndexFromMaxSum());
    }

    @Test
    public void shouldReturnTrueForSquareMatrix() {
        int[][] matrix = {
                {1, 2},
                {1, 2}
        };
        MatrixMethods matrixMethods = new MatrixMethods(matrix);
        assertTrue(matrixMethods.isSquare());
    }

    @Test
    public void shouldReturnFalseForEmptyMatrix() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertFalse(matrixMethods.isSquare());
    }

    @Test
    public void shouldReturnFalseForMatrixWhichIsRectangular() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 4}
        };
        MatrixMethods matrixMethods = new MatrixMethods(matrix);
        assertFalse(matrixMethods.isSquare());
    }

    @Test
    public void shouldReturnFalseForMatrixWhichIsNotRegular() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2}
        };
        MatrixMethods matrixMethods = new MatrixMethods(matrix);
        assertFalse(matrixMethods.isSquare());
    }

    @Test
    public void shouldReturnFalseForEmptyMatrix_checkRegular() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertFalse(matrixMethods.isSquare());
    }

    @Test
    public void shouldReturnFalseForMatrixWithDifferentNumberOfColumns() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2},
                {1, 2, 3, 4}
        };
        MatrixMethods matrixMethods = new MatrixMethods(matrix);
        assertFalse(matrixMethods.isRegular());
    }

    @Test
    public void shouldReturnTrueForRegularMatrix() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
        MatrixMethods matrixMethods = new MatrixMethods(matrix);
        assertTrue(matrixMethods.isRegular());
    }

    @Test
    public void shouldReturnFalseForEmptyMatrix_regularMatrix() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertFalse(matrixMethods.isRegular());
    }

    @Test
    public void shouldReturnFalseForNotSymmetrical2x2Matrix() {
        int[][] matrix = {
                {1, 2},
                {3, 3}
        };
        MatrixMethods matrixMethods = new MatrixMethods(matrix);
        assertFalse(matrixMethods.isSymmetrical());
    }

    @Test
    public void shouldReturnFalseForNotSquareMatrix() {
        int[][] matrix = {
                {1, 2},
                {3}
        };
        MatrixMethods matrixMethods = new MatrixMethods(matrix);
        assertFalse(matrixMethods.isSymmetrical());
    }

    @Test
    public void shouldReturnFalseForNotSymmetricalMatrix() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {3, 3, 3, 3},
                {2, 2, 2, 2},
                {1, 1, 1, 1},
        };
        MatrixMethods matrixMethods = new MatrixMethods(matrix);
        assertFalse(matrixMethods.isSymmetrical());
    }

    @Test
    public void shouldReturnTrueForSymmetrical2x2Matrix() {
        int[][] matrix = {
                {1, 2},
                {2, 3}
        };
        MatrixMethods matrixMethods = new MatrixMethods(matrix);
        assertTrue(matrixMethods.isSymmetrical());
    }

    @Test
    public void shouldReturnTrueForSymmetricalMatrix() {
        int[][] matrix = {
                {1, 3, 2, 4},
                {3, 3, 3, 3},
                {2, 2, 2, 2},
                {4, 3, 2, 1},
        };
        MatrixMethods matrixMethods = new MatrixMethods(matrix);
        assertTrue(matrixMethods.isSymmetrical());
    }

    @Test
    public void shouldReturnMinusOneForEmptyArray() {
        MatrixMethods matrixMethods = new MatrixMethods();
        int expected = -1;
        assertEquals(expected, matrixMethods.countNotZeroPrincipalDiagonal());
    }

    @Test
    public void shouldReturnMinusOneForNotSquareArray() {
        int[][] array = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int expected = -1;
        assertEquals(expected, matrixMethods.countNotZeroPrincipalDiagonal());
    }

    @Test
    public void shouldReturnOneForOneElementDifferentThanZeroInPrincipalDiagonal() {
        int[][] array = {
                {1, 2},
                {3, 0},
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int expected = 1;
        assertEquals(expected, matrixMethods.countNotZeroPrincipalDiagonal());
    }

    @Test
    public void shouldReturnTwoForElementsDifferentThanZeroInPrincipalDiagonal() {
        int[][] array = {
                {1, 2},
                {3, 1},
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int expected = 2;
        assertEquals(expected, matrixMethods.countNotZeroPrincipalDiagonal());
    }

    @Test
    public void shouldReturnFalseForEmptyArray() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertFalse(matrixMethods.isPrincipalDiagonalEqualsSecondaryDiagonal());
    }

    @Test
    public void shouldReturnFalseForNotSquareMatrix_principalSecondaryDiagonal() {
        int[][] array = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertFalse(matrixMethods.isPrincipalDiagonalEqualsSecondaryDiagonal());
    }

    @Test
    public void shouldReturnFalseForMatrixPrincipalAndSecondaryDiagonalDifferent_principalSecondaryDiagonal() {
        int[][] array = {
                {1, 1},
                {1, 2},
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertFalse(matrixMethods.isPrincipalDiagonalEqualsSecondaryDiagonal());
    }

    @Test
    public void shouldReturnTrueForMatrixPrincipalAndSecondaryDiagonalEqual_principalSecondaryDiagonal() {
        int[][] array = {
                {1, 1},
                {2, 2},
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertTrue(matrixMethods.isPrincipalDiagonalEqualsSecondaryDiagonal());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getNumbersWithGreaterDigitsThanAverage() {
        MatrixMethods matrixMethods = new MatrixMethods();
        boolean gettingJustEven = false;
        assertThrows(EmptyArrayException.class, () -> matrixMethods.getNumbersWithGreaterDigitsThanAverage(gettingJustEven));
    }

    @Test
    public void shouldReturnDigitsGreaterThanAverage() {
        int[][] array = {
                {1, 2},
                {1, 10}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        boolean gettingJustEven = false;
        int[] expected = {10};
        assertArrayEquals(expected, matrixMethods.getNumbersWithGreaterDigitsThanAverage(gettingJustEven));
    }

    @Test
    public void shouldReturnEmptyArrayForNoneGreaterThanAverage() {
        int[][] array = {
                {1, 2},
                {1, 1}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        boolean gettingJustEven = false;
        int[] expected = {};
        assertArrayEquals(expected, matrixMethods.getNumbersWithGreaterDigitsThanAverage(gettingJustEven));
    }

    @Test
    public void shouldReturnEvenDigitsGreaterThanAverage() {
        int[][] array = {
                {2, 2},
                {2, 120}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        boolean gettingJustEven = true;
        int[] expected = {120};
        assertArrayEquals(expected, matrixMethods.getNumbersWithGreaterDigitsThanAverage(gettingJustEven));
    }

    @Test
    public void shouldReturnEmptyArrayForNoneEvenGreaterThanAverage() {
        int[][] array = {
                {1, 1},
                {1, 1}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        boolean gettingJustEven = true;
        int[] expected = {};
        assertArrayEquals(expected, matrixMethods.getNumbersWithGreaterDigitsThanAverage(gettingJustEven));
    }

    @Test
    public void shouldThrowExceptionForEmptyArrayOnInvertedValuesForEachMatrixRow() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertThrows(EmptyArrayException.class, matrixMethods::invertValuesEachRow);
    }

    @Test
    public void shouldThrowExceptionForNotRegularArrayOnInvertedValuesForEachMatrixRow() {
        int[][] array = {
                {1, 1},
                {2, 2, 2},
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertThrows(IllegalArgumentException.class, matrixMethods::invertValuesEachRow);
    }

    @Test
    public void shouldReturnInvertedValuesForEachMatrixRow() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int[][] expected = {
                {3, 2, 1},
                {6, 5, 4}
        };
        assertArrayEquals(expected, matrixMethods.invertValuesEachRow());
    }

    @Test
    public void shouldReturnInvertedValuesForEachMatrixRowOnlyOneElement() {
        int[][] array = {
                {0},
                {0}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int[][] expected = {
                {0},
                {0}
        };
        assertArrayEquals(expected, matrixMethods.invertValuesEachRow());
    }

    @Test
    public void shouldReturnInvertedValuesForEachMatrixColumn() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int[][] expected = {
                {1, 4},
                {2, 5},
                {3, 6}
        };
        assertArrayEquals(expected, matrixMethods.invertMatrixByColumn());
    }

    @Test
    public void shouldReturnInvertedValuesForEachMatrixColumnSquareMatrix() {
        int[][] array = {
                {1, 2},
                {3, 4},
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int[][] expected = {
                {1, 3},
                {2, 4},
        };
        assertArrayEquals(expected, matrixMethods.invertMatrixByColumn());
    }

    @Test
    public void shouldThrowExceptionForEmptyArrayOnInvertedValuesForEachMatrixColumn() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertThrows(EmptyArrayException.class, matrixMethods::invertColumn);
    }

    @Test
    public void shouldThrowExceptionForNotRegularArrayOnInvertedValuesForEachMatrixColumn() {
        int[][] array = {
                {1, 1},
                {2, 2, 2},
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertThrows(IllegalArgumentException.class, matrixMethods::invertColumn);
    }

    @Test
    public void shouldReturnInvertedValuesForEachColumn() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int[][] expected = {
                {4, 5, 6},
                {1, 2, 3}
        };
        assertArrayEquals(expected, matrixMethods.invertColumn());
    }

    @Test
    public void shouldThrowExceptionForEmptyArrayOnRotated90() {
        MatrixMethods matrixMethods = new MatrixMethods();
        assertThrows(EmptyArrayException.class, matrixMethods::rotate90);
    }

    @Test
    public void shouldThrowExceptionForNotRegularArrayOnRotated90() {
        int[][] array = {
                {1, 1},
                {2, 2, 2},
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        assertThrows(IllegalArgumentException.class, matrixMethods::rotate90);
    }

    @Test
    public void shouldReturnRotated90() {
        int[][] array = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {8, 9, 0, 1},
                {2, 3, 4, 5},
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int[][] expected = {
                {4, 7, 1, 5},
                {3, 6, 0, 4},
                {2, 5, 9, 3},
                {1, 4, 8, 2},
        };
        assertArrayEquals(expected, matrixMethods.rotate90());
    }

    @Test
    public void shouldReturnRotated180() {
        int[][] array = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {8, 9, 0, 1},
                {2, 3, 4, 5},
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int[][] expected = {
                {5, 4, 3, 2},
                {1, 0, 9, 8},
                {7, 6, 5, 4},
                {4, 3, 2, 1},
        };
        assertArrayEquals(expected, matrixMethods.rotate180(array));
    }

    @Test
    public void shouldReturnRotatedMinus90() {
        int[][] array = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {8, 9, 0, 1},
                {2, 3, 4, 5},
        };
        MatrixMethods matrixMethods = new MatrixMethods(array);
        int[][] expected = {
                {2, 8, 4, 1},
                {3, 9, 5, 2},
                {4, 0, 6, 3},
                {5, 1, 7, 4},
        };
        assertArrayEquals(expected, matrixMethods.rotateMinus90());
    }
}
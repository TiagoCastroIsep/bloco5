package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiDimensionalVectorTest {
    @Test
    public void shouldCreateBiDimensionalEmptyArray() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
    }

    @Test
    public void shouldCreateBiDimensionalArray() {
        int[][] array = {{1, 2}, {1, 2}};
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertArrayEquals(array, biDimensionalVector.getBiDimensionalVector());
    }

    @Test
    public void shouldAddElementToSelectedRowLastPosition() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = 0;
        int number = 3;
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int[][] expected = {{1, 2, 3}, {1, 2}};
        assertArrayEquals(expected, biDimensionalVector.addToRow(rowNumber, number));
    }

    @Test
    public void shouldThrowExceptionForRowNumberLessThanZero_addToRow() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = -1;
        int number = 3;
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> biDimensionalVector.addToRow(rowNumber, number));
    }

    @Test
    public void shouldThrowExceptionForRowNumberMoreThanRowLength_addToRow() throws EmptyArrayException {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = 2;
        int number = 3;
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> biDimensionalVector.addToRow(rowNumber, number));
    }

    @Test
    public void shouldRemoveElementToSelectedRowAtSelectedIndex() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = 0;
        int index = 0;
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int[][] expected = {{2}, {1, 2}};
        assertArrayEquals(expected, biDimensionalVector.removeAtRow(rowNumber, index));
    }

    @Test
    public void shouldThrowExceptionForRowNumberLessThanZero_removeAtRow() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = -1;
        int index = 0;
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> biDimensionalVector.removeAtRow(rowNumber, index));
    }

    @Test
    public void shouldThrowExceptionForRowNumberMoreThanRowLength_removeAtRow() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = 2;
        int index = 0;
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> biDimensionalVector.removeAtRow(rowNumber, index));
    }

    @Test
    public void shouldThrowExceptionForColumnNumberMoreThanColumnLength_removeAtRow() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = 0;
        int index = 2;
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> biDimensionalVector.removeAtRow(rowNumber, index));
    }

    @Test
    public void shouldThrowExceptionForColumnNumberLessThanColumnLength_removeAtRow() {
        int[][] array = {{1, 2}, {1, 2}};
        int rowNumber = 0;
        int index = -1;
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> biDimensionalVector.removeAtRow(rowNumber, index));
    }

    @Test
    public void shouldReturnFalseForNotEmptyMatrix() {
        int[][] array = {{1, 2}, {1, 2}};
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertFalse(biDimensionalVector.isEmpty(array));
    }

    @Test
    public void shouldReturnTrueForEmptyMatrix() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertTrue(biDimensionalVector.isEmpty(new int[0][]));
    }

    @Test
    public void shouldReturnMaxAllElementsDifferent() {
        int[][] array = {
                {1, 2},
                {3, 4}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int expected = 4;
        assertEquals(expected, biDimensionalVector.getMax());
    }

    @Test
    public void shouldReturnMaxAllElementsDifferentInvertedRows() {
        int[][] array = {
                {1, 2},
                {2, 1}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int expected = 2;
        assertEquals(expected, biDimensionalVector.getMax());
    }

    @Test
    public void shouldReturnMaxSomeElementsRepeated() {
        int[][] array = {
                {1, 1},
                {0, 4}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int expected = 4;
        assertEquals(expected, biDimensionalVector.getMax());
    }

    @Test
    public void shouldReturnMaxFirstElementIsMax() {
        int[][] array = {
                {4, 1},
                {2, 3}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int expected = 4;
        assertEquals(expected, biDimensionalVector.getMax());
    }

    @Test
    public void shouldReturnMaxAllElementsRepeated() {
        int[][] array = {
                {0, 0},
                {0, 0}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int expected = 0;
        assertEquals(expected, biDimensionalVector.getMax());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertThrows(EmptyArrayException.class, biDimensionalVector::getMax);
    }

    @Test
    public void shouldReturnMinAllElementsDifferent() {
        int[][] array = {
                {4, 2},
                {3, 1}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int expected = 1;
        assertEquals(expected, biDimensionalVector.getMin());
    }

    @Test
    public void shouldReturnMaxFirstElementIsMin() {
        int[][] array = {
                {1, 4},
                {2, 3}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int expected = 1;
        assertEquals(expected, biDimensionalVector.getMin());
    }

    @Test
    public void shouldReturnMinAllElementsRepeated() {
        int[][] array = {
                {0, 0},
                {0, 0}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int expected = 0;
        assertEquals(expected, biDimensionalVector.getMin());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getMin() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertThrows(EmptyArrayException.class, biDimensionalVector::getMin);
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getAverage() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertThrows(EmptyArrayException.class, biDimensionalVector::getAverage);
    }

    @Test
    public void shouldGetAverageOfBiDimensionalArray() {
        int[][] array = {
                {1, 2},
                {3, 4}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        double expected = 2.5;
        assertEquals(expected, biDimensionalVector.getAverage());
    }

    @Test
    public void shouldGetAverageOfBiDimensionalArrayAllZeros() {
        int[][] array = {
                {0, 0},
                {0, 0}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        double expected = 0.0;
        assertEquals(expected, biDimensionalVector.getAverage());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getEachRowSum() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertThrows(EmptyArrayException.class, biDimensionalVector::getEachRowSum);
    }

    @Test
    public void shouldGetEachRowSumOfBiDimensionalArray() throws EmptyArrayException {
        int[][] array = {
                {1, 2},
                {3, 4}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int[] expected = {3, 7};
        assertArrayEquals(expected, biDimensionalVector.getEachRowSum());
    }

    @Test
    public void shouldGetEachRowSumOfBiDimensionalArrayAllElementsZero() {
        int[][] array = {
                {0, 0},
                {0, 0}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int[] expected = {0, 0};
        assertArrayEquals(expected, biDimensionalVector.getEachRowSum());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getEachColumnSum() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertThrows(EmptyArrayException.class, biDimensionalVector::getEachColumnSum);
    }

    @Test
    public void shouldThrowExceptionForDifferentColumnsCountMatrix_getEachColumnSum() {
        int[][] array = {
                {0, 0},
                {0, 0, 0}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertThrows(IllegalArgumentException.class, biDimensionalVector::getEachColumnSum);
    }

    @Test
    public void shouldReturnArrayWithColumnSums_getEachColumnSum() throws EmptyArrayException {
        int[][] array = {
                {1, 2, 1},
                {2, 1, 1}
        };
        int[] expected = {3, 3, 2};
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertArrayEquals(expected, biDimensionalVector.getEachColumnSum());
    }

    @Test
    public void shouldReturnArrayWithColumnSumsVerticalArray_getEachColumnSum() {
        int[][] array = {
                {1, 2},
                {1, 1},
                {1, 1}
        };
        int[] expected = {3, 4};
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertArrayEquals(expected, biDimensionalVector.getEachColumnSum());
    }

    @Test
    public void shouldReturnArrayWithColumnSumsAllElementsZero_getEachColumnSum() {
        int[][] array = {
                {0, 0},
                {0, 0}
        };
        int[] expected = {0, 0};
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertArrayEquals(expected, biDimensionalVector.getEachColumnSum());
    }

    @Test
    public void shouldThrowExceptionForEmptyMatrix_getIndexFromMaxSum() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertThrows(EmptyArrayException.class, biDimensionalVector::getRowIndexFromMaxSum);
    }

    @Test
    public void shouldReturnIndexFromMaxSum_getIndexFromMaxSum() {
        int[][] array = {
                {1, 3},
                {2, 4}
        };
        int expected = 1;
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertEquals(expected, biDimensionalVector.getRowIndexFromMaxSum());
    }

    @Test
    public void shouldReturnIndexFromMaxSumAllZeros_getIndexFromMaxSum() {
        int[][] array = {
                {0, 0},
                {0, 0}
        };
        int expected = 0;
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertEquals(expected, biDimensionalVector.getRowIndexFromMaxSum());
    }

    @Test
    public void shouldReturnTrueForSquareMatrix() {
        int[][] matrix = {
                {1, 2},
                {1, 2}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(matrix);
        assertTrue(biDimensionalVector.checkIfMatrixIsSquare());
    }

    @Test
    public void shouldReturnFalseForEmptyMatrix() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertFalse(biDimensionalVector.checkIfMatrixIsSquare());
    }

    @Test
    public void shouldReturnFalseForMatrixWhichIsRectangular() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 4}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(matrix);
        assertFalse(biDimensionalVector.checkIfMatrixIsSquare());
    }

    @Test
    public void shouldReturnFalseForMatrixWhichIsNotRegular() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(matrix);
        assertFalse(biDimensionalVector.checkIfMatrixIsSquare());
    }

    @Test
    public void shouldReturnFalseForEmptyMatrix_checkRegular() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertFalse(biDimensionalVector.checkIfMatrixIsSquare());
    }

    @Test
    public void shouldReturnFalseForMatrixWithDifferentNumberOfColumns() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2},
                {1, 2, 3, 4}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(matrix);
        assertFalse(biDimensionalVector.checkIfMatrixIsRegular());
    }

    @Test
    public void shouldReturnTrueForRegularMatrix() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(matrix);
        assertTrue(biDimensionalVector.checkIfMatrixIsRegular());
    }

    @Test
    public void shouldReturnFalseForEmptyMatrix_regularMatrix() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertFalse(biDimensionalVector.checkIfMatrixIsRegular());
    }

    @Test
    public void shouldReturnFalseForNotSymmetrical2x2Matrix() {
        int[][] matrix = {
                {1, 2},
                {3, 3}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(matrix);
        assertFalse(biDimensionalVector.isSymmetrical());
    }

    @Test
    public void shouldReturnFalseForNotSquareMatrix() {
        int[][] matrix = {
                {1, 2},
                {3}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(matrix);
        assertFalse(biDimensionalVector.isSymmetrical());
    }

    @Test
    public void shouldReturnFalseForNotSymmetricalMatrix() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {3, 3, 3, 3},
                {2, 2, 2, 2},
                {1, 1, 1, 1},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(matrix);
        assertFalse(biDimensionalVector.isSymmetrical());
    }

    @Test
    public void shouldReturnTrueForSymmetrical2x2Matrix() {
        int[][] matrix = {
                {1, 2},
                {2, 3}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(matrix);
        assertTrue(biDimensionalVector.isSymmetrical());
    }

    @Test
    public void shouldReturnTrueForSymmetricalMatrix() {
        int[][] matrix = {
                {1, 3, 2, 4},
                {3, 3, 3, 3},
                {2, 2, 2, 2},
                {4, 3, 2, 1},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(matrix);
        assertTrue(biDimensionalVector.isSymmetrical());
    }

    @Test
    public void shouldReturnMinusOneForEmptyArray() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        int expected = -1;
        assertEquals(expected, biDimensionalVector.countNotZeroPrincipalDiagonal());
    }

    @Test
    public void shouldReturnMinusOneForNotSquareArray() {
        int[][] array = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int expected = -1;
        assertEquals(expected, biDimensionalVector.countNotZeroPrincipalDiagonal());
    }

    @Test
    public void shouldReturnOneForOneElementDifferentThanZeroInPrincipalDiagonal() {
        int[][] array = {
                {1, 2},
                {3, 0},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int expected = 1;
        assertEquals(expected, biDimensionalVector.countNotZeroPrincipalDiagonal());
    }

    @Test
    public void shouldReturnTwoForElementsDifferentThanZeroInPrincipalDiagonal() {
        int[][] array = {
                {1, 2},
                {3, 1},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int expected = 2;
        assertEquals(expected, biDimensionalVector.countNotZeroPrincipalDiagonal());
    }

    @Test
    public void shouldReturnFalseForEmptyArray() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertFalse(biDimensionalVector.isPrincipalDiagonalEqualsSecondaryDiagonal());
    }

    @Test
    public void shouldReturnFalseForNotSquareMatrix_principalSecondaryDiagonal() {
        int[][] array = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertFalse(biDimensionalVector.isPrincipalDiagonalEqualsSecondaryDiagonal());
    }

    @Test
    public void shouldReturnFalseForMatrixPrincipalAndSecondaryDiagonalDifferent_principalSecondaryDiagonal() {
        int[][] array = {
                {1, 1},
                {1, 2},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertFalse(biDimensionalVector.isPrincipalDiagonalEqualsSecondaryDiagonal());
    }

    @Test
    public void shouldReturnTrueForMatrixPrincipalAndSecondaryDiagonalEqual_principalSecondaryDiagonal() {
        int[][] array = {
                {1, 1},
                {2, 2},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertTrue(biDimensionalVector.isPrincipalDiagonalEqualsSecondaryDiagonal());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getNumbersWithGreaterDigitsThanAverage() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        boolean gettingJustEven = false;
        assertThrows(EmptyArrayException.class, () -> biDimensionalVector.getNumbersWithGreaterDigitsThanAverage(gettingJustEven));
    }

    @Test
    public void shouldReturnDigitsGreaterThanAverage() {
        int[][] array = {
                {1, 2},
                {1, 10}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        boolean gettingJustEven = false;
        int[] expected = {10};
        assertArrayEquals(expected, biDimensionalVector.getNumbersWithGreaterDigitsThanAverage(gettingJustEven));
    }

    @Test
    public void shouldReturnEmptyArrayForNoneGreaterThanAverage() {
        int[][] array = {
                {1, 2},
                {1, 1}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        boolean gettingJustEven = false;
        int[] expected = {};
        assertArrayEquals(expected, biDimensionalVector.getNumbersWithGreaterDigitsThanAverage(gettingJustEven));
    }

    @Test
    public void shouldReturnEvenDigitsGreaterThanAverage() {
        int[][] array = {
                {2, 2},
                {2, 120}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        boolean gettingJustEven = true;
        int[] expected = {120};
        assertArrayEquals(expected, biDimensionalVector.getNumbersWithGreaterDigitsThanAverage(gettingJustEven));
    }

    @Test
    public void shouldReturnEmptyArrayForNoneEvenGreaterThanAverage() {
        int[][] array = {
                {1, 1},
                {1, 1}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        boolean gettingJustEven = true;
        int[] expected = {};
        assertArrayEquals(expected, biDimensionalVector.getNumbersWithGreaterDigitsThanAverage(gettingJustEven));
    }

    @Test
    public void shouldThrowExceptionForEmptyArrayOnInvertedValuesForEachMatrixRow() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertThrows(EmptyArrayException.class, biDimensionalVector::invertValuesEachRow);
    }

    @Test
    public void shouldThrowExceptionForNotRegularArrayOnInvertedValuesForEachMatrixRow() {
        int[][] array = {
                {1, 1},
                {2, 2, 2},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertThrows(IllegalArgumentException.class, biDimensionalVector::invertValuesEachRow);
    }

    @Test
    public void shouldReturnInvertedValuesForEachMatrixRow() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int[][] expected = {
                {3, 2, 1},
                {6, 5, 4}
        };
        assertArrayEquals(expected, biDimensionalVector.invertValuesEachRow());
    }

    @Test
    public void shouldReturnInvertedValuesForEachMatrixRowOnlyOneElement() {
        int[][] array = {
                {0},
                {0}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int[][] expected = {
                {0},
                {0}
        };
        assertArrayEquals(expected, biDimensionalVector.invertValuesEachRow());
    }

    @Test
    public void shouldReturnInvertedValuesForEachMatrixColumn() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int[][] expected = {
                {1, 4},
                {2, 5},
                {3, 6}
        };
        assertArrayEquals(expected, biDimensionalVector.invertMatrixByColumn());
    }

    @Test
    public void shouldReturnInvertedValuesForEachMatrixColumnSquareMatrix() {
        int[][] array = {
                {1, 2},
                {3, 4},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int[][] expected = {
                {1, 3},
                {2, 4},
        };
        assertArrayEquals(expected, biDimensionalVector.invertMatrixByColumn());
    }

    @Test
    public void shouldThrowExceptionForEmptyArrayOnInvertedValuesForEachMatrixColumn() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertThrows(EmptyArrayException.class, biDimensionalVector::invertColumn);
    }

    @Test
    public void shouldThrowExceptionForNotRegularArrayOnInvertedValuesForEachMatrixColumn() {
        int[][] array = {
                {1, 1},
                {2, 2, 2},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertThrows(IllegalArgumentException.class, biDimensionalVector::invertColumn);
    }

    @Test
    public void shouldReturnInvertedValuesForEachColumn() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int[][] expected = {
                {4, 5, 6},
                {1, 2, 3}
        };
        assertArrayEquals(expected, biDimensionalVector.invertColumn());
    }

    @Test
    public void shouldThrowExceptionForEmptyArrayOnRotated90() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertThrows(EmptyArrayException.class, biDimensionalVector::rotate90);
    }

    @Test
    public void shouldThrowExceptionForNotRegularArrayOnRotated90() {
        int[][] array = {
                {1, 1},
                {2, 2, 2},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        assertThrows(IllegalArgumentException.class, biDimensionalVector::rotate90);
    }

    @Test
    public void shouldReturnRotated90() {
        int[][] array = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {8, 9, 0, 1},
                {2, 3, 4, 5},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int[][] expected = {
                {4, 7, 1, 5},
                {3, 6, 0, 4},
                {2, 5, 9, 3},
                {1, 4, 8, 2},
        };
        assertArrayEquals(expected, biDimensionalVector.rotate90());
    }

    @Test
    public void shouldReturnRotated180() {
        int[][] array = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {8, 9, 0, 1},
                {2, 3, 4, 5},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int[][] expected = {
                {5, 4, 3, 2},
                {1, 0, 9, 8},
                {7, 6, 5, 4},
                {4, 3, 2, 1},
        };
        assertArrayEquals(expected, biDimensionalVector.rotate180(array));
    }

    @Test
    public void shouldReturnRotatedMinus90() {
        int[][] array = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {8, 9, 0, 1},
                {2, 3, 4, 5},
        };
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector(array);
        int[][] expected = {
                {2, 8, 4, 1},
                {3, 9, 5, 2},
                {4, 0, 6, 3},
                {5, 1, 7, 4},
        };
        assertArrayEquals(expected, biDimensionalVector.rotateMinus90());
    }
}
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiDimensionalVectorTest {
    @Test
    public void shouldCreateBiDimensionalEmptyArray() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        int[][] expected = {};
        assertArrayEquals(expected, biDimensionalVector.getBiDimensionalVector());
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
    public void shouldThrowExceptionForRowNumberMoreThanRowLength_addToRow() {
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
        assertFalse(biDimensionalVector.isEmpty());
    }

    @Test
    public void shouldReturnTrueForEmptyMatrix() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertTrue(biDimensionalVector.isEmpty());
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
        assertThrows(NullPointerException.class, biDimensionalVector::getMax);
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
        assertThrows(NullPointerException.class, biDimensionalVector::getMin);
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getAverage() {
        BiDimensionalVector biDimensionalVector = new BiDimensionalVector();
        assertThrows(NullPointerException.class, biDimensionalVector::getAverage);
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
        assertThrows(NullPointerException.class, biDimensionalVector::getEachRowSum);
    }

    @Test
    public void shouldGetEachRowSumOfBiDimensionalArray() {
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
        assertThrows(NullPointerException.class, biDimensionalVector::getEachColumnSum);
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
    public void shouldReturnArrayWithColumnSums_getEachColumnSum() {
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
        assertThrows(NullPointerException.class, biDimensionalVector::getRowIndexFromMaxSum);
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
}
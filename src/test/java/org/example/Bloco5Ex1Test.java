package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.MalformedParametersException;

import static org.junit.jupiter.api.Assertions.*;

class Bloco5Ex1Test {
    @Test
    public void shouldCreateObjectWithNoParameters() {
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1();
        int[] expected = new int[0];
        assertArrayEquals(expected, bloco5Ex1.getVector());
    }

    @Test
    public void shouldCreateObjectWithParameters() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        assertArrayEquals(array, bloco5Ex1.getVector());
    }

    @Test
    public void shouldReturnEmptyArray() {
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1();
        assertArrayEquals(new int[0], bloco5Ex1.getVectorFromEmptyConstructor());
    }

    @Test
    public void shouldReturnProvidedArray() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        assertArrayEquals(array, bloco5Ex1.getVectorFromEmptyConstructor());
    }

    @Test
    public void shouldReturnValueFromArrayAtIndexOf() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int index = 0;
        int expected = 1;
        assertEquals(expected, bloco5Ex1.getValueAt(index));
    }

    @Test
    public void shouldReturnExceptionForInvalidIndex() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int index = -1;
        assertThrows(IndexOutOfBoundsException.class, () -> bloco5Ex1.getValueAt(index));
    }

    @Test
    public void shouldReturnExceptionForValidIndexOnEmptyArray() {
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(); // empty constructor sets array as empty
        int index = 0;
        assertThrows(IndexOutOfBoundsException.class, () -> bloco5Ex1.getValueAt(index));
    }

    @Test
    public void shouldAddNumberOneToVectorAtLastPosition() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int number = 1;
        int[] expected = {1, 2, 3, 1};
        assertArrayEquals(expected, bloco5Ex1.add(number));
    }

    @Test
    public void shouldAddNumberZeroToVectorAtLastPosition() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int number = 0;
        int[] expected = {1, 2, 3, 0};
        assertArrayEquals(expected, bloco5Ex1.add(number));
    }

    @Test
    public void shouldRemoveNumberAtFirstPosition() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int index = 0;
        int[] expected = {2, 3};
        assertArrayEquals(expected, bloco5Ex1.removeAt(index));
    }

    @Test
    public void shouldRemoveNumberAtLastPosition() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int index = 2;
        int[] expected = {1, 2};
        assertArrayEquals(expected, bloco5Ex1.removeAt(index));
    }

    @Test
    public void shouldThrowExceptionForIndexLessThanZero_removeAt() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int index = -1;
        assertThrows(IndexOutOfBoundsException.class, () -> bloco5Ex1.removeAt(index));
    }

    @Test
    public void shouldThrowExceptionForIndexGreaterThanArrayLength_removeAt() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int index = 3;
        assertThrows(IndexOutOfBoundsException.class, () -> bloco5Ex1.removeAt(index));
    }

    @Test
    public void shouldReturnLengthFromEmptyVector() {
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1();
        int expected = 0;
        assertEquals(expected, bloco5Ex1.getLength());
    }

    @Test
    public void shouldReturnLengthFromVector() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int expected = 3;
        assertEquals(expected, bloco5Ex1.getLength());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithAllOnes() {
        int[] array = {1, 1};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int expected = 1;
        assertEquals(expected, bloco5Ex1.getMax());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithAllZeros() {
        int[] array = {0, 0};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int expected = 0;
        assertEquals(expected, bloco5Ex1.getMax());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithOneRepeatedValue() {
        int[] array = {1, 2, 1};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int expected = 2;
        assertEquals(expected, bloco5Ex1.getMax());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithUniqueValues() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int expected = 3;
        assertEquals(expected, bloco5Ex1.getMax());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithUniqueValuesJustOneElement() {
        int[] array = {1};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int expected = 1;
        assertEquals(expected, bloco5Ex1.getMax());
    }

    @Test
    public void shouldReturnMinValueFromVectorWithAllZeros() {
        int[] array = {0, 0};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int expected = 0;
        assertEquals(expected, bloco5Ex1.getMax());
    }

    @Test
    public void shouldReturnMinValueFromVectorWithOneRepeatedValue() {
        int[] array = {1, 2, 1};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int expected = 1;
        assertEquals(expected, bloco5Ex1.getMin());
    }

    @Test
    public void shouldReturnMinValueFromVectorWithUniqueValues() {
        int[] array = {2, 1, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int expected = 1;
        assertEquals(expected, bloco5Ex1.getMin());
    }

    @Test
    public void shouldReturnMinValueFromVectorWithUniqueValuesFirstValIsMin() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int expected = 1;
        assertEquals(expected, bloco5Ex1.getMin());
    }

    @Test
    public void shouldReturnAverageFromVectorPositiveValues() {
        int[] array = {1, 2, 3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        double expected = 2.0;
        assertEquals(expected, bloco5Ex1.getAverage(array));
    }

    @Test
    public void shouldReturnAverageFromVectorNegativeValues() {
        int[] array = {-1, -2, -3};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        double expected = -2.0;
        assertEquals(expected, bloco5Ex1.getAverage(array));
    }

    @Test
    public void shouldReturnAverageFromVectorWithAllZeroValues() {
        int[] array = {0, 0, 0};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        double expected = 0;
        assertEquals(expected, bloco5Ex1.getAverage(array));
    }

    @Test
    public void shouldReturnExceptionFromEmptyVector_getAverageMethod() {
        int[] array = {};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        assertThrows(ArithmeticException.class, () -> bloco5Ex1.getAverage(array));
    }

    @Test
    public void shouldReturnEvensArrayForAllPositiveNumbers() {
        int[] array = {1, 2, 3, 4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int[] expected = {2, 4};
        assertArrayEquals(expected, bloco5Ex1.getEvenNumbers());
    }

    @Test
    public void shouldReturnEvensArrayForAllPositiveNumbersAndOneZero() {
        int[] array = {1, 2, 0, 4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int[] expected = {2, 0, 4};
        assertArrayEquals(expected, bloco5Ex1.getEvenNumbers());
    }

    @Test
    public void shouldReturnEvensArrayForAllNegativeNumbers() {
        int[] array = {-1, -2, -3, -4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int[] expected = {-2, -4};
        assertArrayEquals(expected, bloco5Ex1.getEvenNumbers());
    }

    @Test
    public void shouldReturnEvensArrayForAllZeros() {
        int[] array = {0, 0, 0, 0};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, bloco5Ex1.getEvenNumbers());
    }

    @Test
    public void shouldReturnEvenNumbersAverageFromVectorPositiveValues() {
        int[] array = {1, 2, 3, 4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        double expected = 3;
        assertEquals(expected, bloco5Ex1.getAverageEvenNumbers());
    }

    @Test
    public void shouldReturnEvenNumbersAverageFromVectorNegativeValues() {
        int[] array = {-1, -2, -3, -4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        double expected = -3.0;
        assertEquals(expected, bloco5Ex1.getAverageEvenNumbers());
    }

    @Test
    public void shouldReturnEvenNumbersAverageFromVectorWithAllZeroValues() {
        int[] array = {0, 0, 0};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        double expected = 0;
        assertEquals(expected, bloco5Ex1.getAverageEvenNumbers());
    }

    @Test
    public void shouldReturnExceptionFromEmptyVector_getAverageEvenNumbers() {
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1();
        assertThrows(MalformedParametersException.class, bloco5Ex1::getAverageEvenNumbers);
    }
    /** START: odds **/
    @Test
    public void shouldReturnOddsArrayForAllPositiveNumbers() {
        int[] array = {1, 2, 3, 4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int[] expected = {1, 3};
        assertArrayEquals(expected, bloco5Ex1.getOddNumbers());
    }

    @Test
    public void shouldReturnOddsArrayForAllPositiveNumbersAndOneZero() {
        int[] array = {1, 2, 0, 4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int[] expected = {1};
        assertArrayEquals(expected, bloco5Ex1.getOddNumbers());
    }

    @Test
    public void shouldReturnOddsArrayForAllNegativeNumbers() {
        int[] array = {-1, -2, -3, -4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int[] expected = {-1, -3};
        assertArrayEquals(expected, bloco5Ex1.getOddNumbers());
    }

    @Test
    public void shouldReturnOddsArrayForAllZeros() {
        int[] array = {0, 0, 0, 0};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int[] expected = {};
        assertArrayEquals(expected, bloco5Ex1.getOddNumbers());
    }

    @Test
    public void shouldReturnOddNumbersAverageFromVectorPositiveValues() {
        int[] array = {1, 2, 3, 4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        double expected = 2.0;
        assertEquals(expected, bloco5Ex1.getAverageOddNumbers());
    }

    @Test
    public void shouldReturnOddNumbersAverageFromVectorNegativeValues() {
        int[] array = {-1, -2, -3, -4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        double expected = -2.0;
        assertEquals(expected, bloco5Ex1.getAverageOddNumbers());
    }

    @Test
    public void shouldReturnOddNumbersAverageFromVectorWithAllZeroValues() {
        int[] array = {0, 0, 0};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        double expected = 0.0;
        assertEquals(expected, bloco5Ex1.getAverageOddNumbers());
    }

    @Test
    public void shouldReturnExceptionFromEmptyVector_getAverageOddNumbers() {
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1();
        assertThrows(MalformedParametersException.class, bloco5Ex1::getAverageOddNumbers);
    }

    @Test
    public void shouldReturnMultiplesOfNumberZero() {
        int[] array = {1, 2, 3, 4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int number = 0;
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, bloco5Ex1.getMultiplesOfNumber(number));
    }

    @Test
    public void shouldReturnMultiplesOfNumberTwo() {
        int[] array = {1, 2, 3, 4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int number = 2;
        int[] expected = {2, 4};
        assertArrayEquals(expected, bloco5Ex1.getMultiplesOfNumber(number));
    }

    @Test
    public void shouldThrowExceptionForEmptyVector_getMultiplesOfNumber() {
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1();
        int number = 2;
        assertThrows(ArithmeticException.class, () -> bloco5Ex1.getMultiplesOfNumber(number));
    }

    @Test
    public void shouldReturnAverageOfMultiplesOfNumberTwo() {
        int[] array = {0, 1, 2, 3, 4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int number = 2;
        double expected = 2.0;
        assertEquals(expected, bloco5Ex1.getAverageOfMultiples(number));
    }

    @Test
    public void shouldReturnAverageOfMultiplesOfNumberZero() {
        int[] array = {0, 1, 2, 3, 4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int number = 0;
        double expected = 2.0;
        assertEquals(expected, bloco5Ex1.getAverageOfMultiples(number));
    }
    @Test
    public void shouldReturnAverageOfMultiplesOfNumberTwoOnNegativesArray() {
        int[] array = {0, -1, -2, -3, -4};
        Bloco5Ex1 bloco5Ex1 = new Bloco5Ex1(array);
        int number = 0;
        double expected = -2.0;
        assertEquals(expected, bloco5Ex1.getAverageOfMultiples(number));
    }

}
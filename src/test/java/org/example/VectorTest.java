package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.MalformedParametersException;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {
    @Test
    public void shouldCreateObjectWithNoParameters() {
        Vector vector = new Vector();
        int[] expected = new int[0];
        assertArrayEquals(expected, vector.getVector());
    }

    @Test
    public void shouldCreateObjectWithParameters() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        assertArrayEquals(array, vector.getVector());
    }

    @Test
    public void shouldReturnEmptyArray() {
        Vector vector = new Vector();
        assertArrayEquals(new int[0], vector.getVectorFromEmptyConstructor());
    }

    @Test
    public void shouldReturnProvidedArray() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        assertArrayEquals(array, vector.getVectorFromEmptyConstructor());
    }

    @Test
    public void shouldReturnValueFromArrayAtIndexOf() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        int index = 0;
        int expected = 1;
        assertEquals(expected, vector.getValueAt(index));
    }

    @Test
    public void shouldReturnExceptionForInvalidIndex() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        int index = -1;
        assertThrows(IndexOutOfBoundsException.class, () -> vector.getValueAt(index));
    }

    @Test
    public void shouldReturnExceptionForValidIndexOnEmptyArray() {
        Vector vector = new Vector(); // empty constructor sets array as empty
        int index = 0;
        assertThrows(IndexOutOfBoundsException.class, () -> vector.getValueAt(index));
    }

    @Test
    public void shouldReturnExceptionForEmptyArray_indexOf() {
        Vector vector = new Vector(); // empty constructor sets array as empty
        int number = 0;
        assertThrows(NullPointerException.class, () -> vector.indexOf(number));
    }

    @Test
    public void shouldReturnCorrectIndexFromNumberProvided_indexOf() {
        int[] array = {0, 2, 3};
        Vector vector = new Vector(array);
        int number = 2;
        int expected = 1;
        assertEquals(expected, vector.indexOf(number));
    }

    @Test
    public void shouldReturnNoneIndexFromNumberProvidedNotExisting_indexOf() {
        int[] array = {0, 2, 3};
        Vector vector = new Vector(array);
        int number = 1;
        int expected = -1;
        assertEquals(expected, vector.indexOf(number));
    }

    @Test
    public void shouldAddNumberOneToVectorAtLastPosition() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        int number = 1;
        int[] expected = {1, 2, 3, 1};
        assertArrayEquals(expected, vector.add(number));
    }

    @Test
    public void shouldAddNumberZeroToVectorAtLastPosition() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        int number = 0;
        int[] expected = {1, 2, 3, 0};
        assertArrayEquals(expected, vector.add(number));
    }

    @Test
    public void shouldRemoveNumberAtFirstPosition() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        int index = 0;
        int[] expected = {2, 3};
        assertArrayEquals(expected, vector.removeAt(index));
    }

    @Test
    public void shouldRemoveNumberAtLastPosition() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        int index = 2;
        int[] expected = {1, 2};
        assertArrayEquals(expected, vector.removeAt(index));
    }

    @Test
    public void shouldThrowExceptionForIndexLessThanZero_removeAt() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        int index = -1;
        assertThrows(IndexOutOfBoundsException.class, () -> vector.removeAt(index));
    }

    @Test
    public void shouldThrowExceptionForIndexGreaterThanArrayLength_removeAt() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        int index = 3;
        assertThrows(IndexOutOfBoundsException.class, () -> vector.removeAt(index));
    }

    @Test
    public void shouldReturnLengthFromEmptyVector() {
        Vector vector = new Vector();
        int expected = 0;
        assertEquals(expected, vector.getLength());
    }

    @Test
    public void shouldReturnLengthFromVector() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        int expected = 3;
        assertEquals(expected, vector.getLength());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithAllOnes() {
        int[] array = {1, 1};
        Vector vector = new Vector(array);
        int expected = 1;
        assertEquals(expected, vector.getMax());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithAllZeros() {
        int[] array = {0, 0};
        Vector vector = new Vector(array);
        int expected = 0;
        assertEquals(expected, vector.getMax());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithOneRepeatedValue() {
        int[] array = {1, 2, 1};
        Vector vector = new Vector(array);
        int expected = 2;
        assertEquals(expected, vector.getMax());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithUniqueValues() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        int expected = 3;
        assertEquals(expected, vector.getMax());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithUniqueValuesJustOneElement() {
        int[] array = {1};
        Vector vector = new Vector(array);
        int expected = 1;
        assertEquals(expected, vector.getMax());
    }

    @Test
    public void shouldReturnMinValueFromVectorWithAllZeros() {
        int[] array = {0, 0};
        Vector vector = new Vector(array);
        int expected = 0;
        assertEquals(expected, vector.getMax());
    }

    @Test
    public void shouldReturnMinValueFromVectorWithOneRepeatedValue() {
        int[] array = {1, 2, 1};
        Vector vector = new Vector(array);
        int expected = 1;
        assertEquals(expected, vector.getMin());
    }

    @Test
    public void shouldReturnMinValueFromVectorWithUniqueValues() {
        int[] array = {2, 1, 3};
        Vector vector = new Vector(array);
        int expected = 1;
        assertEquals(expected, vector.getMin());
    }

    @Test
    public void shouldReturnMinValueFromVectorWithUniqueValuesFirstValIsMin() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        int expected = 1;
        assertEquals(expected, vector.getMin());
    }

    @Test
    public void shouldReturnAverageFromVectorPositiveValues() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        double expected = 2.0;
        assertEquals(expected, vector.getAverage(array));
    }

    @Test
    public void shouldReturnAverageFromVectorNegativeValues() {
        int[] array = {-1, -2, -3};
        Vector vector = new Vector(array);
        double expected = -2.0;
        assertEquals(expected, vector.getAverage(array));
    }

    @Test
    public void shouldReturnAverageFromVectorWithAllZeroValues() {
        int[] array = {0, 0, 0};
        Vector vector = new Vector(array);
        double expected = 0;
        assertEquals(expected, vector.getAverage(array));
    }

    @Test
    public void shouldReturnExceptionFromEmptyVector_getAverageMethod() {
        int[] array = {};
        Vector vector = new Vector(array);
        assertThrows(ArithmeticException.class, () -> vector.getAverage(array));
    }

    @Test
    public void shouldReturnEvensArrayForAllPositiveNumbers() {
        int[] array = {1, 2, 3, 4};
        Vector vector = new Vector(array);
        int[] expected = {2, 4};
        assertArrayEquals(expected, vector.getEvenNumbers());
    }

    @Test
    public void shouldReturnEvensArrayForAllPositiveNumbersAndOneZero() {
        int[] array = {1, 2, 0, 4};
        Vector vector = new Vector(array);
        int[] expected = {2, 0, 4};
        assertArrayEquals(expected, vector.getEvenNumbers());
    }

    @Test
    public void shouldReturnEvensArrayForAllNegativeNumbers() {
        int[] array = {-1, -2, -3, -4};
        Vector vector = new Vector(array);
        int[] expected = {-2, -4};
        assertArrayEquals(expected, vector.getEvenNumbers());
    }

    @Test
    public void shouldReturnEvensArrayForAllZeros() {
        int[] array = {0, 0, 0, 0};
        Vector vector = new Vector(array);
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, vector.getEvenNumbers());
    }

    @Test
    public void shouldReturnEvenNumbersAverageFromVectorPositiveValues() {
        int[] array = {1, 2, 3, 4};
        Vector vector = new Vector(array);
        double expected = 3;
        assertEquals(expected, vector.getAverageEvenNumbers());
    }

    @Test
    public void shouldReturnEvenNumbersAverageFromVectorNegativeValues() {
        int[] array = {-1, -2, -3, -4};
        Vector vector = new Vector(array);
        double expected = -3.0;
        assertEquals(expected, vector.getAverageEvenNumbers());
    }

    @Test
    public void shouldReturnEvenNumbersAverageFromVectorWithAllZeroValues() {
        int[] array = {0, 0, 0};
        Vector vector = new Vector(array);
        double expected = 0;
        assertEquals(expected, vector.getAverageEvenNumbers());
    }

    @Test
    public void shouldReturnExceptionFromEmptyVector_getAverageEvenNumbers() {
        Vector vector = new Vector();
        assertThrows(MalformedParametersException.class, vector::getAverageEvenNumbers);
    }
    /** START: odds **/
    @Test
    public void shouldReturnOddsArrayForAllPositiveNumbers() {
        int[] array = {1, 2, 3, 4};
        Vector vector = new Vector(array);
        int[] expected = {1, 3};
        assertArrayEquals(expected, vector.getOddNumbers());
    }

    @Test
    public void shouldReturnOddsArrayForAllPositiveNumbersAndOneZero() {
        int[] array = {1, 2, 0, 4};
        Vector vector = new Vector(array);
        int[] expected = {1};
        assertArrayEquals(expected, vector.getOddNumbers());
    }

    @Test
    public void shouldReturnOddsArrayForAllNegativeNumbers() {
        int[] array = {-1, -2, -3, -4};
        Vector vector = new Vector(array);
        int[] expected = {-1, -3};
        assertArrayEquals(expected, vector.getOddNumbers());
    }

    @Test
    public void shouldReturnOddsArrayForAllZeros() {
        int[] array = {0, 0, 0, 0};
        Vector vector = new Vector(array);
        int[] expected = {};
        assertArrayEquals(expected, vector.getOddNumbers());
    }

    @Test
    public void shouldReturnOddNumbersAverageFromVectorPositiveValues() {
        int[] array = {1, 2, 3, 4};
        Vector vector = new Vector(array);
        double expected = 2.0;
        assertEquals(expected, vector.getAverageOddNumbers());
    }

    @Test
    public void shouldReturnOddNumbersAverageFromVectorNegativeValues() {
        int[] array = {-1, -2, -3, -4};
        Vector vector = new Vector(array);
        double expected = -2.0;
        assertEquals(expected, vector.getAverageOddNumbers());
    }

    @Test
    public void shouldReturnOddNumbersAverageFromVectorWithAllZeroValues() {
        int[] array = {0, 0, 0};
        Vector vector = new Vector(array);
        double expected = 0.0;
        assertEquals(expected, vector.getAverageOddNumbers());
    }

    @Test
    public void shouldReturnExceptionFromEmptyVector_getAverageOddNumbers() {
        Vector vector = new Vector();
        assertThrows(MalformedParametersException.class, vector::getAverageOddNumbers);
    }

    @Test
    public void shouldReturnMultiplesOfNumberZero() {
        int[] array = {1, 2, 3, 4};
        Vector vector = new Vector(array);
        int number = 0;
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, vector.getMultiplesOfNumber(number));
    }

    @Test
    public void shouldReturnMultiplesOfNumberTwo() {
        int[] array = {1, 2, 3, 4};
        Vector vector = new Vector(array);
        int number = 2;
        int[] expected = {2, 4};
        assertArrayEquals(expected, vector.getMultiplesOfNumber(number));
    }

    @Test
    public void shouldThrowExceptionForEmptyVector_getMultiplesOfNumber() {
        Vector vector = new Vector();
        int number = 2;
        assertThrows(ArithmeticException.class, () -> vector.getMultiplesOfNumber(number));
    }

    @Test
    public void shouldReturnAverageOfMultiplesOfNumberTwo() {
        int[] array = {0, 1, 2, 3, 4};
        Vector vector = new Vector(array);
        int number = 2;
        double expected = 2.0;
        assertEquals(expected, vector.getAverageOfMultiples(number));
    }

    @Test
    public void shouldReturnAverageOfMultiplesOfNumberZero() {
        int[] array = {0, 1, 2, 3, 4};
        Vector vector = new Vector(array);
        int number = 0;
        double expected = 2.0;
        assertEquals(expected, vector.getAverageOfMultiples(number));
    }
    @Test
    public void shouldReturnAverageOfMultiplesOfNumberTwoOnNegativesArray() {
        int[] array = {0, -1, -2, -3, -4};
        Vector vector = new Vector(array);
        int number = 0;
        double expected = -2.0;
        assertEquals(expected, vector.getAverageOfMultiples(number));
    }

    @Test
    public void shouldReturnASCSortedArray() {
        int[] array = {3, 2, 1};
        Vector vector = new Vector(array);
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, vector.sorted(SortingType.ASC));
    }

    @Test
    public void shouldReturnASCSortedArrayWithZero() {
        int[] array = {3, 2, 0, 1};
        Vector vector = new Vector(array);
        int[] expected = {0, 1, 2, 3};
        assertArrayEquals(expected, vector.sorted(SortingType.ASC));
    }

    @Test
    public void shouldReturnASCSortedArrayWithAllZeros() {
        int[] array = {0, 0, 0};
        Vector vector = new Vector(array);
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, vector.sorted(SortingType.ASC));
    }

    @Test
    public void shouldReturnASCSortedArrayWithOneElement() {
        int[] array = {0};
        Vector vector = new Vector(array);
        int[] expected = {0};
        assertArrayEquals(expected, vector.sorted(SortingType.ASC));
    }

    @Test
    public void shouldReturnDESCSortedArray() {
        int[] array = {1, 2, 3};
        Vector vector = new Vector(array);
        int[] expected = {3, 2, 1};
        assertArrayEquals(expected, vector.sorted(SortingType.DESC));
    }

    @Test
    public void shouldReturnDESCSortedArrayWithZero() {
        int[] array = {3, 2, 0, 1};
        Vector vector = new Vector(array);
        int[] expected = {3, 2, 1, 0};
        assertArrayEquals(expected, vector.sorted(SortingType.DESC));
    }

    @Test
    public void shouldReturnDESCSortedArrayWithAllZeros() {
        int[] array = {0, 0, 0};
        Vector vector = new Vector(array);
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, vector.sorted(SortingType.DESC));
    }

    @Test
    public void shouldReturnDESCSortedArrayWithOneElement() {
        int[] array = {0};
        Vector vector = new Vector(array);
        int[] expected = {0};
        assertArrayEquals(expected, vector.sorted(SortingType.DESC));
    }

    @Test
    public void shouldReturnExceptionForEmptyArray() {
        Vector vector = new Vector();
        assertThrows(MalformedParametersException.class, () -> vector.sorted(SortingType.ASC));
    }

    @Test
    public void shouldReturnTrueForEmptyArray() {
        Vector vector = new Vector();
        assertTrue(vector.isEmpty());
    }

    @Test
    public void shouldReturnFalseForArrayNotEmpty() {
        int[] array = {0};
        Vector vector = new Vector(array);
        assertFalse(vector.isEmpty());
    }

    @Test
    public void shouldReturnTrueForOneElementArray() {
        int[] array = {0};
        Vector vector = new Vector(array);
        assertTrue(vector.hasOneElement());
    }

    @Test
    public void shouldReturnFalseForArrayWithZeroOrMoreThanOneElements() {
        Vector vector = new Vector();
        assertFalse(vector.hasOneElement());
    }

    @Test
    public void shouldReturnTrueForOneEvenElement() {
        int[] array = {0};
        Vector vector = new Vector(array);
        assertTrue(vector.hasEvenElements());
    }

    @Test
    public void shouldReturnFalseNoneEvenElements() {
        int[] array = {1, 3};
        Vector vector = new Vector(array);
        assertFalse(vector.hasEvenElements());
    }

    @Test
    public void shouldReturnTrueForOneOddElement() {
        int[] array = {1};
        Vector vector = new Vector(array);
        assertTrue(vector.hasOddElements());
    }

    @Test
    public void shouldReturnFalseNoneOddElements() {
        int[] array = {0, 2};
        Vector vector = new Vector(array);
        assertFalse(vector.hasOddElements());
    }

    @Test
    public void shouldReturnTrueForOneDuplicatedElement() {
        int[] array = {1, 1, 2};
        Vector vector = new Vector(array);
        assertTrue(vector.hasDuplicates());
    }

    @Test
    public void shouldReturnFalseForNoneDuplicateElements() {
        int[] array = {0, 2, 3, 4};
        Vector vector = new Vector(array);
        assertFalse(vector.hasDuplicates());
    }

    @Test
    public void shouldReturnOneForNumberZero() {
        int[] array = {0, 2, 3, 4};
        Vector vector = new Vector(array);
        int expected = 1;
        assertEquals(expected, vector.getDigitsCount(array[0]));
    }

    @Test
    public void shouldReturnOneForNumberWithOneDigit() {
        int[] array = {0, 2, 3, 4};
        Vector vector = new Vector(array);
        int expected = 1;
        assertEquals(expected, vector.getDigitsCount(array[1]));
    }

    @Test
    public void shouldReturnTwoForNumberWithTwoDigits() {
        int[] array = {10, 2, 3, 4};
        Vector vector = new Vector(array);
        int expected = 2;
        assertEquals(expected, vector.getDigitsCount(array[0]));
    }

    @Test
    public void shouldReturnMinusOneForEmptyVector() {
        Vector vector = new Vector();
        double expected = -1.0;
        assertEquals(expected, vector.getDigitsAverage());
    }

    @Test
    public void shouldReturnOneForVectorWithAllZeros() {
        int[] array = {0, 0, 0, 0};
        Vector vector = new Vector(array);
        double expected = 1.0;
        assertEquals(expected, vector.getDigitsAverage());
    }

    @Test
    public void shouldReturnOneForVectorWithNumbersWithOneDigit() {
        int[] array = {0, 2, 3, 9};
        Vector vector = new Vector(array);
        double expected = 1.0;
        assertEquals(expected, vector.getDigitsAverage());
    }

    @Test
    public void shouldReturnTwoForVectorWithNumbersWithTwoDigits() {
        int[] array = {10, 20, 30, 99};
        Vector vector = new Vector(array);
        double expected = 2.0;
        assertEquals(expected, vector.getDigitsAverage());
    }

    @Test
    public void shouldReturnCorrectValueVectorWithMixedNumbersSize() {
        int[] array = {10, 2, 3, 99};
        Vector vector = new Vector(array);
        double expected = 1.5;
        assertEquals(expected, vector.getDigitsAverage());
    }

    @Test
    public void shouldReturnNumbersWithMoreDigitsThanAverageDigitsInArray() {
        int[] array = {10, 2, 3, 99};
        Vector vector = new Vector(array);
        int[] expected = {10, 99};
        assertArrayEquals(expected, vector.getNumbersWithDigitsBiggerThanAverageDigits());
    }

    @Test
    public void shouldReturnEmptyArrayForNoneDigitsBiggerThanAverageDigitsInArray() {
        int[] array = {1, 2, 3, 9};
        Vector vector = new Vector(array);
        int[] expected = {};
        assertArrayEquals(expected, vector.getNumbersWithDigitsBiggerThanAverageDigits());
    }

    @Test
    public void shouldReturnNullForEmptyArrayInDigitsBiggerThanAverageDigitsInArray() {
        Vector vector = new Vector();
        assertNull(vector.getNumbersWithDigitsBiggerThanAverageDigits());
    }

    @Test
    public void shouldReturnArrayWithOneElementFor1DigitNumber() {
        int number = 0;
        Vector vector = new Vector();
        int[] expected = {0};
        assertArrayEquals(expected, vector.getDigits(number));
    }

    @Test
    public void shouldReturnArrayWithOneElementForNumber1() {
        int number = 1;
        Vector vector = new Vector();
        int[] expected = {1};
        assertArrayEquals(expected, vector.getDigits(number));
    }

    @Test
    public void shouldReturnArrayWithTwoElementsFor2DigitsNumber() {
        int number = 10;
        Vector vector = new Vector();
        int[] expected = {0, 1};
        assertArrayEquals(expected, vector.getDigits(number));
    }

    @Test
    public void shouldReturnThrowExceptionForEmptyVector_getEvenDigitsInVector() {
        Vector vector = new Vector();
        assertThrows(MalformedParametersException.class, () -> vector.getEvenDigitsInVector(vector.getVector()));
    }

    @Test
    public void shouldReturnArrayWithJustTheEvenDigitsFromAllVectorDigits1DigitNumbers() {
        int[] array = {0, 1, 2, 3};
        Vector vector = new Vector(array);
        int[] expected = {0, 2};
        assertArrayEquals(expected, vector.getEvenDigitsInVector(array));
    }

    @Test
    public void shouldReturnArrayWithJustTheEvenDigitsFromAllVectorDigits2DigitNumbers() {
        int[] array = {10, 13, 21, 31};
        Vector vector = new Vector(array);
        int[] expected = {0, 2};
        assertArrayEquals(expected, vector.getEvenDigitsInVector(array));
    }

    @Test
    public void shouldReturnArrayWithEvenDigitsCountGreaterThanAverageOfEvenDigitsInVector() {
        int[] array = {10, 13, 21, 2222};
        Vector vector = new Vector(array);
        int[] expected = {2222};
        assertArrayEquals(expected, vector.getNumberWithEvenDigitsBiggerThanAverageOfEvenDigits());
    }

    @Test
    public void shouldReturnArrayWithEvenDigitsCountGreaterThanAverageOfEvenDigitsInVectorWithOneElementBeingZero() {
        int[] array = {0, 13, 21, 2222};
        Vector vector = new Vector(array);
        int[] expected = {0, 2222};
        assertArrayEquals(expected, vector.getNumberWithEvenDigitsBiggerThanAverageOfEvenDigits());
    }

    @Test
    public void shouldReturnArrayWithEvenDigitsCountEqualsThanAverageOfEvenDigitsInVector() {
        int[] array = {21, 21, 21, 21};
        Vector vector = new Vector(array);
        int[] expected = {};
        assertArrayEquals(expected, vector.getNumberWithEvenDigitsBiggerThanAverageOfEvenDigits());
    }
}
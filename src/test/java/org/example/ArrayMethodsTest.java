package org.example;

import org.example.utils.EmptyArrayException;
import org.example.utils.SortingType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMethodsTest {
    @Test
    public void shouldCreateObjectWithNoParameters() {
        ArrayMethods arrayMethods = new ArrayMethods();
        int[] expected = new int[0];
        assertArrayEquals(expected, arrayMethods.getVector());
    }

    @Test
    public void shouldCreateObjectWithParameters() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertArrayEquals(array, arrayMethods.getVector());
    }

    @Test
    public void shouldReturnValueFromArrayAtIndexOf() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int index = 0;
        int expected = 1;
        assertEquals(expected, arrayMethods.getValueAt(index));
    }

    @Test
    public void shouldReturnExceptionForInvalidIndex() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int index = -1;
        assertThrows(IndexOutOfBoundsException.class, () -> arrayMethods.getValueAt(index));
    }

    @Test
    public void shouldReturnExceptionForValidIndexOnEmptyArray() {
        ArrayMethods arrayMethods = new ArrayMethods(); // empty constructor sets array as empty
        int index = 0;
        assertThrows(IndexOutOfBoundsException.class, () -> arrayMethods.getValueAt(index));
    }

    @Test
    public void shouldReturnExceptionForEmptyArray_indexOf() {
        ArrayMethods arrayMethods = new ArrayMethods(); // empty constructor sets array as empty
        int number = 0;
        assertThrows(NullPointerException.class, () -> arrayMethods.indexOf(number));
    }

    @Test
    public void shouldReturnCorrectIndexFromNumberProvided_indexOf() {
        int[] array = {0, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int number = 2;
        int expected = 1;
        assertEquals(expected, arrayMethods.indexOf(number));
    }

    @Test
    public void shouldReturnNoneIndexFromNumberProvidedNotExisting_indexOf() {
        int[] array = {0, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int number = 1;
        int expected = -1;
        assertEquals(expected, arrayMethods.indexOf(number));
    }

    @Test
    public void shouldAddNumberOneToVectorAtLastPosition() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int number = 1;
        int[] expected = {1, 2, 3, 1};
        assertArrayEquals(expected, arrayMethods.add(number));
    }

    @Test
    public void shouldAddNumberZeroToVectorAtLastPosition() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int number = 0;
        int[] expected = {1, 2, 3, 0};
        assertArrayEquals(expected, arrayMethods.add(number));
    }

    @Test
    public void shouldRemoveNumberAtFirstPosition() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int index = 0;
        int[] expected = {2, 3};
        assertArrayEquals(expected, arrayMethods.removeAt(index));
    }

    @Test
    public void shouldRemoveNumberAtLastPosition() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int index = 2;
        int[] expected = {1, 2};
        assertArrayEquals(expected, arrayMethods.removeAt(index));
    }

    @Test
    public void shouldThrowExceptionForIndexLessThanZero_removeAt() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int index = -1;
        assertThrows(IndexOutOfBoundsException.class, () -> arrayMethods.removeAt(index));
    }

    @Test
    public void shouldThrowExceptionForIndexGreaterThanArrayLength_removeAt() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int index = 3;
        assertThrows(IndexOutOfBoundsException.class, () -> arrayMethods.removeAt(index));
    }

    @Test
    public void shouldReturnLengthFromEmptyVector() {
        ArrayMethods arrayMethods = new ArrayMethods();
        int expected = 0;
        assertEquals(expected, arrayMethods.getLength());
    }

    @Test
    public void shouldReturnLengthFromVector() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 3;
        assertEquals(expected, arrayMethods.getLength());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithAllOnes() {
        int[] array = {1, 1};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 1;
        assertEquals(expected, arrayMethods.getMax());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithAllZeros() {
        int[] array = {0, 0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 0;
        assertEquals(expected, arrayMethods.getMax());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithOneRepeatedValue() {
        int[] array = {1, 2, 1};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 2;
        assertEquals(expected, arrayMethods.getMax());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithUniqueValues() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 3;
        assertEquals(expected, arrayMethods.getMax());
    }

    @Test
    public void shouldReturnMaxValueFromVectorWithUniqueValuesJustOneElement() {
        int[] array = {1};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 1;
        assertEquals(expected, arrayMethods.getMax());
    }

    @Test
    public void shouldReturnMinValueFromVectorWithAllZeros() {
        int[] array = {0, 0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 0;
        assertEquals(expected, arrayMethods.getMax());
    }

    @Test
    public void shouldReturnMinValueFromVectorWithOneRepeatedValue() {
        int[] array = {1, 2, 1};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 1;
        assertEquals(expected, arrayMethods.getMin());
    }

    @Test
    public void shouldReturnMinValueFromVectorWithUniqueValues() {
        int[] array = {2, 1, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 1;
        assertEquals(expected, arrayMethods.getMin());
    }

    @Test
    public void shouldReturnMinValueFromVectorWithUniqueValuesFirstValIsMin() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 1;
        assertEquals(expected, arrayMethods.getMin());
    }

    @Test
    public void shouldReturnAverageFromVectorPositiveValues() throws EmptyArrayException {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = 2.0;
        assertEquals(expected, arrayMethods.getAverage(array));
    }

    @Test
    public void shouldReturnAverageFromVectorNegativeValues() throws EmptyArrayException {
        int[] array = {-1, -2, -3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = -2.0;
        assertEquals(expected, arrayMethods.getAverage(array));
    }

    @Test
    public void shouldReturnAverageFromVectorWithAllZeroValues() throws EmptyArrayException {
        int[] array = {0, 0, 0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = 0;
        assertEquals(expected, arrayMethods.getAverage(array));
    }

    @Test
    public void shouldReturnExceptionFromEmptyVector_getAverageMethod() {
        int[] array = {};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertThrows(EmptyArrayException.class, () -> arrayMethods.getAverage(array));
    }

    @Test
    public void shouldReturnEvensArrayForAllPositiveNumbers() throws EmptyArrayException {
        int[] array = {1, 2, 3, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {2, 4};
        assertArrayEquals(expected, arrayMethods.getEvenNumbers());
    }

    @Test
    public void shouldReturnEvensArrayForAllPositiveNumbersAndOneZero() throws EmptyArrayException {
        int[] array = {1, 2, 0, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {2, 0, 4};
        assertArrayEquals(expected, arrayMethods.getEvenNumbers());
    }

    @Test
    public void shouldReturnEvensArrayForAllNegativeNumbers() throws EmptyArrayException {
        int[] array = {-1, -2, -3, -4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {-2, -4};
        assertArrayEquals(expected, arrayMethods.getEvenNumbers());
    }

    @Test
    public void shouldReturnEvensArrayForAllZeros() throws EmptyArrayException {
        int[] array = {0, 0, 0, 0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, arrayMethods.getEvenNumbers());
    }

    @Test
    public void shouldReturnEvenNumbersAverageFromVectorPositiveValues() throws EmptyArrayException {
        int[] array = {1, 2, 3, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = 3;
        assertEquals(expected, arrayMethods.getAverageEvenNumbers());
    }

    @Test
    public void shouldReturnEvenNumbersAverageFromVectorNegativeValues() throws EmptyArrayException {
        int[] array = {-1, -2, -3, -4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = -3.0;
        assertEquals(expected, arrayMethods.getAverageEvenNumbers());
    }

    @Test
    public void shouldReturnEvenNumbersAverageFromVectorWithAllZeroValues() throws EmptyArrayException {
        int[] array = {0, 0, 0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = 0;
        assertEquals(expected, arrayMethods.getAverageEvenNumbers());
    }

    @Test
    public void shouldReturnExceptionFromEmptyVector_getAverageEvenNumbers() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertThrows(EmptyArrayException.class, arrayMethods::getAverageEvenNumbers);
    }
    /** START: odds **/
    @Test
    public void shouldReturnOddsArrayForAllPositiveNumbers() {
        int[] array = {1, 2, 3, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {1, 3};
        assertArrayEquals(expected, arrayMethods.getOddNumbers());
    }

    @Test
    public void shouldReturnOddsArrayForAllPositiveNumbersAndOneZero() {
        int[] array = {1, 2, 0, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {1};
        assertArrayEquals(expected, arrayMethods.getOddNumbers());
    }

    @Test
    public void shouldReturnOddsArrayForAllNegativeNumbers() {
        int[] array = {-1, -2, -3, -4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {-1, -3};
        assertArrayEquals(expected, arrayMethods.getOddNumbers());
    }

    @Test
    public void shouldReturnOddsArrayForAllZeros() {
        int[] array = {0, 0, 0, 0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {};
        assertArrayEquals(expected, arrayMethods.getOddNumbers());
    }

    @Test
    public void shouldReturnOddNumbersAverageFromVectorPositiveValues() throws EmptyArrayException {
        int[] array = {1, 2, 3, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = 2.0;
        assertEquals(expected, arrayMethods.getAverageOddNumbers());
    }

    @Test
    public void shouldReturnOddNumbersAverageFromVectorNegativeValues() throws EmptyArrayException {
        int[] array = {-1, -2, -3, -4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = -2.0;
        assertEquals(expected, arrayMethods.getAverageOddNumbers());
    }

    @Test
    public void shouldReturnOddNumbersAverageFromVectorWithAllZeroValues() throws EmptyArrayException {
        int[] array = {0, 0, 0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = 0.0;
        assertEquals(expected, arrayMethods.getAverageOddNumbers());
    }

    @Test
    public void shouldReturnExceptionFromEmptyVector_getAverageOddNumbers() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertThrows(EmptyArrayException.class, arrayMethods::getAverageOddNumbers);
    }

    @Test
    public void shouldReturnMultiplesOfNumberZero() throws EmptyArrayException {
        int[] array = {1, 2, 3, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int number = 0;
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, arrayMethods.getMultiplesOfNumber(number));
    }

    @Test
    public void shouldReturnMultiplesOfNumberTwo() throws EmptyArrayException {
        int[] array = {1, 2, 3, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int number = 2;
        int[] expected = {2, 4};
        assertArrayEquals(expected, arrayMethods.getMultiplesOfNumber(number));
    }

    @Test
    public void shouldThrowExceptionForEmptyVector_getMultiplesOfNumber() {
        ArrayMethods arrayMethods = new ArrayMethods();
        int number = 2;
        assertThrows(EmptyArrayException.class, () -> arrayMethods.getMultiplesOfNumber(number));
    }

    @Test
    public void shouldReturnAverageOfMultiplesOfNumberTwo() throws EmptyArrayException {
        int[] array = {0, 1, 2, 3, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int number = 2;
        double expected = 2.0;
        assertEquals(expected, arrayMethods.getAverageOfMultiples(number));
    }

    @Test
    public void shouldReturnAverageOfMultiplesOfNumberZero() throws EmptyArrayException {
        int[] array = {0, 1, 2, 3, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int number = 0;
        double expected = 2.0;
        assertEquals(expected, arrayMethods.getAverageOfMultiples(number));
    }
    @Test
    public void shouldReturnAverageOfMultiplesOfNumberTwoOnNegativesArray() throws EmptyArrayException {
        int[] array = {0, -1, -2, -3, -4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int number = 0;
        double expected = -2.0;
        assertEquals(expected, arrayMethods.getAverageOfMultiples(number));
    }

    @Test
    public void shouldReturnASCSortedArray() {
        int[] array = {3, 2, 1};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, arrayMethods.sorted(SortingType.ASC));
    }

    @Test
    public void shouldReturnASCSortedArrayWithZero() {
        int[] array = {3, 2, 0, 1};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {0, 1, 2, 3};
        assertArrayEquals(expected, arrayMethods.sorted(SortingType.ASC));
    }

    @Test
    public void shouldReturnASCSortedArrayWithAllZeros() {
        int[] array = {0, 0, 0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, arrayMethods.sorted(SortingType.ASC));
    }

    @Test
    public void shouldReturnASCSortedArrayWithOneElement() {
        int[] array = {0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {0};
        assertArrayEquals(expected, arrayMethods.sorted(SortingType.ASC));
    }

    @Test
    public void shouldReturnDESCSortedArray() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {3, 2, 1};
        assertArrayEquals(expected, arrayMethods.sorted(SortingType.DESC));
    }

    @Test
    public void shouldReturnDESCSortedArrayWithZero() {
        int[] array = {3, 2, 0, 1};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {3, 2, 1, 0};
        assertArrayEquals(expected, arrayMethods.sorted(SortingType.DESC));
    }

    @Test
    public void shouldReturnDESCSortedArrayWithAllZeros() {
        int[] array = {0, 0, 0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, arrayMethods.sorted(SortingType.DESC));
    }

    @Test
    public void shouldReturnDESCSortedArrayWithOneElement() {
        int[] array = {0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {0};
        assertArrayEquals(expected, arrayMethods.sorted(SortingType.DESC));
    }

    @Test
    public void shouldReturnExceptionForEmptyArray() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertThrows(EmptyArrayException.class, () -> arrayMethods.sorted(SortingType.ASC));
    }

    @Test
    public void shouldReturnTrueForEmptyArray() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertTrue(arrayMethods.isEmpty());
    }

    @Test
    public void shouldReturnFalseForArrayNotEmpty() {
        int[] array = {0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertFalse(arrayMethods.isEmpty());
    }

    @Test
    public void shouldReturnTrueForOneElementArray() {
        int[] array = {0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertTrue(arrayMethods.hasOneElement());
    }

    @Test
    public void shouldReturnFalseForArrayWithZeroOrMoreThanOneElements() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertFalse(arrayMethods.hasOneElement());
    }

    @Test
    public void shouldReturnTrueForOneEvenElement() {
        int[] array = {0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertTrue(arrayMethods.hasEvenElements());
    }

    @Test
    public void shouldReturnFalseNoneEvenElements() {
        int[] array = {1, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertFalse(arrayMethods.hasEvenElements());
    }

    @Test
    public void shouldReturnTrueForOneOddElement() {
        int[] array = {1};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertTrue(arrayMethods.hasOddElements());
    }

    @Test
    public void shouldReturnFalseNoneOddElements() {
        int[] array = {0, 2};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertFalse(arrayMethods.hasOddElements());
    }

    @Test
    public void shouldReturnTrueForOneDuplicatedElement() {
        int[] array = {1, 1, 2};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertTrue(arrayMethods.hasDuplicates());
    }

    @Test
    public void shouldReturnFalseForNoneDuplicateElements() {
        int[] array = {0, 2, 3, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertFalse(arrayMethods.hasDuplicates());
    }

    @Test
    public void shouldReturnOneForNumberZero() {
        int[] array = {0, 2, 3, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 1;
        assertEquals(expected, arrayMethods.getDigitsCount(array[0]));
    }

    @Test
    public void shouldReturnOneForNumberWithOneDigit() {
        int[] array = {0, 2, 3, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 1;
        assertEquals(expected, arrayMethods.getDigitsCount(array[1]));
    }

    @Test
    public void shouldReturnTwoForNumberWithTwoDigits() {
        int[] array = {10, 2, 3, 4};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int expected = 2;
        assertEquals(expected, arrayMethods.getDigitsCount(array[0]));
    }

    @Test
    public void shouldReturnMinusOneForEmptyVector() {
        ArrayMethods arrayMethods = new ArrayMethods();
        double expected = -1.0;
        assertEquals(expected, arrayMethods.getDigitsAverage());
    }

    @Test
    public void shouldReturnOneForVectorWithAllZeros() {
        int[] array = {0, 0, 0, 0};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = 1.0;
        assertEquals(expected, arrayMethods.getDigitsAverage());
    }

    @Test
    public void shouldReturnOneForVectorWithNumbersWithOneDigit() {
        int[] array = {0, 2, 3, 9};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = 1.0;
        assertEquals(expected, arrayMethods.getDigitsAverage());
    }

    @Test
    public void shouldReturnTwoForVectorWithNumbersWithTwoDigits() {
        int[] array = {10, 20, 30, 99};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = 2.0;
        assertEquals(expected, arrayMethods.getDigitsAverage());
    }

    @Test
    public void shouldReturnCorrectValueVectorWithMixedNumbersSize() {
        int[] array = {10, 2, 3, 99};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        double expected = 1.5;
        assertEquals(expected, arrayMethods.getDigitsAverage());
    }

    @Test
    public void shouldReturnNumbersWithMoreDigitsThanAverageDigitsInArray() {
        int[] array = {10, 2, 3, 99};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {10, 99};
        assertArrayEquals(expected, arrayMethods.getNumbersWithDigitsBiggerThanAverageDigits());
    }

    @Test
    public void shouldReturnEmptyArrayForNoneDigitsBiggerThanAverageDigitsInArray() {
        int[] array = {1, 2, 3, 9};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {};
        assertArrayEquals(expected, arrayMethods.getNumbersWithDigitsBiggerThanAverageDigits());
    }

    @Test
    public void shouldReturnNullForEmptyArrayInDigitsBiggerThanAverageDigitsInArray() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertNull(arrayMethods.getNumbersWithDigitsBiggerThanAverageDigits());
    }

    @Test
    public void shouldReturnArrayWithOneElementFor1DigitNumber() {
        int number = 0;
        ArrayMethods arrayMethods = new ArrayMethods(new int[0]);
        int[] expected = {0};
        assertArrayEquals(expected, arrayMethods.getDigits(number));
    }

    @Test
    public void shouldReturnArrayWithOneElementForNumber1() {
        int number = 1;
        ArrayMethods arrayMethods = new ArrayMethods();
        int[] expected = {1};
        assertArrayEquals(expected, arrayMethods.getDigits(number));
    }

    @Test
    public void shouldReturnArrayWithTwoElementsFor2DigitsNumber() {
        int number = 10;
        ArrayMethods arrayMethods = new ArrayMethods();
        int[] expected = {1, 0};
        assertArrayEquals(expected, arrayMethods.getDigits(number));
    }

    @Test
    public void shouldReturnThrowExceptionForEmptyVector_getEvenDigitsInVector() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertThrows(EmptyArrayException.class, () -> arrayMethods.getEvenDigitsInVector(arrayMethods.getVector()));
    }

    @Test
    public void shouldReturnArrayWithJustTheEvenDigitsFromAllVectorDigits1DigitNumbers() throws EmptyArrayException {
        int[] array = {0, 1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {0, 2};
        assertArrayEquals(expected, arrayMethods.getEvenDigitsInVector(array));
    }

    @Test
    public void shouldReturnArrayWithJustTheEvenDigitsFromAllVectorDigits2DigitNumbers() throws EmptyArrayException {
        int[] array = {10, 13, 21, 31};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {0, 2};
        assertArrayEquals(expected, arrayMethods.getEvenDigitsInVector(array));
    }

    @Test
    public void shouldReturnArrayWithEvenDigitsCountGreaterThanAverageOfEvenDigitsInVector() throws EmptyArrayException {
        int[] array = {10, 13, 21, 2222};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {2222};
        assertArrayEquals(expected, arrayMethods.getNumberWithEvenDigitsBiggerThanAverageOfEvenDigits());
    }

    @Test
    public void shouldReturnArrayWithEvenDigitsCountGreaterThanAverageOfEvenDigitsInVectorWithOneElementBeingZero() throws EmptyArrayException {
        int[] array = {0, 13, 21, 2222};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {0, 2222};
        assertArrayEquals(expected, arrayMethods.getNumberWithEvenDigitsBiggerThanAverageOfEvenDigits());
    }

    @Test
    public void shouldReturnArrayWithEvenDigitsCountEqualsThanAverageOfEvenDigitsInVector() throws EmptyArrayException {
        int[] array = {21, 21, 21, 21};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {};
        assertArrayEquals(expected, arrayMethods.getNumberWithEvenDigitsBiggerThanAverageOfEvenDigits());
    }

    @Test
    public void shouldThrowExceptionForEmptyArrayToReverse() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertThrows(EmptyArrayException.class, arrayMethods::reversedOrder);
    }

    @Test
    public void shouldReturnReversedOrderArray() {
        int[] array = {1, 2, 3};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {3, 2, 1};
        assertArrayEquals(expected, arrayMethods.reversedOrder());
    }

    @Test
    public void shouldReturnAscendingSequencesForSingleDigits() {
        int[] array = {1, 2, 3, 4};
        int minNumberElements = 0;
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertArrayEquals(array, arrayMethods.getDigitsAscendingSequence(minNumberElements));
    }

    @Test
    public void shouldReturnAscendingSequencesForMoreThanOneDigits() {
        int[] array = {10, 21, 33, 43};
        int minNumberElements = 0;
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {};
        assertArrayEquals(expected, arrayMethods.getDigitsAscendingSequence(minNumberElements));
    }

    @Test
    public void shouldReturnAscendingSequencesForMoreThanOneDigitsAtThreeDigitNumberNotAsc() {
        int[] array = {10, 21, 33, 34, 445};
        int minNumberElements = 0;
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {34};
        assertArrayEquals(expected, arrayMethods.getDigitsAscendingSequence(minNumberElements));
    }

    @Test
    public void shouldReturnAscendingSequencesForMoreThanOneDigitsAtThreeDigitNumberAsc() {
        int[] array = {10, 21, 33, 34, 456};
        int minNumberElements = 0;
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {34, 456};
        assertArrayEquals(expected, arrayMethods.getDigitsAscendingSequence(minNumberElements));
    }

    @Test
    public void shouldReturnAscendingSequencesForMoreThanOneDigitsAtThreeDigitNumberAscNIsThree() {
        int[] array = {10, 21, 33, 34, 456};
        int minNumberElements = 3;
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {456};
        assertArrayEquals(expected, arrayMethods.getDigitsAscendingSequence(minNumberElements));
    }

    @Test
    public void shouldReturnEmptyArrayForNoneAscendingSequences() {
        int[] array = {10, 21, 32, 43};
        int minNumberElements = 0;
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {};
        assertArrayEquals(expected, arrayMethods.getDigitsAscendingSequence(minNumberElements));
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getDigitsAscendingSequence() {
        ArrayMethods arrayMethods = new ArrayMethods();
        int minNumberElements = 0;
        assertThrows(EmptyArrayException.class, () -> arrayMethods.getDigitsAscendingSequence(minNumberElements));
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getPalindromes() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertThrows(EmptyArrayException.class, arrayMethods::getPalindromes);
    }

    @Test
    public void shouldReturnCorrectPalindromes() {
        int[] array = {1, 22, 11, 5, 232};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {22, 11, 232};
        assertArrayEquals(expected, arrayMethods.getPalindromes());
    }

    @Test
    public void shouldReturnCorrectPalindromesWithThreeDigitNotPalindrome() {
        int[] array = {1, 22, 11, 5, 2331};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {22, 11};
        assertArrayEquals(expected, arrayMethods.getPalindromes());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getNumbersWithSameDigits() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertThrows(EmptyArrayException.class, arrayMethods::getNumbersWithSameDigits);
    }

    @Test
    public void shouldReturnCorrectElementsWithEqualDigits() {
        int[] array = {1, 22, 23, 444, 454, 556};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {22, 444};
        assertArrayEquals(expected, arrayMethods.getNumbersWithSameDigits());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_getNotAmstrongNumbers() {
        ArrayMethods arrayMethods = new ArrayMethods();
        assertThrows(EmptyArrayException.class, arrayMethods::getPalindromes);
    }

    @Test
    public void shouldReturnCorrectNotAmstrongNumbers() {
        int[] array = {373, 371};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        int[] expected = {373};
        assertArrayEquals(expected, arrayMethods.getNotAmstrongNumbers());
    }

    @Test
    public void shouldThrowExceptionForEmptyArray_equals() {
        int[] argArray = {1, 2};
        ArrayMethods arrayMethods = new ArrayMethods();
        assertThrows(EmptyArrayException.class, () -> arrayMethods.equals(argArray));
    }

    @Test
    public void shouldThrowExceptionForEmptyArrayEmptyArgArray_equals() {
        int[] array = {1, 2};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertThrows(EmptyArrayException.class, () -> arrayMethods.equals(new int[0]));
    }

    @Test
    public void shouldThrowExceptionForEmptyArrayNullArgArray_equals() {
        int[] array = {1, 2};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertThrows(NullPointerException.class, () -> arrayMethods.equals(null));
    }

    @Test
    public void shouldReturnTrueForArrayEqualsArgArray() {
        int[] array = {1, 2};
        int[] argArray = {1, 2};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertTrue(arrayMethods.equals(argArray));
    }

    @Test
    public void shouldReturnFalseForArrayEqualsArgArray() {
        int[] array = {1, 2};
        int[] argArray = {1};
        ArrayMethods arrayMethods = new ArrayMethods(array);
        assertFalse(arrayMethods.equals(argArray));
    }
}
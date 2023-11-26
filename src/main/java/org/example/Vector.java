package org.example;

import java.lang.reflect.MalformedParametersException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Vector {
    private final int[] vector;

    public Vector() {
        this(new int[0]);
    }

    public Vector(int[] vector) {
        this.vector = vector;
    }

    public int[] getVector() {
        return vector;
    }

    public int[] getVectorFromEmptyConstructor() {
        return vector;
    }

    public int getValueAt(int index) throws IndexOutOfBoundsException {
        return vector[index];
    }

    public int indexOf(int number) {
        if (vector.length == 0) throw new NullPointerException();
        int index = 0;
        for (int currentValue : vector) {
            if (number == currentValue) break;
            index++;
        }

        if (index == vector.length) return -1;

        return index;
    }

    public int[] add(int number) {
        int[] extendedVector = new int[vector.length + 1];
        for (int i = 0; i < vector.length; i++) extendedVector[i] = vector[i];
        extendedVector[extendedVector.length - 1] = number;
        return extendedVector;
    }

    public int[] removeAt(int index) throws IndexOutOfBoundsException {
        int[] shortenedVector = new int[vector.length - 1];
        for (int i = 0, currIndex = 0; i < vector.length; i++) {
            if (vector[i] != vector[index]) {
                shortenedVector[currIndex] = vector[i];
                currIndex++;
            }
        }
        return shortenedVector;
    }

    public int getLength() {
        return vector.length;
    }

    public int getMax() {
        int maxVal = vector[0];
        for (int currNumber : vector) maxVal = Math.max(currNumber, maxVal);
        return maxVal;
    }

    public int getMin() {
        int minVal = vector[0];
        for (int currNumber : vector) minVal = Math.min(currNumber, minVal);
        return minVal;
    }

    protected double getAverage(int[] array) {
        if (vector.length == 0) throw new ArithmeticException("Cannot divide by zero");
        int sum = 0;
        for (int value : array) sum += value;
        return (double) sum / array.length;
    }

    protected int[] getEvenNumbers() {
        if (vector.length == 0) throw new MalformedParametersException("Array can't be empty");
        int arrayLength = getEvenNumbersLength();
        int[] evenNumbersArray = new int[arrayLength];
        for (int i = 0, currIndex = 0; i < vector.length; i++) {
            if (vector[i] == 0) {
                evenNumbersArray[currIndex] = vector[i];
                currIndex++;
                continue;
            }
            if (vector[i] % 2 == 0) {
                evenNumbersArray[currIndex] = vector[i];
                currIndex++;
            }
        }
        // could also not return anything and inject the value onto a private field
        return evenNumbersArray;
    }

    private int getEvenNumbersLength() {
        int count = 0;
        for (int number : vector) {
            if (number == 0) {
                count++;
                continue;
            }
            if (number % 2 == 0) count++;
        }
        return count;
    }

    public double getAverageEvenNumbers() {
        return getAverage(getEvenNumbers());
    }

    protected int[] getOddNumbers() {
        if (vector.length == 0) throw new MalformedParametersException("Array can't be empty");
        int arrayLength = getOddNumbersLength();
        int[] oddsArray = new int[arrayLength];
        for (int i = 0, currIndex = 0; i < vector.length; i++) {
            if (vector[i] == 0) continue;
            if (vector[i] % 2 != 0) {
                oddsArray[currIndex] = vector[i];
                currIndex++;
            }
        }
        // could also not return anything and inject the value onto a private field
        return oddsArray;
    }

    private int getOddNumbersLength() {
        int count = 0;
        for (int number : vector) {
            if (number == 0) continue;
            if (number % 2 != 0) count++;
        }
        return count;
    }

    public double getAverageOddNumbers() {
        int[] oddNumbers = getOddNumbers();
        return oddNumbers.length > 0 ? getAverage(oddNumbers) : 0.0;
    }

    protected int[] getMultiplesOfNumber(int number) {
        if (vector.length == 0) throw new ArithmeticException("Cannot divide by zero");
        if (number == 0) return vector;

        int[] multiples = new int[getMultiplesLength(number)];
        int currIndex = 0;
        for (int n : vector)
            if (n % number == 0) {
                multiples[currIndex] = n;
                currIndex++;
            }
        return multiples;
    }

    private int getMultiplesLength(int number) {
        int count = 0;
        for (int n : vector) if (n % number == 0) count++;
        return count;
    }

    public double getAverageOfMultiples(int number) {
        return getAverage(getMultiplesOfNumber(number));
    }

    public int[] sorted(SortingType sortingType) {
        if (vector.length == 0) throw new MalformedParametersException("Array can't be empty");

        int[] sortedArray = Arrays.copyOf(vector, vector.length);

        if (sortingType == SortingType.ASC) {
            Arrays.sort(sortedArray);
            return sortedArray;
        }

        Integer[] reverseSort = Arrays.stream(sortedArray).boxed().toArray(Integer[]::new);
        Arrays.sort(reverseSort, Collections.reverseOrder());

        for (int i = 0; i < sortedArray.length; i++) sortedArray[i] = reverseSort[i];

        return sortedArray;
    }

    public boolean isEmpty() {
        return vector.length == 0;
    }

    public boolean hasOneElement() {
        return vector.length == 1;
    }

    public boolean hasEvenElements() {
        return getEvenNumbersLength() != 0;
    }

    public boolean hasOddElements() {
        return getOddNumbersLength() != 0;
    }

    public boolean hasDuplicates() {
        return countDuplicates() > 0;
    }

    private int countDuplicates() {
        int count = 0;
        for (int i = 0; i < vector.length; i++) {
            for (int j = 1; j < vector.length; j++) {
                if (i == j) continue;
                if (vector[i] == vector[j]) count++;
            }
        }

        return count;
    }

    /**START: s) **/
    protected int getDigitsCount(int number) {
        if (number == 0) return 1;
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    protected double getDigitsAverage() {
        if (vector.length == 0) return -1.0;
        int sum = 0;
        for (int number : vector) sum += getDigitsCount(number);
        return (double) sum / vector.length;
    }

    public int[] getNumbersWithDigitsBiggerThanAverageDigits() {
        double average = getDigitsAverage();
        if (average == -1.0) return null;
        List<Integer> result = new ArrayList<>();
        for (int number : vector) {
            if (getDigitsCount(number) > average) {
                result.add(number);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    /** END: s) **/

    /** START: t) **/
    protected int[] getDigits(int number) {
        if (number == 0) return new int[] {0};
        List<Integer> result = new ArrayList<>();
        while (number != 0) {
            result.add(number % 10);
            number /= 10;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /** START: u) **/
    protected int[] getEvenDigitsInVector(int[] array) {
        if (array.length == 0) throw new MalformedParametersException("Array can't be empty");
        List<Integer> result = new ArrayList<>();
        for (int number : array) {
            int[] digits = getDigits(number);
            for (int digit : digits) if (digit % 2 == 0) result.add(digit);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    /** END: u) **/

    private int getDigitsCountFromVector() {
        int count = 0;
        for (int number : vector) count += getDigits(number).length;
        return count;
    }

    private double getAverageEvenDigits(int[] array, int totalCount) {
        return (double) getEvenDigitsInVector(array).length / totalCount;
    }

    public int[] getNumberWithEvenDigitsBiggerThanAverageOfEvenDigits() {
        double averageEvenDigitsInVector = getAverageEvenDigits(vector, getDigitsCountFromVector());
        List<Integer> result = new ArrayList<>();
        for (int number : vector) {
            int[] currentElementDigits = getDigits(number);
            if (getAverageEvenDigits(currentElementDigits, currentElementDigits.length) > averageEvenDigitsInVector) {
                result.add(number);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    /** END: t) **/

    //TODO: v)
    //TODO: w)
    //TODO: x)
    //TODO: y)
    //TODO: z)
    //TODO: aa)
}

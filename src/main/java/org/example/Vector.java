package org.example;

import org.example.utils.EmptyArrayException;
import org.example.utils.SortingType;

import java.util.*;
import java.util.stream.Collectors;

public class Vector {
    private final int[] vector;

    public Vector() {
        this.vector = new int[0];
    }

    public Vector(int[] vector) {
        this.vector = Arrays.copyOf(vector, vector.length);
    }

    public int[] getVector() {
        return Arrays.copyOf(vector, vector.length);
    }

    public int getValueAt(int index) throws IndexOutOfBoundsException {
        return vector[index];
    }

    public int indexOf(int number) {
        if (isEmpty()) throw new EmptyArrayException();
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
        if (isEmpty()) throw new EmptyArrayException();
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
        if (isEmpty()) throw new EmptyArrayException();
        int maxVal = vector[0];
        for (int currNumber : vector) maxVal = Math.max(currNumber, maxVal);
        return maxVal;
    }

    public int getMin() {
        if (isEmpty()) throw new EmptyArrayException();
        int minVal = vector[0];
        for (int currNumber : vector) minVal = Math.min(currNumber, minVal);
        return minVal;
    }

    protected double getAverage(int[] array) {
        if (array.length == 0) throw new EmptyArrayException();
        int sum = 0;
        for (int value : array) sum += value;
        return (double) sum / array.length;
    }

    protected int[] getEvenNumbers() {
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
        if (isEmpty()) throw new EmptyArrayException();
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
        if (isEmpty()) throw new EmptyArrayException();

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
        if (isEmpty()) throw new EmptyArrayException();
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
        if (isEmpty()) throw new EmptyArrayException("Cannot divide by zero.");
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
        if (isEmpty()) throw new EmptyArrayException();
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
        if (isEmpty()) throw new EmptyArrayException();
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
        int[] digits = new int[getDigitsCount(number)];
        int index = digits.length - 1;
        while (number != 0) {
            digits[index] = number % 10;
            number /= 10;
            index--;
        }

        return digits;
    }

    /** START: u) **/
    protected int[] getEvenDigitsInVector(int[] array) {
        if (array.length == 0) throw new EmptyArrayException("Array can't be empty");
        List<Integer> result = new ArrayList<>();
        for (int number : array) {
            int[] digits = getDigits(number);
            for (int digit : digits) if (digit % 2 == 0) result.add(digit);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    /** END: u) **/

    public int getDigitsCountFromVector() {
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

    public int[] reversedOrder() {
        if (vector.length == 0) throw new EmptyArrayException();
        int[] reversedVector = new int[vector.length];
        for (int i = 0, j = vector.length - 1; i < vector.length; i++, j--) {
            reversedVector[i] = vector[j];
        }
        return reversedVector;
    }

    public int[] getDigitsAscendingSequence(int minNumberElements) {
        if (vector.length == 0) throw new EmptyArrayException();
        List<Integer> ascDigitsList = new ArrayList<>();
        for (int number : vector) {
            int[] digits = getDigits(number);
            if (isAscOrder(digits, minNumberElements)) ascDigitsList.add(number);
        }
        return ascDigitsList.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isAscOrder(int[] digits, int minNumberElements) {
        if (digits.length == 1) return true;
        if (digits.length < minNumberElements) return false;

        int previousDigit = digits[0];
        for (int i = 1; i < digits.length; i++) {
            if (previousDigit >= digits[i]) return false;
        }
        return true;
    }

    public int[] getPalindromes() {
        if (isEmpty()) throw new EmptyArrayException();
        List<Integer> palindromes = new ArrayList<>();
        for (int number : vector) {
            int[] digits = getDigits(number);
            if (isPalindrome(digits)) palindromes.add(number);
        }
        return palindromes.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isPalindrome(int[] digits) {
        if (digits.length == 1) return false;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != digits[digits.length - 1 - i]) return false;
        }
        return true;
    }

    public int[] getNumbersWithSameDigits() {
        if (vector.length == 0) throw new EmptyArrayException();
        List<Integer> sameDigits = new ArrayList<>();
        for (int number : vector) {
            int[] digits = getDigits(number);
            if (isSameDigits(digits)) sameDigits.add(number);
        }
        return sameDigits.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isSameDigits(int[] digits) {
        if (digits.length == 1) return false;
        int prevDigit = digits[0];
        for (int digit : digits) {
            if (digit != prevDigit) return false;
        }
        return true;
    }

    public int[] getNotAmstrongNumbers() {
        if (isEmpty()) throw new EmptyArrayException();

        List<Integer> notAmstrong = new ArrayList<>();
        for (int number : vector) {
            int[] digits = getDigits(number);
            if (!isAmstrong(digits, number)) notAmstrong.add(number);
        }

        return notAmstrong.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isAmstrong(int[] digits, int number) {
        int sum = 0;
        for (int l : digits) {
            sum += (int) Math.pow(l, 3);
        }

        return sum == number;
    }

    public boolean equals(int[] array) throws NullPointerException {
        if (isEmpty()) throw new EmptyArrayException();
        if (array.length == 0) throw new EmptyArrayException();
        List<Integer> argArray = Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> objArray = Arrays.stream(vector).boxed().collect(Collectors.toList());

        return objArray.equals(argArray);
    }
}

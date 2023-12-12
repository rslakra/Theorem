package com.devamatre.theorem.adts;

import com.devamatre.appsuite.core.Sets;
import com.devamatre.theorem.adts.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @created 9/19/23 1:57 PM
 */
public enum AlgoUtils {
    INSTANCE;

    /**
     * The maximum size of array to allocate (unless necessary). Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in OutOfMemoryError: Requested array size exceeds VM limit
     */
    public static final int SIZE = 8;
    public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - SIZE;
    public static final int DEFAULT_SIZE = SIZE * 2;
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 100;

    private static final Logger LOGGER = LoggerFactory.getLogger(AlgoUtils.class);

    /**
     * Shared empty array instance used for default sized empty instances. We distinguish this from
     * DEFAULT_EMPTY_ELEMENTS to know how much to inflate when first element is added.
     */
    private static final Object[] DEFAULT_EMPTY_ELEMENTS = {};

    /**
     * Returns true if the index is valid.
     *
     * @param arr
     * @param index
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> boolean isValidIndex(T[] arr, int index) {
        return (index >= 0 && index < arr.length);
    }

    /**
     * Swaps the elements at the <code>source</code> index with the <code>target</code> index in the <code>input</code>
     * array.
     *
     * @param input
     * @param source
     * @param target
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void swapElements(T[] input, int source, int target) {
        LOGGER.trace("-swapElements({}, {}, {})", input, source, target);
        if (isValidIndex(input, source) && isValidIndex(input, target)) {
            T temp = input[source];
            input[source] = input[target];
            input[target] = temp;
        }
    }

    /**
     * Checks the <code>minCapacity</code>.
     *
     * @param minCapacity
     */
    public static void checkOutOfMemoryError(int minCapacity) {
        if (minCapacity < 0) { // overflow
            throw new OutOfMemoryError();
        }
    }

    /**
     * Returns a capacity at least as large as the given minimum capacity. Returns the current capacity increased by 50%
     * if that suffices. Will not return a capacity greater than MAX_ARRAY_SIZE unless the given minimum capacity is
     * greater than MAX_ARRAY_SIZE.
     *
     * @param minCapacity the desired minimum capacity
     * @param elements
     * @param minCapacity
     * @return
     * @throws OutOfMemoryError if minCapacity is less than zero
     */
    private static int newCapacity(Object[] elements, int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elements == DEFAULT_EMPTY_ELEMENTS) {
                return Math.max(DEFAULT_SIZE, minCapacity);
            }

            checkOutOfMemoryError(minCapacity);
            return minCapacity;
        }

        return (newCapacity - MAX_ARRAY_SIZE <= 0) ? newCapacity : maxCapacity(minCapacity);
    }

    /**
     * Returns the max capacity of an array.
     *
     * @param minCapacity
     * @return
     */
    private static int maxCapacity(int minCapacity) {
        checkOutOfMemoryError(minCapacity);
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    /**
     * Grows the capacity of an array.
     *
     * @param elements
     * @param minCapacity
     * @return
     */
    public static Object[] growCapacity(Object[] elements, int minCapacity) {
        elements = Arrays.copyOf(elements, newCapacity(elements, minCapacity));
        return elements;
    }

    /**
     * Prints the <code>elements</code>.
     *
     * @param elements
     * @param <T>
     */
    public static <T> void printElements(List<T> elements) {
        for (int i = 0; i < elements.size(); i++) {
            System.out.print(elements.get(i));
            if (i < elements.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * @param elements
     * @param <T>
     */
    public static <T> void printArray(T[] elements) {
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i]);
            if (i < elements.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * @param elements
     */
    public static <T> void print2DArray(T[][] elements) {
        for (T[] array : elements) {
            for (T item : array) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * @param message
     */
    public static void print(Object message) {
        System.out.print(message);
    }

    /**
     * @param list
     */
    public static void print(List<String> list) {
        System.out.println("----------------------------------------------------");
        for (String str : list) {
            System.out.print(str + ", ");
        }
        System.out.println();
    }

    /**
     * @param message
     */
    public static void println(Object message) {
        System.out.println(message);
    }

    /**
     *
     */
    public static void println() {
        System.out.println();
    }

    /**
     * Generates an array of unique <code>Integer</code>(s) of the <code>size</code> with <code>upperBound</code>.
     *
     * @param size
     * @param upperBound
     * @param firstElementEmpty
     * @return
     */
    public static Integer[] uniqueIntArrayGenerator(int size, int upperBound, boolean firstElementEmpty) {
        final Set<Integer> result = new LinkedHashSet<>();
        final Random random = new Random();
        if (firstElementEmpty) {
            result.add(null);
        }

        while (result.size() < size) {
            result.add(random.nextInt(upperBound));
        }

        return result.toArray(new Integer[0]);
    }

    /**
     * Generates the set of unique <code>Integer</code>(s) of the <code>size</code> with <code>upperBound</code>.
     *
     * @param size
     * @param upperBound
     * @return
     */
    public static Set<Integer> uniqueIntSetGenerator(int size, int upperBound) {
        return Sets.asSet(uniqueIntArrayGenerator(size, upperBound, false));
    }

    /**
     * Generates the list of unique <code>Integer</code>(s) of the <code>size</code> with <code>upperBound</code>.
     *
     * @param size
     * @param upperBound
     * @return
     */
    public static List<Integer> uniqueIntListGenerator(int size, int upperBound) {
        return Arrays.asList(uniqueIntArrayGenerator(size, upperBound, false));
    }

    /**
     * Generates an array of unique <code>Integer</code>(s) of the <code>size</code> with <code>upperBound</code>.
     *
     * @param size
     * @param upperBound
     * @param firstElementEmpty
     * @return
     */
    public static Integer[] randomIntArrayGenerator(int size, int upperBound, boolean firstElementEmpty) {
        final Random random = new Random();
        final List<Integer> result = new ArrayList<>();
        if (firstElementEmpty) {
            result.add(null);
        }

        while (result.size() < size) {
            result.add(random.nextInt(upperBound));
        }

        return result.toArray(new Integer[0]);
    }

    /**
     * Generates the list of <code>Integer</code>(s) of the <code>size</code> with <code>upperBound</code>.
     *
     * @param size
     * @param upperBound
     * @return
     */
    public static List<Integer> randomIntListGenerator(int size, int upperBound) {
        return Arrays.asList(randomIntArrayGenerator(size, upperBound, false));
    }

    /**
     * @param size
     * @return
     */
    public static Integer[] positiveIntArrayGenerator(int size, boolean firstElementEmpty) {
        LOGGER.debug("+positiveIntArrayGenerator({}, {})", size, firstElementEmpty);
        Integer[] result = new Integer[size];
        int index = firstElementEmpty ? 1 : 0;
        while (index < size) {
            LOGGER.trace("index:{}", index);
            result[index] = Integer.valueOf(index);
            index++;
        }

        LOGGER.debug("-positiveIntArrayGenerator(), result:{}", Arrays.toString(result));
        return result;
    }

    /**
     * @param size
     * @return
     */
    public static List<Integer> positiveIntListGenerator(int size) {
        return Arrays.asList(positiveIntArrayGenerator(size, false));
    }

    /**
     * @param size
     * @return
     */
    public static Set<Integer> positiveIntSetGenerator(int size) {
        return Sets.asSet(positiveIntArrayGenerator(size, false));
    }

    /**
     * Returns true if all the elements are null.
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> boolean isAllNull(List<T> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param list
     * @param <T>
     */
    public static <T> void printAsList(List<T> list) {
        int count = 0;
        for (T t : list) {
            count++;
            System.out.print(t);
            if (count % 10 != 0) {
                System.out.print("\t");
            } else {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * @param deque
     * @param <T>
     */
    public static <T> void printDeque(Deque<T> deque) {
        int count = 0;
        for (T t : deque) {
            count++;
            System.out.print(t);
            if (count % 10 != 0) {
                System.out.print("\t");
            } else {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        System.out.println("Matrix is: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------");
    }

    /**
     * @param matrix
     */
    public static void printMatrixGeneric(boolean[][] matrix) {
        System.out.println("Matrix is: ");
        for (boolean[] row : matrix) {
            for (boolean t : row) {
                System.out.print(t + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------");

    }

    /**
     * @param res
     * @param <T>
     */
    public static <T> void print2DList(List<List<T>> res) {
        for (List<T> list : res) {
            for (T i : list) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    /**
     * @param intervals
     */
    public static void printIntervals(List<Interval> intervals) {
        for (Interval interval : intervals) {
            System.out.print("[" + interval.getStart() + ", " + interval.getEnd() + "], ");
        }
        System.out.println();
    }

}

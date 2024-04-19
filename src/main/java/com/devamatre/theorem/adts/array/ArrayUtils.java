package com.devamatre.theorem.adts.array;

import com.devamatre.appsuite.core.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/08/2017 9:55 PM
 */
public enum ArrayUtils {

    INSTANCE;
    public static final String NEW_LINE = "\n";
    public static final Integer MINUS_ONE = Integer.valueOf(-1);
    public static final String CLONE = "clone";

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayUtils.class);

    /**
     * Returns an index of the maximum value in the list.
     *
     * @param inputData
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int findMaxValueIndex(List<Integer> inputData, int startIndex, int endIndex) {
        int maxValueIndex = startIndex;
        int maxValue = inputData.get(startIndex);
        for (int i = startIndex + 1; i < endIndex; i++) {
            if (inputData.get(i) > maxValue) {
                maxValue = inputData.get(i);
                maxValueIndex = i;
            }
        }

        return maxValueIndex;
    }

    /**
     * Returns an index of the maximum value in the list.
     *
     * @param inputData
     * @return
     */
    public static int findMaxValueIndex(List<Integer> inputData) {
        return findMaxValueIndex(inputData, 0, inputData.size());
    }

    /**
     * Returns the maximum value index.
     *
     * @param inputData
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int findMaxValueIndex(Integer[] inputData, int startIndex, int endIndex) {
        int maxIndex = startIndex;
        int max = inputData[startIndex];
        for (int i = startIndex + 1; i < endIndex; i++) {
            if (inputData[i] > max) {
                max = inputData[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    /**
     * Returns the maximum value index.
     *
     * @param inputData
     * @return
     */
    public static int findMaxValueIndex(Integer[] inputData) {
        return findMaxValueIndex(inputData, 0, inputData.length);
    }

    /**
     * Replace <code>null</code> with <code>-1</code>.
     *
     * @param inputData
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void replaceNullWithMinusOne(List<E> inputData) {
        if (BeanUtils.isNotEmpty(inputData)) {
            for (int i = 0; i < inputData.size(); i++) {
                if (inputData.get(i) == null) {
                    inputData.set(i, (E) MINUS_ONE);
                }
            }
        }
    }

    /**
     * Fills the <code>inputData</code> with the provided <code>defaultValue</code> to each element of the specified
     * range of the specified <code>size</code>. The range to be filled extends from index 0 inclusive, to index
     * <code>size</code>, exclusive.
     *
     * @param inputData
     * @param size
     * @param defaultValue
     */
    public static <E extends Comparable<? super E>> void fillList(List<E> inputData, int size, E defaultValue) {
        for (int i = 0; i < size; i++) {
            inputData.add(defaultValue);
        }
    }

    /**
     * Initializes the generic multidimensional array with the provided size.
     *
     * @param classType
     * @param rows
     * @param columns
     * @param <T>
     * @return
     */
    public static <T> T[][] initMultiDimensionArray(Class<T> classType, int rows, int columns) {
        return (T[][]) Array.newInstance(classType, rows, columns);
    }

    /**
     * Initializes the generic one dimensional array with the provided size.
     *
     * @param classType
     * @param size
     * @param <T>
     * @return
     */
    public static <T> T[] initArray(Class<T> classType, int size) {
        return (T[]) Array.newInstance(classType, size);
    }

    /**
     * Initializes the generic array with the given size.
     *
     * @param size
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> E[] initArray(int size, Class<E> classType) {
        return initArray(classType, size);
    }

    /**
     * @param size
     * @return
     */
    public static Integer[] initIntArray(int size) {
        return initArray(size, Integer.class);
    }

    /**
     * Converts the <code>List<E></code> to an array of an <code>E</code> type.
     *
     * @param inputData
     * @param <E>
     * @return
     * @see <code>(E[]) Array.newInstance(data.getComponentType(), data.size())</code>
     */
    public static <E> E[] asArray(List<E> inputData, Class<E> classType) {
        return inputData.toArray(initArray(classType, inputData.size()));
    }

    /**
     * Converts the <code>List<Integer></code> to an array of an <code>Integer</code> type.
     *
     * @param inputData
     * @return
     * @see <code>(E[]) Array.newInstance(data.getComponentType(), data.size())</code>
     */
    public static <E extends Comparable<? super E>> Integer[] asIntArray(List<E> inputData) {
        return asArray((List<Integer>) inputData, Integer.class);
    }

    /**
     * @param inputData
     * @return
     */
    public static Integer[] asIntArray(int[] inputData) {
        return Arrays.stream(inputData).boxed().toArray(Integer[]::new);
    }

    /**
     * Converts the <code>List<E></code> to an array of an <code>E</code> type.
     *
     * @param inputData
     * @param <E>
     * @return
     * @see <code>(E[]) Array.newInstance(data.getComponentType(), data.size())</code>
     */
    public static <E extends Comparable<? super E>> List<List<E>> asList(Object[][] inputData) {
        final List<List<E>> listOfList = new ArrayList<>();
        if (Objects.nonNull(inputData)) {
            for (Object[] objects : inputData) {
                listOfList.add(Arrays.stream(objects).map(item -> (E) item).collect(Collectors.toList()));
            }
        }

        return listOfList;
    }

    /**
     * @param inputData
     * @return
     */
    public static List<Integer> asIntList(int[] inputData) {
        return Arrays.stream(inputData).boxed().collect(Collectors.toList());
    }

    /**
     * @param inputData
     * @return
     */
    public static List<List<Integer>> asIntList(int[][] inputData) {
        List<List<Integer>> inputList = new ArrayList<>();
        for (int[] input : inputData) {
            inputList.add(asIntList(input));
        }
        return inputList;
    }

    /**
     * @param list
     * @param classType
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> E[] clone(List<E> list, Class<E> classType) {
        return null;
    }

    /**
     * Returns true if the object is an array otherwise false.
     *
     * @param object
     * @return
     */
    public static boolean isArray(final Object object) {
        return (object != null && object.getClass().isArray());
    }

    /**
     * Returns true if the <code>cloneObject</code> is cloneable otherwise false.
     *
     * @param cloneObject
     * @return
     */
    public static boolean isCloneable(Object cloneObject) {
        return (Objects.nonNull(cloneObject) && (cloneObject instanceof Cloneable || Cloneable.class.isAssignableFrom(
            cloneObject.getClass())));
    }

    /**
     * Make a <code>clone</code> method call of the <code>cloneObject</code> object.
     *
     * @param cloneObject
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> E invokeCloneMethod(final E cloneObject) {
        if (isCloneable(cloneObject)) {
            try {
                return (E) cloneObject.getClass().getMethod(CLONE).invoke(cloneObject);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
                throw new RuntimeException(ex);
            }
        }

        return null;
    }

    /**
     * Clone an cloneObject if possible.
     *
     * <p>This method is similar to {@link #(Object).clone(Comparable)} (Object)}, but will return the provided
     * instance as the return value instead of {@code null} if the instance is not cloneable. This is more convenient if
     * the caller uses different implementations (e.g. of a service) and some of the implementations do not allow
     * concurrent processing or have state. In such cases the implementation can simply provide a proper clone
     * implementation and the caller's code does not have to change.</p>
     *
     * @param cloneObject
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> E cloneIfPossible(final E cloneObject) {
        Object objectCloned = null;
        if (isCloneable(cloneObject)) {
            if (isArray(cloneObject)) {
                final Class<?> componentType = cloneObject.getClass().getComponentType();
                if (componentType.isPrimitive()) {
                    int length = Array.getLength(cloneObject);
                    objectCloned = Array.newInstance(componentType, length);
                    while (length-- > 0) {
                        Array.set(objectCloned, length, Array.get(cloneObject, length));
                    }
                } else {
                    // objectCloned = ((Object[]) cloneObject).clone();
                }
            } else {
                objectCloned = invokeCloneMethod(cloneObject);
            }
        }

        return (E) objectCloned;
    }

    /**
     * Prints the single dimension array.
     *
     * @param data
     */
    public static <E> void printArray(E[] data) {
        System.out.println(Arrays.toString(data));
    }

    /**
     * Prints the 2D (two-dimensional) array.
     *
     * @param matrix
     */
    public static <E> void printMatrix(E[][] matrix) {
        TablePrettyPrinter.buildPrettyPrinter().prettyPrint(matrix);
    }

    /**
     * Prints the <code>data</code> diagonally.
     *
     * @param data
     */
    public static <E> void printDiagonally(E[][] data) {
        LOGGER.trace("+printDiagonally({})", data);
        // print left to bottom.
        for (int row = 0; row < data.length; row++) {
            for (int i = 0; i < ((data.length * 2) - row); i++) {
                System.out.print(" ");
            }
            for (int column = 0; column <= row; column++) {
                if (row == 0 || column == 0) {
                    System.out.print(data[row][column] + " ");
                } else {
                    System.out.print(data[row - column][column] + " ");
                }
            }
            System.out.println();
        }
        LOGGER.trace("-printDiagonally()");
    }

    /**
     * Returns the index of an element in an array.
     *
     * @param input
     * @param index
     * @return
     */
    public static int findParent(int[] input, int index) {
        if (index < 0 || index >= input.length) {
            return -1;
        } else if (input[index] == index) {
            return index;
        }

        return findParent(input, input[index]);
    }

    /**
     * Recursively, updates the value of the parent at the provided <code>vertex</code> with the provided
     * <code>value</code>.
     *
     * @param parent
     * @param vertex
     * @param value
     * @return
     */
    public static int union(int[] parent, int vertex, int value) {
        LOGGER.trace("+union({}, {}, {})", parent, vertex, value);
        if (parent[vertex] != vertex) {
            parent[vertex] = union(parent, parent[vertex], value);
        } else {
            parent[vertex] = value;
        }

        LOGGER.trace("-union(), parent[{}]:{}", vertex, parent[vertex]);
        return parent[vertex];
    }

    /**
     * Returns the <code>int[]</code> for the provided <code>Integer[]</code>.
     *
     * @return
     */
    public static int[] toIntArray(Integer[] inputData) {
        return Arrays.stream(inputData).mapToInt(Integer::intValue).toArray();
    }

    /**
     * Returns the <code>int[]</code> for the provided <code>Integer[]</code>.
     *
     * @return
     */
    public static int[] toIntArray(List<Integer> inputData) {
        return inputData.stream().mapToInt(Integer::intValue).toArray();
    }

}

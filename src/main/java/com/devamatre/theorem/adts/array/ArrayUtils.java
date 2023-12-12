package com.devamatre.theorem.adts.array;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.tree.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/08/2017 9:55 PM
 */
public enum ArrayUtils {

    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayUtils.class);

    /**
     * Returns the maximum value index.
     *
     * @param data
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int findMaxIndex(Integer[] data, int startIndex, int endIndex) {
        int maxIndex = startIndex;
        int max = data[startIndex];
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (data[i] > max) {
                max = data[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    /**
     * Returns the maximum value index.
     *
     * @param data
     * @return
     */
    public static int findMaxIndex(Integer[] data) {
        return findMaxIndex(data, 0, data.length - 1);
    }

    /**
     * Replace <code>null</code> with <code>-1</code>.
     *
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void replaceNullWithMinus(List<E> data) {
        if (BeanUtils.isNotEmpty(data)) {
            /**
             * TODO: FIX ME! Add Generic Implementation here instead of hard coding Integer objects.
             */
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i) == null) {
                    data.set(i, (E) TreeUtils.MINUS_ONE);
                }
            }
        }
    }

    /**
     * Initializes the generic array with the given size.
     *
     * @param size
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> E[] initArray(int size) {
        LOGGER.debug("initArray({})", size);
        return ((E[]) new Object[size]);
    }

    /**
     * TODO: FIX ME! Add Generic Implementation here instead of hard coding Integer objects.
     *
     * @param list
     * @param <E>
     * @return
     * @see <code>(E[]) Array.newInstance(data.getComponentType(), data.size())</code>
     */
    public static <E extends Comparable<? super E>> E[] toIntArray(List<E> list) {
        return (E[]) list.toArray(new Integer[0]);
    }

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

//    /**
//     * Clone an object.
//     *
//     * @param object
//     * @param <E>
//     * @return
//     */
//    public static <E extends Comparable<? super E>> E clone(final E object) {
//        if (object instanceof Cloneable) {
//            final Object result;
//            if (isArray(object)) {
//                final Class<?> componentType = object.getClass().getComponentType();
//                if (componentType.isPrimitive()) {
//                    int length = Array.getLength(object);
//                    result = Array.newInstance(componentType, length);
//                    while (length-- > 0) {
//                        Array.set(result, length, Array.get(object, length));
//                    }
//                } else {
////                    result = ((Object[]) object).clone();
//                }
//            } else {
//                final Method clone;
//                try {
//                    clone = object.getClass().getMethod("clone");
//                    result = clone.invoke(object);
//                } catch (NoSuchMethodException e) {
//                    throw new RuntimeException(e);
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                } catch (InvocationTargetException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            @SuppressWarnings("unchecked") // OK because input is of type E
//            final E checked = (E) result;
//            return checked;
//        }
//
//        return null;
//    }
//
//    /**
//     * Clone an object if possible.
//     *
//     * <p>This method is similar to {@link #clone(Comparable)} (Object)}, but will return the provided
//     * instance as the return value instead of {@code null} if the instance is not cloneable. This is more convenient if
//     * the caller uses different implementations (e.g. of a service) and some of the implementations do not allow
//     * concurrent processing or have state. In such cases the implementation can simply provide a proper clone
//     * implementation and the caller's code does not have to change.</p>
//     *
//     * @param <E> the type of the object
//     * @param object the object to clone, null returns null
//     * @return the clone if the object implements {@link Cloneable} otherwise the object itself
//     * @since 3.0
//     */
//    public static <E> E cloneIfPossible(final E object) {
//        final E clone = clone(object);
//        return clone == null ? object : clone;
//    }


    /**
     * Prints the single dimension array.
     *
     * @param data
     */
    public static <E> void printMatrix(E[] data) {
        System.out.print(Arrays.toString(data));
    }

    /**
     * Prints the two-dimensional array.
     *
     * @param data
     */
    public static <E> void printMatrix(E[][] data) {
        for (int i = 0; i < data.length; i++) {
            printMatrix(data[i]);
            System.out.println();
        }
    }

    /**
     * Prints the <code>data</code> diagonally.
     *
     * @param data
     */
    public static <E> void printDiagonally(E[][] data) {
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
    }

}

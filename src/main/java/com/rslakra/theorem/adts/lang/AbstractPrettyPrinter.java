package com.rslakra.theorem.adts.lang;

import static java.lang.String.format;

import com.rslakra.theorem.adts.PrettyPrinter;
import com.rslakra.theorem.adts.array.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 1/14/24 2:10 PM
 */
public abstract class AbstractPrettyPrinter<E> implements PrettyPrinter<E> {

    protected static final int BUFFER = 1024;
    private static final String BORDER_KNOT = "+";
    private static final String HORIZONTAL_BORDER = "-";
    private static final String VERTICAL_BORDER = "|";
    protected static final String NULL = "(null)";

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPrettyPrinter.class);
    private Writer output;
    private final String defaultValue;

    /**
     * @param output
     * @param defaultValue
     */
    public AbstractPrettyPrinter(Writer output, String defaultValue) {
        LOGGER.trace("+AbstractPrettyPrinter({}, {})", output, defaultValue);
        if (Objects.isNull(output)) {
            throw new IllegalArgumentException("The output stream must provide!");
        }
        if (Objects.isNull(defaultValue)) {
            throw new IllegalArgumentException("The default value must provide!");
        }
        this.output = output;
        this.defaultValue = defaultValue;
        LOGGER.trace("-AbstractPrettyPrinter()");
    }

    /**
     * @param output
     */
    public AbstractPrettyPrinter(Writer output) {
        this(output, NULL);
    }

    /**
     *
     */
    public AbstractPrettyPrinter() {
        this(new StringWriter(BUFFER));
    }

    /**
     * Returns the maximum number of columns (in case the elements columns are not consistent).
     *
     * @param elements
     * @return
     */
    private int countMaxColumns(List<List<E>> elements) {
        LOGGER.trace("+countMaxColumns({})", elements);
        int maxColumns = 0;
        if (Objects.nonNull(elements)) {
            for (List<?> columns : elements) {
                if (Objects.nonNull(columns) && columns.size() > maxColumns) {
                    maxColumns = columns.size();
                }
            }
        }

        LOGGER.trace("-countMaxColumns(), maxColumns:{}", maxColumns);
        return maxColumns;
    }

    /**
     * Returns the maximum number of columns (in case the elements columns are not consistent).
     *
     * @param elements
     * @return
     */
    private int countMaxColumns(E[][] elements) {
        LOGGER.trace("+countMaxColumns({})", Arrays.toString(elements));
        int maxColumns = 0;
        for (E[] columns : elements) {
            if (Objects.nonNull(columns) && columns.length > maxColumns) {
                maxColumns = columns.length;
            }
        }

        LOGGER.trace("-countMaxColumns(), maxColumns:{}", maxColumns);
        return maxColumns;
    }

    /**
     * Returns the value of the <code>columns</code> at the provided <code>index</code>.
     *
     * @param columns
     * @param index
     * @return
     */
    private E getCellValue(List<E> columns, int index) {
        LOGGER.trace("getCellValue({}, {})", columns, index);
        return index < columns.size() ? columns.get(index) : null;
    }

    /**
     * Returns the value of the <code>columns</code> at the provided <code>index</code>.
     *
     * @param columns
     * @param index
     * @return
     */
    private int getCellValueLength(List<E> columns, int index) {
        return toString(getCellValue(columns, index)).length();
    }

    /**
     * Returns the value of the <code>columns</code> at the provided <code>index</code>.
     *
     * @param columns
     * @param index
     * @return
     */
    private E getCellValue(E[] columns, int index) {
        LOGGER.trace("getCellValue({}, {})", Arrays.toString(columns), index);
        return index < columns.length ? columns[index] : null;
    }

    /**
     * @param element
     * @return
     */
    private String toString(E element) {
        return Objects.toString(element, defaultValue);
    }

    /**
     * Adjusts the tuple/row columns width.
     *
     * @param rowColumns
     * @param columnWidths
     */
    private void adjustTupleColumnsWidth(List<E> rowColumns, List<Integer> columnWidths) {
        LOGGER.trace("+adjustTupleColumnsWidth({}, {})", rowColumns, columnWidths);
        if (Objects.nonNull(rowColumns)) {
            for (int column = 0; column < columnWidths.size(); column++) {
                final int cellValueLength = getCellValueLength(rowColumns, column);
                if (columnWidths.get(column) < cellValueLength) {
                    LOGGER.trace("column:{}, cellValueLength:{}", column, cellValueLength);
                    columnWidths.set(column, cellValueLength);
                }
            }
        }
        LOGGER.trace("-adjustTupleColumnsWidth(), columnWidths:{}", columnWidths);
    }

    /**
     * Adjusts the column width based on the actual width of the column.
     *
     * @param elements
     * @param columnWidths
     */
    private void adjustColumnWidths(List<List<E>> elements, List<Integer> columnWidths) {
        LOGGER.trace("+adjustColumnWidths({}, {})", elements, columnWidths);
        for (List<E> rowColumns : elements) {
            adjustTupleColumnsWidth(rowColumns, columnWidths);
        }
        LOGGER.trace("-adjustColumnWidths(), columnWidths:{}", columnWidths);
    }

    /**
     * @param elements
     * @param columnWidths
     */
    private void adjustColumnWidths(E[][] elements, List<Integer> columnWidths) {
        LOGGER.trace("+adjustColumnWidths({}, {})", elements, columnWidths);
        for (final E[] rowColumns : elements) {
            if (Objects.nonNull(rowColumns)) {
                for (int column = 0; column < columnWidths.size(); column++) {
                    final int cellValueLength = getCellValueLength(Arrays.asList(rowColumns), column);
                    if (columnWidths.get(column) < cellValueLength) {
                        LOGGER.trace("column:{}, cellValueLength:{}", column, cellValueLength);
                        columnWidths.set(column, cellValueLength);
                    }
                }
            }
        }
        LOGGER.trace("-adjustColumnWidths(), columnWidths:{}", columnWidths);
    }

    /**
     * Builds the horizontal border based on the <code>columnWidths</code>.
     *
     * @param columnWidths
     * @return
     */
    private String buildHorizontalBorder(List<Integer> columnWidths) {
        LOGGER.trace("+buildHorizontalBorder({})", columnWidths);
        final StringBuilder rowBuilder = new StringBuilder(256);
        rowBuilder.append(BORDER_KNOT);
        columnWidths.forEach(width -> {
            fillBuilder(rowBuilder, width, HORIZONTAL_BORDER);
            rowBuilder.append(BORDER_KNOT);
        });

        LOGGER.trace("-buildHorizontalBorder(), rowBuilder:{}", rowBuilder);
        return rowBuilder.toString();
    }

    /**
     * @param inputData
     * @param width
     * @return
     */
    private static String padRight(String inputData, int width) {
        return format("%1$-" + width + "s", inputData);
    }

    /**
     * Builds the row with columns data and borders.
     * <p>
     * <pre>
     *  System.out.println(
     *    Arrays.deepToString(matrix) .replace("],", "\n") .replace(",", "\t| ").replaceAll("[\\[\\]]"," ")
     *  );
     * </pre>
     *
     * @param rowColumns
     * @param columnWidths
     * @param lineLength
     * @return
     */
    private String buildTableRow(List<E> rowColumns, List<Integer> columnWidths, int lineLength) {
        LOGGER.trace("+buildTableRow({}, {}, {})", rowColumns, columnWidths, lineLength);
        final StringBuilder rowBuilder = new StringBuilder(lineLength).append(VERTICAL_BORDER);
        // max width of the columns
        for (int i = 0; i < columnWidths.size(); i++) {
            rowBuilder
                .append(padRight(toString(getCellValue(rowColumns, i)), columnWidths.get(i)))
                .append(VERTICAL_BORDER);
        }

        LOGGER.trace("-buildTableRow(), rowBuilder:{}", rowBuilder);
        return rowBuilder.toString();
    }

    /**
     * Pretty prints the row of the table.
     *
     * @param rowColumns
     * @param columnWidths
     * @param rowBorder
     * @throws IOException
     */
    private void prettyPrintTableRow(List<E> rowColumns, List<Integer> columnWidths, String rowBorder)
        throws IOException {
        LOGGER.trace("+prettyPrintTableRow({}, {}, {})", rowColumns, columnWidths, rowBorder);
        if (Objects.nonNull(rowColumns)) {
            // print each rowColumns elements
            output.append(ArrayUtils.NEW_LINE).append(buildTableRow(rowColumns, columnWidths, rowBorder.length()));
            // print a rowColumns border after each rowColumns (kind of last rowColumns of the table)
            output.append(ArrayUtils.NEW_LINE).append(rowBorder);
        }
        LOGGER.trace("-prettyPrintTableRow(), writer:{}", output.toString());
    }

    /**
     * Prints the pretty table.
     *
     * @param elements
     * @param columnWidths
     * @param rowBorder
     */
    private void prettyPrintTable(List<List<E>> elements, List<Integer> columnWidths, String rowBorder)
        throws IOException {
        LOGGER.trace("+prettyPrintTable({}, {}, {})", elements, columnWidths, rowBorder);
        // print first row border
        output.append(ArrayUtils.NEW_LINE).append(rowBorder);
        for (List<E> rowColumns : elements) {
            prettyPrintTableRow(rowColumns, columnWidths, rowBorder);
        }
        LOGGER.trace("-prettyPrintTable()");
    }

    /**
     * Prints the pretty table.
     *
     * @param elements
     * @param columnWidths
     * @param rowBorder
     */
    private void prettyPrintTable(E[][] elements, List<Integer> columnWidths, String rowBorder) throws IOException {
        LOGGER.trace("+prettyPrintTable({}, {}, {})", elements, columnWidths, rowBorder);
        // print first row border
        output.append(ArrayUtils.NEW_LINE).append(rowBorder);
        for (E[] rowColumns : elements) {
            // keeping this double if check in case an array has null row
            if (Objects.nonNull(rowColumns)) {
                prettyPrintTableRow(Arrays.asList(rowColumns), columnWidths, rowBorder);
            }
        }
        LOGGER.trace("-prettyPrintTable()");
    }

    /**
     * Initializes the column width.
     *
     * @param maxColumns
     * @return
     */
    private List<Integer> initColumnWidths(int maxColumns) {
        List<Integer> columnWidths = new ArrayList<>(maxColumns);
        for (int i = 0; i < maxColumns; i++) {
            columnWidths.add(0);
        }

        return columnWidths;
    }

    /**
     * Prints the pretty <code>elements</code> horizontally.
     *
     * @param elements
     */
    @Override
    public void prettyPrint(List<List<E>> elements) {
        if (Objects.isNull(elements)) {
            throw new IllegalArgumentException("The tabular data must provide!");
        } else if (elements.isEmpty()) {
            return;
        }

        try {
            // count max columns
            int maxColumns = countMaxColumns(elements);
            final List<Integer> columnWidths = initColumnWidths(maxColumns);
            adjustColumnWidths(elements, columnWidths);
            prettyPrintTable(elements, columnWidths, buildHorizontalBorder(columnWidths));
            System.out.println(this);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    /**
     * Prints the pretty <code>elements</code>.
     *
     * @param elements
     */
    @Override
    public void prettyPrint(E[][] elements) {
        if (Objects.isNull(elements)) {
            throw new IllegalArgumentException("The tabular data must provide!");
        } else if (elements.length == 0) {
            return;
        }
        try {
            // max columns
            int maxColumns = countMaxColumns(elements);
            final List<Integer> columnWidths = initColumnWidths(maxColumns);
            adjustColumnWidths(elements, columnWidths);
            prettyPrintTable(elements, columnWidths, buildHorizontalBorder(columnWidths));
            System.out.println(this);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return output.toString();
    }
}

package com.devamatre.theorem.adts.tree.data.loader;

import com.devamatre.theorem.adts.tree.AbstractTree;

/**
 * @author Rohtash Lakra
 * @created 12/21/23 8:33 AM
 */
public interface TreeHierarchicalDataLoader<E extends Comparable<? super E>> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    AbstractTree<E> fillHierarchicalData(AbstractTree<E> tree);

    /**
     * Returns the <code>TreeHierarchicalDataLoader</code> object for the <code>hierarchicalType</code>.
     *
     * @param hierarchicalType
     * @return
     */
    static TreeHierarchicalDataLoader createDataLoader(TreeHierarchicalType hierarchicalType) {
        switch (hierarchicalType) {
            case ANIMAL_BIOLOGICAL:
                return new AnimalBiologicalTreeHierarchicalDataLoader();

            case CLUSTER:
                return new ClusterTreeHierarchicalDataLoader();

            case CONTINENT:
                return new ContinentTreeHierarchicalDataLoader();

            case NUMERIC:
                return new NumericTreeHierarchicalDataLoader();

            case OPERATOR:
                return new OperatorTreeHierarchicalDataLoader();

            case POLYGON:
                return new PolygonTreeHierarchicalDataLoader();

            case WEB_PAGE:
                return new WebPageTreeHierarchicalDataLoader();

            default:
                return new AnimalHypotheticalTreeHierarchicalDataLoader();
        }
    }

}

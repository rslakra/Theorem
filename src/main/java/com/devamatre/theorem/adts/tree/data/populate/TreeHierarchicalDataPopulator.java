package com.devamatre.theorem.adts.tree.data.populate;

import com.devamatre.theorem.adts.tree.AbstractTree;

/**
 * @author Rohtash Lakra
 * @created 12/21/23 8:33 AM
 */
public interface TreeHierarchicalDataPopulator<E extends Comparable<? super E>> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    AbstractTree<E> fillHierarchicalData(AbstractTree<E> tree);

    /**
     * Returns the <code>TreeHierarchicalDataPopulator</code> object for the <code>hierarchicalType</code>.
     *
     * @param hierarchicalType
     * @return
     */
    public static TreeHierarchicalDataPopulator createHierarchicalDataPopulator(TreeHierarchicalType hierarchicalType) {
        switch (hierarchicalType) {
            case ANIMAL_BIOLOGICAL:
                return new AnimalBiologicalTreeHierarchicalDataPopulator();

            case CLUSTER:
                return new ClusterTreeHierarchicalDataPopulator();

            case CONTINENT:
                return new ContinentTreeHierarchicalDataPopulator();

            case NUMERIC:
                return new NumericTreeHierarchicalDataPopulator();

            case POLYGON:
                return new PolygonTreeHierarchicalDataPopulator();

            case WEB_PAGE:
                return new WebPageTreeHierarchicalDataPopulator();

            default:
                return new AnimalHypotheticalTreeHierarchicalDataPopulator();
        }
    }

}

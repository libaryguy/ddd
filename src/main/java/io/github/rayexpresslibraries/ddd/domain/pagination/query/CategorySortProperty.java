package io.github.rayexpresslibraries.ddd.domain.pagination.query;

/**
 * example use of {@link SortProperty}
 */
class CategorySortProperty extends SortProperty {

    /**
     * Domain property that can use for Sort.
     * Limiting them
     */
    private static final String[] properties = {"name", "status"};

    public CategorySortProperty() {
        super(properties);
    }

    @Override
    public String getDefaultProperty() {
        return properties[0];
    }
}

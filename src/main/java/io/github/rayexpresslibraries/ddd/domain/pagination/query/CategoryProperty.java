package io.github.rayexpresslibraries.ddd.domain.pagination.query;

/**
 * example use of {@link Property}
 */
class CategoryProperty extends Property {

    /**
     * Domain property that can use for Sort/search.
     * Limiting them
     */
    private static final String[] properties = {"name", "status"};

    public CategoryProperty() {
        super(properties);
    }

    @Override
    public String getDefaultProperty() {
        return properties[0];
    }
}

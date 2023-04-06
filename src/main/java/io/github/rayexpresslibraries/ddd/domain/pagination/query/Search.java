package io.github.rayexpresslibraries.ddd.domain.pagination.query;

public class Search {
    private final String attributeName;
    private final String attributeValue;

    private Search(final String attributeName, final String attributeValue) {
        if (isEmpty(attributeName)) {
            throw new IllegalArgumentException("attributeName must not be empty");
        }
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    private static Search by(final String[] sort, Property aProperty) {
        try {
            final String property = sort[0];
            final String value = sort[1];
            return new Search(aProperty.getDomainProperty(property), value);
        } catch (Exception e) {
            return Search.unsarched();
        }
    }

    public static Search by(final String attributeName, final String attributeValue) {
        return new Search(attributeName, attributeValue);
    }


    public static Search by(final String[] search, Class<? extends Property> property) {
        try {
            return Search.by(search, property.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            return Search.unsarched();
        }
    }

    public static Search unsarched() {
        return new Search(null, null);
    }

    public boolean hasSearch() {
        return attributeName != null;
    }

    private boolean isEmpty(final String v) {
        return v != null && (v.isEmpty() || v.trim().isEmpty() || v.isBlank() || v.trim().isBlank());
    }

    public String attributeName() {
        return attributeName;
    }

    public String attributeValue() {
        return attributeValue;
    }
}

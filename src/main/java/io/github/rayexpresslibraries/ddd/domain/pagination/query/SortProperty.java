package io.github.rayexpresslibraries.ddd.domain.pagination.query;

import java.util.Arrays;

/**
 * Domain properties that should be used for Sort.
 * Without this, anyone can access your domain property outside.
 * So you must limit what people can use for sort there.
 * See an exemple of usage here {@link CategorySortProperty}
 */
public abstract class SortProperty {

    private final String[] values;

    protected SortProperty(String[] values) {
        this.values = values;
    }

    public abstract String getDefaultProperty();

    public String getDomainProperty(final String p) {
        return Arrays.stream(values).filter(v -> v.equalsIgnoreCase(p)).findFirst().orElse(getDefaultProperty());
    }
}
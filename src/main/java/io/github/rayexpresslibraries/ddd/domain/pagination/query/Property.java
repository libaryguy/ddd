package io.github.rayexpresslibraries.ddd.domain.pagination.query;

import java.util.Arrays;

public abstract class Property {

    private final String[] values;

    protected Property(String[] values) {
        this.values = values;
    }

    public abstract String getDefaultProperty();

    public String getDomainProperty(final String p) {
        return Arrays.stream(values).filter(v -> v.equalsIgnoreCase(p)).findFirst().orElse(getDefaultProperty());
    }
}
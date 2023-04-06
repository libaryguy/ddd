package io.github.rayexpresslibraries.ddd.domain.pagination.query;

import java.util.Arrays;

/**
 * Domain properties that should be used for Sort or Search.
 * Without this, anyone can access your domain property outside.
 * So you must limit what people can use for sort/search there.
 * See an exemple of usage here {@link CategoryProperty}
 */
public abstract class Property {

    protected final String[] values;

    protected Property(String[] values) {
        this.values = values;
    }

    public String getDefaultProperty(){
        if (values == null || values.length == 0) return "";
        return this.values[0];
    }

    public String getDomainProperty(final String p) {
        return Arrays.stream(values).filter(v -> v.equalsIgnoreCase(p)).findFirst().orElse(getDefaultProperty());
    }
}
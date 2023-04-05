package io.github.rayexpresslibraries.ddd.domain.pagination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public record Pagination<T>(
        int page,
        int size,
        long total,
        List<T> items
) {
    public <R> Pagination<R> map(final Function<T, R> mapper) {
        final List<R> newList = this.items.stream().map(mapper).toList();
        return new Pagination<>(page(), size(), total(), newList);
    }

    /**
     * @return Default Pagination with:
     * * page = 0
     * * size = 10
     */
    public static <T> Pagination<T> standard(List<T> items) {
        final List<T> list = items == null ? Collections.emptyList() : new ArrayList<>(items);
        return new Pagination<>(0, 10, list.size(), list);
    }
}

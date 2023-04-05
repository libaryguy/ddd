package io.github.rayexpresslibraries.ddd.domain.pagination.query;

import com.rayllanderson.rayexpress.category.domain.category.CategorySortProperty;

public final class SortFactory {
    private SortFactory() {
    }

    /**
     * @param sort array que precisa conter, nesta ordem: '[0] - property' e '[1] - direction'
     */
    public static Sort categorySort(final String[] sort) {
        return Sort.by(sort, CategorySortProperty.class);
    }

    public static Sort categorySort(final String property, final Direction direction) {
        return Sort.by(property, direction, CategorySortProperty.class);
    }

    public static Sort categoryAscSort(final String property) {
        return Sort.by(property, Direction.ASC, CategorySortProperty.class);
    }

    public static Sort categoryDescSort(final String property) {
        return Sort.by(property, Direction.DESC, CategorySortProperty.class);
    }
}

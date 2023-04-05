package io.github.rayexpresslibraries.ddd.domain.pagination.query;

import java.util.Optional;

public record SearchQuery(
        int currentPage,
        int pageSize,
        String search,
        Sort sort
) {
    public String sortDirection() {
        return Optional.ofNullable(sort)
                .map(Sort::direction)
                .orElseGet(Sort::defaultDirection)
                .name();
    }

    public String sortProperty() {
        return Optional.ofNullable(sort)
                .map(Sort::property)
                .orElse("");
    }
}


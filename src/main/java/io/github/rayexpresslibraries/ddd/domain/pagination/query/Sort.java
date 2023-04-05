package io.github.rayexpresslibraries.ddd.domain.pagination.query;

class Sort {
    private final String property;
    private final Direction direction;

    private Sort(String property, Direction direction) {
        this.property = property;
        this.direction = direction;
    }

    public String property() {
        return this.property;
    }

    public Direction direction() {
        return this.direction;
    }

    private static Sort by(final String[] sort, Property aProperty) {
        if (sort == null || sort.length == 0) return Sort.unsorted();
        final String property = sort[0];
        try {
            final String direction = sort[1];
            return new Sort(aProperty.getDomainProperty(property), Direction.valueOf(direction.toUpperCase()));
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            return new Sort(property, defaultDirection());
        }
    }

    protected static Sort by(final String[] sort, Class<? extends Property> aProperty) {
        try {
            return Sort.by(sort, aProperty.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            return new Sort("", defaultDirection());
        }
    }

    protected static Sort by(final String property, final Direction direction, final Class<? extends Property> aProperty) {
        try {
            return Sort.by(new String[]{property, direction.name()}, aProperty.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            return new Sort("", defaultDirection());
        }
    }

    protected static Direction defaultDirection() {
        return Direction.ASC;
    }

    private static Sort unsorted() {
        return new Sort("", defaultDirection());
    }

    @Override
    public String toString() {
        return "Sort{" +
                "property='" + property + '\'' +
                ", direction=" + direction +
                '}';
    }
}

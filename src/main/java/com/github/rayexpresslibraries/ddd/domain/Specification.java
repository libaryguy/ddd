package com.github.rayexpresslibraries.ddd.domain;

public interface Specification<T> {
    boolean isSatisfiedBy(T t);
}
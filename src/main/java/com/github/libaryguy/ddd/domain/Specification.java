package com.github.libaryguy.ddd.domain;

public interface Specification<T> {
    boolean isSatisfiedBy(T t);
}
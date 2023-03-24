package com.github.libaryguy.ddd.application;

public abstract class UseCase<IN, OUT> {

    public abstract OUT execute(IN input);
}

package io.github.rayexpresslibraries.ddd.application;

public abstract class UnitUseCase<IN> {

    public abstract void execute(IN input);
}

package io.github.rayexpresslibraries.ddd.domain.exceptions;

public class InvalidArgumentException extends NoStacktraceException {

    public InvalidArgumentException(final String aMessage) {
        super(aMessage);
    }
}

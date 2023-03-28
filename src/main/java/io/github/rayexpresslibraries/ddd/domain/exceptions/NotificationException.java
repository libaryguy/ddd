package io.github.rayexpresslibraries.ddd.domain.exceptions;


import io.github.rayexpresslibraries.ddd.domain.validation.handler.Notification;

public class NotificationException extends DomainException {

    public NotificationException(final String aMessage, final Notification notification) {
        super(aMessage, notification.getErrors());
    }
}

package com.github.libaryguy.ddd.domain.exceptions;


import com.github.libaryguy.ddd.domain.validation.handler.Notification;

public class NotificationException extends DomainException {

    public NotificationException(final String aMessage, final Notification notification) {
        super(aMessage, notification.getErrors());
    }
}

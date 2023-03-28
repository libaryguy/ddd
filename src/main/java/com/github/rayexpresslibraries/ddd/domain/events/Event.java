package com.github.rayexpresslibraries.ddd.domain.events;

import java.io.Serializable;
import java.time.Instant;

public interface Event extends Serializable {
    Instant occurredOn();
}

package io.github.rayexpresslibraries.ddd.domain;

import io.github.rayexpresslibraries.ddd.domain.events.Event;
import io.github.rayexpresslibraries.ddd.domain.events.EventPublisher;
import io.github.rayexpresslibraries.ddd.domain.validation.ValidatorHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Entity<ID extends Identifier> {
    protected final ID id;
    private final List<Event> domainEvents;

    protected Entity(final ID id) {
        this(id, null);
    }

    protected Entity(final ID id, final List<Event> domainEvents) {
        Objects.requireNonNull(id, "'id' should not be null");
        this.id = id;
        this.domainEvents = new ArrayList<>(domainEvents == null ? Collections.emptyList() : domainEvents);
    }

    public abstract void validate(ValidatorHandler validationHandler);

    public ID getId() {
        return id;
    }

    public List<Event> getDomainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }

    public void clearDomainEvents() {
        this.domainEvents.clear();
    }

    public void registerEvent(final Event event) {
        if (event == null) return;

        this.domainEvents.add(event);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity<?> entity = (Entity<?>) o;
        return getId().equals(entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

package com.mail.app.client.engine.eventbus;

import com.google.gwt.event.shared.EventHandler;

/**
 * Root class for all GWT events.
 * 
 * @param <H>
 *            - handler type.
 */
public abstract class GwtEventSupport<H extends EventHandler> {
    private EventKey<H> eventKey;

    public GwtEventSupport(EventKey<H> eventKey) {
        this.eventKey = eventKey;
    }

    /**
     * Get current event key. Used by {@link EventBusController} during firing
     * some event/s to retrieve current event key of specified event.
     * 
     * @return current event key.
     */
    public EventKey<H> getCurrentEventKey() {
        return eventKey;
    }

    /**
     * Unique event class used to register events on the event bus. Unique event
     * is parameterized by the handler type in order to make the addHandler
     * method type safe.
     * 
     * @param <H>
     *            - handler type.
     */
    public static class EventKey<H> extends com.google.web.bindery.event.shared.Event.Type<H> {
    }

    /**
     * Should only be called by {@link EventBusController}. In other words, do
     * not use or call.
     * 
     * @param handler
     *            - handler.
     */
    public abstract void dispatch(H handler);
}

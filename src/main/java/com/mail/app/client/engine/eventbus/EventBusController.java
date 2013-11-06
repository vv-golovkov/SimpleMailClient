package com.mail.app.client.engine.eventbus;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.shared.EventHandler;
import com.mail.app.client.engine.eventbus.GwtEventSupport.EventKey;
import com.smartgwt.client.util.SC;

/**
 * Event Bus implementation.
 * 
 */
public class EventBusController {
    
    /**
     * Event bus. Map key is {@link EventKey} of simple or parameterized event
     * and map value is {@link EventHandler} of simple or parameterized event
     * handler.
     */
    private static final Map<EventKey<?>, EventHandler> BUS = new HashMap<EventKey<?>, EventHandler>();

    /**
     * Add handler to event bus.
     * 
     * @param eventKey
     *            - event key.
     * @param handler
     *            - appropriate handler.
     */
    public final <H extends EventHandler> void addHandler(EventKey<H> eventKey, H handler) {
        BUS.put(eventKey, handler);
    }

    /**
     * Fire specified event.
     * 
     * @param specifiedEvent
     *            - event to dispatch.
     */
    @SuppressWarnings("unchecked")
    public final <H extends EventHandler> void fireEvent(GwtEventSupport<H> specifiedEvent) {
        H handlerForSpecifiedEvent = (H) BUS.get(specifiedEvent.getCurrentEventKey());
        if (handlerForSpecifiedEvent == null) {
            SC.warn("Did not find specified event in the EventBus[" + specifiedEvent.getCurrentEventKey() + "]");
            return;
        }
        specifiedEvent.dispatch(handlerForSpecifiedEvent);
    }
}

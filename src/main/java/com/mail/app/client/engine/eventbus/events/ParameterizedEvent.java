package com.mail.app.client.engine.eventbus.events;

import com.mail.app.client.engine.eventbus.GwtEventSupport;
import com.mail.app.client.engine.eventbus.GwtEventSupport.EventKey;
import com.mail.app.client.engine.eventbus.handlers.ParameterizedEventHandler;

/**
 * Class for creating parameterized events. To create event/s, just needs to add
 * {@link EventKey} initialization with 'event_' prefix and relevant event name.
 * 
 */
public class ParameterizedEvent extends GwtEventSupport<ParameterizedEventHandler> {
    
    public ParameterizedEvent(GwtEventSupport.EventKey<ParameterizedEventHandler> eventKey) {
        super(eventKey);
    }

    @Override
    public void dispatch(ParameterizedEventHandler handler) {
        handler.onOperationPerformed(this);
    }
}

package com.mail.app.client.engine.eventbus.handlers;

import com.google.gwt.event.shared.EventHandler;
import com.mail.app.client.engine.eventbus.events.ParameterizedEvent;

/**
 * Interface for parameterized event handlers. All event handlers with
 * parameters implement {@link ParameterizedEventHandler}.
 * 
 */
public interface ParameterizedEventHandler extends EventHandler {
    
    /**
     * Method will be called when some {@link ParameterizedEvent} has been
     * fired.
     * 
     * @param result
     *            - value should be passed along with {@link ParameterizedEvent}
     *            .
     */
    void onOperationPerformed(ParameterizedEvent result);
}
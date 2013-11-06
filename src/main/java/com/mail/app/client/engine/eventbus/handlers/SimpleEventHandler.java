package com.mail.app.client.engine.eventbus.handlers;

import com.google.gwt.event.shared.EventHandler;
import com.mail.app.client.engine.eventbus.events.SimpleEvent;

/**
 * Interface for simple event handlers. All simple event handlers implement
 * {@link SimpleEventHandler}.
 * 
 */
public interface SimpleEventHandler extends EventHandler {
    
    /**
     * Method will be called when some {@link SimpleEvent} has been fired.
     */
    void onOperationPerformed();
}

package com.mail.app.client.engine.history;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

/**
 * History handler class.
 */
public class HistoryEngine implements ValueChangeHandler<String> {

    public void onValueChange(ValueChangeEvent<String> event) {
        final String historyToken = event.getValue();
    }
}

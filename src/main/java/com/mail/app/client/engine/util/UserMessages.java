package com.mail.app.client.engine.util;

import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;

public class UserMessages {

    public void showLoading(String message) {
        SC.showPrompt(message);
    }
    
    public void hideLoading() {
        SC.clearPrompt();
    }

    public void showInformation(String infoMessage) {
        inform(infoMessage);
    }

    public void showInformation(String infoMessage, BooleanCallback booleanCallback) {
        inform(infoMessage, booleanCallback);
    }

    public void showWarning(String warningMessage) {
        warn(warningMessage);
    }

    public void showWarning(String warningMessage, BooleanCallback booleanCallback) {
        warn(warningMessage, booleanCallback);
    }

    /****************************************** PRIVATE ******************************************/
    private void warn(String message) {
        SC.warn(message);
    }

    private void warn(String message, BooleanCallback booleanCallback) {
        SC.warn(message, booleanCallback);
    }

    private void inform(String message) {
        SC.say(message);
    }

    private void inform(String message, BooleanCallback booleanCallback) {
        SC.say(message, booleanCallback);
    }
}

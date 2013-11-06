package com.mail.app.client;

import com.google.gwt.core.client.EntryPoint;
import com.mail.app.client.engine.util.UserMessages;
import com.mail.app.client.mvc.controller.BaseController;
import com.mail.app.client.mvc.controller.core.AbstractController;
import com.mail.app.client.mvc.view.BaseView;

public class SimpleMailClient implements EntryPoint {

    public void onModuleLoad() {
        /*HistoryManager history = new HistoryManager();
        history.apply();*/
        
        AbstractController<?> controller = new BaseController(new BaseView(), new UserMessages());
        controller.loadView();
    }
}

package com.mail.app.client.mvc.controller;

import com.mail.app.client.engine.util.UserMessages;
import com.mail.app.client.mvc.controller.core.AbstractController;
import com.mail.app.client.mvc.view.BaseView;
import com.mail.app.shared.transport.DefServiceResponse;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;

public class BaseController extends AbstractController<BaseView> {
    public BaseController(BaseView view, UserMessages userMessages) {
        super(view, userMessages);
    }

    @Override
    protected void createEventHandlers() {
        view.addReceiveButtonHandler(new ReceiveClickHandler());
    }

    class ReceiveClickHandler implements ClickHandler {
        public void onClick(ClickEvent event) {
            userMessages.showLoading("Receiving...");
            rpc.receive(new ReceiceCallback());
        }
    }

    class ReceiceCallback extends CommonDefCallback {
        public void onSuccess(DefServiceResponse result) {
            userMessages.hideLoading();
            System.out.println("hello");
        }
    }
}

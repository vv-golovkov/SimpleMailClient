package com.mail.app.client.mvc.controller.core;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mail.app.client.engine.eventbus.EventBusController;
import com.mail.app.client.engine.util.UserMessages;
import com.mail.app.client.mvc.view.core.AbstractViewProvider;
import com.mail.app.client.service.BaseService;
import com.mail.app.client.service.BaseServiceAsync;
import com.mail.app.shared.transport.DefServiceResponse;

public abstract class AbstractController<T extends AbstractViewProvider> {
    protected static final EventBusController eventBus = new EventBusController();
    protected final UserMessages userMessages;
    protected final T view;
    
    protected BaseServiceAsync rpc = BaseService.Util.getInstance();

    public AbstractController(T view, UserMessages userMessages) {
        this.view = view;
        this.userMessages = userMessages;
    }

    public final void loadView() {
        view.load();
        createEventHandlers();
    }

    /****************************************** ABSTRACT ******************************************/
    protected abstract void createEventHandlers();

    /****************************************** COMMON ******************************************/
    protected abstract class CommonDefCallback implements AsyncCallback<DefServiceResponse> {
        public void onFailure(Throwable exception) {
            userMessages.hideLoading();
            String errorMessage = exception.getMessage();
            userMessages.showWarning(errorMessage);
        }
    }
}

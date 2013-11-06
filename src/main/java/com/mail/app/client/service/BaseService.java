package com.mail.app.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mail.app.shared.exception.CoreServiceException;
import com.mail.app.shared.transport.DefServiceResponse;
import com.mail.app.shared.transport.MessageDto;

@RemoteServiceRelativePath("rpcServices/BaseService.rpc")
public interface BaseService extends RemoteService {

    public static final class Util {
        private static final BaseServiceAsync INSTANCE = GWT.create(BaseService.class);

        private Util() {
        }

        public static BaseServiceAsync getInstance() {
            return INSTANCE;
        }
    }

    DefServiceResponse receive() throws CoreServiceException;
    DefServiceResponse send(MessageDto message) throws CoreServiceException;

}

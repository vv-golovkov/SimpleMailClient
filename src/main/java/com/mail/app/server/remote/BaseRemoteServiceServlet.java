package com.mail.app.server.remote;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mail.app.client.service.BaseService;
import com.mail.app.server.mail.receive.MailReader;
import com.mail.app.shared.exception.CoreServiceException;
import com.mail.app.shared.transport.DefServiceResponse;
import com.mail.app.shared.transport.MessageDto;

public class BaseRemoteServiceServlet extends RemoteServiceServlet implements BaseService {
    private static final long serialVersionUID = 1L;

    public DefServiceResponse receive() throws CoreServiceException {
        new MailReader();
        return new DefServiceResponse(null);
    }

    public DefServiceResponse send(MessageDto message) throws CoreServiceException {
        return null;
    }
}

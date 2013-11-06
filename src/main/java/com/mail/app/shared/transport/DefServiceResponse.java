package com.mail.app.shared.transport;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class DefServiceResponse implements IsSerializable {
    private List<MessageDto> messages;

    /************************************** CONSTRUCTORS **************************************/
    private DefServiceResponse() {}

    public DefServiceResponse(List<MessageDto> messages) {
        this.messages = messages;
    }

    /************************************** GETTERS **************************************/
    public List<MessageDto> getMessagesResponse() {
        return messages;
    }

    /************************************** METHODS **************************************/
    public static DefServiceResponse stub() {
        return new DefServiceResponse();
    }
}

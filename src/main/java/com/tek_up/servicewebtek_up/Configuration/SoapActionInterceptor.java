package com.tek_up.servicewebtek_up.Configuration;

import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapMessage;

public class SoapActionInterceptor implements ClientInterceptor {

    private final String soapAction;

    public SoapActionInterceptor(String soapAction) {
        this.soapAction = soapAction;
    }

    @Override
    public boolean handleRequest(MessageContext messageContext) {
        SoapMessage soapMessage = (SoapMessage) messageContext.getRequest();
        soapMessage.setSoapAction(soapAction);
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception ex) {
    }
}

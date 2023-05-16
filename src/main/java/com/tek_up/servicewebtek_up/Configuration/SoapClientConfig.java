package com.tek_up.servicewebtek_up.Configuration;

import com.xignite.services.ConvertRealTimeValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapClientConfig {

    @Value("${currency.soap.service.uri}")
    private String defaultUri;

    @Value("${currency.soap.action}")
    private String soapAction;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.xignite.services");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setDefaultUri(defaultUri);
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        return webServiceTemplate;
    }

    // Add this bean definition to include ConvertRealTimeValue class in the JAXB context
    @Bean
    public Class[] jaxbClasses() {
        return new Class[]{ConvertRealTimeValue.class};
    }
}

package com.util;

import com.server.Code;

import com.server.CounthouseServer;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.server.Request;

public class CounthouseClientUtil {
    
    private static final String SERVICE_URL   = "http://localhost:8080/counthouse?wsdl";
    private static final String NAMESPACE_URI = "http://server.com/";
    private static final String LOCAL_PART    = "CounthouseServerImplService";
    
    
    public Request createNewDataItemRequest() {
        Request request = new Request();
        
        // the user will have to be prompted for these values!
        request.setRequestCode(Code.CREATE);
        request.setName("Jacks Tavern");
        request.setCity("Chicago");
        request.setState("Illinois");
        
        return request;
    }
    
    public Request createNewDeleteItemRequest(Integer id) {
        Request request = new Request();
        
        request.setRequestCode(Code.DELETE);
        request.setId(id);
        
        return request;
    }
    
    public Request createNewReadRequest(Integer id) {
        Request request = new Request();
        
        request.setRequestCode(Code.READ);
        request.setId(id);
        
        return request;
    }
    
    public Request createNewUpdateRequest(Integer id) {
        Request request = new Request();
    
        // the user will have to be prompted for these values!
        // all fields would need to be set - do an update with a read always
        request.setRequestCode(Code.UPDATE);
        request.setId(id);
        request.setCity("Omaha");
        request.setState("NE");
        
        return request;    
    }
    
    public Request createNewDisplayAllRequest() {
        Request request = new Request();
        
        request.setRequestCode(Code.DISPLAY);
        
        return request;
    }
    
    
    public CounthouseServer setupService() {

      try {
        return Service.create(new URL(SERVICE_URL),
                              new QName(NAMESPACE_URI,
                                        LOCAL_PART))
                      .getPort(CounthouseServer.class);

      } catch (Exception e) {
        System.out.println(e.toString());
        return null;
      }
    }
}
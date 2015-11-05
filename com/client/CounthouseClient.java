package com.client;

import com.server.Request;
import com.server.Code;
import com.server.Response;
import com.server.CounthouseServer;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;


public class CounthouseClient {

  private static final String SERVICE_URL   = "http://localhost:8080/counthouse?wsdl";
  private static final String NAMESPACE_URI = "http://server.com/";
  private static final String LOCAL_PART    = "CounthouseServerImplService";

  public static void main(String ... args) {

    CounthouseServer service = setupService();

    Request request = new Request();

    request.setRequestCode(Code.CREATE);
    request.setName("Jacks Tavern");
    request.setCity("Chicago");
    request.setState("Illinois");

    Response response1 = service.process(request);

    request.setRequestCode(Code.DELETE);
    request.setId(25);

    Response response2 = service.process(request);

    request.setRequestCode(Code.READ);
    request.setId(89);

    Response response3 = service.process(request);

    request.setRequestCode(Code.UPDATE);
    // all fields would need to be set - do an update with a read always
    request.setCity("Omaha");
    request.setState("NE");

    Response response4 = service.process(request);

    request.setRequestCode(Code.DISPLAY);
    Response response5 = service.process(request);
  }

  private static CounthouseServer setupService() {

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

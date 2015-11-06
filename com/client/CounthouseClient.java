package com.client;

import com.server.Request;
import com.server.Code;
import com.server.Response;
import com.server.CounthouseServer;

import com.util.CounthouseClientUtil;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;


public class CounthouseClient {
    
    private static CounthinghouseClientUtil util = new CounthouseClientUtil();

  public static void main(String ... args) {

    CounthouseServer service = util.setupService();

    Response response1 = service.process(util.createNewDataItem());
    Response response2 = service.process(util.createNewDeleteItemRequest(25));
    Response response3 = service.process(util.createNewReadRequest(89));
    Response response4 = service.process(util.createNewUpdateRequest(89));
    Response response5 = service.process(util.createNewDisplayAllRequest());
  }


}

package com.client;

import com.server.Response;
import com.server.CounthouseServer;

import com.util.CounthouseClientUtil;


public class CounthouseClient {
    
    private static CounthouseClientUtil util = new CounthouseClientUtil();

    /**
     * @param args
     */
    public static void main(String ... args) {

    CounthouseServer service = util.setupService();

    Response response1 = service.process(util.createNewDataItemRequest());
    Response response2 = service.process(util.createNewDeleteItemRequest(25));
    Response response3 = service.process(util.createNewReadRequest(89));
    Response response4 = service.process(util.createNewUpdateRequest(89));
    Response response5 = service.process(util.createNewDisplayAllRequest());
  }


}

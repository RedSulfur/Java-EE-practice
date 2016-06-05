package ru.gs.test.wstest;

/**
 * Created by sulfur on 18.03.16.
 */
public class SimpleWebServiceClient {

    public static void main(String[] args) {
//        com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump=true;

        SimpleWebServiceService service = new SimpleWebServiceService();
        SimpleWebService port = service.getSimpleWebServicePort();
        String str = port.sayHello("World!");
        System.out.println("returned: " + str);

    }
}

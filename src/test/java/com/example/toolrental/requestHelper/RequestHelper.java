package com.example.toolrental.requestHelper;

import com.example.toolrental.dto.CheckoutRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class RequestHelper {

    private static final String CR1PATH = "src/test/resources/requests/TestRequest1.json";
    private static final String CR2PATH = "src/test/resources/requests/TestRequest2.json";
    private static final String CR3PATH = "src/test/resources/requests/TestRequest3.json";
    private static final String CR4PATH = "src/test/resources/requests/TestRequest4.json";
    private static final String CR5PATH = "src/test/resources/requests/TestRequest5.json";
    private static final String CR6PATH = "src/test/resources/requests/TestRequest6.json";

    public CheckoutRequest getCR1() throws IOException {
        ObjectMapper ob = new ObjectMapper().findAndRegisterModules();
      return ob.readValue(new File(CR1PATH), CheckoutRequest.class);
    }

    public CheckoutRequest getCR2() throws IOException {
        ObjectMapper ob = new ObjectMapper().findAndRegisterModules();
        return ob.readValue(new File(CR2PATH), CheckoutRequest.class);
    }

    public CheckoutRequest getCR3() throws IOException {
        ObjectMapper ob = new ObjectMapper().findAndRegisterModules();
        return ob.readValue(new File(CR3PATH), CheckoutRequest.class);
    }

    public CheckoutRequest getCR4() throws IOException {
        ObjectMapper ob = new ObjectMapper().findAndRegisterModules();
        return ob.readValue(new File(CR4PATH), CheckoutRequest.class);
    }

    public CheckoutRequest getCR5() throws IOException {
        ObjectMapper ob = new ObjectMapper().findAndRegisterModules();
        return ob.readValue(new File(CR5PATH), CheckoutRequest.class);
    }

    public CheckoutRequest getCR6() throws IOException {
        ObjectMapper ob = new ObjectMapper().findAndRegisterModules();
        return ob.readValue(new File(CR6PATH), CheckoutRequest.class);
    }
}

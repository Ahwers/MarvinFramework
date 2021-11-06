package com.ahwers.marvin.service;

import com.ahwers.marvin.TestClient;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ahwers.marvin.framework.application.ActionInvocation;
import com.ahwers.marvin.framework.application.ApplicationAction;
import com.ahwers.marvin.framework.command.Command;
import com.ahwers.marvin.framework.response.MarvinResponse;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class EndpointsTest {
    
    private TestClient client = null;

    @Before
    public void setUp() {
        client = new TestClient();
    }

    @After
    public void tearDown() {
        client.close();
    }

    @Test
    public void commandStringRequest() {
        Response response = client.postCommandRequest("successful marvin request test");
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void commandObjectRequest() {
        Command command = new Command("successful marvin request test");
        Response response = client.postCommandRequest(command);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void applicationActionObjectRequest() {
        ActionInvocation invocation = new ActionInvocation("Service Tester", "successfulMarvinRequestTest", new HashMap<String, String>());
        Response response = client.postActionInvocationExecutionRequest(invocation);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

}
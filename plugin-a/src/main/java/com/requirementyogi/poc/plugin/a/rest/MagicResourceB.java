package com.requirementyogi.poc.plugin.a.rest;

import com.requirementyogi.poc.plugin.a.api.MyInterface2;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Deployed at /rest/plugin-a/1/magic2
 */
@Path("/magic2")
public class MagicResourceB {
    private final MyInterface2 myInterface2;

    @Inject
    public MagicResourceB(MyInterface2 myInterface2) {
        this.myInterface2 = myInterface2;
    }

    /**
     * Will return something if the Plugin B is present. Otherwise, the constructor isn't injected.
     */
    @GET
    @Produces("text/html; charset=utf8")
    public String getOneBean() {
        return myInterface2.getName();
    }
}

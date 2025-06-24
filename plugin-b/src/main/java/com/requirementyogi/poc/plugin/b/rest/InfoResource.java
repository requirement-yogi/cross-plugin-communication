package com.requirementyogi.poc.plugin.b.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Deployed at /rest/plugin-b/1/info
 * */
@Path("/info")
public class InfoResource {

    @Inject
    public InfoResource() {
        // Nothing
    }

    @GET
    @Produces("text/html; charset=utf8")
    public String info() {
        return "Plugin B";
    }
}

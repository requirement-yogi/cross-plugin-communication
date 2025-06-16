package com.requirementyogi.poc.plugin.a.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * A resource to confirm that the plugin is up and running,
 * and to confirm how serialization features behave.
 * <p>
 * Deployed at /rest/reqs/1/info
 * */
@Path("/info")
public class InfoResource {

    //@Autowired
    @Inject
    public InfoResource(
    ) {
    }

    @GET
    @Produces("text/html; charset=utf8")
    public String info() {
        return "Plugin A<br/><br/><a href=\"magic/1\">Proceed...</a>";
    }
}

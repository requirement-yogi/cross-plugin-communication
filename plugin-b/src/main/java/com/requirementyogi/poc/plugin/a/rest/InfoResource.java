package com.requirementyogi.poc.plugin.a.rest;

import com.atlassian.confluence.core.ContextPathHolder;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
    //@Produces(BaseUtils.JSON_UTF8)
    public String info() {
        return "Plugin B";
    }
}

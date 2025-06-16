package com.requirementyogi.poc.plugin.b.rest;

import com.requirementyogi.poc.plugin.b.managers.ComponentB;
import com.requirementyogi.poc.plugin.b.managers.MyInterface;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * A resource to confirm that the plugin is up and running,
 * and to confirm how serialization features behave.
 * <p>
 * Deployed at /rest/reqs/1/info
 * */
@Path("/magic")
public class MagicResource {

    private final MyInterface myInterface;

    //@Autowired
    @Inject
    public MagicResource(ComponentB myInterface) {
        this.myInterface = myInterface;
    }

    @GET
    //@Produces(BaseUtils.JSON_UTF8)
    public String get() {
        return myInterface.getName();
    }
}

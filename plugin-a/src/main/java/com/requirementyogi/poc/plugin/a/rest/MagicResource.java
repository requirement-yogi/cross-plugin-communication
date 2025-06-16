package com.requirementyogi.poc.plugin.a.rest;

import com.atlassian.plugin.PluginAccessor;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.requirementyogi.poc.plugin.a.managers.ComponentA;
import com.requirementyogi.poc.plugin.a.api.MyInterface;

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
@SuppressWarnings("StringConcatenationInLoop")
@Path("/magic")
public class MagicResource {

    private final ComponentA componentA;
    private final PluginAccessor pluginAccessor;

    @Inject
    public MagicResource(ComponentA componentA,
                         @ComponentImport PluginAccessor pluginAccessor
    ) {
        this.componentA = componentA;
        this.pluginAccessor = pluginAccessor;
        System.out.println("====== Plugin A: Magic Resource loaded");
    }

    @GET
    @Produces("text/html; charset=utf8")
    public String getSummary() {
        return
                "<p><a href=\"magic/1\">Single component</a></p>"
                + "<p><a href=\"magic/2\">PluginAccessor.getEnabledModulesByClass(ComponentA.class)</a></p>"
                + "<p><a href=\"magic/3\">PluginAccessor.getEnabledModulesByClass(MyInterface.class)</a></p>"
                ;
    }

    @GET
    @Path("/1")
    @Produces("text/plain; charset=utf8")
    public String getOneBean() {
        return componentA.getName();
    }

    @GET
    @Path("/2")
    @Produces("text/plain; charset=utf8")
    public String listWithPluginAccessor() {
        String response = "List for the single component:";
        for (ComponentA module : pluginAccessor.getEnabledModulesByClass(ComponentA.class)) {
            response += "\n-" + module.getName();
        }
        return response;
    }

    @GET
    @Path("/3")
    @Produces("text/plain; charset=utf8")
    public String listInterfaceWithPluginAccessor() {
        String response = "List for the interface:";
        for (MyInterface module : pluginAccessor.getEnabledModulesByClass(MyInterface.class)) {
            response += "\n-" + module.getName();
        }
        return response;
    }
}

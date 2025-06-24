package com.requirementyogi.poc.plugin.a.rest;

import com.atlassian.plugin.PluginAccessor;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.requirementyogi.poc.plugin.a.api.MyInterface;
import com.requirementyogi.poc.plugin.a.managers.ComponentA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Deployed at /rest/plugin-a/1/magic
 * */
@SuppressWarnings("StringConcatenationInLoop")
@Path("/magic")
public class MagicResource {

    private final static Logger log = LoggerFactory.getLogger(MagicResource.class);

    private final ComponentA componentA;
    private final MyInterface myInterface;
    private final PluginAccessor pluginAccessor;

    @Inject
    public MagicResource(ComponentA componentA,
                         MyInterface myInterface,
                         @ComponentImport PluginAccessor pluginAccessor
    ) {
        this.componentA = componentA;
        this.myInterface = myInterface;
        this.pluginAccessor = pluginAccessor;
        log.error("\n====== Plugin A: Magic Resource loaded");
    }

    @GET
    @Produces("text/html; charset=utf8")
    public String getSummary() {
        return
                "<p><a href=\"magic/1\">Constructor injection of ComponentA</a></p>"
                + "<p><a href=\"magic/2\">Constructor injection of MyInterface</a></p>"
                + "<p><a href=\"magic/3\">PluginAccessor.getEnabledModulesByClass(ComponentA.class)</a></p>"
                + "<p><a href=\"magic/4\">PluginAccessor.getEnabledModulesByClass(MyInterface.class)</a></p>"
                + "<p><a href=\"magic2\">Constructor injection of MyInterface2</a></p>"
                ;
    }

    @GET
    @Path("/1")
    @Produces("text/plain; charset=utf8")
    public String getOneBean() {
        return "Injection by constructor for Component A: " + componentA.getName();
    }

    @GET
    @Path("/2")
    @Produces("text/plain; charset=utf8")
    public String getOneBeanByInterface() {
        return "Injection by constructor for MyInterface: " + myInterface.getName();
    }

    @GET
    @Path("/3")
    @Produces("text/plain; charset=utf8")
    public String listWithPluginAccessor() {
        String response = "pluginAccessor.getEnabledModulesByClass(ComponentA.class) should return Component A:";
        List<ComponentA> list = pluginAccessor.getEnabledModulesByClass(ComponentA.class);
        for (ComponentA module : list) {
            response += "\n- " + module.getName();
        }
        response += "\n- (End of list)";
        if (list.isEmpty()) {
            response += "\n\nERROR: The list is missing the Component A.";
        }
        return response;
    }

    @GET
    @Path("/4")
    @Produces("text/plain; charset=utf8")
    public String listInterfaceWithPluginAccessor() {
        String response = "pluginAccessor.getEnabledModulesByClass(MyInterface.class) should return" +
                " both Component A and Component B:";
        List<MyInterface> list = pluginAccessor.getEnabledModulesByClass(MyInterface.class);
        for (MyInterface module : list) {
            response += "\n- " + module.getName();
        }
        response += "\n- (End of list)";
        if (list.isEmpty()) {
            response += "\n\nERROR: The list is missing the Component A and the Component B, both of which implement MyInterface.";
        }
        return response;
    }
}

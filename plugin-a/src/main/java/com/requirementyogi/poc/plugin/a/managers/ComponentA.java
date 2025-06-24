package com.requirementyogi.poc.plugin.a.managers;

import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.requirementyogi.poc.plugin.a.api.MyInterface;
import com.requirementyogi.poc.plugin.a.config.PluginASpringInjection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
//@ExportAsService({ MyInterface.class })
public class ComponentA implements MyInterface {

    private final static Logger log = LoggerFactory.getLogger(ComponentA.class);

    public ComponentA() {
        log.error("\n====== Plugin A: Component A loaded");
    }

    @Override
    public String getName() {
        return "Component A";
    }
}

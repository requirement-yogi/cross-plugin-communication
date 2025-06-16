package com.requirementyogi.poc.plugin.a.managers;

import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.requirementyogi.poc.plugin.a.api.MyInterface;
import org.springframework.stereotype.Component;

@Component
@ExportAsService({ MyInterface.class })
public class ComponentA implements MyInterface {

    public ComponentA() {
        System.out.println("====== Plugin A: Component A loaded");
    }

    @Override
    public String getName() {
        return "Component A";
    }
}

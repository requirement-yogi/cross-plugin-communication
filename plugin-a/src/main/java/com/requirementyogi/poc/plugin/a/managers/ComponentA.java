package com.requirementyogi.poc.plugin.a.managers;

import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.requirementyogi.poc.plugin.b.api.MyInterface;
import org.springframework.stereotype.Component;

@Component
@ExportAsService({ MyInterface.class })
public class ComponentA implements MyInterface {

    public ComponentA() {
        System.out.println("====== Plugin B: Component B loaded");
    }

    @Override
    public String getName() {
        return "Component B";
    }
}

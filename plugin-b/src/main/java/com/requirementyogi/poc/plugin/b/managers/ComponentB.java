package com.requirementyogi.poc.plugin.b.managers;

import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.requirementyogi.poc.plugin.a.api.MyInterface;
import org.springframework.stereotype.Component;

@Component
@ExportAsService({ MyInterface.class })
public class ComponentB implements MyInterface {

    public ComponentB() {
        System.out.println("====== Plugin B: Component B loaded");
    }

    @Override
    public String getName() {
        return "Component B";
    }
}

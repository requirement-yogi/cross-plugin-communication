package com.requirementyogi.poc.plugin.b.managers;

import com.requirementyogi.poc.plugin.a.api.MyInterface;
import com.requirementyogi.poc.plugin.a.api.MyInterface2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentB implements MyInterface, MyInterface2 {
    private final static Logger log = LoggerFactory.getLogger(ComponentB.class);

    public ComponentB() {
        log.error("\n====== Plugin B: Component B loaded");
    }

    @Override
    public String getName() {
        return "Component B";
    }
}

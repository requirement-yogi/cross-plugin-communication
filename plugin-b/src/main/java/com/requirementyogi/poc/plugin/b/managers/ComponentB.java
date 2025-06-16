package com.requirementyogi.poc.plugin.b.managers;

import org.springframework.stereotype.Component;

@Component
public class ComponentB implements MyInterface {

    @Override
    public String getName() {
        return "Component B";
    }
}

package com.requirementyogi.poc.plugin.b.config;

import org.springframework.context.annotation.Configuration;

/**
 * Configures the injection of services which vary depending on the host application.
 * All simple services can simply use the @Component annotation.
 */
@Configuration
public class PluginBSpringInjection {

    public PluginBSpringInjection() {
        System.out.println("====== Plugin B: Spring Injection loaded");
    }
}

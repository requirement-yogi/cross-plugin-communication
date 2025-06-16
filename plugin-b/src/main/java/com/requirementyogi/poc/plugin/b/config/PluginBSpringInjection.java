package com.requirementyogi.poc.plugin.b.config;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Configures the injection of services which vary depending on the host application.
 * All simple services can simply use the @Component annotation.
 */
@Configuration
public class PluginBSpringInjection {
    private final AutowireCapableBeanFactory beanFactory;

    public PluginBSpringInjection(AutowireCapableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}

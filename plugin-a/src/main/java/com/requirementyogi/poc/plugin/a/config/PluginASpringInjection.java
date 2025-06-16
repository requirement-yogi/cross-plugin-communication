package com.requirementyogi.poc.plugin.a.config;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Configures the injection of services which vary depending on the host application.
 * All simple services can simply use the @Component annotation.
 */
@Configuration
public class PluginASpringInjection {
    private final AutowireCapableBeanFactory beanFactory;

    public PluginASpringInjection(AutowireCapableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}

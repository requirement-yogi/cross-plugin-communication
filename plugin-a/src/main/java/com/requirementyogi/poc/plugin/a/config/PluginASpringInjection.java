package com.requirementyogi.poc.plugin.a.config;

import com.atlassian.plugin.PluginAccessor;
import com.atlassian.plugins.osgi.javaconfig.ExportOptions;
import com.atlassian.plugins.osgi.javaconfig.ImportOptions;
import com.atlassian.plugins.osgi.javaconfig.OsgiServices;
import com.requirementyogi.poc.plugin.a.api.MyInterface;
import com.requirementyogi.poc.plugin.a.managers.ComponentA;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures the injection of services which vary depending on the host application.
 * All simple services can simply use the @Component annotation.
 */
@Configuration
public class PluginASpringInjection {

    private final static Logger log = LoggerFactory.getLogger(PluginASpringInjection.class);

    static {
        log.error("\n======\n====== Plugin A: Classloader OK \n======");
    }

    public PluginASpringInjection() {
        log.error("\n====== Plugin A: Spring Injection loaded");
    }

    @Bean
    public ComponentA componentA() {
        return new ComponentA();
    }

    @Bean
    public FactoryBean<ServiceRegistration> exportComponentA(ComponentA componentA) {
        return OsgiServices.exportOsgiService(componentA, ExportOptions.as(MyInterface.class));
    }

    @Bean
    public PluginAccessor getPluginAccessor() {
        return OsgiServices.importOsgiService(PluginAccessor.class, ImportOptions.defaultOptions());
    }
}

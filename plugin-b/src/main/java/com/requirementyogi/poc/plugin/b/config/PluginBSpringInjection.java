package com.requirementyogi.poc.plugin.b.config;

import com.atlassian.plugins.osgi.javaconfig.ExportOptions;
import com.atlassian.plugins.osgi.javaconfig.OsgiServices;
import com.requirementyogi.poc.plugin.a.api.MyInterface;
import com.requirementyogi.poc.plugin.a.api.MyInterface2;
import com.requirementyogi.poc.plugin.b.managers.ComponentB;
import org.osgi.framework.ServiceRegistration;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public ComponentB componentB() {
        return new ComponentB();
    }

    @Bean
    public FactoryBean<ServiceRegistration> exportComponentB(ComponentB componentB) {
        return OsgiServices.exportOsgiService(componentB, ExportOptions.as(MyInterface.class, MyInterface2.class));
    }
}

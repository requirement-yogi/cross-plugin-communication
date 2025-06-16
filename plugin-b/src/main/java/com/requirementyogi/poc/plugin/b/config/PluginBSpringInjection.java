package com.requirementyogi.poc.plugin.b.config;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Configures the injection of services which vary depending on the host application.
 * All simple services can simply use the @Component annotation.
 */
@Configuration
public class PluginBSpringInjection {
    static {
        System.out.println("====== Plugin B: Classloader OK");
    }

    public PluginBSpringInjection() {
        System.out.println("====== Plugin B: Spring Injection loaded");
    }

    // If necessary, implement those:
    //    @Bean
    //    public FooService fooService() {
    //        return new FooServiceImpl();
    //    }
    //
    //    // The above component, exported to OSGi
    //    // The "exportOsgiService" method comes from our helper library
    //    @Bean
    //    public FactoryBean<ServiceRegistration> exportFooService(FooService fooService) {
    //        return exportOsgiService(fooService, ExportOptions.as(FooService.class));
    //    }
}

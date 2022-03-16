package com.revature.music;

import java.io.File;

import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {
    @Bean
    public Tomcat tomcat() {
        final String contextPath = "";
        final String docBase = new File(System.getProperty("java.io.tmpdir")).getAbsolutePath();
        Tomcat server = new Tomcat();
        server.setBaseDir(docBase);
        server.getConnector();
        server.addContext(contextPath, docBase);
        return server;
    }
}

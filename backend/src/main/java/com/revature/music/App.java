package com.revature.music;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class App {
    public static void main(String[] args) {
        ApplicationContext springIoC = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        AnnotationConfigWebApplicationContext webmvc = new AnnotationConfigWebApplicationContext();
        webmvc.setParent(springIoC);
        webmvc.scan("com.revature.music");

        Tomcat server = springIoC.getBean(Tomcat.class);
        server.addServlet("", "dispatcher", new DispatcherServlet(webmvc)).addMapping("/*");
        try {
            server.start();
        } catch (LifecycleException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}

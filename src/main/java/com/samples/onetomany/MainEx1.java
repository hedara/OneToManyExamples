package com.samples.onetomany;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by edara on 9/5/16.
 */
public class MainEx1 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ServiceEx1 service = (ServiceEx1) context.getBean("serviceEx1");
        service.run();
        System.out.println("Done");
    }
}

package com.santosh.javacracservice;

import org.crac.Context;
import org.crac.Core;
import org.crac.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.management.ManagementFactory;

@SpringBootApplication
public class JavaCracServiceApplication implements Resource {

    public static void main(String[] args) {
        SpringApplication.run(JavaCracServiceApplication.class, args);
        System.out.println("Hello World!");
        new JavaCracServiceApplication();
        long currentTime = System.currentTimeMillis();
        long vmStartTime = ManagementFactory.getRuntimeMXBean().getStartTime();
        System.out.println("JVM Startup time    : " + (currentTime - vmStartTime) + " ms");
        System.out.println("PID                 : " + ProcessHandle.current().pid());

//        try {
//            while (true) {
//                Thread.sleep(1000);
//            }
//        } catch (InterruptedException e) {}
    }

    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
        System.out.println("beforeCheckpoint() called.");
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {
        System.out.println("afterRestore() called.");
    }

    public JavaCracServiceApplication() {
//        Registering a Context of a Resource
        Core.getGlobalContext().register(JavaCracServiceApplication.this);
    }
}

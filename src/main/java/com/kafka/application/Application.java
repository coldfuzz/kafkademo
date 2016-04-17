package com.kafka.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * Created by ykurtulus on 4/13/16.
 */
@SpringBootApplication
@ComponentScan({"com.kafka"})
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }
}

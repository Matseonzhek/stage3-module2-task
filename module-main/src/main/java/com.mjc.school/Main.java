package com.mjc.school;

import com.mjc.school.controller.implementation.AuthorController;
import com.mjc.school.controller.implementation.NewsController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.mjc.school");
        NewsController newsController = context.getBean(NewsController.class);
        AuthorController authorController = context.getBean(AuthorController.class);

        newsController.readAll().forEach(System.out::println);
//        authorController.readAll().forEach(System.out::println);
    }
}

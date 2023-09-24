package com.crudapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Класс для запуска приложения.
 */
@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
        System.out.println("Запуск приложения");
        SpringApplication.run(CrudApplication.class, args);
    }

}

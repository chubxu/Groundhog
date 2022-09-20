package org.chubxu.groundhog.console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GroundhogConsoleApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(GroundhogConsoleApplication.class, args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

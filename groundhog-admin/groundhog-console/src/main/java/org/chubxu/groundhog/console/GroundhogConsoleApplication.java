package org.chubxu.groundhog.console;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.chubxu.groundhog.dal.mapper")
public class GroundhogConsoleApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(GroundhogConsoleApplication.class, args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

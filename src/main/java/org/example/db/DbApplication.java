package org.example.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author liudaojian
 */
@SpringBootApplication
@EntityScan("org.example.db.entity")
public class DbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
        System.out.println("http://127.0.0.1:8080");
    }

}

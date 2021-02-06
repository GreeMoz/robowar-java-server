package org.hse.robowar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("org.hse.robowar.model")
@SpringBootApplication
public class RobowarApplication {
    public static void main(String[] args) {
        SpringApplication.run(RobowarApplication.class, args);
    }
}

package org.hse.robowar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("org.hse.robowar.model")
@SpringBootApplication
@EnableJpaRepositories("org.hse.robowar.repository")
public class RobowarApplication {
    public static void main(String[] args) {
        SpringApplication.run(RobowarApplication.class, args);
    }
}

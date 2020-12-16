package io.dsub.blog.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EntityScan (basePackages = {"io.dsub.blog.common.entity"})
@EnableJpaAuditing
@SpringBootApplication
public class BlogApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApiApplication.class, args);
    }
}

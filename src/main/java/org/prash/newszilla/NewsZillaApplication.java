package org.prash.newszilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.prash"})
public class NewsZillaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsZillaApplication.class, args);
    }

}

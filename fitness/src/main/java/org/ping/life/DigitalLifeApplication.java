package org.ping.life;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.ping.life.*.mapper")
@SpringBootApplication
public class DigitalLifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalLifeApplication.class, args);
    }

}

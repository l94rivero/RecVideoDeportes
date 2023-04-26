package com.ar.rec;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@ComponentScan("com.ar.servicios")
@ComponentScan("com.ar.repositorios")
@EnableJpaRepositories
class RecApplicationTests {

    @Test
    void contextLoads() {
    }

}

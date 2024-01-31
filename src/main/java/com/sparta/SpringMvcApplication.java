package com.sparta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
// @EnableJpaAuditing : Auditing 기능을 사용하겠다고 알려주는 어노테이션
public class SpringMvcApplication {

    /*
    SpringBootApplication 어노테이션이 이 클래스가 담아져 있는 패키지와 하위 패키지까지 전부 ComponentScan을 하기 때문에
    클래스에 Component 어노테이션을 붙여주면 Bean으로 등록됩니다.
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }

}

package com.sparta.springmvc;

import com.sparta.week3.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {
    /*
    @Autowired
    Food food;
    이렇게 작성하면
    Bean이 두개이기 때문에 어떤 bean을 사용할지 모르기 때문에
    1. 등록된 빈의 이름을 명시하는 방법
    2. 빈으로 등록된 클래스 중에서 하나를 골라 @Primary를 붙여주는 방법
    3. 빈으로 등록된 클래스 중에서 하나를 골라 @Qualifier("bean name")를 붙여주는 방법
       Autowired 밑에 똑같이 @Qualifier("bean name")
    * 여기서 Primary 어노테이션과 Qualifier 어노테이션 중에서 Qualifier가 우선순위
    따라서 같은 타입의 빈이 여러개 있을 때 범용적인 빈에는 Primary를 지역적으로 사용하는 빈에는 Qualifier를 사용하는게 좋다.
     */

    @Autowired
    Food pizza;

    @Autowired
    Food chicken;

    @Test
    @DisplayName("테스트")
    void test1() {
        pizza.eat();
        chicken.eat();
    }

}
package com.sparta.springmvc.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {
    // @ResponseBody : 이 어노테이션이 없다면 html 파일을 찾아서 반환하려고 하기 때문에
    // 데이터만 반환하려고 한다는 것을 알려줄 때 사용

    // Content-Type : text/html
    // Response Body
    // {"name" : "Robbie", "age" : 95}
    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    // Content-Type : application/json
    // Response Body
    // {"name" : "namji", "age" : 20}
    @GetMapping("/json/class")
    @ResponseBody
    public Star helloClassJson() {
        return new Star("namji", 20);
    }
}

/**
 * package com.sparta.springmvc.response;
 *
 * import org.springframework.stereotype.Controller;
 * import org.springframework.web.bind.annotation.GetMapping;
 * import org.springframework.web.bind.annotation.RequestMapping;
 * import org.springframework.web.bind.annotation.ResponseBody;
 *
 * @Controller
 * @RequestMapping("/response")
 * public class ResponseController {
 *     // [Response header]
 *     //   Content-Type: text/html
 *     // [Response body]
 *     //   {"name":"Robbie","age":95}
 *     @GetMapping("/json/string")
 *     @ResponseBody
 *     public String helloStringJson() {
 *         return "{\"name\":\"Robbie\",\"age\":95}";
 *     }
 *
 *     // [Response header]
 *     //   Content-Type: application/json
 *     // [Response body]
 *     //   {"name":"Robbie","age":95}
 *     @GetMapping("/json/class")
 *     @ResponseBody
 *     public Star helloClassJson() {
 *         return new Star("Robbie", 95);
 *     }
 * }
 */
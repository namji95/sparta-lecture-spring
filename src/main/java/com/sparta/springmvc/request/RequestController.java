package com.sparta.springmvc.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request")
public class RequestController {

    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    // [Request sample]
    // GET http://localhost:8080/hello/request/star/Robbie/age/95
     /*
     @PathVariable방식은 우리가 보내려고 하는 데이터를 브라우저에서 api 경로에 담는 방식입니다.
     필요한 데이터는 api에 {} 안에 변수명을 담습니다.
     밑에 코드를 예시로 보면 @PathVariable String name = api의 {name} @PathVariable int age = api의 {age}
     @PathVariable을 파라미터에 담습니다.
      */
    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age)
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
    // GET http://localhost:8080/hello/request/form/param?name=Robbie&age=95
    /*
    @RequestParam 방식은 QueryString 방식이라고 불립니다.
    api의 Param까지가 api 요청이고, ?부터 key=value&key=value.. 이런식으로 작성합니다.
    GetMapping방식에서 RequestParam을 파라미터에 담습니다.
     */
    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // RequestParam을 생략해도 동작은 합니다. 대신 클라이언트에서 값을 넣지 않고 요청할 시 에러가 발생하지만
    // RequestParma의 옵션 중 required = false를 사용하면   클라이언트가 해당 값이 포함되지 않아도 에러를 발생하지 않게 해줍니다.
    //    @GetMapping("/form/param")
    //    @ResponseBody
    //    public String helloGetRequestParam(String name, int age) {
    //        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    //    }

    // [Request sample]
    // POST http://localhost:8080/hello/request/form/param
    // Header
    //  Content type: application/x-www-form-urlencoded
    // Body
    //  name=Robbie&age=95
    /*
    post 방식으로 RequestParam으로 받을 경우
    post 방식은 다른 방식과 다르게 Body를 갖고 있습니다.
    Query String 방식
    파라미터에 @RequestParam을 작성합니다.
     */
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }
}
package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    //get과같이 URL에 값을 넣어 요청

    @DeleteMapping(value = "/{variable}")
    public String DeleteVariable(@PathVariable String variable) {
        return variable;
    }

    @DeleteMapping(value = "/request1")
    public String getRequestParam(@RequestParam String email) {
        return "e-mail : " + email;
    }
}

package com.springboot.api.controller;

import com.springboot.api.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api") //공통 URL 설정
@Slf4j
public class GetController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)

    public String getHello() {
        log.info("hello로 요청이 들어왔습니다");
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {//매개변수를 받지 않는다(거의 쓰이지 않는다)
        log.info("name으로 요청이 들어왔습니다");
        return "Flature";
    }

    @GetMapping(value = "/variable1/{variable}")//url에 값을 담아 요청
    public String getVariable(@PathVariable String variable) {
        log.info("getVariable1으로 요청이 들어왔습니다. variable:{}", variable);
        return variable;
    }
    @GetMapping(value = "/variable2/{variable}")//url에 값을 담아 요청
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    //http://localhost:8080/api/v1/get-api/request1?name=hakjun&email=hiatus&organization
    //선언된 변수를 다 적어야함
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name+" "+email+" "+organization;

    }

    @GetMapping(value = "/request2")//매개변수로 몇개가 들어올지 모른다
    public String getRequestParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name+" "+email+" "+organization;

    }
    @GetMapping(value = "/request21")//콘솔에출력
    public String getRequestParam3(@RequestParam Map<String,String> param) {
        param.entrySet().forEach((map)->
        {System.out.printf("key:%s : value:%s\n",map.getKey(),map.getValue());});
        return "request2 호출 완료";
    }
    @GetMapping(value ="/request3")
    public String getRequestParam4(@RequestParam Map<String,String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping
    public String getRequestParam5(MemberDto memberDto) {
        return memberDto.toString();
    }

}

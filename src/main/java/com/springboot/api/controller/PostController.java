package com.springboot.api.controller;

import com.springboot.api.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String,Object>postData) {//어떤요청,어떤타입이들어올지모른다
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");});
            return sb.toString();
    }

    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}

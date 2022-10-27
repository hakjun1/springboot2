package com.springboot.api.controller;

import com.springboot.api.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @RequestMapping(value = "/domain", method = RequestMethod.PUT)
    public String postExample() {
        return "Hello Post API";
    }

    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @PutMapping(value = "/member1")//text plane
    public String postMemberDto1(@RequestBody MemberDto memberDto) {
        return memberDto.toString();//String 리턴
    }

    @PutMapping(value = "/member2")//JSON
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;//객체 리턴
    }

    @PutMapping(value = "/member3")//ResponseEntity는 HttpStatus구현가능 다른메서드도가능
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);//응답코드202
        //응답코드변경, 헤드와 바디 쉽게 구성 가능
    }
}

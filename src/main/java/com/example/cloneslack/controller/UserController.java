package com.example.cloneslack.controller;


import com.example.cloneslack.dto.requestdto.UserRequestDto;
import com.example.cloneslack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/api/users")  //체크 완료
    public ResponseEntity signup(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok().body(userService.signup(userRequestDto));
        // 바디를 내려주려면 .body() , ok가 스테이터스 코드
    }

    @PostMapping("/api/checkId")
    public ResponseEntity duplicateusername(@RequestBody UserRequestDto userRequestDto) {
        return userService.checkId(userRequestDto);
    }

    @PostMapping("/api/checkNick")
    public ResponseEntity duplicateNickname(@RequestBody UserRequestDto userRequestDto) {
        return userService.checkNick(userRequestDto);
    }
}
package com.example.cloneslack.service;


import com.example.cloneslack.dto.requestdto.UserRequestDto;
import com.example.cloneslack.dto.responsedto.UserResponseDto;
import com.example.cloneslack.exceptionhandler.CustomException;
import com.example.cloneslack.exceptionhandler.ErrorCode;
import com.example.cloneslack.model.User;
import com.example.cloneslack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    //회원가입
    @Transactional
    public ResponseEntity signup(UserRequestDto userRequestDto) {


        String pattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        String passwordCheck = userRequestDto.getPasswordCheck();
        String password = userRequestDto.getPassword();
        String profileUrl = userRequestDto.getProfileUrl();
        String username = userRequestDto.getUsername();
        String nickname = userRequestDto.getNickname();

        //회원가입시 body 에 UserResponseDto 를 리스트로 건네줌
        UserResponseDto userResponseDto = new UserResponseDto(
                username, nickname, profileUrl, "회원가입 성공");
//        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
//        userResponseDtoList.add(userResponseDto);
//         회원가입 조건
        if (username.length() < 4) {
            throw new CustomException(ErrorCode.USERNAME_LEGNTH);
        }
        if (!Pattern.matches(pattern, username)) {
            throw new CustomException(ErrorCode.USERNAME_EMAIL);
        }
        if (!password.equals(passwordCheck)) {
            throw new CustomException(ErrorCode.PASSWORD_PASSWORDCHECK);
        }
        if (password.length() < 8) {
            throw new CustomException(ErrorCode.PASSWORD_LEGNTH);
        }
        if (password.contains(username)) {
            throw new CustomException(ErrorCode.PASSWORD_CONTAINUSERNAME);
        }
        if (nickname.equals("")) {
            throw new CustomException(ErrorCode.EMPTY_CONTENT);
        }
        if (nickname.equals(null)) {
            throw new CustomException(ErrorCode.EMPTY_CONTENT);
        }

        password = passwordEncoder.encode(userRequestDto.getPassword());//비번 인코딩

        User user = new User(username, nickname, password, profileUrl);
        userRepository.save(user);

        return new ResponseEntity(userResponseDto, HttpStatus.OK);
    }

    public ResponseEntity checkId(UserRequestDto userRequestDto) {
        if(userRepository.findByUsername(userRequestDto.getUsername()).isPresent()){
            throw new CustomException(ErrorCode.DUPLICATE_USERNAME);
        }
        return new ResponseEntity("사용가능한 아이디입니다.", HttpStatus.OK);

    }

    public ResponseEntity checkNick(UserRequestDto userRequestDto) {
        if(userRepository.findByNickname(userRequestDto.getNickname()).isPresent()) {
            throw new CustomException(ErrorCode.DUPLICATE_NICKNAME);
        }
        return new ResponseEntity("사용가능한 닉네임입니다.", HttpStatus.OK);
    }

    public User findByNickname(String nickname) {
        User user = userRepository.findByNickname(nickname).orElseThrow(
                ()-> new IllegalArgumentException("찾는 유저가 없습니다")
        );
        return user;
    }
}
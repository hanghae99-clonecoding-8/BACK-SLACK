package com.example.cloneslack.dto.responsedto;

import lombok.Getter;

@Getter
public class LoginResponseDto {

    private String nickname;
    private String profileUrl;

    private String letter;

    public LoginResponseDto(String nickname, String profileUrl, String letter) {
        this.nickname = nickname;
        this.profileUrl = profileUrl;
        this.letter = letter;
    }
}

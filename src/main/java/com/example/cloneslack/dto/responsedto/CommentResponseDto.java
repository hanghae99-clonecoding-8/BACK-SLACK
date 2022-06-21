package com.example.cloneslack.dto.responsedto;


import com.example.cloneslack.model.Comment;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class CommentResponseDto {
    private String nickname;
    private String username;
    private String comment;
    private LocalDateTime createdAt;
    private String profileUrl;
    private Long commentId;

    public CommentResponseDto(Comment comment, String profileUrl, String nickname, String username) {
        this.nickname = nickname;
        this.username = username;
        this.comment = comment.getComment();
        this.createdAt = comment.getCreatedAt();
        this.profileUrl = profileUrl;
        this.commentId = comment.getCommentId();
    }
}

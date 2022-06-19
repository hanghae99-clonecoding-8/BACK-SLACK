package com.example.cloneslack.dto.response;


import com.example.cloneslack.model.Comment;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class CommentResponseDto {
    private String nickname;
    private String comment;
    private LocalDateTime createdAt;
    private String profileUrl;
    private Long commentId;

    public CommentResponseDto(Comment comment, String profileUrl) {
        this.nickname = comment.getNickname();
        this.comment = comment.getComment();
        this.createdAt = comment.getCreatedAt();
        this.profileUrl = profileUrl;
        this.commentId = comment.getCommentId();
    }
}

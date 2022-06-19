package com.example.cloneslack.model;

import com.example.cloneslack.dto.request.CommentRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentRequestDto requestDto, Post post, User joinUser) {
        this.comment = requestDto.getComment();
        this.postId = post.getPostId();
        this.userId = joinUser.getUserId();
        this.username = joinUser.getUsername();
        //오니 저 조인유져 어디서 나오는거지?? 뭐 스프링 시큐리티 기능인가?
    }



//    public void update(CommentRequestDto requestDto) {
//        this.comment = requestDto.getComment();
//    }
}

package com.example.cloneslack.model;

import com.example.cloneslack.dto.requestdto.CommentRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String profileUrl;

    @Column(nullable = false)
    private String comment;


//    @ManyToOne
//    @JoinColumn(name = "post_id", nullable = false)
//    private Post post;

    public Comment(CommentRequestDto CommentRequestDto, Post post, User user){
        this.postId = post.getPostId();
        this.userId = user.getId();
        this.nickname = user.getNickname();
        this.username = user.getUsername();
        this.comment = CommentRequestDto.getComment();
        this.profileUrl = user.getProfileUrl();

    }


//    public Comment(CommentRequestDto requestDto, Post post, User user) {
//        this.comment = requestDto.getComment();
//        this.postId = post.getPostId();
//        this.userId = user.getId();
//        this.username = user.getUsername();
//        //오니 저 조인유져 어디서 나오는거지?? 뭐 스프링 시큐리티 기능인가?
//    }



//    public void update(CommentRequestDto requestDto) {
//        this.comment = requestDto.getComment();
//    }
}

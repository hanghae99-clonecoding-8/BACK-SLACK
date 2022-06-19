package com.example.cloneslack.dto.response;
import com.example.cloneslack.model.Post;
import lombok.Getter;
import com.example.cloneslack.model.User;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {

    private LocalDateTime createdAt;
    private Long postId;
    private Long userId;
    private String username;
    private String profileUrl;
//    private String title;
    private String contents;
//    private Boolean done;
//    private String category;
//    private boolean fav;

    public PostResponseDto(Post post, User user) {
        this.createdAt = post.getCreatedAt();
        this.postId = post.getPostId();
        this.userId = post.getUserId();
        this.username = user.getUsername();
        this.profileUrl = user.getProfileUrl();
//        this.title = post.getTitle();
        this.contents = post.getContents();
//        this.done = post.getDone();
//        this.category = post.getCategory();
//        this.fav = true;
    }
}

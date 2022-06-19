package com.example.cloneslack.model;

import com.example.cloneslack.dto.request.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false)
    private Long userId;

//    @Column(nullable = false)
//    private String title;

    @Column(nullable = false)
    private String contents;

//    @Column(nullable = false)
//    private Boolean done;

//    @Column(nullable = false)
//    private String category;

    public Post(Long userId, PostRequestDto requestDto) {
        this.userId = userId;
//        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
//        this.done = requestDto.getDone();
//        this.category = requestDto.getCategory();
    }

    public void updatePost(PostRequestDto requestDto) {
//        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
//        this.category = requestDto.getCategory();
    }

//    public void doneArticle() {
//        this.done = true;
//    }
}
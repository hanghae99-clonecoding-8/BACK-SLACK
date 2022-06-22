package com.example.cloneslack.model;

import com.example.cloneslack.dto.requestdto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@Table(name = "post")
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

//    @JsonIgnore
//    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Comment> comments = new ArrayList<>();


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
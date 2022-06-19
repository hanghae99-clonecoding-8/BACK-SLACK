package com.example.cloneslack.controller;

import com.example.cloneslack.dto.request.PostRequestDto;
import com.example.cloneslack.dto.response.PostResponseDto;
import com.example.cloneslack.exceptionhandler.CustomException;
import com.example.cloneslack.exceptionhandler.ErrorCode;
import com.example.cloneslack.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    // 게시글 작성
    @PostMapping("/api/posts")
    public PostResponseDto createPost(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody PostRequestDto requestDto) {
        if (userDetails != null) {
            PsotResponseDto responseDto = postService.createArticle(userDetails, requestDto);
            return responseDto;
        }
        throw new CustomException(ErrorCode.AUTH_TOKEN_NOT_FOUND);
    }

    // 게시글 수정
    @PutMapping("/api/posts/{postId}")
    publicPostResponseDto updateArticle(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postId, @RequestBody PostRequestDto requestDto) {
        if (userDetails != null) {
            PostResponseDto responseDto = postService.updateArticle(userDetails, postId, requestDto);
            return responseDto;
        }
        throw new CustomException(ErrorCode.AUTH_TOKEN_NOT_FOUND);
    }

    // 게시글 삭제
//    @DeleteMapping("/api/posts/{postId}")
//    public String deletePost(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postId) {
//        if (userDetails != null) {
//            postService.deletePost(userDetails, postId);
//            commentService.deleteComments(postId);
//            return "게시글이 삭제되었습니다.";
//        }
//        throw new CustomException(ErrorCode.AUTH_TOKEN_NOT_FOUND);
//    }

    // 게시글 목록 조회
//    @GetMapping("/api/articles/page/{page}")
//    public Page<Article> readArticles(@PathVariable int page) {
//        page -= 1;
//        Page<Article> articles = articleService.readArticles(page);
//        return articles;
//    }
    @GetMapping("/api/posts")
    public List<PostResponseDto> readPosts() {
        return postService.readPosts();
    }

//    // 게시글 카테고리별 목록 조회
//    @GetMapping("/api/articles/category/{category}")
//    public List<ArticleResponseDto> readArticlesByCategory(@PathVariable String category) {
//        return articleService.readArticlesByCategory(category);
//    }

    // 게시글 상세 조회
    @GetMapping("/api/posts/{postId}")
    public PostResponseDto readPost(@PathVariable Long postId) {
        return postService.readPost(postId);
    }

//    // 게시글 완료 처리
//    @PatchMapping("/api/articles/{articleId}/done")
//    public ArticleResponseDto doneArticle(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long articleId) {
//        if (userDetails != null) {
//            ArticleResponseDto responseDto = articleService.doneArticle(userDetails, articleId);
//            return responseDto;
//        }
//        throw new CustomException(ErrorCode.AUTH_TOKEN_NOT_FOUND);
//    }
//
//    // 게시글 해결분 모아보기
//    @GetMapping("/api/articles/solved")
//    public List<ArticleResponseDto> readSolvedArticles() {
//        return articleService.readSolvedArticles();
//    }
//
//    // 게시글 미해결분 모아보기
//    @GetMapping("/api/articles/unsolved")
//    public List<ArticleResponseDto> readUnsolvedArticles() {
//        return articleService.readUnsolvedArticles();
//    }
}

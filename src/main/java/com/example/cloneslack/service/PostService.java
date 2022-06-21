package com.example.cloneslack.service;

import com.example.cloneslack.dto.requestdto.PostRequestDto;
import com.example.cloneslack.dto.responsedto.CommentResponseDto;
import com.example.cloneslack.dto.responsedto.PostResponseDto;
import com.example.cloneslack.exceptionhandler.CustomException;
import com.example.cloneslack.exceptionhandler.ErrorCode;
import com.example.cloneslack.model.Post;
import com.example.cloneslack.repository.PostRepository;
import com.example.cloneslack.repository.UserRepository;
import com.example.cloneslack.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.cloneslack.model.User;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 게시글 작성
    public PostResponseDto createPost(@AuthenticationPrincipal UserDetailsImpl userDetails, PostRequestDto requestDto) {
        Long userId = userDetails.getUser().getId();
//        String title = requestDto.getTitle();
        String contents = requestDto.getContents();
//        String category = requestDto.getCategory();

//        if (title.equals("")) throw new CustomException(ErrorCode.EMPTY_CONTENT);
        if (contents.equals("")) throw new CustomException(ErrorCode.EMPTY_CONTENT);
//        if (category.equals("")) throw new CustomException(ErrorCode.EMPTY_CONTENT);

        Post post = new Post(userId, requestDto);
        postRepository.save(post);

        User user = getUserDetails(post.getUserId());
        PostResponseDto responseDto = new PostResponseDto(post, user);
        return responseDto;
    }



    // 게시글 삭제
    @Transactional
    public void deletePost(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postId) {
        Long loginId = userDetails.getUser().getId();
        Post post = postRepository.findByPostId(postId).orElseThrow(
                () -> new CustomException(ErrorCode.ARTICLE_NOT_FOUND)
        );

        if (loginId != post.getUserId()) throw new CustomException(ErrorCode.INVALID_AUTHORITY);

        postRepository.deleteByPostId(postId);
    }

    // 게시글 목록 조회
//    public Page<Article> readArticles(int page) {
//        Sort sort = Sort.by(Sort.Direction.ASC, "createdAt");
//        Pageable pageable = PageRequest.of(page, 5, sort);
//        return articleRepository.findAll(pageable);
//    }
    public List<PostResponseDto> readPosts() {
        List<PostResponseDto> responseList = new ArrayList<>();
        List<Post> postList = postRepository.findAll();

        for(int i = 0; i < postList.size(); i++) {
            User user = getUserDetails(postList.get(i).getUserId());
            PostResponseDto responseDto = new PostResponseDto(postList.get(i), user);
            responseList.add(responseDto);
        }
        return responseList;

    }


    // 게시글 카테고리별 목록 조회
//    public List<ArticleResponseDto> readArticlesByCategory(String category) {
//        List<ArticleResponseDto> responseList = new ArrayList<>();
//        List<Article> articleList = articleRepository.findAllByCategory(category);
//
//        for(int i = 0; i < articleList.size(); i++) {
//            User user = getUserDetails(articleList.get(i).getUserId());
//            ArticleResponseDto responseDto = new ArticleResponseDto(articleList.get(i), user);
//            responseList.add(responseDto);
//        }
//        return responseList;
//    }

//     게시글 상세 조회
    public PostResponseDto readPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new CustomException(ErrorCode.ARTICLE_NOT_FOUND)
        );

        User user = getUserDetails(post.getUserId());
        PostResponseDto responseDto = new PostResponseDto(post, user);
        return responseDto;
    }
//    @Transactional
//    public DetailBoardResponseDto getBoard(Long id, UserDetailsImpl userDetails) {
//        Board board = boardRepository.findById(id).orElseThrow(
//                () -> new NotExistException()
//        );
//        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
//        for (Comment comment : board.getComments()) {
//            CommentResponseDto commentResponseDto = new CommentResponseDto(
//                    comment.getId(),
//                    comment.getUser().getNickname(),
//                    comment.getComment(),
//                    comment.getCreatedAt()
//            );
//            commentResponseDtos.add(commentResponseDto);
//        }
//
//
//        boolean checkLove = false;
//        for(Love love : board.getLoveList()) {
//            if (userDetails.getUser().getNickname() == love.getUser().getNickname() && board.getId() == love.getBoard().getId())
//                checkLove = true;
//        }
//
//        return new DetailBoardResponseDto(
//                board.getId(),
//                board.getNickname(),
//                board.getTitle(),
//                board.getContents(),
//                board.getUrl(),
//                board.getYear(),
//                board.getCreatedAt(),
//                board.getModifiedAt(),
//                checkLove,
//                commentResponseDtos
//        );
//    }
//
//     게시글 완료 처리
//    @Transactional
//    public ArticleResponseDto doneArticle(@AuthenticationPrincipal UserDetailsImpl userDetails, Long articleId) {
//        Long loginId = userDetails.getUser().getUserId();
//        Article article = articleRepository.findByArticleId(articleId).orElseThrow(
//                () -> new CustomException(ErrorCode.ARTICLE_NOT_FOUND)
//        );
//
//        if (loginId != article.getUserId()) throw new CustomException(ErrorCode.INVALID_AUTHORITY);
//
//        article.doneArticle();
//        articleRepository.save(article);
//
//        User user = getUserDetails(article.getUserId());
//        ArticleResponseDto responseDto = new ArticleResponseDto(article, user);
//        return responseDto;
//    }

    // 게시글 해결분 모아보기
   /* public List<ArticleResponseDto> readSolvedArticles() {
        List<ArticleResponseDto> responseList = new ArrayList<>();
        List<Article> articleList = articleRepository.findAllByDone(true);

        for(int i = 0; i < articleList.size(); i++) {
            User user = getUserDetails(articleList.get(i).getUserId());
            ArticleResponseDto responseDto = new ArticleResponseDto(articleList.get(i), user);
            responseList.add(responseDto);
        }
        return responseList;
    }*/

    // 게시글 미해결분 모아보기
//    public List<ArticleResponseDto> readUnsolvedArticles() {
//        List<ArticleResponseDto> responseList = new ArrayList<>();
//        List<Article> articleList = articleRepository.findAllByDone(false);
//
//        for(int i = 0; i < articleList.size(); i++) {
//            User user = getUserDetails(articleList.get(i).getUserId());
//            ArticleResponseDto responseDto = new ArticleResponseDto(articleList.get(i), user);
//            responseList.add(responseDto);
//        }
//        return responseList;


    // responseDto에 넣을 User 정보 불러오기
    private User getUserDetails(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );
        return user;
        //요렇게 불러오고 이거를 여기저기서 가져다가 쓰는건가보다
    }

    @Transactional
    public PostResponseDto updatePost(@AuthenticationPrincipal UserDetailsImpl userDetails, Long postId, PostRequestDto requestDto) {
        Long loginId = userDetails.getUser().getId();
//        String title = requestDto.getTitle();
        String contents = requestDto.getContents();
//        String category = requestDto.getCategory();
        Post post = postRepository.findByPostId(postId).orElseThrow(
                () -> new CustomException(ErrorCode.ARTICLE_NOT_FOUND)
        );

        if (loginId != post.getUserId()) throw new IllegalArgumentException("로그인 정보가 일치하지 않습니다.");

//        if (title.equals("")) throw new CustomException(ErrorCode.EMPTY_CONTENT);
        if (contents.equals("")) throw new CustomException(ErrorCode.EMPTY_CONTENT);
//        if (category.equals("")) throw new CustomException(ErrorCode.EMPTY_CONTENT);

        post.updatePost(requestDto);
        postRepository.save(post);

        User user = getUserDetails(post.getUserId());
        PostResponseDto responseDto = new PostResponseDto(post, user);
        return responseDto;
    }

}
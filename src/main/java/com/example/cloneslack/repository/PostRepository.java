package com.example.cloneslack.repository;

import com.example.cloneslack.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
//    Page<Post> findAll(Pageable pageable);

    List<Post> findAllByOrderByModifiedAtDesc();
    //이거 모디파이드 말고 그리애이트 앳으로 바꿔야 되나??

    Optional<Post> findByPostId(Long postId);

    void deleteByPostId(Long postId);

//    List<Post> findAllByCategory(String category);
//
//    List<Post> findAllByDone(Boolean done);
}

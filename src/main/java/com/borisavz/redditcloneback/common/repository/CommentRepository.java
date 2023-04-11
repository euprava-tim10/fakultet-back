package com.borisavz.redditcloneback.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "" +
            " SELECT (" +
            "     SELECT COUNT(*)" +
            "     FROM reaction r" +
            "     WHERE r.type = 0" +
            "     AND r.comment_id = ?1" +
            " ) - (" +
            "     SELECT COUNT(*)" +
            "     FROM reaction r" +
            "     WHERE r.type = 1" +
            "     AND r.comment_id = ?1" +
            " ) AS karma",
            nativeQuery = true)
    int getCommentKarma(long commentId);

    @Query(value = "SELECT * FROM comment WHERE post_id = ?1 AND child = false AND deleted = 0",
            nativeQuery = true)
    List<Comment> findCommentsForPost(long postId);
}

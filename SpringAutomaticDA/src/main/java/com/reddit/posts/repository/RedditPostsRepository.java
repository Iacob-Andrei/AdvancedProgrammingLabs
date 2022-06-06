package com.reddit.posts.repository;

import com.reddit.posts.RedditPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedditPostsRepository extends JpaRepository<RedditPost, String> {

    @Query("SELECT p FROM RedditPost p ORDER BY p.score DESC")
    List<RedditPost> findTopPosts();

    @Query("SELECT AVG(p.negative) FROM RedditPost p")
    Double avgNegative();

    @Query("SELECT AVG(p.neutral) FROM RedditPost p")
    Double avgNeutral();

    @Query("SELECT AVG(p.positive) FROM RedditPost p")
    Double avgPositive();

    @Query("SELECT p FROM RedditPost p WHERE p.neutral IS NULL")
    List<RedditPost> toAnalyze();
}

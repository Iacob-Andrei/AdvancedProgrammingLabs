package com.reddit.comments.repository;

import com.reddit.comments.RedditComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedditCommentsRepository extends JpaRepository<RedditComment, String> {

    @Query("SELECT c FROM RedditComment c ORDER BY c.score")
    List<RedditComment> getTop();

    @Query("SELECT COUNT(c) FROM RedditComment c WHERE c.sentiment = 'negative'")
    int getCountNegative();

    @Query("SELECT COUNT(c) FROM RedditComment c WHERE c.sentiment = 'neutral'")
    int getCountNeutral();

    @Query("SELECT COUNT(c) FROM RedditComment c WHERE c.sentiment = 'positive'")
    int getCountPositive();

    @Query("SELECT c FROM RedditComment c WHERE c.sentiment IS NULL")
    List<RedditComment> toAnalyze();
}

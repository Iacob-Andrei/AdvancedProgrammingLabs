package com.twitter.repository;

import com.twitter.TwitterPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TwitterRepository extends JpaRepository<TwitterPost, Long> {

    @Query("SELECT p FROM TwitterPost p ORDER BY p.retweets DESC")
    List<TwitterPost> getPopular();

    @Query("SELECT COUNT(c) FROM TwitterPost c WHERE c.sentiment = 'negative'")
    int getCountNegative();

    @Query("SELECT COUNT(c) FROM TwitterPost c WHERE c.sentiment = 'neutral'")
    int getCountNeutral();

    @Query("SELECT COUNT(c) FROM TwitterPost c WHERE c.sentiment = 'positive'")
    int getCountPositive();

    @Query("SELECT p from TwitterPost p WHERE p.sentiment IS NULL")
    List<TwitterPost> toAnalyze();
}

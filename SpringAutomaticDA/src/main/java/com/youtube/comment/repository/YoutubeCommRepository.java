package com.youtube.comment.repository;

import com.youtube.comment.YoutubeComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface YoutubeCommRepository extends JpaRepository<YoutubeComment, String> {

    @Query("SELECT c FROM YoutubeComment c ORDER BY c.likes DESC ")
    List<YoutubeComment> getTop();

    @Query("SELECT COUNT(c) FROM YoutubeComment c WHERE c.sentiment = 'negative'")
    int getCountNegative();

    @Query("SELECT COUNT(c) FROM YoutubeComment c WHERE c.sentiment = 'neutral'")
    int getCountNeutral();

    @Query("SELECT COUNT(c) FROM YoutubeComment c WHERE c.sentiment = 'positive'")
    int getCountPositive();

    @Query("SELECT c FROM YoutubeComment c WHERE c.sentiment IS NULL ")
    List<YoutubeComment> toAnalyze();
}

package com.youtube.video.repository;

import com.youtube.video.YoutubeVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YoutubeVideoRepository extends JpaRepository<YoutubeVideo, String> {

    @Query("SELECT COUNT(c) FROM YoutubeVideo c WHERE c.sentiment = 'negative'")
    int getCountNegative();

    @Query("SELECT COUNT(c) FROM YoutubeVideo c WHERE c.sentiment = 'neutral'")
    int getCountNeutral();

    @Query("SELECT COUNT(c) FROM YoutubeVideo c WHERE c.sentiment = 'positive'")
    int getCountPositive();

    @Query("SELECT v FROM YoutubeVideo v WHERE v.sentiment IS NULL")
    List<YoutubeVideo> toAnalyze();
}

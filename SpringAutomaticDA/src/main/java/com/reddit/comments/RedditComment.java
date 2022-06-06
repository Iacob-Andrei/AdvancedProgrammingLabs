package com.reddit.comments;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reddit_comments")
public class RedditComment {
    @Id
    @Column(name = "id", nullable = false, length = 40)
    private String id;

    @Column(name = "id_post", nullable = false, length = 10)
    private String idPost;

    @Lob
    @Column(name = "selftext")
    private String selftext;

    @Column(name = "score")
    private Integer score;

    @Column(name = "award_score")
    private Integer awardScore;

    @Column(name = "sentiment", length = 20)
    private String sentiment;

    @Column(name = "created_utc")
    private LocalDate createdUtc;

    @Column(name = "selftext_translated")
    private String selftextTranslated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAwardScore() {
        return awardScore;
    }

    public void setAwardScore(Integer awardScore) {
        this.awardScore = awardScore;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public LocalDate getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(LocalDate createdUtc) {
        this.createdUtc = createdUtc;
    }

    public String getSelftextTranslated() {
        return selftextTranslated;
    }

    public void setSelftextTranslated(String selftextTranslated) {
        this.selftextTranslated = selftextTranslated;
    }

}
package com.twitter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "twitter_posts")
public class TwitterPost {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "likes")
    private Integer likes;

    @Column(name = "retweets")
    private Integer retweets;

    @Column(name = "text", length = 300)
    private String text;

    @Column(name = "created_utc")
    private LocalDate createdUtc;

    @Column(name = "sentiment", length = 10)
    private String sentiment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getRetweets() {
        return retweets;
    }

    public void setRetweets(Integer retweets) {
        this.retweets = retweets;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(LocalDate createdUtc) {
        this.createdUtc = createdUtc;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TwitterPost{");
        sb.append("id=").append(id);
        sb.append(", likes=").append(likes);
        sb.append(", retweets=").append(retweets);
        sb.append(", text='").append(text).append('\'');
        sb.append(", createdUtc=").append(createdUtc);
        sb.append(", sentiment='").append(sentiment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
package com.reddit.posts;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reddit_posts")
public class RedditPost {
    @Id
    @Column(name = "id", nullable = false, length = 100)
    private String id;

    @Column(name = "subreddit", length = 300)
    private String subreddit;

    @Column(name = "title", length = 2000)
    private String title;

    @Column(name = "selftext")
    private String selftext;

    @Column(name = "score")
    private Integer score;

    @Column(name = "award_score")
    private Integer awardScore;

    @Column(name = "views")
    private Integer views;

    @Column(name = "created_utc")
    private LocalDate createdUtc;

    @Column(name = "positive")
    private Double positive;

    @Column(name = "negative")
    private Double negative;

    @Column(name = "neutral")
    private Double neutral;

    @Column(name = "title_translated", length = 2000)
    private String titleTranslated;

    @Column(name = "selftext_translated")
    private String selftextTranslated;

    @Column(name = "link", length = 40)
    private String link;

    @Column(name = "sentiment")
    private String sentiment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public LocalDate getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(LocalDate createdUtc) {
        this.createdUtc = createdUtc;
    }

    public Double getPositive() {
        return positive;
    }

    public void setPositive(Double positive) {
        this.positive = positive;
    }

    public Double getNegative() {
        return negative;
    }

    public void setNegative(Double negative) {
        this.negative = negative;
    }

    public Double getNeutral() {
        return neutral;
    }

    public void setNeutral(Double neutral) {
        this.neutral = neutral;
    }

    public String getTitleTranslated() {
        return titleTranslated;
    }

    public void setTitleTranslated(String titleTranslated) {
        this.titleTranslated = titleTranslated;
    }

    public String getSelftextTranslated() {
        return selftextTranslated;
    }

    public void setSelftextTranslated(String selftextTranslated) {
        this.selftextTranslated = selftextTranslated;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RedditPost{");
        sb.append("id='").append(id).append('\'');
        sb.append(", subreddit='").append(subreddit).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", selftext='").append(selftext).append('\'');
        sb.append(", score=").append(score);
        sb.append(", awardScore=").append(awardScore);
        sb.append(", views=").append(views);
        sb.append(", createdUtc=").append(createdUtc);
        sb.append(", positive=").append(positive);
        sb.append(", negative=").append(negative);
        sb.append(", neutral=").append(neutral);
        sb.append(", titleTranslated='").append(titleTranslated).append('\'');
        sb.append(", selftextTranslated='").append(selftextTranslated).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append(", sentiment='").append(sentiment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
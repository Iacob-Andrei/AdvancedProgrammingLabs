package com.youtube.video;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "youtube_videos")
public class YoutubeVideo {
    @Id
    @Column(name = "id", nullable = false, length = 30)
    private String id;

    @Column(name = "score")
    private Integer score;

    @Column(name = "title", length = 300)
    private String title;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "sentiment", length = 20)
    private String sentiment;

    @Column(name = "created_utc")
    private LocalDate createdUtc;

    @Column(name = "title_translated", length = 300)
    private String titleTranslated;

    @Column(name = "description_translated", length = 1000)
    private String descriptionTranslated;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "link", length = 50)
    private String link;

    @Column(name = "author")
    private String author;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getTitleTranslated() {
        return titleTranslated;
    }

    public void setTitleTranslated(String titleTranslated) {
        this.titleTranslated = titleTranslated;
    }

    public String getDescriptionTranslated() {
        return descriptionTranslated;
    }

    public void setDescriptionTranslated(String descriptionTranslated) {
        this.descriptionTranslated = descriptionTranslated;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("YoutubeVideo{");
        sb.append("id='").append(id).append('\'');
        sb.append(", score=").append(score);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", sentiment='").append(sentiment).append('\'');
        sb.append(", createdUtc=").append(createdUtc);
        sb.append(", titleTranslated='").append(titleTranslated).append('\'');
        sb.append(", descriptionTranslated='").append(descriptionTranslated).append('\'');
        sb.append(", thumbnail='").append(thumbnail).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
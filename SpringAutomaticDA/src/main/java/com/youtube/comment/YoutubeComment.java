package com.youtube.comment;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "youtube_comments")
public class YoutubeComment {
    @Id
    @Column(name = "id", nullable = false, length = 30)
    private String id;

    @Column(name = "id_video", nullable = false, length = 30)
    private String idVideo;

    @Column(name = "likes")
    private Integer likes;

    @Column(name = "text")
    private String text;

    @Column(name = "sentiment", length = 20)
    private String sentiment;

    @Column(name = "created_utc")
    private LocalDate createdUtc;

    @Column(name = "author")
    private String author;

    @Column(name = "text_translated")
    private String textTranslated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTextTranslated() {
        return textTranslated;
    }

    public void setTextTranslated(String textTranslated) {
        this.textTranslated = textTranslated;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("YoutubeComment{");
        sb.append("id='").append(id).append('\'');
        sb.append(", idVideo='").append(idVideo).append('\'');
        sb.append(", likes=").append(likes);
        sb.append(", text='").append(text).append('\'');
        sb.append(", sentiment='").append(sentiment).append('\'');
        sb.append(", createdUtc=").append(createdUtc);
        sb.append(", author='").append(author).append('\'');
        sb.append(", textTranslated='").append(textTranslated).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
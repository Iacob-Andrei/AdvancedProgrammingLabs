package com.analyzer.controller;

import com.reddit.comments.service.RedditCommService;
import com.reddit.posts.service.RedditPostsService;
import com.twitter.service.TwitterService;
import com.youtube.comment.service.YoutubeCommService;
import com.youtube.video.service.YoutubeVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("analyzer")
public class AnalyzerController {

    private final RedditCommService redditCommService;
    private final RedditPostsService redditPostsService;
    private final YoutubeVideoService youtubeVideoService;
    private final YoutubeCommService youtubeCommService;
    private final TwitterService twitterService;

    @Autowired
    public AnalyzerController(RedditCommService redditCommService, RedditPostsService redditPostsService, YoutubeVideoService youtubeVideoService, YoutubeCommService youtubeCommService, TwitterService twitterService) {
        this.redditCommService = redditCommService;
        this.redditPostsService = redditPostsService;
        this.youtubeVideoService = youtubeVideoService;
        this.youtubeCommService = youtubeCommService;
        this.twitterService = twitterService;
    }

    @GetMapping
    public List<Object> analyze(){

        List<Object> updated = new ArrayList<>();
        updated.add(redditCommService.analyze());
        updated.add(redditPostsService.analyze());
        updated.add(youtubeCommService.analyze());
        updated.add(youtubeVideoService.analyze());
        updated.add(twitterService.analyze());

        System.out.println("Done");
        return updated;
    }
}

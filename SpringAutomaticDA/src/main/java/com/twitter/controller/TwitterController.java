package com.twitter.controller;

import com.twitter.TwitterPost;
import com.twitter.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("twitter")
public class TwitterController {

    private final TwitterService twitterService;

    @Autowired
    public TwitterController(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @GetMapping
    public List<TwitterPost> getPosts(){
        return twitterService.getPosts();
    }

    @GetMapping(path="{idPost}")
    public Optional<TwitterPost> getPost(@PathVariable Long idPost){
        return twitterService.getPost(idPost);
    }

    @GetMapping(path="statistics")
    public Map<String, Double> getStatistics(){
        return twitterService.getStatistics();
    }

    @GetMapping(path="retweets")
    public List<TwitterPost> getPopular(){
        return twitterService.getPopular();
    }
}

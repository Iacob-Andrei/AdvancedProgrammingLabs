package com.reddit.posts.controller;

import com.reddit.posts.RedditPost;
import com.reddit.posts.service.RedditPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("reddit/posts")
public class RedditPostsController {

    private final RedditPostsService redditPostsService;

    @Autowired
    public RedditPostsController(RedditPostsService redditPostsService) {
        this.redditPostsService = redditPostsService;
    }

    @GetMapping
    public List<RedditPost> getPosts(){
        return redditPostsService.getPosts();
    }

    //1kdwim
    @GetMapping(path="{idPost}")
    public Optional<RedditPost> getPost(@PathVariable("idPost") String id){
        return redditPostsService.getPost(id);
    }

    @GetMapping(path="top")
    public List<RedditPost> getTop(){
        return redditPostsService.getTop();
    }

    @GetMapping(path="statistics")
    public Map<String, Double> getStatistics(){
        return redditPostsService.getStatistics();
    }
}

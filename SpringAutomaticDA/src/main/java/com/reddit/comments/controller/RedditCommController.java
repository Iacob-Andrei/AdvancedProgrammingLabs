package com.reddit.comments.controller;


import com.reddit.comments.RedditComment;
import com.reddit.comments.service.RedditCommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("reddit/comms")
public class RedditCommController {

    private final RedditCommService redditCommService;

    @Autowired
    public RedditCommController(RedditCommService redditCommService) {
        this.redditCommService = redditCommService;
    }

    @GetMapping
    public List<RedditComment> getComms(){
        return redditCommService.getComms();
    }

    //cy6q2wo
    @GetMapping(path="/{idComm}")
    public Optional<RedditComment> getComm(@PathVariable String idComm){
        return redditCommService.getComm(idComm);
    }

    @GetMapping(path="statistics")
    public Map<String, Double> getStatistics(){
        return redditCommService.getStatistics();
    }

    @GetMapping(path="top")
    public List<RedditComment> getTop(){
        return redditCommService.getTop();
    }
}

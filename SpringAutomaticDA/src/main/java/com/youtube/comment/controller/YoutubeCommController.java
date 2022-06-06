package com.youtube.comment.controller;

import com.youtube.comment.YoutubeComment;
import com.youtube.comment.service.YoutubeCommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("youtube/comm")
public class YoutubeCommController {

    private final YoutubeCommService youtubeCommService;

    @Autowired
    public YoutubeCommController(YoutubeCommService youtubeCommService) {
        this.youtubeCommService = youtubeCommService;
    }

    @GetMapping
    public List<YoutubeComment> getComments(){
        return youtubeCommService.getComments();
    }

    @GetMapping(path="top")
    public List<YoutubeComment> getTop(){
        return youtubeCommService.getTop();
    }

    @GetMapping(path="{idComm}")
    public Optional<YoutubeComment> getComment(@PathVariable String idComm){
        return youtubeCommService.getComment(idComm);
    }

    @GetMapping(path="statistics")
    public Map<String, Double> getStatistics(){
        return youtubeCommService.getStatistics();
    }
}

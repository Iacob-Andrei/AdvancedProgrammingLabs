package com.youtube.video.controller;

import com.youtube.video.YoutubeVideo;
import com.youtube.video.service.YoutubeVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("youtube/video")
public class YoutubeVideoController {

    private final YoutubeVideoService youtubeVideoService;

    @Autowired
    public YoutubeVideoController(YoutubeVideoService youtubeVideoService) {
        this.youtubeVideoService = youtubeVideoService;
    }

    @GetMapping
    public List<YoutubeVideo> getVideos(){
        return youtubeVideoService.getVideos();
    }

    @GetMapping(path="{idVideo}")
    public Optional<YoutubeVideo> getVideo(@PathVariable String idVideo){
        return youtubeVideoService.getVideo(idVideo);
    }

    @GetMapping(path="statistics")
    public Map<String, Double> getStatistics(){
        return youtubeVideoService.getStatistics();
    }
}

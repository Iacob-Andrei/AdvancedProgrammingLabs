package com.youtube.video.service;

import com.analyzer.stanfordCore.NLP;
import com.youtube.video.YoutubeVideo;
import com.youtube.video.repository.YoutubeVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class YoutubeVideoService {

    private final YoutubeVideoRepository youtubeVideoRepository;

    @Autowired
    public YoutubeVideoService(YoutubeVideoRepository youtubeVideoRepository) {
        this.youtubeVideoRepository = youtubeVideoRepository;
    }

    public List<YoutubeVideo> getVideos() {
        return youtubeVideoRepository.findAll().subList(0, 20);
    }

    public Optional<YoutubeVideo> getVideo(String idVideo) {
        return youtubeVideoRepository.findById(idVideo);
    }

    public Map<String, Double> getStatistics() {
        int countNegative = youtubeVideoRepository.getCountNegative();
        int countNeutral = youtubeVideoRepository.getCountNeutral();
        int countPositive = youtubeVideoRepository.getCountPositive();
        long total = youtubeVideoRepository.count();

        Map<String, Double> map= new HashMap<>();
        map.put("negative", (double)countNegative/total*100);
        map.put("neutral", (double)countNeutral/total*100);
        map.put("positive", (double)countPositive/total*100);
        return map;
    }

    private static String predominantSentiment(List<Double> sentimentList){

        String sentiment = "negative";
        double predominant = sentimentList.get(0);

        if( sentimentList.get(0) < sentimentList.get(1) ){
            predominant = sentimentList.get(1);
            sentiment = "neutral";
        }
        if( predominant < sentimentList.get(2) ){
            sentiment = "positive";
        }

        return sentiment;
    }

    private static String selectText(String description, String descriptionTranslated, String title, String titleTranslated){

        String toAnalyze = "";
        if( titleTranslated != null )
            toAnalyze = toAnalyze.concat(titleTranslated);
        else if( title != null)
            toAnalyze = toAnalyze.concat(title);

        if( descriptionTranslated != null )
            toAnalyze = toAnalyze.concat(descriptionTranslated);
        else if( description != null)
            toAnalyze = toAnalyze.concat(description);

        return toAnalyze;
    }

    public List<YoutubeVideo> analyze() {

        List<YoutubeVideo> toAnalyze = youtubeVideoRepository.toAnalyze();
        for(YoutubeVideo video : toAnalyze){

            List<Double> sentimentList = NLP.estimatingSentiment(selectText(video.getDescription(), video.getDescriptionTranslated(), video.getTitle(), video.getTitleTranslated()));
            video.setSentiment(predominantSentiment(sentimentList));
            //youtubeVideoRepository.save(video);
        }
        return toAnalyze;
    }
}

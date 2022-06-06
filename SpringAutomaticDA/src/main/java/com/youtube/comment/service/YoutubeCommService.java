package com.youtube.comment.service;

import com.analyzer.stanfordCore.NLP;
import com.youtube.comment.YoutubeComment;
import com.youtube.comment.repository.YoutubeCommRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class YoutubeCommService {

    private final YoutubeCommRepository youtubeCommRepository;

    @Autowired
    public YoutubeCommService(YoutubeCommRepository youtubeCommRepository) {
        this.youtubeCommRepository = youtubeCommRepository;
    }

    public List<YoutubeComment> getComments() {
        return youtubeCommRepository.findAll().subList(0, 20);
    }

    public List<YoutubeComment> getTop() {
        return youtubeCommRepository.getTop().subList(0, 5);
    }

    public Optional<YoutubeComment> getComment(String idComm) {
        return youtubeCommRepository.findById(idComm);
    }

    public Map<String, Double> getStatistics() {
        int countNegative = youtubeCommRepository.getCountNegative();
        int countNeutral = youtubeCommRepository.getCountNeutral();
        int countPositive = youtubeCommRepository.getCountPositive();
        long total = youtubeCommRepository.count();

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

    public List<YoutubeComment> analyze() {

        List<YoutubeComment> toAnalyze = youtubeCommRepository.toAnalyze();

        for( YoutubeComment comment : toAnalyze ){

            List<Double> sentimentList;
            if( !(comment.getTextTranslated() == null && comment.getText() == null) ){
                if( comment.getTextTranslated() != null ){
                    sentimentList = NLP.estimatingSentiment(comment.getTextTranslated());
                }else{
                    sentimentList = NLP.estimatingSentiment(comment.getText());
                }
                comment.setSentiment(predominantSentiment(sentimentList));
                //youtubeCommRepository.save(comment);
            }
        }
        return toAnalyze;
    }

}

package com.twitter.service;

import com.analyzer.stanfordCore.NLP;
import com.twitter.TwitterPost;
import com.twitter.repository.TwitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TwitterService {

    private final TwitterRepository twitterRepository;

    @Autowired
    public TwitterService(TwitterRepository twitterRepository) {
        this.twitterRepository = twitterRepository;
    }

    public List<TwitterPost> getPosts() {
        return twitterRepository.findAll().subList(0, 20);
    }

    public Optional<TwitterPost> getPost(Long idPost) {
        return twitterRepository.findById(idPost);
    }

    public Map<String, Double> getStatistics() {
        int countNegative = twitterRepository.getCountNegative();
        int countNeutral = twitterRepository.getCountNeutral();
        int countPositive = twitterRepository.getCountPositive();
        long total = twitterRepository.count();

        Map<String, Double> map= new HashMap<>();
        map.put("negative", (double)countNegative/total*100);
        map.put("neutral", (double)countNeutral/total*100);
        map.put("positive", (double)countPositive/total*100);
        return map;
    }

    public List<TwitterPost> getPopular() {
        return twitterRepository.getPopular().subList(0, 5);
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

    public List<TwitterPost> analyze() {

        List<TwitterPost> toAnalyze = twitterRepository.toAnalyze();
        for(TwitterPost post : toAnalyze){

            List<Double> sentimentList = NLP.estimatingSentiment(post.getText());
            post.setSentiment(predominantSentiment(sentimentList));
            //twitterRepository.save(post);
        }
        return toAnalyze;
    }
}

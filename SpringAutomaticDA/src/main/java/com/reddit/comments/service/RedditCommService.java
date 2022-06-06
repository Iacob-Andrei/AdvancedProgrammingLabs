package com.reddit.comments.service;

import com.analyzer.stanfordCore.NLP;
import com.reddit.comments.RedditComment;
import com.reddit.comments.repository.RedditCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RedditCommService {

    private final RedditCommentsRepository redditCommentsRepository;

    @Autowired
    public RedditCommService(RedditCommentsRepository redditCommentsRepository) {
        this.redditCommentsRepository = redditCommentsRepository;
    }

    public List<RedditComment> getComms() {
        return redditCommentsRepository.findAll().subList(0, 20);
    }

    public Optional<RedditComment> getComm(String id) {
        return redditCommentsRepository.findById(id);
    }

    public Map<String, Double> getStatistics() {
        int countNegative = redditCommentsRepository.getCountNegative();
        int countNeutral = redditCommentsRepository.getCountNeutral();
        int countPositive = redditCommentsRepository.getCountPositive();
        long total = redditCommentsRepository.count();

        Map<String, Double> map= new HashMap<>();
        map.put("negative", (double)countNegative/total*100);
        map.put("neutral", (double)countNeutral/total*100);
        map.put("positive", (double)countPositive/total*100);
        return map;
    }

    public List<RedditComment> getTop() {
        return redditCommentsRepository.getTop().subList(0, 5);
    }

    public static String predominantSentiment(List<Double> sentimentList){

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

    public List<RedditComment> analyze() {

        List<RedditComment> toAnalyze = redditCommentsRepository.toAnalyze();

        for(RedditComment comment : toAnalyze){

            List<Double> sentimentList = NLP.estimatingSentiment(comment.getSelftext());
            comment.setSentiment(predominantSentiment(sentimentList));
            System.out.println(comment);

            //redditCommentsRepository.save(comment);
        }
        return toAnalyze;
    }
}

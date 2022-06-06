package com.reddit.posts.service;

import com.analyzer.stanfordCore.NLP;
import com.reddit.posts.RedditPost;
import com.reddit.posts.repository.RedditPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RedditPostsService {
    private final RedditPostsRepository redditPostsRepository;

    @Autowired
    public RedditPostsService(RedditPostsRepository redditPostsRepository) {
        this.redditPostsRepository = redditPostsRepository;
    }

    public List<RedditPost> getPosts() {
        return redditPostsRepository.findAll().subList(0,20);
    }

    public Optional<RedditPost> getPost(String id) {
        return redditPostsRepository.findById(id);
    }

    public List<RedditPost> getTop() {
        return redditPostsRepository.findTopPosts().subList(0,5);
    }

    public Map<String, Double> getStatistics() {
        Map<String, Double> map = new HashMap<>();
        map.put("negative", redditPostsRepository.avgNegative());
        map.put("neutral", redditPostsRepository.avgNeutral());
        map.put("positive", redditPostsRepository.avgPositive());
        return map;
    }

    public List<RedditPost> analyze() {

        List<RedditPost> toAnalyze = redditPostsRepository.toAnalyze();

        for( RedditPost post : toAnalyze ){
            String text;
            if( post.getSelftext() == null ){
                text = post.getTitle();
            }else{
                text = post.getTitle().concat(". ").concat(post.getSelftext());
            }

            List<Double> sentimentList = NLP.estimatingSentiment(text); // poz 0 - % negative sentiment | poz 1 - % neutral sentiment | poz 2 - % positive sentiment
            post.setNegative(sentimentList.get(0));
            post.setNeutral(sentimentList.get(1));
            post.setPositive(sentimentList.get(2));

            //redditPostsRepository.save(post);
        }
        return toAnalyze;
    }
}

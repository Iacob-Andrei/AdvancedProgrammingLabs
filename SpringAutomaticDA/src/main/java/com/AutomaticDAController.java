package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class AutomaticDAController {

    @GetMapping
    public String hello(){
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>This is the main page for Automatic DA. Hello!</h1>").append(
                "<h2>Useful commands:</h2>");
        sb.append("<ol>" +
                "<li><h3>Reddit</h3></li>" +
                    "<ul>" +
                        "<li><h4>Reddit Posts</h4></li>" +
                            "<ul>" +
                                "<li> <a href=\"http://localhost:8081/reddit/posts\">/reddit/posts</a> - print a few reddit posts that were analyzed.</li>" +
                                "<li> <a href=\"http://localhost:8081/reddit/posts/1kdwim\">/reddit/posts/{idPost}</a>   - print a post that has the specified id.</li>" +
                                "<li> <a href=\"http://localhost:8081/reddit/posts/top\">/reddit/posts/top</a> - prints the most popular reddit posts.</li>" +
                                "<li> <a href=\"http://localhost:8081/reddit/posts/statistics\">/reddit/posts/statistics</a> - print a general statistic about the percentage of texts sentiments.</li>" +
                            "</ul>" +
                        "<li><h4>Reddit Comments</h4></li>" +
                            "<ul>" +
                                "<li> <a href=\"http://localhost:8081/reddit/comms\">/reddit/comms</a>  - print a few reddit comments that were analyzed.</li>" +
                                "<li> <a href=\"http://localhost:8081/reddit/comms/dpqt3fx\">/reddit/comms/{idPost}</a>  - print a reddit comment that has the specified id.</li>" +
                                "<li> <a href=\"http://localhost:8081/reddit/comms/top\">/reddit/comms/top</a> - prints the most popular reddit comments.</li>" +
                                "<li> <a href=\"http://localhost:8081/reddit/comms/statistics\">/reddit/comms/statistics</a> - print a general statistic about the percentage of texts sentiments.</li>" +
                            "</ul>" +
                    "</ul>" +
                "<li><h3>Youtube</h3></li>" +
                    "<ul>" +
                        "<li>Youtube Videos</li>" +
                            "<ul>" +
                                "<li> <a href=\"http://localhost:8081/youtube/video\">/youtube/video</a>  - prints a few youtube videos that were analyzed.</li>" +
                                "<li> <a href=\"http://localhost:8081/youtube/video/_010Uj4uUt4\">/youtube/video/{idVideo}</a>  - print a video that has the specified id.</li>" +
                                "<li> <a href=\"http://localhost:8081/youtube/video/statistics\">/youtube/video/statistics</a>  - print a general statistic about the percentage of texts sentiments.</li>" +
                            "</ul>" +
                        "<li>Youtube Comments</li>" +
                            "<ul>" +
                                "<li> <a href=\"http://localhost:8081/youtube/comm\">/youtube/comm</a> - prints a few youtube videos that were analyzed.</li>" +
                                "<li> <a href=\"http://localhost:8081/youtube/comm/Ugg0kXsS-b\">/youtube/comm/{idComm}</a> - print a video that has the specified id.</li>" +
                                "<li> <a href=\"http://localhost:8081/youtube/comm/top\">/youtube/comm/top</a> - print the most popular comments</li>" +
                                "<li> <a href=\"http://localhost:8081/youtube/comm/statistics\">/youtube/comm/statistics</a> - print a general statistic about the percentage of texts sentiments.</li>" +
                            "</ul>" +
                    "</ul>" +
                "<li><h3>Twitter Posts</h3></li>" +
                    "<ul>" +
                        "<li> <a href=\"http://localhost:8081/twitter\">/twitter</a> - prints a few twitter posts that were analyzed.</li>" +
                        "<li> <a href=\"http://localhost:8081/twitter/1514175865634050000\">/twitter/{idPost}</a> - print the posts that has the specified id.</li>" +
                        "<li> <a href=\"http://localhost:8081/twitter/retweets\">/twitter/retweets</a> - print the tweets with the most number of retweets.</li>" +
                        "<li> <a href=\"http://localhost:8081/twitter/statistics\">/twitter/statistics</a> - print a general statistics about the percentage of texts sentiments.</li>" +
                    "</ul>" +
                "<li><h3> <a href=\"http://localhost:8081//swagger-ui/index.html#/\">Swagger </a></h3></li>" +
                "</ol>");
        return sb.toString();
    }
}

package org.prash.newszilla.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prash.newszilla.dto.News;
import org.prash.newszilla.exception.NewsNotFound;
import org.prash.newszilla.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Project: NewsZill
 * Author: bittu
 * Date: 11-06-2024
 */

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
@Slf4j
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> getAllNews(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        log.info("NewsService::getAllNews Triggered Request Prams page:{}, size:{}", page, size);
        return ResponseEntity.ok(newsService.getAllNews(page, size));
    }

    @PostMapping
    public ResponseEntity<News> createNews(@RequestBody News news) throws URISyntaxException {
        log.info("NewsService::createNews Triggered");
        log.info("Request: {}", news);
        News newNews = newsService.createNews(news);
        log.info("Response: {}", newNews);
        return ResponseEntity.created(new URI("/" + newNews.id()))
                .body(newNews);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNews(@PathVariable Integer id) {

        boolean isNewsDeleted = newsService.deleteNews(id);
        if (isNewsDeleted) {
            return ResponseEntity.ok("NEWS deleted Successfully");
        }
        log.warn("News with id:{} not found", id);
        throw new NewsNotFound("NEWS not found with Id: " + id);
    }
}

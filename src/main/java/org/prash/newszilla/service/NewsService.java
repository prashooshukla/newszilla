package org.prash.newszilla.service;

import lombok.RequiredArgsConstructor;
import org.prash.newszilla.dto.News;
import org.prash.newszilla.entity.NewsEntity;
import org.prash.newszilla.repository.NewsRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Project: NewsZilla
 * Author: bittu
 * Date: 11-06-2024
 */

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public List<News> getAllNews(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return newsRepository.findAll(pageable).getContent()
                .stream()
                .map(news -> new News(news.getId(), news.getTitle(), news.getContent(), news.getAuthor(), news.getPublishedDate(), news.getSource(), news.getCategory(), news.getCreatedAt()))
                .toList();
    }


    public News createNews(News news) {
        
        NewsEntity newsEntity = NewsEntity.builder()
                .title(news.title())
                .content(news.content())
                .author(news.author())
                .publishedDate(news.publishedDate())
                .source(news.source())
                .category(news.category())
                .createdAt(LocalDateTime.now())
                .build();
        
        NewsEntity savedNews = newsRepository.save(newsEntity);
        return new News(savedNews.getId(), savedNews.getTitle(), savedNews.getContent(), savedNews.getAuthor(), savedNews.getPublishedDate(), savedNews.getSource(), savedNews.getCategory(), savedNews.getCreatedAt());
    }

    public boolean deleteNews(Integer id) {

        if (newsRepository.existsById(id)) {
            newsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<News> getLatestNews() {
        return newsRepository.findTop4ByOrderByCreatedAtDesc()
                .stream()
                .map(news -> new News(news.getId(), news.getTitle(), news.getContent(), news.getAuthor(), news.getPublishedDate(), news.getSource(), news.getCategory(), news.getCreatedAt()))
                .toList();
    }
}

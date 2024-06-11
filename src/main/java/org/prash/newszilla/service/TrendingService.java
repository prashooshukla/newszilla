package org.prash.newszilla.service;

import lombok.RequiredArgsConstructor;
import org.prash.newszilla.dto.News;
import org.prash.newszilla.dto.Video;
import org.prash.newszilla.repository.NewsRepository;
import org.prash.newszilla.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Project: NewsZill
 * Author: bittu
 * Date: 11-06-2024
 */

@Service
@RequiredArgsConstructor
public class TrendingService {

    private final VideoService videoService;
    private final NewsService newsService;

    public List<Object> getTopTrending() {
        List<Video> latestVideos = videoService.getLatestVideos();
        List<News> latestNews = newsService.getLatestNews();

        List<Object> combinedList = new ArrayList<>();
        combinedList.addAll(latestVideos);
        combinedList.addAll(latestNews);

        combinedList.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                LocalDateTime createdAt1 = (o1 instanceof Video) ? ((Video) o1).createdAt() : ((News) o1).createdAt();
                LocalDateTime createdAt2 = (o2 instanceof Video) ? ((Video) o2).createdAt() : ((News) o2).createdAt();
                return createdAt2.compareTo(createdAt1);
            }
        });

        if (combinedList.size() > 4) {
            return combinedList.subList(0, 4);
        }
        return combinedList;
    }

}

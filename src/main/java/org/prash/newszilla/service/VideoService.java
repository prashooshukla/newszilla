package org.prash.newszilla.service;

import lombok.RequiredArgsConstructor;
import org.prash.newszilla.dto.Video;
import org.prash.newszilla.entity.VideoEntity;
import org.prash.newszilla.exception.VideoNotFound;
import org.prash.newszilla.repository.VideoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Project: NewsZilla
 * Author: bittu
 * Date: 11-06-2024
 */

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;


    public List<Video> getVideos(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return videoRepository.findAll(pageable).getContent()
                .stream()
                .map(video -> new Video(video.getId(), video.getTitle(), video.getUrl(), video.getDescription(), video.getDuration(), video.getUploadedBy(), video.getViews(), video.getCreatedAt()))
                .toList();
    }

    public Optional<Video> getVideoById(Integer id) {
        return videoRepository.findById(id)
                .map(video -> new Video(video.getId(), video.getTitle(), video.getUrl(), video.getDescription(), video.getDuration(), video.getUploadedBy(), video.getViews(), video.getCreatedAt()))
                .or(Optional::empty);

    }


    public Video createVideo(Video video) {

        VideoEntity newVideo = VideoEntity.builder()
                .title(video.title())
                .url(video.url())
                .description(video.description())
                .uploadedBy(video.uploadedBy())
                .duration(video.duration())
                .createdAt(LocalDateTime.now())
                .build();

        VideoEntity savedVideo = videoRepository.save(newVideo);
        return new Video(savedVideo.getId(), savedVideo.getTitle(), savedVideo.getUrl(), savedVideo.getDescription(), savedVideo.getDuration(), savedVideo.getUploadedBy(), savedVideo.getViews(), savedVideo.getCreatedAt());
    }

    public boolean deleteVideo(Integer id) {

        if (videoRepository.existsById(id)) {
            videoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Video> getLatestVideos() {
        return videoRepository.findTop4ByOrderByCreatedAtDesc()
                .stream()
                .map(video -> new Video(video.getId(), video.getTitle(), video.getUrl(), video.getDescription(), video.getDuration(), video.getUploadedBy(), video.getViews(), video.getCreatedAt()))
                .toList();
    }

}

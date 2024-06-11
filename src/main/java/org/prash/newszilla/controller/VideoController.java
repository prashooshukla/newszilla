package org.prash.newszilla.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prash.newszilla.dto.CustomErrorResponse;
import org.prash.newszilla.dto.Video;
import org.prash.newszilla.exception.VideoNotFound;
import org.prash.newszilla.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
@Slf4j
public class VideoController {

    private final VideoService videoService;

    @GetMapping
    public ResponseEntity<List<Video>> getVideos(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size
    ) {
        log.info("VideoController::getVideos Triggered, with params page:{}, size:{}", page, size);
        return ResponseEntity.ok(videoService.getVideos(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Integer id) {
        log.info("VideoController::getVideoById triggered. Id:{}", id);
        return videoService.getVideoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<Video> createVideo(@RequestBody Video video) throws URISyntaxException {
        log.info("VideoController::createVideo Triggered. Request video:{}", video);
        Video newVideo = videoService.createVideo(video);
        log.info("VideoController::createVideo completed. Created video:{}", newVideo);
        return ResponseEntity.created(new URI("/" + newVideo.id()))
                .body(newVideo);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteVideo(@PathVariable Integer id) {

        boolean isVideoDeleted = videoService.deleteVideo(id);
        if (isVideoDeleted) {
            return ResponseEntity.ok("Video deleted successfully");
        }
        log.info("Video with id:{} not found", id);
        throw new VideoNotFound("Video Not Found with Id: " + id);
    }


}

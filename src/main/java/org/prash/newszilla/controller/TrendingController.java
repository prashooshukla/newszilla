package org.prash.newszilla.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prash.newszilla.service.TrendingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Project: NewsZilla
 * Author: bittu
 * Date: 11-06-2024
 */

@RestController
@RequestMapping("/api/v1/trending")
@RequiredArgsConstructor
@Slf4j
public class TrendingController {

    private final TrendingService trendingService;

    @GetMapping
    public ResponseEntity<List<Object>> getTrending() {
        log.info("TrendingController::getTrending triggered");
        return ResponseEntity.ok(trendingService.getTopTrending());
    }
}

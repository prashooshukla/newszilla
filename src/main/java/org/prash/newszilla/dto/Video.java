package org.prash.newszilla.dto;

import java.time.LocalDateTime;

/**
 * Project: NewsZill
 * Author: bittu
 * Date: 11-06-2024
 */

public record Video(
        Integer id,
        String title, String url, String description, Integer duration, String uploadedBy, Integer views,
        LocalDateTime createdAt
) {
}

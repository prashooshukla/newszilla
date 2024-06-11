package org.prash.newszilla.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Project: NewsZill
 * Author: bittu
 * Date: 11-06-2024
 */

public record News(
        Integer id,
        String title,
        String content,
        String author,
        LocalDate publishedDate,
        String source,
        String category,
        LocalDateTime createdAt
) {
}

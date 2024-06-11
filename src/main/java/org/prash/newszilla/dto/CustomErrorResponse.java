package org.prash.newszilla.dto;

import org.springframework.http.HttpStatus;

/**
 * Project: NewsZill
 * Author: bittu
 * Date: 11-06-2024
 */

public record CustomErrorResponse (Integer value, String message) {
}

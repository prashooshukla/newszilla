package org.prash.newszilla.exception;

/**
 * Project: NewsZill
 * Author: bittu
 * Date: 11-06-2024
 */

public class NewsNotFound extends RuntimeException {

    public NewsNotFound(String message) {
        super(message);
    }

    public NewsNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public NewsNotFound(Throwable cause) {
        super(cause);
    }
}

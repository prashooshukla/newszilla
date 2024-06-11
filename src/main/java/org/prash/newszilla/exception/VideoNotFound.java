package org.prash.newszilla.exception;

/**
 * Project: NewsZill
 * Author: bittu
 * Date: 11-06-2024
 */

public class VideoNotFound extends RuntimeException {

    public VideoNotFound(String message) {
        super(message);
    }

    public VideoNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public VideoNotFound(Throwable cause) {
        super(cause);
    }

}

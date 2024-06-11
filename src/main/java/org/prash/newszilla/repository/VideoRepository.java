package org.prash.newszilla.repository;

import org.prash.newszilla.dto.Video;
import org.prash.newszilla.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Project: NewsZilla
 * Author: bittu
 * Date: 11-06-2024
 */

public interface VideoRepository extends JpaRepository<VideoEntity, Integer>, PagingAndSortingRepository<VideoEntity, Integer> {

    List<VideoEntity> findTop4ByOrderByCreatedAtDesc();

}

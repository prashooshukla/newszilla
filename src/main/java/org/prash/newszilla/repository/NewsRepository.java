package org.prash.newszilla.repository;

import org.prash.newszilla.dto.News;
import org.prash.newszilla.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Project: NewsZilla
 * Author: bittu
 * Date: 11-06-2024
 */

public interface NewsRepository extends JpaRepository<NewsEntity, Integer>, PagingAndSortingRepository<NewsEntity, Integer> {
    List<NewsEntity> findTop4ByOrderByCreatedAtDesc();
}

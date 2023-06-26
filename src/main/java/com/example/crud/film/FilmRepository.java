package com.example.crud.film;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FilmRepository extends PagingAndSortingRepository<Film, Integer> {

    Page<Film> findByTitleContainingIgnoreCase(String filmSearchStr, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Film f set f.releaseYear = :year where f.filmId = :id")
    void updateReleaseYearById(@Param("year") Integer year, @Param("id") Integer id);
}
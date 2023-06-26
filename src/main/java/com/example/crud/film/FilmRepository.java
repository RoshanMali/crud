package com.example.crud.film;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FilmRepository extends PagingAndSortingRepository<Film, Integer> {

    Page<Film> findByTitleContainingIgnoreCase(String filmSearchStr, Pageable pageable);
}
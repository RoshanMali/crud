package com.example.crud.film;

import com.example.crud.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public Response getFilms(Integer pageNo,Integer pageSize,String sortBy, String sortOrder) {
        Pageable paging;
        if (sortBy == null || sortBy.isEmpty() || sortBy.isBlank() || sortBy.equals("undefined")) {
            paging = PageRequest.of(pageNo, pageSize);
        } else {
            Sort sort = sortOrder.equals("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending() ;
            paging = PageRequest.of(pageNo, pageSize, sort);
        }
        Response response = new Response();
        response.setData(filmRepository.findAll(paging));
        return response;
    }
}

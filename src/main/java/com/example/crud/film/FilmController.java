package com.example.crud.film;

import com.example.crud.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping(path="/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @PostMapping(path="/films")
    public @ResponseBody Response getFilms(@RequestBody Map<Object, String> data) {
        return filmService.getFilms(Integer.parseInt(data.get("pageNo")), Integer.parseInt(data.get("pageSize")), data.get("sortBy"), data.get("sortOrder"), data.get("filmSearchStr"));
    }
}

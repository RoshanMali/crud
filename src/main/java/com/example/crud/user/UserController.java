package com.example.crud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping(path="/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers(@RequestParam(required = false) String gender) {
        if (gender != null && !gender.trim().isEmpty()) {
            return userRepository.filterByGender(gender);
        } else {
            return userRepository.findAll();
        }
    }
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody Boolean addNewUser (@RequestBody User user) {
        userRepository.save(user);
        return true;
    }
    @PostMapping(path="/update/{id}") // Map ONLY POST Requests
    public @ResponseBody Boolean updateUser (@PathVariable int id, @RequestBody User user) {
        Optional<User> a = userRepository.findById(id);
        if (a.isPresent()) {
            a.get().setName(user.getName());
            a.get().setEmail(user.getEmail());
            a.get().setGender(user.getGender());
            userRepository.save(a.get());
            return true;
        } else {
            return false;
        }
    }
    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody Boolean delete(@PathVariable int id) {
        userRepository.deleteById(id);
        return true;
    }

    @DeleteMapping(path = "/deleteAll")
    public @ResponseBody Boolean deleteAll() {
        userRepository.deleteAll();
        return true;
    }
}

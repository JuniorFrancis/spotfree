package com.exame.spotfree.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/musics")
public class MusicController {

    @GetMapping("/hello-world")
    public String hello(){

        return "Hello World";
    }

}

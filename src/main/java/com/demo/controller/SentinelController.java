package com.demo.controller;

import com.demo.entity.Response;
import com.demo.service.SentinelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SentinelController {

    @Autowired
    private SentinelService service;

    @GetMapping(value = "/hello")
    public Response apiHello() {
        return service.sayHello();
    }
}

package com.example.actuator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
@Controller
public class LogController {

    @GetMapping("/log")
    public void log() {
        log.info("log info");
        log.debug("log debug");
        log.warn("log warn");
        log.error("log error");
        log.trace("log trace");
    }

    @GetMapping("/error-log")
    public String errorLog() {
        log.error("error log");
        return "error";
    }
}

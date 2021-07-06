package com.example.log4j2.controller.rest;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.log4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api")
@RestController
public class HelloWorld {
  private static final Logger logger = LogManager.getLogger();

  @GetMapping
  public String helloWorld() {
    String requestKey = UUID.randomUUID().toString();
    MDC.put("request_id", requestKey);
    logger.debug("Debug Message Logged !!!");
    logger.info("Info Message Logged !!!");
    return "hello world";
  }
}

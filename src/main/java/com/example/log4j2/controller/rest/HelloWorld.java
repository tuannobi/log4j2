package com.example.log4j2.controller.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api")
@RestController
public class HelloWorld {

  private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

  @GetMapping
  public String helloWorld() {
    String requestKey = UUID.randomUUID().toString();
    System.out.println("Request Key: " + requestKey);
    MDC.put("request_id", requestKey);
    MDC.put("author_name","Tran Anh Tran");
    logger.debug("Debug Message Logged !!!");
    logger.info("Info Message Logged !!!");
    return "hello world";
  }
}

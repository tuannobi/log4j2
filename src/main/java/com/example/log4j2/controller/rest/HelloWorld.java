package com.example.log4j2.controller.rest;
import org.apache.logging.log4j.LogManager;
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
    MDC.put("request_key",requestKey);
    System.out.println("Request Key: " + requestKey);
    logger.debug("This is a debug message");
    logger.info("This is an info message");
    logger.warn("This is a warn message");
    logger.error("This is an error message");
    return "hello world";
  }
}

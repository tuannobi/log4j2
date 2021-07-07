package com.example.log4j2.controller.rest;
import com.example.log4j2.config.CustomMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/api")
@RestController
public class HelloWorld {

  private static final String LOGGER_WITH_CUSTOM_LAYOUT = "LOGGER_WITH_CUSTOM_LAYOUT";
  private static Logger loggerWithCustomLayout = LogManager.getLogger(LOGGER_WITH_CUSTOM_LAYOUT);
  @GetMapping
  public String helloWorld() {
    loggerWithCustomLayout.trace("Enter hello world api");
    String requestKey = UUID.randomUUID().toString();
//    MDC.put("request_key",requestKey);
    ThreadContext.put("tradeId", requestKey);
    System.out.println("Request Key: " + requestKey);
    Map<String, Object> map = Map.of("a","b","c","d");
    CustomMessage customMessage= new CustomMessage(map);
    loggerWithCustomLayout.debug("This is a debug message");
    loggerWithCustomLayout.info(customMessage);
    loggerWithCustomLayout.warn("This is a warn message");
    loggerWithCustomLayout.error("This is an error message");
    ThreadContext.pop();
    return "hello world";
  }
}

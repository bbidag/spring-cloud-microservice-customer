package com.bbidag.microservice.customer.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StaticConfigService {

  @Value("${bbidag.test}")
  private String message;

  @Value("${bbidag.test-count}")
  private String count;

  public Map<String, Object> getStaticConfig(){
    return Map.of("message", message, "count", Integer.parseInt(count));
  }

}

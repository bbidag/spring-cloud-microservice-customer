package com.bbidag.microservice.customer.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class DynamicConfigService {

  @Value("${bbidag.test}")
  private String message;

  @Value("${bbidag.test-count}")
  private String count;

  public Map<String, Object> getDynamicConfig(){
    return Map.of("message", message, "count", Integer.parseInt(count));
  }

}

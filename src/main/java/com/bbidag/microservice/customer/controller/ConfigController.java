package com.bbidag.microservice.customer.controller;

import com.bbidag.microservice.customer.service.DynamicConfigService;
import com.bbidag.microservice.customer.service.StaticConfigService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

  @Autowired
  private DynamicConfigService dynamicConfigService;

  @Autowired
  private StaticConfigService staticConfigService;

  @GetMapping("/config/dynamic")
  public ResponseEntity<Map<String, Object>> getDynamicConfig(){
    return new ResponseEntity<>(dynamicConfigService.getDynamicConfig(), HttpStatus.OK);
  }

  @GetMapping("/config/static")
  public ResponseEntity<Map<String, Object>> getStaticConfig(){
    return new ResponseEntity<>(staticConfigService.getStaticConfig(), HttpStatus.OK);
  }

}

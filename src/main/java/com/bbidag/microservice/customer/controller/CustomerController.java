package com.bbidag.microservice.customer.controller;

import com.bbidag.microservice.customer.dto.Product;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

  @Autowired
  private DiscoveryClient discoveryClient;

  @PostMapping("/{user}/cart/buy/all")
  private ResponseEntity<String> buyAllProduct(@PathVariable String user) {
    List<ServiceInstance> scmServices = discoveryClient.getInstances("scm-service");

    String buyFruitsUrl = scmServices.get(0).getUri().toString() + "/fruits/all";

    RestTemplate restTemplate = new RestTemplate();
    List<Product> products = restTemplate.exchange(buyFruitsUrl, HttpMethod.GET, null,
        new ParameterizedTypeReference<List<Product>>(){}).getBody();

    String responseMessage = user + "가 " +
        products.stream().map(Product::getName).collect(Collectors.joining(",")) +
        "를 구매했습니다.";

    return new ResponseEntity<>(responseMessage, HttpStatus.OK);
  }

}

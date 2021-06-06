package com.bbidag.microservice.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  private String productId;
  private String categoryName;
  private String name;
  private int price;

}

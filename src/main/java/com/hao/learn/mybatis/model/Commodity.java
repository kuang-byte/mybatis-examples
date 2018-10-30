package com.hao.learn.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {

  private int id;
  private String name;
  private Double price;
  private String description;

  public Commodity(String name, Double price, String description) {
    this.name = name;
    this.price = price;
    this.description = description;
  }
}

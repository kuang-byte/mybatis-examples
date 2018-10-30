package com.hao.learn.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {
  private Integer id;
  private String name;
  private Double price;
  private String description;
}

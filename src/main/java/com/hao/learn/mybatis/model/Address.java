package com.hao.learn.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
  private Integer addressId;
  private String streetAddress;
  private Integer personId;
}

package com.hao.learn.mybatis.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  private Integer personId;
  private String name;
  private List<Address> addresses;
}

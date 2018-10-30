package com.hao.learn.mybatis.dao;

import com.hao.learn.mybatis.model.Commodity;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface CommodityDao {

  @Select("SELECT * FROM commodity")
  List<Commodity> getAllCommodity();

  @Select("SELECT * FROM commodity WHERE id = #{id}")
  Commodity getCommodity(Integer id);
}

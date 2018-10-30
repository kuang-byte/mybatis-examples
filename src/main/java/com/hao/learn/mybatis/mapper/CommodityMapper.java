package com.hao.learn.mybatis.mapper;

import com.hao.learn.mybatis.model.Commodity;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CommodityMapper {

  @Select("SELECT * FROM commodity")
  List<Commodity> getAllCommodity();

  @Select("SELECT * FROM commodity WHERE id = #{id}")
  Commodity getCommodity(Integer id);

  @Insert("INSERT into commodity(id,name,price,description) VALUES(#{id},#{name},#{price},#{description})")
  @Options(useGeneratedKeys = true, keyColumn = "id")
  Integer addCommodity(Commodity commodity);

  @Update("UPDATE commodity SET description = #{description} WHERE id = #{id}")
  void updateCommodity(@Param("id") Integer id, @Param("description") String description);

  @Delete("DELETE FROM commodity WHERE id = #{id}")
  void deleteCommodity(@Param("id") Integer id);
}
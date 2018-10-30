package com.hao.learn.mybatis.model;

import com.hao.learn.mybatis.mapper.CommodityMapper;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Not a valid unit test which is only for example
 */
public class CommodityTest {

  private SqlSessionFactory sqlSessionFactory = null;

  @Before
  public void setUp() throws Exception {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void getAllCommodity() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      CommodityMapper commodityMapper = sqlSession.getMapper(CommodityMapper.class);

      List<Commodity> allCommodity = commodityMapper.getAllCommodity();
      System.out.printf(allCommodity.toString());
    } finally {
      sqlSession.close();
    }
  }

  @Test
  public void getCommodityById() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      CommodityMapper commodityMapper = sqlSession.getMapper(CommodityMapper.class);
      Commodity commodity = commodityMapper.getCommodity(1001);
      System.out.printf(commodity.toString());
    } finally {
      sqlSession.close();
    }
  }

  @Test
  public void updateCommodityById() {
    String newDescription = "Update by test case " + new Random().nextInt();
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      CommodityMapper commodityMapper = sqlSession.getMapper(CommodityMapper.class);
      Commodity commodity = new Commodity("test", 11d, "test");
      commodityMapper.addCommodity(commodity);
      commodityMapper.updateCommodity(commodity.getId(), newDescription);
      sqlSession.commit();
      // verify
      commodity = commodityMapper.getCommodity(commodity.getId());
      Assert.assertEquals(newDescription, commodity.getDescription());
    } finally {
      sqlSession.close();
    }
  }

  @Test
  public void addCommodity() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      CommodityMapper commodityMapper = sqlSession.getMapper(CommodityMapper.class);
      Commodity commodity = new Commodity("test", 11d, "test");
      commodityMapper.addCommodity(commodity);
      sqlSession.commit();
      Assert.assertTrue(commodity.getId() != 0);
    } finally {
      sqlSession.close();
    }
  }

  @Test
  public void deleteCommodityById() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      CommodityMapper CommodityMapper = sqlSession.getMapper(CommodityMapper.class);
      CommodityMapper.deleteCommodity(1005);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
}
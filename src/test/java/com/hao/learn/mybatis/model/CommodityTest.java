package com.hao.learn.mybatis.model;

import com.hao.learn.mybatis.dao.CommodityDao;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
      CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
      List<Commodity> allCommodity = commodityDao.getAllCommodity();
      System.out.printf(allCommodity.toString());
    } finally {
      sqlSession.close();
    }
  }

  @Test
  public void getCommodityById() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
      Commodity commodity = commodityDao.getCommodity(1001);
      System.out.printf(commodity.toString());
    } finally {
      sqlSession.close();
    }
  }
}
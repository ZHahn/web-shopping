package com.shopping.dao;

import com.alibaba.fastjson.JSON;
import com.csvreader.CsvReader;
import com.shopping.entity.ShoppingCar;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/** 
* ShoppingCarDaoImplement Tester.
 *  UT_TC_005
*/
@RunWith(SpringJUnit4ClassRunner.class)
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
//测试的时候加载服务器
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class ShoppingCarDaoImplementTest {
    @Autowired
    public ShoppingCarDaoImplement shoppingCarDaoImplement;

@Before
public void before() throws Exception {
    System.out.print("Class ShoppingCarDaoImplement;\n");
} 

@After
public void after() throws Exception { 
} 

///**
//*
//* Method: getShoppingCar(int userId, int productId)
//*
//*/
//@Test
//public void testGetShoppingCar() throws Exception {
////TODO: Test goes here...
//}

///**
//*
//* Method: addShoppingCar(ShoppingCar shoppingCar)
//*
//*/
//@Test
//public void testAddShoppingCar() throws Exception {
////TODO: Test goes here...
//}

/** 
* 
* Method: deleteShoppingCar(int userId, int productId) 
* 
*/ 
@Test
public void testDeleteShoppingCar() throws Exception {
//TODO: Test goes here...
    String testCase = "UT_TC_005_001";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_005_001.csv", ',', Charset.forName("GBK"));
    csvReader.readHeaders();
    System.out.println("Test-function--deleteShoppingCar");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        String userId = csvReader.get(0);
        String productId = csvReader.get(1);
        String expect = csvReader.get(2).toLowerCase();
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
        Boolean output = shoppingCarDaoImplement.deleteShoppingCar(Integer.parseInt(userId),Integer.parseInt(productId));

        boolean ispassed = output.toString().equals(expect);
        if (ispassed) {
            System.out.print(testCase+"-"+(++i)+" passed\n" );
        } else {
            System.out.print(testCase+"-"+(++i)+" failed\n" );
        }
        System.out.println("output:" + output);
        System.out.println("expect:" + expect);
        //将测试结果放在列表里
        passedList.add(ispassed);
        System.out.println("\n");
    }
    //断言是为了调用junit工具来记录是否通过测试
    for (boolean p : passedList) {
        assert p;
    }
} 

/** 
* 
* Method: updateShoppingCar(ShoppingCar shoppingCar) 
* 
*/ 
@Test
public void testUpdateShoppingCar() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_005_002";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_005_002.csv", ',', Charset.forName("utf8"));
    csvReader.readHeaders();
    System.out.println("Test-function--updateShoppingCar");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        int userId = Integer.parseInt(csvReader.get(0));
        int productId = Integer.parseInt(csvReader.get(1));
        int count = Integer.parseInt(csvReader.get(2));
        int price = Integer.parseInt(csvReader.get(3));
        String expect = csvReader.get(4).toLowerCase();

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
        //开始调用函数
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setCounts(count);
        shoppingCar.setUserId(userId);
        shoppingCar.setProductId(productId);
        shoppingCar.setProductPrice(price);

        Boolean output = shoppingCarDaoImplement.updateShoppingCar(shoppingCar);



        //为true表示通过
        boolean ispassed = output.toString().equals(expect);
        if (ispassed) {
            System.out.print(testCase+"-"+(++i)+" passed\n" );
        } else {
            System.out.print(testCase+"-"+(++i)+" failed\n" );
        }
        System.out.println("output:" + output);
        System.out.println("expect:" + expect);

        //将测试结果放在列表里
        passedList.add(ispassed);
        System.out.println("\n");
    }
    //断言是为了调用junit工具来记录是否通过测试
    for (boolean p : passedList) {
        assert p;
    }
} 

/** 
* 
* Method: getShoppingCars(int userId) 
* 
*/ 
@Test
public void testGetShoppingCars() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_005_003";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_005_003.csv", ',', Charset.forName("GBK"));
    csvReader.readHeaders();
    System.out.println("Test-function--getShoppingCar");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        int userId = Integer.parseInt(csvReader.get(0));
        int productId = Integer.parseInt(csvReader.get(1));
        String expect = csvReader.get(2);

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出

        //开始调用函数
        String output = JSON.toJSONString(shoppingCarDaoImplement.getShoppingCar(userId,productId));


        //为true表示通过
        boolean ispassed = output.equals(expect);
       //打印结果
        if (ispassed) {
            System.out.print(testCase+"-"+(++i)+" passed\n" );
        } else {
            System.out.print(testCase+"-"+(++i)+" failed\n" );
        }
        System.out.println("output:" + output);
        System.out.println("expect:" + expect);

        //将测试结果放在列表里
        passedList.add(ispassed);
        System.out.println("\n");
    }
    //断言是为了调用junit工具来记录是否通过测试
    for (boolean p : passedList) {
        assert p;
    }
} 

/** 
* 
* Method: deleteShoppingCarByUser(int userId) 
* 
*/ 
@Test
public void testDeleteShoppingCarByUser() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_005_004";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_005_004.csv", ',', Charset.forName("GBK"));
    csvReader.readHeaders();
    System.out.println("Test-function--deleteShoppingCarByUser");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        String userId = csvReader.get(0);
        String expect = csvReader.get(1).toLowerCase();
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
        Boolean output = shoppingCarDaoImplement.deleteShoppingCarByUser(Integer.parseInt(userId));

        boolean ispassed = output.toString().equals(expect);
        if (ispassed) {
            System.out.print(testCase+"-"+(++i)+" passed\n" );
        } else {
            System.out.print(testCase+"-"+(++i)+" failed\n" );
        }
        System.out.println("output:" + output);
        System.out.println("expect:" + expect);
        //将测试结果放在列表里
        passedList.add(ispassed);
        System.out.println("\n");
    }
    //断言是为了调用junit工具来记录是否通过测试
    for (boolean p : passedList) {
        assert p;
    }
} 

///**
//*
//* Method: deleteShoppingCarByProduct(int productId)
//*
//*/
//@Test
//public void testDeleteShoppingCarByProduct() throws Exception {
////TODO: Test goes here...
//}


} 

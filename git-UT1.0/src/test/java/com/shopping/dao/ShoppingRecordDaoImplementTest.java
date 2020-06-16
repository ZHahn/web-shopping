package com.shopping.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.csvreader.CsvReader;
import com.shopping.entity.ShoppingRecord;
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
import java.util.List;
import java.util.logging.Level;

/** 
* ShoppingRecordDaoImplement Tester. 
* UT_TC_002
*/
@RunWith(SpringJUnit4ClassRunner.class)
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
//测试的时候加载服务器
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class ShoppingRecordDaoImplementTest { 
    @Autowired
    public ShoppingRecordDaoImplement shoppingRecordDaoImplement;
@Before
public void before() throws Exception {
    System.out.print("Class ShoppingRecordDaoImplement;\n");
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getShoppingRecord(int userId, int productId, String time) 
* 
*/ 
@Test
public void testGetShoppingRecord() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_002_002";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_002_002.csv", ',', Charset.forName("GBK"));
    csvReader.readHeaders();
    System.out.println("Test-function--getShoppingRecord");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        int userId = Integer.parseInt(csvReader.get(0));
        int productId = Integer.parseInt(csvReader.get(1));
        String time = csvReader.get(2);
        String expect = csvReader.get(3);


        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
        String output = JSON.toJSONString(shoppingRecordDaoImplement.getShoppingRecord(userId,productId,time));

        boolean ispassed = output.equals(expect);
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
//* Method: addShoppingRecord(ShoppingRecord shoppingRecord)
//*
//*/
//@Test
//public void testAddShoppingRecord() throws Exception {
////TODO: Test goes here...
//}

/** 
* 
* Method: deleteShoppingRecord(int userId, int productId) 
* 
*/ 
@Test
public void testDeleteShoppingRecord() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_002_004";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_002_004.csv", ',', Charset.forName("GBK"));
    csvReader.readHeaders();
    System.out.println("Test-function--deleteShoppingRecord");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        int userId = Integer.parseInt(csvReader.get(0));
        int productId = Integer.parseInt(csvReader.get(1));

        String expect = csvReader.get(2).toLowerCase();


        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
        Boolean output = shoppingRecordDaoImplement.deleteShoppingRecord(userId,productId);


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
* Method: updateShoppingRecord(ShoppingRecord shoppingRecord) 
* 
*/ 
@Test
public void testUpdateShoppingRecord() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_002_001";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_002_001.csv", ',', Charset.forName("GBK"));
    csvReader.readHeaders();
    System.out.println("Test-function--UpdateShoppingRecord");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        int userId = Integer.parseInt(csvReader.get(0));
        int productId = Integer.parseInt(csvReader.get(1));
        String time = csvReader.get(2);
        int orderStatus = Integer.parseInt(csvReader.get(3));
        int price = Integer.parseInt(csvReader.get(4));
        int counts = Integer.parseInt(csvReader.get(5));
        String expect = csvReader.get(6).toLowerCase();

        ShoppingRecord shoppingRecord = new ShoppingRecord();
        shoppingRecord.setOrderStatus(orderStatus);
        shoppingRecord.setCounts(counts);
        shoppingRecord.setProductId(productId);
        shoppingRecord.setTime(time);
        shoppingRecord.setProductPrice(price);
        shoppingRecord.setUserId(userId);

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));

        Boolean output = shoppingRecordDaoImplement.updateShoppingRecord(shoppingRecord);

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
//* Method: getShoppingRecords(int userId)
//*
//*/
//@Test
//public void testGetShoppingRecords() throws Exception {
////TODO: Test goes here...
//}

///**
//*
//* Method: getAllShoppingRecords()
//*
//*/
//@Test
//public void testGetAllShoppingRecords() throws Exception {
////TODO: Test goes here...
//}

/** 
* 
* Method: getShoppingRecordsByOrderStatus(int orderStatus) 
* 
*/ 
@Test
public void testGetShoppingRecordsByOrderStatus() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_002_003";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_002_003.csv", ',', Charset.forName("GBK"));
    csvReader.readHeaders();
    System.out.println("Test-function--getShoppingRecordsByOrderStatus");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        int orderState = Integer.parseInt(csvReader.get(0));
        String expect = csvReader.get(1);
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
//        List<ShoppingRecord> output = shoppingRecordDaoImplement.getShoppingRecordsByOrderStatus(orderState);
//        output = JSON.toJSONString(output);
        String output = JSONArray.toJSONString(shoppingRecordDaoImplement.getShoppingRecordsByOrderStatus(orderState));
        boolean ispassed = output.equals(expect);
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
//
///**
//*
//* Method: getUserProductRecord(int userId, int productId)
//*
//*/
//@Test
//public void testGetUserProductRecord() throws Exception {
////TODO: Test goes here...
//}
//
///**
//*
//* Method: deleteShoppingRecordByUser(int userId)
//*
//*/
//@Test
//public void testDeleteShoppingRecordByUser() throws Exception {
////TODO: Test goes here...
//}
//
///**
//*
//* Method: deleteShoppingRecordByProductId(int productId)
//*
//*/
//@Test
//public void testDeleteShoppingRecordByProductId() throws Exception {
////TODO: Test goes here...
//}


} 

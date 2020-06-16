package com.shopping.dao;

import com.alibaba.fastjson.JSON;
import com.csvreader.CsvReader;
import com.shopping.entity.ShoppingCar;
import com.shopping.entity.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
* UserDaoImplement Tester. 
* UT_TC_003
*/

@RunWith(SpringJUnit4ClassRunner.class)
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
//测试的时候加载服务器
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class UserDaoImplementTest { 
    @Autowired
    UserDaoImplement userDaoImplement;
@Before
public void before() throws Exception {
    System.out.print("Class UserDaoImplement;\n");
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getUser(int id) 
* 
*/ 
@Test
public void testGetUserId() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_003_001";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_003_001.csv", ',', Charset.forName("GBK"));
    csvReader.readHeaders();
    System.out.println("Test-function--getUser(id)");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        int userId = Integer.parseInt(csvReader.get(0));
        String expect = csvReader.get(1);


        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
        String output = JSON.toJSONString(userDaoImplement.getUser(userId));

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
//* Method: getUser(String nameOrEmail)
//*
//*/
//@Test
//public void testGetUserNameOrEmail() throws Exception {
////TODO: Test goes here...
//}

///**
//*
//* Method: addUser(User user)
//*
//*/
//@Test
//public void testAddUser() throws Exception {
////TODO: Test goes here...
//}

/** 
* 
* Method: deleteUser(int id) 
* 
*/ 
@Test
public void testDeleteUser() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_003_002";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_003_002.csv", ',', Charset.forName("GBK"));
    csvReader.readHeaders();
    System.out.println("Test-function--deleteUser(id)");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的值
        int userId = Integer.parseInt(csvReader.get(0));

        String expect = csvReader.get(1).toLowerCase();


        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
        try {
            Boolean output = userDaoImplement.deleteUser(userId);
        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.print(testCase + "-" + (++i) + " failed\n");
            System.out.println("org.hibernate.exception.ConstraintViolationException happend \n" );
            passedList.add(false);
            continue;
        }
        Boolean output = userDaoImplement.deleteUser(userId);
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
* Method: updateUser(User user) 
* 
*/ 
@Test
public void testUpdateUser() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_003_003";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_003_003.csv", ',', Charset.forName("GBK"));
    csvReader.readHeaders();
    System.out.println("Test-function--updateUser");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        String name = csvReader.get(0);
        String email = csvReader.get(1);
        String nickName = csvReader.get(2);
        int userId = Integer.parseInt(csvReader.get(3));
        String expect = csvReader.get(4).toLowerCase();


        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
        //开始调用函数
        User user = new User();
        user.setEmail(email);
        user.setNickName(nickName);
        user.setRole(0);
        user.setId(userId);
        user.setName(name);
        try {
            Boolean output = userDaoImplement.updateUser(user);
        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.print(testCase + "-" + (++i) + " failed\n");
            System.out.println("org.hibernate.exception.ConstraintViolationException happend \n" );
            passedList.add(false);
            continue;
        }

        Boolean output = userDaoImplement.updateUser(user);


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

///**
//*
//* Method: getAllUser()
//*
//*/
//@Test
//public void testGetAllUser() throws Exception {
////TODO: Test goes here...
//}


} 

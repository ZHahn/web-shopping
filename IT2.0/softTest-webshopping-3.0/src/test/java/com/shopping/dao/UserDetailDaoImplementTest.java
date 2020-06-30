package com.shopping.dao;

import com.alibaba.fastjson.JSON;
import com.csvreader.CsvReader;
import com.shopping.entity.User;
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
* UserDetailDaoImplement Tester. 
* UT_TC_004
*/
@RunWith(SpringJUnit4ClassRunner.class)
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
//测试的时候加载服务器
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class UserDetailDaoImplementTest { 
    @Autowired UserDetailDaoImplement userDetailDaoImplement;
@Before
public void before() throws Exception {
    System.out.print("Class UserDetailDaoImplement;\n");
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getUserDetail(int id) 
* 
*/ 
@Test
public void testGetUserDetail() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_004_001";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_004_001.csv", ',', Charset.forName("utf8"));
    csvReader.readHeaders();
    System.out.println("Test-function--getUserDetail");
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
        //开始调用函数

        String output = JSON.toJSONString(userDetailDaoImplement.getUserDetail(userId));


        //为true表示通过
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
//* Method: addUserDetail(UserDetail userDetail)
//*
//*/
//@Test
//public void testAddUserDetail() throws Exception {
////TODO: Test goes here...
//}
//
///**
//*
//* Method: deleteUserDetail(int id)
//*
//*/
//@Test
//public void testDeleteUserDetail() throws Exception {
////TODO: Test goes here...
//}

///**
//*
//* Method: updateUserDetail(UserDetail userDetail)
//*
//*/
//@Test
//public void testUpdateUserDetail() throws Exception {
////TODO: Test goes here...
//}
//
///**
//*
//* Method: getAllUserDetail()
//*
//*/
//@Test
//public void testGetAllUserDetail() throws Exception {
////TODO: Test goes here...
//}


} 

package com.shopping.controller;

import com.csvreader.CsvReader;
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
* EvaluationController Tester. 
* IT_TD_004
*/
@RunWith(SpringJUnit4ClassRunner.class)
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
//测试的时候加载服务器
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class EvaluationControllerTest {
    @Autowired
    EvaluationController evaluationController;
@Before
public void before() throws Exception {
    System.out.print("Class EvaluationController;\n");
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: addShoppingEvaluation(int userId, int productId, String content) 
* 
*/ 
@Test
public void testAddShoppingEvaluation() throws Exception { 
//TODO: Test goes here...
    String testCase = "IT_TD_004_001";
    CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_004_001.csv", ',', Charset.forName("utf8"));
    csvReader.readHeaders();
    System.out.println("Test-interface--addShoppingEvaluation");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        int userId = Integer.parseInt(csvReader.get(0));
        int productId = Integer.parseInt(csvReader.get(1));
        String content = csvReader.get(2);
        String expect = csvReader.get(3);

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出

        String output = evaluationController.addShoppingEvaluation(userId,productId,content).get("result").toString();

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

/** 
* 
* Method: getShoppingEvaluations(int productId) 
* 
*/ 
@Test
public void testGetShoppingEvaluations() throws Exception { 
//TODO: Test goes here...
    String testCase = "IT_TD_004_002";
    CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_004_002.csv", ',', Charset.forName("utf8"));
    csvReader.readHeaders();
    System.out.println("Test-interface--getShoppingEvaluations");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        int productId = Integer.parseInt(csvReader.get(0));
        String expect = csvReader.get(1);

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出

        String output = evaluationController.getShoppingEvaluations(productId).get("result").toString();

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


} 

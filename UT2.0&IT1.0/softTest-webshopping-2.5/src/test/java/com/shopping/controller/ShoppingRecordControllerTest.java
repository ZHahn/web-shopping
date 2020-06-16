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
 * ShoppingRecordController Tester.
 * IT_TD_003
 */
@RunWith(SpringJUnit4ClassRunner.class)
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
//测试的时候加载服务器
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class ShoppingRecordControllerTest {
    @Autowired
    private ShoppingRecordController shoppingRecordController;

    @Before
    public void before() throws Exception {
        System.out.print("Class ShoppingRecordController;\n");
    }

    @After
    public void after() throws Exception {
    }

//    /**
////     * Method: shopping_record()
////     */
////    @Test
////    public void testShopping_record() throws Exception {
//////TODO: Test goes here...
////    }

//    /**
//     * Method: shopping_handle()
//     */
//    @Test
//    public void testShopping_handle() throws Exception {
////TODO: Test goes here...
//    }

    /**
     * Method: addShoppingRecord(int userId, int productId, int counts)
     */
    @Test
    public void testAddShoppingRecord() throws Exception {
//TODO: Test goes here...
        String testCase = "IT_TD_003_001";
        CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_003_001.csv", ',', Charset.forName("utf8"));
        csvReader.readHeaders();
        System.out.println("Test-interface--addShoppingRecord");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();
        int i=0;
        //测试用例表格的每行元素(除去header后)
        while (csvReader.readRecord()) {
            //每列元素的
            int userId = Integer.parseInt(csvReader.get(0));
            int productId = Integer.parseInt(csvReader.get(1));
            int counts = Integer.parseInt(csvReader.get(2));
            String expect = csvReader.get(3);

            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出

            String output = shoppingRecordController.addShoppingRecord(userId,productId,counts).get("result").toString();

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
     * Method: changeShoppingRecord(int userId, int productId, String time, int orderStatus)
     */
    @Test
    public void testChangeShoppingRecord() throws Exception {
//TODO: Test goes here...
        String testCase = "IT_TD_003_002";
        CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_003_002.csv", ',', Charset.forName("utf8"));
        csvReader.readHeaders();
        System.out.println("Test-interface--changeShoppingRecord");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();
        int i=0;
        //测试用例表格的每行元素(除去header后)
        while (csvReader.readRecord()) {
            //每列元素的
            int userId = Integer.parseInt(csvReader.get(0));
            int productId = Integer.parseInt(csvReader.get(1));
            String time = csvReader.get(2);
            int orderState = Integer.parseInt(csvReader.get(3));
            String expect = csvReader.get(4);

            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出

            String output = shoppingRecordController.changeShoppingRecord(userId,productId,time,orderState).get("result").toString();

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
     * Method: getShoppingRecords(int userId)
     */
    @Test
    public void testGetShoppingRecords() throws Exception {
//TODO: Test goes here...
        String testCase = "IT_TD_003_003";
        CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_003_003.csv", ',', Charset.forName("utf8"));
        csvReader.readHeaders();
        System.out.println("Test-interface--getShoppingRecords");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();
        int i=0;
        //测试用例表格的每行元素(除去header后)
        while (csvReader.readRecord()) {
            //每列元素的
            int userId = Integer.parseInt(csvReader.get(0));
            String expect = csvReader.get(1);

            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出

            String output = shoppingRecordController.getShoppingRecords(userId).get("result").toString();

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
     * Method: getShoppingRecordsByOrderStatus(int orderStatus)
     */
    @Test
    public void testGetShoppingRecordsByOrderStatus() throws Exception {
//TODO: Test goes here...
        String testCase = "IT_TD_003_004";
        CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_003_004.csv", ',', Charset.forName("utf8"));
        csvReader.readHeaders();
        System.out.println("Test-interface--getShoppingRecordsByOrderStatus");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();
        int i=0;
        //测试用例表格的每行元素(除去header后)
        while (csvReader.readRecord()) {
            //每列元素的
            int orderState = Integer.parseInt(csvReader.get(0));
            String expect = csvReader.get(1);

            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出

            String output = shoppingRecordController.getShoppingRecordsByOrderStatus(orderState).get("result").toString();

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

//    /**
//     * Method: getAllShoppingRecords()
//     */
//    @Test
//    public void testGetAllShoppingRecords() throws Exception {
////TODO: Test goes here...
//    }

//    /**
//     * Method: getUserProductRecord(int userId, int productId)
//     */
//    @Test
//    public void testGetUserProductRecord() throws Exception {
////TODO: Test goes here...
//    }


} 

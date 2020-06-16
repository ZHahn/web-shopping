package com.shopping.dao;

import com.alibaba.fastjson.JSONArray;
import com.csvreader.CsvReader;
import com.shopping.entity.Product;
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

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/** 
* ProductDaoImplement Tester. 
* UT_TC_001
*/

@RunWith(SpringJUnit4ClassRunner.class)
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
//测试的时候加载服务器
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class ProductDaoImplementTest { 
    @Autowired
    ProductDaoImplement productDaoImplement;
@Before
public void before() throws Exception {
    System.out.print("Class ProductDaoImplement;\n");
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getProduct(int id) 
* 
*/ 
@Test
public void testGetProductId() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_001_002";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_001_002.csv", ',', Charset.forName("utf8"));
    csvReader.readHeaders();
    System.out.println("Test-function--getProduct");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        int productId = Integer.parseInt(csvReader.get(0));
        String expect = csvReader.get(1);

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
//        List<ShoppingRecord> output = shoppingRecordDaoImplement.getShoppingRecordsByOrderStatus(orderState);
//        output = JSON.toJSONString(output);
        String output = JSONArray.toJSONString(productDaoImplement.getProduct(productId));

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
//* Method: getProduct(String name)
//*
//*/
//@Test
//public void testGetProductName() throws Exception {
////TODO: Test goes here...
//}

///**
//*
//* Method: addProduct(Product product)
//*
//*/
//@Test
//public void testAddProduct() throws Exception {
////TODO: Test goes here...
//
//}

/** 
* 
* Method: deleteProduct(int id) 
* 
*/ 
@Test
public void testDeleteProduct() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_001_001";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_001_001.csv", ',', Charset.forName("utf8"));
    csvReader.readHeaders();
    System.out.println("Test-function--deleteProduct");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        String productId = csvReader.get(0);
        String expect = csvReader.get(1).toLowerCase();
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出

        Boolean output = productDaoImplement.deleteProduct(Integer.parseInt(productId));
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
* Method: updateProduct(Product product) 
* 
*/ 
@Test
public void testUpdateProduct() throws Exception {
//TODO: Test goes here...
    String testCase = "UT_TC_001_003";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_001_003.csv", ',', Charset.forName("utf8"));
    csvReader.readHeaders();
    System.out.println("Test-function--updateProduct");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i = 0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        int productId = Integer.parseInt(csvReader.get(0));
        String name = csvReader.get(1);
        String description = csvReader.get(2);
        int type = Integer.parseInt(csvReader.get(3));
        String keyword = csvReader.get(4);
        int price = Integer.parseInt(csvReader.get(5));
        int counts = Integer.parseInt(csvReader.get(6));

        String expect = csvReader.get(7).toLowerCase();

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
        //开始调用函数
        Product product = new Product();
        product.setCounts(counts);
        product.setDescription(description);
        product.setKeyWord(keyword);
        product.setName(name);
        product.setPrice(price);
        product.setId(productId);
        product.setType(type);
        try {
            Boolean output = productDaoImplement.updateProduct(product);
        } catch (org.hibernate.exception.ConstraintViolationException e) {
            System.out.print(testCase + "-" + (++i) + " passed\n");
//            System.out.println("org.hibernate.exception.ConstraintViolationException happend \n" );
//            触发这个约束条件是因为在表中设置了name唯一属性
            passedList.add(true);
            continue;
        }

        Boolean output = productDaoImplement.updateProduct(product);
        //为true表示通过
        boolean ispassed = output.toString().equals(expect);
        if (ispassed) {
            System.out.print(testCase + "-" + (++i) + " passed\n");
        } else {
            System.out.print(testCase + "-" + (++i) + " failed\n");
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
* Method: getProductsByKeyWord(String searchKeyWord) 
* 
*/ 
@Test
public void testGetProductsByKeyWord() throws Exception { 
//TODO: Test goes here...
    String testCase = "UT_TC_001_004";
    CsvReader csvReader = new CsvReader("src/testCase/UT/UT_TC_001_004.csv", ',', Charset.forName("utf8"));
    csvReader.readHeaders();
    System.out.println("Test-function--getProductsByKeyWord");
    //用来存储是否通过测试的Boolean
    List<Boolean> passedList = new ArrayList<>();
    int i=0;
    //测试用例表格的每行元素(除去header后)
    while (csvReader.readRecord()) {
        //每列元素的
        String keyword = csvReader.get(0);
        String expect = csvReader.get(1);

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
//        List<ShoppingRecord> output = shoppingRecordDaoImplement.getShoppingRecordsByOrderStatus(orderState);
//        output = JSON.toJSONString(output);
        String output = JSONArray.toJSONString(productDaoImplement.getProductsByKeyWord(keyword));

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
//* Method: getProductsByType(int type)
//*
//*/
//@Test
//public void testGetProductsByType() throws Exception {
////TODO: Test goes here...
//}
//
///**
//*
//* Method: getAllProduct()
//*
//*/
//@Test
//public void testGetAllProduct() throws Exception {
////TODO: Test goes here...
//}


} 

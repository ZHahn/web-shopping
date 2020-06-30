package com.shopping.controller;

import com.csvreader.CsvReader;
import com.shopping.utils.Response;
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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;

/**
 * ProductController Tester.
 * UT-TD-002
 */
@RunWith(SpringJUnit4ClassRunner.class)
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
//测试的时候加载服务器
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @Before
    public void before() throws Exception {
        System.out.print("Class ProductController;\n");
    }

    @After
    public void after() throws Exception {
    }

//    /**
//     * Method: getAllProducts()
//     */
//    @Test
//    public void testGetAllProducts() throws Exception {
////TODO: Test goes here...
//    }

    /**
     * Method: deleteProduct(int id)
     */
    @Test
    public void testDeleteProduct() throws Exception {
//TODO: Test goes here...
        String testCase = "IT_TD_002_002";
        CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_002_002.csv", ',', Charset.forName("utf8"));
        csvReader.readHeaders();
        System.out.println("Test-interface--deleteProduct");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();
        int i=0;
        //测试用例表格的每行元素(除去header后)
        while (csvReader.readRecord()) {
            //每列元素的
            int productId = Integer.parseInt(csvReader.get(0));
            String expect = csvReader.get(1).toLowerCase();

            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出

            int status = productController.deleteProduct(productId).getStatus();
            String output;
            if(status ==1){
                output = "true";
            }
            else{
                output = "false";
            }
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
     * Method: addProduct(String name, String description, String keyWord, int price, int counts, int type)
     */
    @Test
    public void testAddProduct() throws Exception {
//TODO: Test goes here...
        String testCase = "IT_TD_002_001";
        CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_002_001.csv", ',', Charset.forName("utf8"));
        csvReader.readHeaders();
        System.out.println("Test-interface--addProduct");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();
        int i=0;
        //测试用例表格的每行元素(除去header后)
        while (csvReader.readRecord()) {
            //每列元素的
            String name = csvReader.get(0);
            String description = csvReader.get(1);
            int type = Integer.parseInt(csvReader.get(2));
            String keyword = csvReader.get(3);
            int price = Integer.parseInt(csvReader.get(4));
            int counts = Integer.parseInt(csvReader.get(5));
            String expect = csvReader.get(6).toLowerCase();

            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
            String output = productController.addProduct(name,description,keyword,price,counts,type).get("result").toString();
            if(output.equals("success")){
                output = "true";
            }
            else{
                output = "false";
            }
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
     * Method: productDetail(int id, HttpSession httpSession)
     */
    @Test
    public void testProductDetail() throws Exception {
//TODO: Test goes here...
        String testCase = "IT_TD_002_003";
        CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_002_003.csv", ',', Charset.forName("utf8"));
        csvReader.readHeaders();
        System.out.println("Test-interface--productDetail");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();
        int i=0;
        //测试用例表格的每行元素(除去header后)
        while (csvReader.readRecord()) {
            //每列元素的
            int productId = Integer.parseInt(csvReader.get(0));
            String expect = csvReader.get(1).toLowerCase();

            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
            HttpSession httpSession = new HttpSession() {
                @Override
                public long getCreationTime() {
                    return 0;
                }

                @Override
                public String getId() {
                    return null;
                }

                @Override
                public long getLastAccessedTime() {
                    return 0;
                }

                @Override
                public ServletContext getServletContext() {
                    return null;
                }

                @Override
                public void setMaxInactiveInterval(int interval) {

                }

                @Override
                public int getMaxInactiveInterval() {
                    return 0;
                }

                @Override
                public HttpSessionContext getSessionContext() {
                    return null;
                }

                @Override
                public Object getAttribute(String name) {
                    return null;
                }

                @Override
                public Object getValue(String name) {
                    return null;
                }

                @Override
                public Enumeration<String> getAttributeNames() {
                    return null;
                }

                @Override
                public String[] getValueNames() {
                    return new String[0];
                }

                @Override
                public void setAttribute(String name, Object value) {

                }

                @Override
                public void putValue(String name, Object value) {

                }

                @Override
                public void removeAttribute(String name) {

                }

                @Override
                public void removeValue(String name) {

                }

                @Override
                public void invalidate() {

                }

                @Override
                public boolean isNew() {
                    return false;
                }
            };
            String output = productController.productDetail(productId,httpSession).get("result").toString();
            if(output.equals("success")){
                output = "true";
            }
            else{
                output = "false";
            }
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
//     * Method: product_detail()
//     */
//    @Test
//    public void testProduct_detail() throws Exception {
////TODO: Test goes here...
//    }

//    /**
//     * Method: searchPre(String searchKeyWord, HttpSession httpSession)
//     */
//    @Test
//    public void testSearchPre() throws Exception {
////TODO: Test goes here...
//    }

//    /**
//     * Method: search()
//     */
//    @Test
//    public void testSearch() throws Exception {
////TODO: Test goes here...
//    }

    /**
     * Method: searchProduct(String searchKeyWord)
     */
    @Test
    public void testSearchProduct() throws Exception {
//TODO: Test goes here...
        String testCase = "IT_TD_002_004";
        CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_002_004.csv", ',', Charset.forName("utf8"));
        csvReader.readHeaders();
        System.out.println("Test-interface--searchPre");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();
        int i=0;
        //测试用例表格的每行元素(除去header后)
        while (csvReader.readRecord()) {
            //每列元素的
            String searchKey = csvReader.get(0);
            String expect = csvReader.get(1);

            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
            String output = productController.searchProduct(searchKey).get("result").toString();

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
//     * Method: getProductById(int id)
//     */
//    @Test
//    public void testGetProductById() throws Exception {
////TODO: Test goes here...
//    }

//    /**
////     * Method: uploadFile(@RequestParam MultipartFile productImgUpload, String name, HttpServletRequest request)
////     */
////    @Test
////    public void testUploadFile() throws Exception {
//////TODO: Test goes here...
////    }


} 

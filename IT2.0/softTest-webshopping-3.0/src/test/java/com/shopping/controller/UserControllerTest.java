package com.shopping.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.csvreader.CsvReader;
import com.shopping.controller.UserController;
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
 * UserController Tester.
 * UT-TD-001
 */
@RunWith(SpringJUnit4ClassRunner.class)
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
//测试的时候加载服务器
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class UserControllerTest {
    @Autowired
    private UserController userController;

    @Before
    public void before() throws Exception {
        System.out.print("Class UserController;\n");
    }

    @After
    public void after() throws Exception {
    }

//    /**
//     * Method: getUserById(int id)
//     */
//    @Test
//    public void testGetUserById() throws Exception {
////TODO: Test goes here...
//    }

//    /**
//     * /**
//     * <p>
//     * Method: register()
//     */
//    @Test
//    public void testRegister() throws Exception {
////TODO: Test goes here...
//    }

//    /**
//     * Method: amend_info()
//     */
//    @Test
//    public void testAmend_info() throws Exception {
////TODO: Test goes here...
//    }

//    /**
//     * Method: login()
//     */
//    @Test
//    public void testLogin() throws Exception {
////TODO: Test goes here...
//    }

//    /**
//     * Method: main()
//     */
//    @Test
//    public void testMain() throws Exception {
////TODO: Test goes here...
//    }

//    /**
//     * Method: control()
//     */
//    @Test
//    public void testControl() throws Exception {
////TODO: Test goes here...
//    }

    /**
     * Method: doLogin(String userNameOrEmail, String password, HttpSession httpSession)
     */
    @Test
    public void testDoLogin() throws Exception {
//TODO: Test goes here...
        String testCase = "IT_TD_001_001";
        CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_001_001.csv", ',', Charset.forName("utf8"));
        csvReader.readHeaders();
        System.out.println("Test-interface--doLogin");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();
        int i=0;
        //测试用例表格的每行元素(除去header后)
        while (csvReader.readRecord()) {
            //每列元素的
            String username = csvReader.get(0);
            String password = csvReader.get(1);
            String expect = csvReader.get(2).toLowerCase();

            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        output = JSON.toJSONString(output);
//            String output = JSONArray.toJSONString(productDaoImplement.getProduct(productId));
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
            String output = userController.doLogin(username,password,httpSession).get("result").toString();
            if(output.equals("unexist")||output.equals("wrong")){
                output = "false";
            }
            else{
                output = "true";
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
     * Method: doRegister(String userName, String email, String nickName, String password, String phoneNumber, int sex, String birthday, String postNumber, String address)
     */
    @Test
    public void testDoRegister() throws Exception {
//TODO: Test goes here...
        String testCase = "IT_TD_001_002";
        CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_001_002.csv", ',', Charset.forName("utf8"));
        csvReader.readHeaders();
        System.out.println("Test-interface--doRegister");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();
        int i=0;
        //测试用例表格的每行元素(除去header后)
        while (csvReader.readRecord()) {
            //每列元素的
            String username = csvReader.get(0);
            String email = csvReader.get(1);
            String nickName = csvReader.get(2);
            String password = csvReader.get(3);
            String phoneNumber = csvReader.get(4);
            int sex = Integer.parseInt(csvReader.get(5));
            String birthday = csvReader.get(6);
            String postNumber = csvReader.get(7);
            String address = csvReader.get(8);
            String expect = csvReader.get(9).toLowerCase();

            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        output = JSON.toJSONString(output);
//            String output = JSONArray.toJSONString(productDaoImplement.getProduct(productId));
            String output = userController.doRegister(username,email,nickName,password,phoneNumber,sex,birthday,postNumber,address).get("result").toString();
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
//     * Method: doUpdate(String userName, String email, String nickName, String password, String phoneNumber, int sex, String birthday, String postNumber, String address)
//     */
//    @Test
//    public void testDoUpdate() throws Exception {
////TODO: Test goes here...
//    }

//    /**
//     * Method: getAllUser()
//     */
//    @Test
//    public void testGetAllUser() throws Exception {
////TODO: Test goes here...
//    }

//    /**
//     * Method: deleteUser(int id)
//     */
//    @Test
//    public void testDeleteUser() throws Exception {
////TODO: Test goes here...
//    }

    /**
     * Method: getUserAddressAndPhoneNumber(int id)
     */
    @Test
    public void testGetUserAddressAndPhoneNumber() throws Exception {
//TODO: Test goes here...
        String testCase = "IT_TD_001_004";
        CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_001_004.csv", ',', Charset.forName("utf8"));
        csvReader.readHeaders();
        System.out.println("Test-interface--getUserAddressAndPhoneNumber");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();
        int i=0;
        //测试用例表格的每行元素(除去header后)
        while (csvReader.readRecord()) {
            //每列元素的
            int userId = Integer.parseInt(csvReader.get(0));
            String expect = csvReader.get(1);

            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        output = JSON.toJSONString(output);
//            String output = JSONArray.toJSONString(productDaoImplement.getProduct(productId));
            String output = JSON.toJSONString(userController.getUserAddressAndPhoneNumber(userId));

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
//     * Method: doLogout(HttpSession httpSession)
//     */
//    @Test
//    public void testDoLogout() throws Exception {
////TODO: Test goes here...
//    }


    /**
     * Method: getUserDetailById(int id)
     */
    @Test
    public void testGetUserDetailById() throws Exception {
//TODO: Test goes here...
        String testCase = "IT_TD_001_003";
        CsvReader csvReader = new CsvReader("src/testCase/IT/IT_TD_001_003.csv", ',', Charset.forName("utf8"));
        csvReader.readHeaders();
        System.out.println("Test-interface--getUserDetailById");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();
        int i=0;
        //测试用例表格的每行元素(除去header后)
        while (csvReader.readRecord()) {
            //每列元素的
            int userId = Integer.parseInt(csvReader.get(0));
            String expect = csvReader.get(1);

            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        output = JSON.toJSONString(output);
//            String output = JSONArray.toJSONString(productDaoImplement.getProduct(productId));
            String output = userController.getUserDetailById(userId).get("result").toString();

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

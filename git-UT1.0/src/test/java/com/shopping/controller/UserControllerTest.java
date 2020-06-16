package com.shopping.controller;

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

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * UserController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 28, 2019</pre>
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
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getUserById(int id)
     */
    @Test
    public void testGetUserById() throws Exception {
//TODO: Test goes here...
        //读取测试用例
        CsvReader csvReader = new CsvReader("src/testCase/1.csv", ',', Charset.forName("GBK"));
        csvReader.readHeaders();
        System.out.println("Test-case");
        //用来存储是否通过测试的Boolean
        List<Boolean> passedList = new ArrayList<>();

        //测试用例表格的每行元素
        while (csvReader.readRecord()) {
            //每列元素的
            String id = csvReader.get(0);
            String expect = csvReader.get(1);
            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);//关闭烦人的hibernate日志输出
//        String output = new GsonBuilder().disableHtmlEscaping().create().toJson(articleService.searchArticles(query));
            String output = userController.getUserById(Integer.parseInt(id)).get("result").toString();
            System.out.println("id:" + id);
            System.out.println("output:" + output);
            System.out.println("expect:" + expect);

            //为true表示通过
            boolean ispassed = output.equals(expect);
            if (ispassed) {
                System.out.print("test case passed");
            } else {
                System.out.print("test case failed");
            }
            //将测试结果放在列表里
            passedList.add(ispassed);
            System.out.println("\n");
        }
        //断言是为了调用junit工具来记录是否通过测试
        for (boolean p : passedList) {
            assert p;
        }
//    Object obj = userController.getUserById(2);
//    System.out.print(((Map) obj).get("result").toString());
//    assertEquals(1,1);
    }

    /**
     * /**
     * <p>
     * Method: register()
     */
    @Test
    public void testRegister() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: amend_info()
     */
    @Test
    public void testAmend_info() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: login()
     */
    @Test
    public void testLogin() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: main()
     */
    @Test
    public void testMain() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: control()
     */
    @Test
    public void testControl() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: doLogin(String userNameOrEmail, String password, HttpSession httpSession)
     */
    @Test
    public void testDoLogin() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: doRegister(String userName, String email, String nickName, String password, String phoneNumber, int sex, String birthday, String postNumber, String address)
     */
    @Test
    public void testDoRegister() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: doUpdate(String userName, String email, String nickName, String password, String phoneNumber, int sex, String birthday, String postNumber, String address)
     */
    @Test
    public void testDoUpdate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getAllUser()
     */
    @Test
    public void testGetAllUser() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteUser(int id)
     */
    @Test
    public void testDeleteUser() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getUserAddressAndPhoneNumber(int id)
     */
    @Test
    public void testGetUserAddressAndPhoneNumber() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: doLogout(HttpSession httpSession)
     */
    @Test
    public void testDoLogout() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: getUserDetailById(int id)
     */
    @Test
    public void testGetUserDetailById() throws Exception {
//TODO: Test goes here... 
    }


} 

package com.shopping.controller;

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

/**
 * ProductController Tester.
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
public class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getAllProducts()
     */
    @Test
    public void testGetAllProducts() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteProduct(int id)
     */
    @Test
    public void testDeleteProduct() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addProduct(String name, String description, String keyWord, int price, int counts, int type)
     */
    @Test
    public void testAddProduct() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: productDetail(int id, HttpSession httpSession)
     */
    @Test
    public void testProductDetail() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: product_detail()
     */
    @Test
    public void testProduct_detail() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: searchPre(String searchKeyWord, HttpSession httpSession)
     */
    @Test
    public void testSearchPre() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: search()
     */
    @Test
    public void testSearch() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: searchProduct(String searchKeyWord)
     */
    @Test
    public void testSearchProduct() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getProductById(int id)
     */
    @Test
    public void testGetProductById() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: uploadFile(@RequestParam MultipartFile productImgUpload, String name, HttpServletRequest request)
     */
    @Test
    public void testUploadFile() throws Exception {
//TODO: Test goes here... 
    }


} 

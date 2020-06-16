package com.shopping.dao;

import com.shopping.entity.Product;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductDaoImplement implements ProductDao {
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Product getProduct(int id) {
        String hql = "from Product where id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, id);
        return (Product) query.uniqueResult();
    }

    @Override
    public Product getProduct(String name) {
        String hql = "from Product where name=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, name);
        return (Product) query.uniqueResult();
    }

    @Override
    public void addProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        String hql_1 = "delete Evaluation where productId=?";
        String hql_2 = "delete ShoppingRecord where productId=?";
        String hql_3 = "delete ShoppingCar where productId=?";
        String hql_4 = "delete Product where id=?";
        List<String> hql = Arrays.asList(hql_1,hql_2,hql_3,hql_4);
        boolean result = false;
        for(int i = 0;i < hql.size();i++){
            Query query = sessionFactory.getCurrentSession().createQuery(hql.get(i));
            query.setParameter(0, id);
            result = query.executeUpdate() > 0;
//            System.out.print(i);
        }
        return result;


//        String hql = "delete Product where id=?";
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        query.setParameter(0, id);
//        return query.executeUpdate() > 0;
    }

    @Override
    public boolean updateProduct(Product product) {
//        System.out.print(product.getName());
        if(product.getPrice() < 0||product.getCounts() < 0 || product.getName().equals("") || product.getKeyWord().equals("")){
            return false;
        }
        String hql_1 = "update ShoppingCar set productPrice=? where productId=?";
        String hql_2= "update ShoppingRecord set productPrice=? where productId=?";
        String hql_3 = "update Product set name=?,description=?,keyWord=?,price=?,counts=?,type=? where id=?";
        Query query1 = sessionFactory.getCurrentSession().createQuery(hql_1);
        query1.setParameter(0, product.getPrice());
        query1.setParameter(1, product.getId());
        query1.executeUpdate();

        Query query2 = sessionFactory.getCurrentSession().createQuery(hql_2);
        query2.setParameter(0, product.getPrice());
        query2.setParameter(1, product.getId());
        query2.executeUpdate();

        Query query3 = sessionFactory.getCurrentSession().createQuery(hql_3);
        query3.setParameter(0, product.getName());
        query3.setParameter(1, product.getDescription());
        query3.setParameter(2, product.getKeyWord());
        query3.setParameter(3, product.getPrice());
        query3.setParameter(4, product.getCounts());
        query3.setParameter(5, product.getType());
        query3.setParameter(6, product.getId());
        return query3.executeUpdate() > 0;
    }

    @Override
    public List<Product> getProductsByKeyWord(String searchKeyWord) {
        if(searchKeyWord.equals(""))
        {
            String hql = "from Product where name=?";
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setParameter(0, searchKeyWord);
            return query.list();
        }
        else {
            String queryKeyWord = "%";
            for (int i = 0; i < searchKeyWord.length(); i++) {
                queryKeyWord += String.valueOf(searchKeyWord.charAt(i)) + "%";
            }
//        System.out.println("我搜索了" + queryKeyWord);
            String hql = "from Product where name like ? or key_word like ?";
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setParameter(0, queryKeyWord);
            query.setParameter(1, queryKeyWord);
            return query.list();
        }
    }

    @Override
    public List<Product> getProductsByType(int type) {
        String hql = "from Product where type=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, type);
        return query.list();
    }


    @Override
    public List<Product> getAllProduct() {
        String hql = "from Product";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
}

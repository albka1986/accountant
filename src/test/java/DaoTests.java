// Created by Ponomarenko Oleh on 20.08.2016.

import org.junit.Assert;
import org.junit.Test;
import ua.com.alfacell.dao.CrudDao;
import ua.com.alfacell.dao.ProductDaoImpl;
import ua.com.alfacell.models.Product;

import java.util.List;

public class DaoTests {
    CrudDao<Product> productDao = new ProductDaoImpl();
    //ProductDaoImpl
    @Test
    public void testFindProductById() {
        Product product = productDao.findById(1);
        Assert.assertNotNull(product);
        System.out.println(product);
    }

    @Test
    public void testFindAllProducts() {
        List<Product> products = productDao.findAll();
        Assert.assertNotNull(products);
        System.out.println(products);
    }

    @Test
    public void testSaveProduct() {
        Product product = new Product();
        product.setBarcode("123123123123");
        product.setBrand("Huawei");
        product.setImei("123123123123123");
        product.setNameProduct("y3c");

        productDao.save(product);
        System.out.println(productDao.findAll());

    }



}

// Created by Ponomarenko Oleh on 20.08.2016.

import org.junit.Assert;
import org.junit.Test;
import ua.com.alfacell.dao.CrudDao;
import ua.com.alfacell.dao.impl.ProductDaoImpl;
import ua.com.alfacell.models.Product;

import java.util.List;

public class DaoTests {
    CrudDao<Product> productDao = new ProductDaoImpl();

    //ProductDaoImpl
    @Test
    public void testFindProductById() {
        Product product = productDao.findById(1);
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

    @Test
    public void testUpdateProduct() {
        Product updateProduct = new Product();
        updateProduct.setId(1);
        updateProduct.setNameProduct("y5c");
        updateProduct.setBrand("LG");
        updateProduct.setImei("123123123123");
        updateProduct.setBarcode("123123123123");

        System.out.println("Before");
        System.out.println(productDao.findAll());

        productDao.update(updateProduct);

        System.out.println("After");
        System.out.println(productDao.findAll());
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product();
        product.setId(1);

        System.out.println("Before");
        System.out.println(productDao.findAll());

        productDao.delete(product);

        System.out.println("After");
        System.out.println(productDao.findAll());
    }


}

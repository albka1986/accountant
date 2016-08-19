// Created by Ponomarenko Oleh on 20.08.2016.

import org.junit.Assert;
import org.junit.Test;
import ua.com.alfacell.dao.CrudDao;
import ua.com.alfacell.dao.ProductDaoImpl;
import ua.com.alfacell.models.Product;

public class DaoTests {

    //ProductDaoImpl
    @Test
    public void testFindProductById() {
        CrudDao<Product> productDao = new ProductDaoImpl();
        Product product = productDao.findById(1);
        Assert.assertNotNull(product);
        System.out.println(product);

    }


}

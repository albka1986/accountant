// Created by Ponomarenko Oleh on 20.08.2016.

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import ua.com.alfacell.dao.CrudDao;
import ua.com.alfacell.dao.impl.ProductDaoImpl;
import ua.com.alfacell.dao.impl.ShopDaoImpl;
import ua.com.alfacell.dao.impl.UserDaoImpl;
import ua.com.alfacell.models.Product;
import ua.com.alfacell.models.Shop;
import ua.com.alfacell.models.User;

import java.util.List;

public class DaoTests {

    //ProductDaoImpl
    CrudDao<Product> productDao = new ProductDaoImpl();
    //UserDaoImpl
    CrudDao<User> userDao = new UserDaoImpl();
    //ShopDaoImpl
    CrudDao<Shop> shopDao = new ShopDaoImpl();

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

    @Test
    public void testFindUserById() {
        User user = userDao.findById(1);
        System.out.println(user);
    }

    @Test
    public void testFindAllUsers() {
        List<User> users = userDao.findAll();
        System.out.println(users);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setLogin("Login2");
        user.setPassword("password2");
        user.setAddress("Any address");
        user.setPhone("0631441234");
        user.setEmail("alba@ma.ru");
        userDao.save(user);
        System.out.println(userDao.findAll());
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(2);
        user.setFirstName("UpdatedUser");

        System.out.println("");
        System.out.println("Before");
        System.out.println(userDao.findAll());
        userDao.update(user);
        System.out.println("");
        System.out.println("After");
        System.out.println(userDao.findAll());
    }

    @Test
    public void testDeleteUser() {
        User user = new User();
        user.setId(3);

        System.out.println("");
        System.out.println("Before");
        System.out.println("Amount of users: " + userDao.findAll().size());
        userDao.delete(user);
        System.out.println("");
        System.out.println("After");
        System.out.println("Amount of users: " + userDao.findAll().size());

    }

    @Test
    public void testFindShopById() {
        Shop shop = shopDao.findById(1);
        System.out.println(shop);
    }

    @Test
    public void testFindAllShops() {
        List<Shop> shops = shopDao.findAll();
        System.out.println(shops);
    }

    @Test
    public void testSaveShop() {
        Shop shop = new Shop();
        shop.setNameShop("Alekseevka");

        System.out.println("");
        System.out.println("Before");
        System.out.println(shopDao.findAll().size());
        shopDao.save(shop);
        System.out.println("");
        System.out.println("After");
        System.out.println(shopDao.findAll().size());
    }

    @Test
    public void testSaveTenShops() {
        System.out.println("");
        System.out.println("Before");
        System.out.println("Amount of shops: " + shopDao.findAll().size());
        for (int x = 0; x < 10; x++) {
            Shop shop = new Shop();
            shop.setNameShop("shop_" + x);
            shopDao.save(shop);
        }
        System.out.println("");
        System.out.println("After");
        System.out.println("Amount of shops: " + shopDao.findAll().size());
    }
}

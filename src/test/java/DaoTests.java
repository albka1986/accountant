import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.alfacell.dao.CrudDao;
import ua.com.alfacell.dao.impl.*;
import ua.com.alfacell.models.*;

import java.util.List;
import java.util.Random;

import static util.MyRandom.falseOrTrue;

public class DaoTests {

    //ProductDaoImpl
    CrudDao<Product> productDao = new ProductDaoImpl();
    //UserDaoImpl
    UserDaoImpl userDao = new UserDaoImpl();
    //ShopDaoImpl
    CrudDao<Shop> shopDao = new ShopDaoImpl();
    //CategoryDaoImpl
    CrudDao<Category> categoryDao = new CategoryDaoImpl();
    //StorageDaoImpl
    CrudDao<Storage> storageDao = new StorageDaoImpl();

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
        user.setLogin("admin");
        user.setPassword("admin");
        userDao.save(user);
        System.out.println(new UserDaoImpl().findById(1));
    }

    @Test
    public void testSaveUser2() {
        User user = new User();
        user.setLastName("oleh");
        user.setPassword("12345678");
        user.setFirstName("Oleh");
        user.setLastName("Ponomarenko");
        user.setPhone("+380631110001");
        user.setEmail("my@email.com");

        userDao.save(user);
    }

    @Test(invocationCount = 100)
    public void testSaveUserRandom() {
        Random random = new Random();
        int x = random.nextInt(99999);

        User user = new User();

        user.setFirstName("name" + x);
        user.setLastName("lastName" + x);
        user.setLogin("login" + x);
        user.setPassword("password" + x);
        user.setEmail("mail.@mail.com" + x);
        if (falseOrTrue()) {
            user.setPhone("777-" + random.nextInt(100) + "-" + random.nextInt(100));
        }
        if (falseOrTrue()) {
            user.setRole(Role.USER);
        }
        if (falseOrTrue()) {
            int amountShops = shopDao.findAll().size();
            Shop shop = shopDao.findById(new Random().nextInt(amountShops));
            user.setShop(shop);
        }

        userDao.save(user);
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

    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setId(3);
        shop.setNameShop("Updated");

        System.out.println("Before");
        System.out.println(shopDao.findById(3));
        shopDao.update(shop);
        System.out.println("After");
        System.out.println(shopDao.findById(3));
    }

    @Test
    public void testDeleteShop() {
        Shop shop = new Shop();
        shop.setId(1);

        System.out.println("Amount of Shop (BEFORE): " + shopDao.findAll().size());
        shopDao.delete(shop);
        System.out.println("Amount of Shop (AFTER): " + shopDao.findAll().size());
    }

    @Test
    public void testFindCategoryById() {
        Category category = categoryDao.findById(1);
        System.out.println(category);
    }

    @Test
    public void testFindAllCategories() {
        List<Category> categories = categoryDao.findAll();
        System.out.println(categories);
    }

    @Test
    public void testSaveCategory() {
        Category category = new Category();
        category.setNameCategory("Чехлы");

        System.out.println("");
        System.out.println("Before");
        System.out.println("Amount of category: " + categoryDao.findAll().size());
        categoryDao.save(category);
        System.out.println("");
        System.out.println("After");
        System.out.println("Amount of category: " + categoryDao.findAll().size());
    }

    @Test
    public void testUpdateCategory() {
        Category category = new Category();
        category.setId(1);
        category.setNameCategory("Updated");

        System.out.println(categoryDao.findById(1));
        categoryDao.update(category);
        System.out.println(categoryDao.findById(1));
    }

    @Test
    public void testDeleteCategory() {
        Category category = new Category();
        category.setId(0);

        System.out.println("Amount of categories(before deleting): " + categoryDao.findAll().size());
        categoryDao.delete(category);
        System.out.println("Amount of categories(after deleting): " + categoryDao.findAll().size());
    }

    @Test
    public void testFindStorageById() {
        Storage storage = storageDao.findById(1);
        Assert.assertNotNull(storage);
        System.out.println(storage);
    }

    @Test
    public void testFindAllStorage() {
        List<Storage> storageList = storageDao.findAll();
        System.out.println(storageList);
        System.out.println(storageList.size());
    }

    @Test
    public void testSaveStorage() {
        Storage storage = new Storage();
        storageDao.save(storage);
    }

    @Test
    public void testUpdateStorage() {
        Storage storage = new Storage();
        storage.setId(1);
        storage.setImei(String.valueOf(new Random().nextInt(999999999)));
        storageDao.update(storage);
    }

    @Test
    public void testDelete() {
        Storage storage = new Storage();
        storage.setId(1);

        storageDao.delete(storage);
    }

    @Test
    public void testFindUserLoginPassword() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findByLoginPassword("user1", "password");
        System.out.println(user);
    }

    @Test
    public void testAmountOfProductAllShops() {
      /*  List<Storage> storageList = new StorageDaoImpl().amountOfProductAllShops();
        Assert.assertNotNull(storageList);
        for (Storage storage : storageList) {
            System.out.println(storage);
        }*/
    }

    @Test(invocationCount = 10)
    public void testRandomBoolean() {

        boolean result = falseOrTrue();
        System.out.println(result);

    }

}

// Created by Ponomarenko Oleh on 31.08.2016.

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.alfacell.dto.*;
import ua.com.alfacell.models.Role;
import ua.com.alfacell.service.*;

import java.util.List;
import java.util.Random;

import static util.MyRandom.falseOrTrue;

public class ServiceTests {

    UserService userService = new UserService();
    ShopService shopService = new ShopService();
    ProductService productService = new ProductService();
    Random random = new Random();

    @Test
    public void testServiceSaveUser() {
        UserDto userDto = new UserDto();
        userDto.setLogin("oleg-login");
        userDto.setPassword("password1234");
        userDto.setFirstName("Oleg");
        userDto.setLastName("Ponomarenko");
        userDto.setPhone("+380631112220");
        userDto.setEmail("albka1986@mail.ru");

        ShopDto shopDto = new ShopDto();
        shopDto.setNameShop("Petrovskogo");
        userDto.setShopDto(shopDto);
        userService.save(userDto);
    }

    @Test
    public void testGetAllStorage() {

        StorageService storageService = new StorageService();
        List<StorageDto> storageDtos = storageService.findProductsByShopId(6);
        Assert.assertNotNull(storageDtos);
        storageDtos.forEach(System.out::println);

    }

    @Test
    public void testFindProductsByShopId() {
        List<StorageDto> storageDtoList = new StorageService().findProductsByShopId(6);
        Assert.assertNotNull(storageDtoList);
        System.out.println("List of Products in a Shop #6");
        storageDtoList.forEach(System.out::println);
    }

    @Test
    public void testFindAllUsers() {
        List<UserDto> userDtos = userService.findAll();
        Assert.assertNotNull(userDtos);
    }

    @Test(invocationCount = 1)
    public void testSaveUserRandom() {

        int x = random.nextInt(99999);

        UserDto userDto = new UserDto();

        userDto.setFirstName("name" + x);
        userDto.setLastName("lastName" + x);
        userDto.setLogin("login" + x);
        userDto.setPassword("password" + x);
        userDto.setEmail("mail.@mail.com" + x);
        if (true) {
            userDto.setPhone("777-" + random.nextInt(100) + "-" + random.nextInt(100));
        }
        if (falseOrTrue()) {
            userDto.setRole(Role.USER);
        }
        if (falseOrTrue()) {
            int amountShops = shopService.findAll().size();
            int randomShop = random.nextInt(amountShops) + 1;
            ShopDto shopDto = shopService.findById(randomShop);
            userDto.setShopDto(shopDto);
        }

        userService.save(userDto);
    }

    @Test(invocationCount = 100)
    public void testSaveUserRole() {

        int x = random.nextInt(99999);

        UserDto userDto = new UserDto();

        userDto.setFirstName("name" + x);
        userDto.setLastName("lastName" + x);
        userDto.setLogin("login" + x);
        userDto.setPassword("password" + x);
        userDto.setEmail("mail.@mail.com" + x);
        if (falseOrTrue()) {
            userDto.setPhone("777-" + random.nextInt(100) + "-" + random.nextInt(100));
        }
        userDto.setRole(Role.MANAGER);

        if (falseOrTrue()) {
            int amountShops = shopService.findAll().size();
            int randomShop = random.nextInt(amountShops) + 1;
            ShopDto shopDto = shopService.findById(randomShop);
            userDto.setShopDto(shopDto);
        }

        userService.save(userDto);
        Assert.assertTrue(userDto.getRole().equals(Role.MANAGER));
    }

    @Test
    public void testRole() {
        String admin = "ADMIN";
        String manager = "MANAGER";
        String user = "USER";
        Role roleAdmin = Role.valueOf(admin);
        Role roleManager = Role.valueOf(manager);
        Role roleUser = Role.valueOf(user);
        System.out.println(roleAdmin);
        System.out.println(roleManager);
        System.out.println(roleUser);
    }

    @Test
    public void testCreateProduct() {

        ProductDto productDto = null;
        for (int i = 0; i < 10; i++) {
            productDto = new ProductDto();
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(new Random().nextInt(2) + 1);
            productDto.setCategoryDto(categoryDto);
            productDto.setBrand("MyBrand");
            productDto.setNameProduct("Model #" + i);
            productDto.setBarcode(String.valueOf(new Random().nextInt(999999999) + "0000"));
            System.out.println(productDto);
            productService.save(productDto);
        }
    }

    @Test(invocationCount = 10)
    public void testFindCategoryByNameBool() {
        System.out.println("Enter");
        CategoryService categoryService = new CategoryService();
        String testNameCategory = "asdasaq21asda";

        boolean result = categoryService.nameCategoryExists(testNameCategory);
        System.out.println(result);
        Assert.assertFalse(result);

        CategoryDto category = new CategoryDto();
        category.setNameCategory(testNameCategory);
        categoryService.save(category);

        result = categoryService.nameCategoryExists(testNameCategory);
        Assert.assertTrue(result);
        categoryService.delete(categoryService.findByName(testNameCategory));
        System.out.println("Exit");
    }

}

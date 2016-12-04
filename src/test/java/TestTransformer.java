// Created by Ponomarenko Oleh on 27.11.2016.

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.alfacell.dao.impl.ProductDaoImpl;
import ua.com.alfacell.dto.ProductDto;
import ua.com.alfacell.dto.ShopDto;
import ua.com.alfacell.dto.UserDto;
import ua.com.alfacell.models.*;
import ua.com.alfacell.utilites.Transformer;

import java.util.LinkedList;
import java.util.List;

public class TestTransformer {

    @Test
    public void testShopToShopDto() {
        Shop shop = new Shop();
        shop.setId(1);
        shop.setNameShop("Ленина");

        ShopDto shopDto = Transformer.shopToShopDto(shop);
        Assert.assertNotNull(shopDto);
    }

    @Test
    public void testUserToUserDto() {
        User user = new User();
        user.setId(1);
        user.setFirstName("oleg");
        user.setLastName("ponom");
        user.setLogin("oleg");
        user.setPassword("oleg");
        user.setEmail("admin@alfacell.com.ua");
        user.setShop(null);
        user.setRole(Role.ADMIN);

        UserDto userDto = Transformer.userToUserDto(user);
        Assert.assertNotNull(userDto);
    }

    @Test
    public void testListProductToProductDto() {
        List<Product> products = new LinkedList<>();
        ProductDaoImpl productDao = new ProductDaoImpl();

        Product product = new Product();
        product.setId(1);
        product.setNameProduct("G4");
        product.setBrand("LG");
        Category category = new Category();
        category.setId(1);
        category.setNameCategory("Телефоны");
        product.setCategory(category);
        products.add(product);

        product = new Product();
        product.setId(2);
        product.setNameProduct("G5");
        product.setBrand("LG2");
        product.setCategory(category);
        products.add(product);


        product = new Product();
        product.setId(3);
        product.setNameProduct("G6");
        product.setBrand("LG3");
        products.add(product);

        List<ProductDto> productDtos = Transformer.listProductToProductDto(products);
        Assert.assertNotNull(productDtos);

    }


}

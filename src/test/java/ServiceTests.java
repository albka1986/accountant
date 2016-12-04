// Created by Ponomarenko Oleh on 31.08.2016.

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.alfacell.dto.ShopDto;
import ua.com.alfacell.dto.StorageDto;
import ua.com.alfacell.dto.UserDto;
import ua.com.alfacell.models.Role;
import ua.com.alfacell.service.ShopService;
import ua.com.alfacell.service.StorageService;
import ua.com.alfacell.service.UserService;

import java.util.List;
import java.util.Random;

import static util.MyRandom.falseOrTrue;

public class ServiceTests {

    UserService userService = new UserService();
    ShopService shopService = new ShopService();
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

    @Test(invocationCount = 100)
    public void testSaveUserRandom() {

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
}

// Created by Ponomarenko Oleh on 31.08.2016.

import org.junit.Assert;
import org.junit.Test;
import ua.com.alfacell.dto.ShopDto;
import ua.com.alfacell.dto.UserDto;
import ua.com.alfacell.service.UserService;

public class ServiceTests {

    UserService userService = new UserService();

    @Test
    public void testServiceSaveUser(){
        UserDto userDto = new UserDto();
        userDto.setLogin("oleg-login");
        userDto.setPassword("password1234");
        userDto.setFirstName("Oleg");
        userDto.setLastName("Ponomarenko");
        userDto.setPhone("+380631112220");
        userDto.setAddress("Харьков, пр. Победы, 17, кв. 2");
        userDto.setEmail("albka1986@mail.ru");

        ShopDto shopDto = new ShopDto();
        shopDto.setNameShop("Petrovskogo");
        userDto.setShop(shopDto);
        userService.save(userDto);
    }

}

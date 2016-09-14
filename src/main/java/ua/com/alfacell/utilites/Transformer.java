package ua.com.alfacell.utilites;

import ua.com.alfacell.dto.ShopDto;
import ua.com.alfacell.dto.UserDto;
import ua.com.alfacell.models.Shop;
import ua.com.alfacell.models.User;

import java.util.ArrayList;
import java.util.List;

public class Transformer {

    public static UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setAddress(user.getAddress());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setRole(user.getRole());
        userDto.setShop(shopToShopDto(user.getShop()));
        return userDto;
    }

    public static User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setPhone(userDto.getPhone());
        user.setRole(userDto.getRole());
        user.setShop(Transformer.shopDtoToShop(userDto.getShop()));
        return user;
    }


    public static List<UserDto> listUsersToListUserDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = userToUserDto(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public static ShopDto shopToShopDto(Shop shop) {
        ShopDto shopDto = new ShopDto();
        shopDto.setId(shop.getId());
        shopDto.setNameShop(shop.getNameShop());
        return shopDto;
    }

    public static Shop shopDtoToShop(ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setId(shopDto.getId());
        shop.setNameShop(shopDto.getNameShop());

        return shop;
    }


}

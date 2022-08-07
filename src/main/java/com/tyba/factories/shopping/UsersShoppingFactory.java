package com.tyba.factories.shopping;

import com.tyba.exceptions.DataNotFoundException;
import com.tyba.models.shopping.UserShopping;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.tyba.enums.JsonPaths.USER_SHOPPING;
import static io.restassured.path.json.JsonPath.from;

public class UsersShoppingFactory {

    public static List<UserShopping> getUsers() {
        return Arrays.asList(from(getUsersFile()).getObject(USER_SHOPPING.getObjectsName(), UserShopping[].class));
    }

    public static UserShopping getUserByKey(int key) {
        return getUsers().stream()
                .filter(a -> a.getKey() == key)
                .findFirst()
                .orElseThrow(() ->
                        new DataNotFoundException(String.format("User with key %s not found", key)));
    }

    @SneakyThrows
    private static URL getUsersFile() {
        URL filePath = UsersShoppingFactory.class.getClassLoader().getResource(USER_SHOPPING.getPath());
        if (filePath == null) {
            throw new FileNotFoundException("File not found for users: " + USER_SHOPPING.getPath());
        }
        return filePath;
    }

    public static UserShopping getUserWithRandomInfo(int key) {
        UserShopping user = getUserByKey(key);
        String rdm = String.valueOf(new Random().nextInt(1000));
        user.setUserName(user.getUserName().concat(rdm));
        user.setFirstName(user.getFirstName().concat(rdm));
        user.setEmail(user.getFirstName().concat(user.getEmail()));
        user.setPhoneNumber(user.getPhoneNumber().concat(rdm));
        return user;
    }

}

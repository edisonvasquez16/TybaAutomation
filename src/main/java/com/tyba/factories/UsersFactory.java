package com.tyba.factories;

import com.github.javafaker.Faker;
import com.tyba.exceptions.DataNotFoundException;
import com.tyba.models.User;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static com.tyba.enums.JsonPaths.USERS;
import static io.restassured.path.json.JsonPath.from;

public class UsersFactory {

    public static List<User> getUsers() {
        return Arrays.asList(from(getUsersFile()).getObject(USERS.getObjectsName(), User[].class));
    }

    public static User getUserByKey(int key) {
        return getUsers().stream()
                .filter(a -> a.getKey() == key)
                .findFirst()
                .orElseThrow(() ->
                        new DataNotFoundException(String.format("User with key %s not found", key)));
    }

    @SneakyThrows
    private static URL getUsersFile() {
        URL filePath = UsersFactory.class.getClassLoader().getResource(USERS.getPath());
        if (filePath == null) {
            throw new FileNotFoundException("File not found for users: " + USERS.getPath());
        }
        return filePath;
    }

    public static User getUserWithRandomInfo(int key) {
        User user = getUserByKey(key);
        String rdm = Faker.instance().random().nextInt(100, 999).toString();
        user.setUserName(user.getUserName().concat(rdm));
        user.setFirstName(user.getFirstName().concat(rdm));
        user.setEmail(user.getFirstName().concat(user.getEmail()));
        user.setPhoneNumber(user.getPhoneNumber().concat(rdm));
        return user;
    }

}

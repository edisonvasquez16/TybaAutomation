package com.tyba.factories.books;

import com.tyba.exceptions.DataNotFoundException;
import com.tyba.models.books.UserBook;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static com.tyba.enums.JsonPaths.USERS_BOOKS;
import static io.restassured.path.json.JsonPath.from;

public class UsersBookFactory {

    public static List<UserBook> getUsers() {
        return Arrays.asList(from(getUsersFile()).getObject(USERS_BOOKS.getObjectsName(), UserBook[].class));
    }

    public static UserBook getUserByKey(int key) {
        return getUsers().stream()
                .filter(a -> a.getKey() == key)
                .findFirst()
                .orElseThrow(() ->
                        new DataNotFoundException(String.format("User with key %s not found", key)));
    }

    @SneakyThrows
    private static URL getUsersFile() {
        URL filePath = UsersBookFactory.class.getClassLoader().getResource(USERS_BOOKS.getPath());
        if (filePath == null) {
            throw new FileNotFoundException("File not found for users: " + USERS_BOOKS.getPath());
        }
        return filePath;
    }

}

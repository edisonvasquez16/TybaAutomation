package com.tyba.factories.books;

import com.tyba.exceptions.DataNotFoundException;
import com.tyba.models.books.Book;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static com.tyba.enums.JsonPaths.BOOKS;
import static io.restassured.path.json.JsonPath.from;

public class BookFactory {

    public static List<Book> getBooks() {
        return Arrays.asList(from(getBooksFile()).getObject(BOOKS.getObjectsName(), Book[].class));
    }

    public static Book getBooksByKey(int key) {
        return getBooks().stream()
                .filter(a -> a.getKey() == key)
                .findFirst()
                .orElseThrow(() ->
                        new DataNotFoundException(String.format("Book with key %s not found", key)));
    }

    @SneakyThrows
    private static URL getBooksFile() {
        URL filePath = BookFactory.class.getClassLoader().getResource(BOOKS.getPath());
        if (filePath == null) {
            throw new FileNotFoundException("File not found for books: " + BOOKS.getPath());
        }
        return filePath;
    }

}

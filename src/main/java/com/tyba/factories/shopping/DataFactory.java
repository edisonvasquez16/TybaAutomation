package com.tyba.factories.shopping;

import com.tyba.exceptions.DataNotFoundException;
import com.tyba.models.shopping.ExampleData;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static com.tyba.enums.JsonPaths.EXAMPLE_DATA;
import static io.restassured.path.json.JsonPath.from;

public class DataFactory {

    public static List<ExampleData> getData() {
        return Arrays.asList(from(getDataFile()).getObject(EXAMPLE_DATA.getObjectsName(), ExampleData[].class));
    }

    public static ExampleData getDataByKey(int key) {
        return getData().stream()
                .filter(a -> a.getId() == key)
                .findFirst()
                .orElseThrow(() ->
                        new DataNotFoundException(String.format("Data with key %s not found", key)));
    }

    @SneakyThrows
    private static URL getDataFile() {
        URL filePath = DataFactory.class.getClassLoader().getResource(EXAMPLE_DATA.getPath());
        if (filePath == null) {
            throw new FileNotFoundException("File not found for data: " + EXAMPLE_DATA.getPath());
        }
        return filePath;
    }

}

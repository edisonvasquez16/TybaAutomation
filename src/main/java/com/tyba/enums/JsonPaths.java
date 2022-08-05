package com.tyba.enums;

public enum JsonPaths {

    EXAMPLE_DATA("files/jsonfe/example-data.json", "data"),
    USER_SHOPPING("files/jsonfe/users.json", "users"),
    USERS_BOOKS("files/jsonapi/users.json", "users"),
    BOOKS("files/jsonapi/books.json", "books"),
    ;

    private final String path;
    private final String objectsName;

    JsonPaths(String path, String objectsName) {
        this.path = path;
        this.objectsName = objectsName;
    }

    public String getPath() {
        return path;
    }

    public String getObjectsName() {
        return objectsName;
    }
}

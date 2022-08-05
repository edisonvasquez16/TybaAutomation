package com.tyba.enums;

public enum JsonPaths {

    EXAMPLE_DATA("files/example-data.json", "data"),
    USERS("files/users.json", "users"),
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

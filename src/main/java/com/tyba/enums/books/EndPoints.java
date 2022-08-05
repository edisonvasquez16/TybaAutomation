package com.tyba.enums.books;

public enum EndPoints {

    POST_TOKEN("auth", "Get token"),
    POST_BOOK("booking", "Create book"),
    GET_BOOK("booking/{id}", "See book"),
    UPDATE_BOOK("booking/{id}", "Update book"),
    DELETE_BOOK("booking/{id}", "Delete book"),
    ;

    private final String path;
    private final String serviceName;

    EndPoints(String path, String serviceName) {
        this.path = path;
        this.serviceName = serviceName;
    }

    public String getPath() {
        return path;
    }

    public String getServiceName() {
        return serviceName;
    }
}

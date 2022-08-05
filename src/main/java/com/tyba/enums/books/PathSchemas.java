package com.tyba.enums.books;

public enum PathSchemas {

    TOKEN_SC("files/jsonapi/token-schema.json"),
    BOOK_CREATED("files/jsonapi/book-created-schema.json"),
    BOOK_CONSULT("files/jsonapi/book-consult-schema.json"),
    BOOK_UPDATE("files/jsonapi/book-update-schema.json"),
    ;

    private final String path;

    PathSchemas(String path) {
        this.path = path;

    }

    public String getPath() {
        return path;
    }

}

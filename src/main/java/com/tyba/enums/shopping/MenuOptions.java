package com.tyba.enums.shopping;

public enum MenuOptions {

    OUR_PRODUCTS("OUR PRODUCTS"),
    SPECIAL_OFFER("SPECIAL OFFER"),
    POPULAR_ITEMS("POPULAR ITEMS"),
    CONTACT_US("CONTACT US"),
    ;

    private final String text;

    MenuOptions(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}

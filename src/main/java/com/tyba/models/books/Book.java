package com.tyba.models.books;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    private int key;
    private String firstname;
    private String lastname;
    private String totalprice;
    private String depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;

}

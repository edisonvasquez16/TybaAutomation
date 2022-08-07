package com.tyba.consequences.books;

import com.tyba.enums.books.PathSchemas;
import com.tyba.models.books.Book;
import com.tyba.models.books.BookResponse;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Consequence;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

public class SeeThatThe {

    public static Consequence statusResponseCodeOk() {
        return seeThat("status response", response ->
                        SerenityRest
                                .lastResponse()
                                .statusCode(),
                equalTo(SC_OK));
    }

    public static Consequence correctSchema(PathSchemas pathSchema) {
        return seeThat("Schema validation ".concat(pathSchema.name()), response ->
                        SerenityRest.lastResponse().asString(),
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath(pathSchema.getPath()));
    }

    public static Consequence[] bookInformationCreated(Book book, PathSchemas bookCreatedPath) {
        Book bookCreated = SerenityRest.lastResponse().as(BookResponse.class).getBooking();
        return new Consequence[]{
                seeThat("data book firstname information", response ->
                                bookCreated.getFirstname(),
                        equalTo(book.getFirstname())),
                seeThat("data book lastname information", response ->
                                bookCreated.getLastname(),
                        equalTo(book.getLastname())),
                seeThat("data book total price information", response ->
                                bookCreated.getTotalprice(),
                        equalTo(book.getTotalprice())),
                seeThat("data book deposit paid information", response ->
                                bookCreated.getDepositpaid(),
                        equalTo(book.getDepositpaid())),
                seeThat("data book additional needs information", response ->
                                bookCreated.getAdditionalneeds(),
                        equalTo(book.getAdditionalneeds())),
                correctSchema(bookCreatedPath),
                statusResponseCodeOk()
        };
    }

    public static Consequence[] bookInformationUpdated(Book book, PathSchemas bookUpdatePath) {
        Book bookUpdated = SerenityRest.lastResponse().as(Book.class);
        return new Consequence[]{
                seeThat("data book firstname information", response ->
                                bookUpdated.getFirstname(),
                        equalTo(book.getFirstname())),
                seeThat("data book lastname information", response ->
                                bookUpdated.getLastname(),
                        equalTo(book.getLastname())),
                seeThat("data book total price information", response ->
                                bookUpdated.getTotalprice(),
                        equalTo(book.getTotalprice())),
                seeThat("data book deposit paid information", response ->
                                bookUpdated.getDepositpaid(),
                        equalTo(book.getDepositpaid())),
                seeThat("data book additional needs information", response ->
                                bookUpdated.getAdditionalneeds(),
                        equalTo(book.getAdditionalneeds())),
                correctSchema(bookUpdatePath),
                statusResponseCodeOk()
        };
    }

}

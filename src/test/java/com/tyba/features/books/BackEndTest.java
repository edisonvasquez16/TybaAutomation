package com.tyba.features.books;

import com.tyba.conf.BaseConfBackEnd;
import com.tyba.tasks.books.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.tyba.factories.books.BookFactory.getBooksByKey;
import static com.tyba.factories.books.UsersBookFactory.getUserByKey;

@RunWith(SerenityRunner.class)
@Narrative(text = {"As a user of Tyba",
        "I want to be able to validate books",
        "To be able to manage books"})
@WithTag("TybaExampleBooks")
public class BackEndTest extends BaseConfBackEnd {


    @Test
    @WithTagValuesOf({"book-services:ESC:1", "smoke"})
    public void validateGenerateToken() {
        tybaUser.attemptsTo(
                GetToken
                        .authentication(getUserByKey(1))
        );
    }

    @Test
    @WithTagValuesOf({"book-services:ESC:2", "smoke"})
    public void validateCreateBook() {
        tybaUser.attemptsTo(
                GetToken
                        .authentication(getUserByKey(1)),
                CreateBook
                        .withInformation(getBooksByKey(1))
        );
    }

    @Test
    @WithTagValuesOf({"book-services:ESC:3", "smoke"})
    public void validateConsultBook() {
        tybaUser.attemptsTo(
                GetToken
                        .authentication(getUserByKey(1)),
                CreateBook
                        .withInformation(getBooksByKey(1)),
                GetBook
                        .information()
        );
    }

    @Test
    @WithTagValuesOf({"book-services:ESC:4", "smoke"})
    public void validateUpdateBook() {
        tybaUser.attemptsTo(
                GetToken
                        .authentication(getUserByKey(1)),
                CreateBook
                        .withInformation(getBooksByKey(1)),
                UpdateBook
                        .withInformation(getBooksByKey(2))
        );
    }

    @Test
    @WithTagValuesOf({"book-services:ESC:5", "smoke"})
    public void validateDeleteBooks() {
        tybaUser.attemptsTo(
                GetToken
                        .authentication(getUserByKey(1)),
                CreateBook
                        .withInformation(getBooksByKey(1)),
                DeleteBook
                        .fromDatabase()
        );
    }

    @Test
    @WithTagValuesOf({"book-services:ESC:6", "regression"})
    public void validateManageBooks() {
        tybaUser.attemptsTo(
                GetToken
                        .authentication(getUserByKey(1)),
                CreateBook
                        .withInformation(getBooksByKey(1)),
                GetBook
                        .information(),
                UpdateBook
                        .withInformation(getBooksByKey(2)),
                GetBook
                        .information(),
                DeleteBook
                        .fromDatabase()
        );
    }

}
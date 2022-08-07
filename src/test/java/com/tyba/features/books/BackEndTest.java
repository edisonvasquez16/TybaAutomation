package com.tyba.features.books;

import com.tyba.conf.BaseConfBackEnd;
import com.tyba.consequences.books.SeeThatThe;
import com.tyba.tasks.books.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.tyba.enums.books.PathSchemas.*;
import static com.tyba.factories.books.BookFactory.getBooksByKey;
import static com.tyba.factories.books.UsersBookFactory.getUserByKey;

@RunWith(SerenityRunner.class)
@Narrative(text = {"As a user of Tyba",
        "I want to be able to validate books",
        "To be able to manage books"})
@WithTag("TybaExampleBooks")
public class BackEndTest extends BaseConfBackEnd {


    @Test
    @WithTagValuesOf({"all","book-services:ESC:1", "regression"})
    public void validateGenerateToken() {
        tybaUser.attemptsTo(
                GetToken
                        .authentication(getUserByKey(1))
        );
        tybaUser.should(
                SeeThatThe.statusResponseCodeOk(),
                SeeThatThe.correctSchema(TOKEN_SC)
        );
    }

    @Test
    @WithTagValuesOf({"all","book-services:ESC:2", "regression"})
    public void validateGenerateTokenIncorrectUser() {
        tybaUser.attemptsTo(
                GetToken
                        .authentication(getUserByKey(2))
        );
        tybaUser.should(
                SeeThatThe.incorrectToken()
        );
    }

    @Test
    @WithTagValuesOf({"all","book-services:ESC:3", "regression"})
    public void validateCreateBook() {
        tybaUser.attemptsTo(
                GetToken
                        .authentication(getUserByKey(1)),
                CreateBook
                        .withInformation(getBooksByKey(1))
        );

        tybaUser.should(
                SeeThatThe.bookInformationCreated(getBooksByKey(1), BOOK_CREATED)
        );
    }

    @Test
    @WithTagValuesOf({"all","book-services:ESC:4", "regression"})
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
    @WithTagValuesOf({"all","book-services:ESC:5", "regression"})
    public void validateUpdateBook() {
        tybaUser.attemptsTo(
                GetToken
                        .authentication(getUserByKey(1)),
                CreateBook
                        .withInformation(getBooksByKey(1)),
                UpdateBook
                        .withInformation(getBooksByKey(2))
        );

        tybaUser.should(
                SeeThatThe.bookInformationUpdated(getBooksByKey(2), BOOK_UPDATE)
        );
    }

    @Test
    @WithTagValuesOf({"all","book-services:ESC:6", "regression"})
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
    @WithTagValuesOf({"all","book-services:ESC:7", "smoke"})
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
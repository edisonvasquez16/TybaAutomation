package com.tyba.features;

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
@WithTag("TybaExample")
public class BackEndTest extends BaseConfBackEnd {

    @Test
    @WithTagValuesOf({"book-services:ESC:1", "smoke"})
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
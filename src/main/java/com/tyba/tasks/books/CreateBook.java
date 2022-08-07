package com.tyba.tasks.books;

import com.tyba.consequences.books.SeeThatThe;
import com.tyba.models.books.Book;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.tyba.enums.Memory.BOOKING_ID;
import static com.tyba.enums.Memory.TOKEN;
import static com.tyba.enums.books.EndPoints.POST_BOOK;
import static com.tyba.enums.books.PathSchemas.BOOK_CREATED;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateBook implements Task {

    private final Book book;

    public CreateBook(Book book) {
        this.book = book;
    }

    public static CreateBook withInformation(Book book) {
        return instrumented(CreateBook.class, book);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(POST_BOOK.getPath())
                        .withRequest(
                                request ->
                                        request.contentType(ContentType.JSON)
                                                .header("Cookie", "token=" + actor.recall(TOKEN.toString()))
                                                .body(book)
                        )
        );
        actor.should(
                SeeThatThe.bookInformationCreated(book, BOOK_CREATED)
        );
        actor.remember(BOOKING_ID.toString(), SerenityRest.lastResponse().jsonPath().getString("bookingid"));
    }
}

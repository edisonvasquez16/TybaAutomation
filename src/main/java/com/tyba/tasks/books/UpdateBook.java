package com.tyba.tasks.books;

import com.tyba.consequences.books.SeeThatThe;
import com.tyba.models.books.Book;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.tyba.enums.Memory.BOOKING_ID;
import static com.tyba.enums.Memory.TOKEN;
import static com.tyba.enums.books.EndPoints.UPDATE_BOOK;
import static com.tyba.enums.books.PathSchemas.BOOK_UPDATE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateBook implements Task {

    private final Book book;

    public UpdateBook(Book book) {
        this.book = book;
    }

    public static UpdateBook withInformation(Book book) {
        return instrumented(UpdateBook.class, book);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(UPDATE_BOOK.getPath())
                        .withRequest(
                                request ->
                                        request.contentType(ContentType.JSON)
                                                .header("Cookie", "token=" + actor.recall(TOKEN.toString()))
                                                .body(book)
                                                .pathParam("id", actor.recall(BOOKING_ID.toString()))
                        )
        );
        actor.should(
                SeeThatThe.bookInformationUpdated(book, BOOK_UPDATE)
        );
    }
}

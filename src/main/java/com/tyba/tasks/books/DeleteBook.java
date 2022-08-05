package com.tyba.tasks.books;

import com.tyba.consequences.books.SeeThatThe;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static com.tyba.enums.Memory.BOOKING_ID;
import static com.tyba.enums.Memory.TOKEN;
import static com.tyba.enums.books.EndPoints.DELETE_BOOK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteBook implements Task {

    public static Performable fromDatabase() {
        return instrumented(DeleteBook.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(DELETE_BOOK.getPath())
                        .withRequest(
                                request ->
                                        request.contentType(ContentType.JSON)
                                                .header("Cookie", "token=" + actor.recall(TOKEN.toString()))
                                                .pathParam("id", actor.recall(BOOKING_ID.toString()))
                        )
        );
        actor.should(
                SeeThatThe.statusResponseDeleteOk()
        );
    }
}

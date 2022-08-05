package com.tyba.tasks.books;

import com.tyba.consequences.books.SeeThatThe;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.tyba.enums.Memory.BOOKING_ID;
import static com.tyba.enums.Memory.TOKEN;
import static com.tyba.enums.books.EndPoints.GET_BOOK;
import static com.tyba.enums.books.PathSchemas.BOOK_CONSULT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetBook implements Task {

    public static Performable information() {
        return instrumented(GetBook.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(GET_BOOK.getPath())
                        .withRequest(
                                request ->
                                        request.contentType(ContentType.JSON)
                                                .header("Cookie", "token=" + actor.recall(TOKEN.toString()))
                                                .pathParam("id", actor.recall(BOOKING_ID.toString()))
                        )
        );
        actor.should(
                SeeThatThe.statusResponseCodeOk(),
                SeeThatThe.correctSchema(BOOK_CONSULT)
        );
    }
}

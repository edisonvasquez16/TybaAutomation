package com.tyba.tasks.books;

import com.tyba.models.books.UserBook;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.tyba.enums.Memory.TOKEN;
import static com.tyba.enums.books.EndPoints.POST_TOKEN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetToken implements Task {

    private final UserBook user;

    public GetToken(UserBook user) {
        this.user = user;
    }

    public static GetToken authentication(UserBook user) {
        return instrumented(GetToken.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(POST_TOKEN.getPath())
                        .withRequest(
                                request ->
                                        request.contentType(ContentType.JSON)
                                                .body(user)
                        )
        );
        actor.remember(TOKEN.toString(), SerenityRest.lastResponse().jsonPath().getString("token"));
    }
}

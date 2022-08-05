package com.tyba.consequences.books;

import com.tyba.enums.books.PathSchemas;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_CREATED;
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

    public static Consequence statusResponseDeleteOk() {
        return seeThat("status response", response ->
                        SerenityRest
                                .lastResponse()
                                .statusCode(),
                equalTo(SC_CREATED));
    }

    public static Consequence correctSchema(PathSchemas pathSchema) {
        return seeThat("Schema validation ".concat(pathSchema.name()), response -> LastResponse.received()
                        .answeredBy(theActorInTheSpotlight()).asString(),
                JsonSchemaValidator
                        .matchesJsonSchemaInClasspath(pathSchema.getPath()));
    }

}

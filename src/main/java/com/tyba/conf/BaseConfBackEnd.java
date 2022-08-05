package com.tyba.conf;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class BaseConfBackEnd {

    protected Actor tybaUser;
    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        tybaUser = theActorCalled("Tyba User");
        tybaUser.can(CallAnApi
                .at(
                        EnvironmentSpecificConfiguration.from(environmentVariables)
                                .getProperty("service.base.url")
                ));
        SerenityRest.setDefaultRequestSpecification(defaultRequestSpecification());
    }

    private RequestSpecification defaultRequestSpecification() {
        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());
        return new RequestSpecBuilder()
                .addFilters(filters).build();
    }
}

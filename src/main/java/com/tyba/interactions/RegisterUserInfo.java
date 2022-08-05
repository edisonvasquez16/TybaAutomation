package com.tyba.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static com.tyba.ui.UserRegister.*;

public class RegisterUserInfo {

    public static Performable username(String username) {
        return Task.where("{0} enter the value in username",
                Enter.theValue(username).into(USERNAME)
        );
    }

    public static Performable email(String email) {
        return Task.where("{0} enter the value in email",
                Enter.theValue(email).into(EMAIL)
        );
    }

    public static Performable password(String password) {
        return Task.where("{0} enter the value in password",
                Enter.theValue(password).into(PASSWORD)
        );
    }

    public static Performable confirmPassword(String password) {
        return Task.where("{0} enter the value in confirmPassword",
                Enter.theValue(password).into(CONFIRM_PASSWORD)
        );
    }

    public static Performable firstName(String firstName) {
        return Task.where("{0} enter the value in firstName",
                Enter.theValue(firstName).into(FIRSTNAME)
        );
    }

    public static Performable lastName(String lastName) {
        return Task.where("{0} enter the value in lastName",
                Enter.theValue(lastName).into(LASTNAME)
        );
    }

    public static Performable phoneNumber(String phoneNumber) {
        return Task.where("{0} enter the value in phoneNumber",
                Enter.theValue(phoneNumber).into(PHONE_NUMBER)
        );
    }

    public static Performable country(String country) {
        return Task.where("{0} enter the value in country",
                SelectFromOptions.byVisibleText(country).from(COUNTRY)
        );
    }

    public static Performable city(String city) {
        return Task.where("{0} enter the value in city",
                Enter.theValue(city).into(CITY)
        );
    }

    public static Performable address(String address) {
        return Task.where("{0} enter the value in address",
                Enter.theValue(address).into(ADDRESS)
        );
    }

    public static Performable state(String state) {
        return Task.where("{0} enter the value in state",
                Enter.theValue(state).into(STATE)
        );
    }

    public static Performable postalCode(String postalCode) {
        return Task.where("{0} enter the value in postalCode",
                Enter.theValue(postalCode).into(POSTAL_CODE)
        );
    }

    public static Performable saveInfo() {
        return Task.where("{0} save info user register",
                Scroll.to(REGISTER).andAlignToBottom()
                        .then(Click.on(AGREE_CONDITIONS))
                        .then(Click.on(REGISTER))
        );
    }

}

package com.tyba.tasks;

import com.tyba.interactions.RegisterUserInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUser implements Task {

    private final List<Performable> itemsRegisterUser;

    public RegisterUser() {
        itemsRegisterUser = new ArrayList<>();
    }

    public static RegisterUser withInfo() {
        return instrumented(RegisterUser.class);
    }

    public RegisterUser username(String userName) {
        this.itemsRegisterUser.add(RegisterUserInfo.username(userName));
        return this;
    }

    public RegisterUser email(String email) {
        this.itemsRegisterUser.add(RegisterUserInfo.email(email));
        return this;
    }

    public RegisterUser password(String password) {
        this.itemsRegisterUser.add(RegisterUserInfo.password(password));
        return this;
    }

    public RegisterUser confirmPassword(String password) {
        this.itemsRegisterUser.add(RegisterUserInfo.confirmPassword(password));
        return this;
    }

    public RegisterUser firstName(String firstName) {
        this.itemsRegisterUser.add(RegisterUserInfo.firstName(firstName));
        return this;
    }

    public RegisterUser lastName(String lastName) {
        this.itemsRegisterUser.add(RegisterUserInfo.lastName(lastName));
        return this;
    }

    public RegisterUser phoneNumber(String phoneNumber) {
        this.itemsRegisterUser.add(RegisterUserInfo.phoneNumber(phoneNumber));
        return this;
    }

    public RegisterUser country(String country) {
        this.itemsRegisterUser.add(RegisterUserInfo.country(country));
        return this;
    }

    public RegisterUser city(String city) {
        this.itemsRegisterUser.add(RegisterUserInfo.city(city));
        return this;
    }

    public RegisterUser address(String address) {
        this.itemsRegisterUser.add(RegisterUserInfo.address(address));
        return this;
    }

    public RegisterUser state(String state) {
        this.itemsRegisterUser.add(RegisterUserInfo.state(state));
        return this;
    }

    public RegisterUser postalCode(String postalCode) {
        this.itemsRegisterUser.add(RegisterUserInfo.postalCode(postalCode));
        return this;
    }

    public RegisterUser andSaveInfo() {
        this.itemsRegisterUser.add(RegisterUserInfo.saveInfo());
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                registerUserActions()
        );
    }

    private Performable[] registerUserActions() {
        return this.itemsRegisterUser.toArray(new Performable[this.itemsRegisterUser.size()]);
    }
}

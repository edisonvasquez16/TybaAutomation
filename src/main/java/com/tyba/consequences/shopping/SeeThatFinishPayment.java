package com.tyba.consequences.shopping;

import com.tyba.models.shopping.ExampleData;
import com.tyba.models.shopping.UserShopping;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.questions.Text;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.tyba.ui.shopping.FinishedPayment.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class SeeThatFinishPayment {

    public static Consequence[] userData(UserShopping user) {
        return new Consequence[]{
                seeThat(
                        Text.of(USER_NAME), equalTo(user.getFirstName().concat(" ").concat(user.getLastName()))),
                seeThat(
                        Text.of(ADDRESS), equalTo(user.getAddress())),
                seeThat(
                        Text.of(CITY), equalTo(user.getCity())),
                seeThat(
                        Text.of(STATE), equalTo(user.getState())),
                seeThat(
                        Text.of(USER_PHONE_NUMBER), equalTo(user.getPhoneNumber()))
        };
    }

    public static Consequence[] payment() {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDateTime ldt = LocalDateTime.now();
        return new Consequence[]{
                seeThat(
                        Text.of(PAYMENT_DATE), equalTo(dt.format(ldt)))
        };
    }

    public static Consequence[] values(ExampleData data) {
        return new Consequence[]{
                seeThat(
                        Text.of(SUMMARY_SUBTOTAL), equalTo(data.getSubTotal())),
                seeThat(
                        Text.of(SUMMARY_SHIPPING), equalTo(data.getShipping())),
                seeThat(
                        Text.of(SUMMARY_TOTAL), equalTo(data.getTotalWithTaxes()))
        };
    }
}

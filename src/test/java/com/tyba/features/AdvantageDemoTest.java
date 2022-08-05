package com.tyba.features;

import com.tyba.conf.BaseConf;
import com.tyba.consequences.SeeThatFinishPayment;
import com.tyba.consequences.SeeThatInCart;
import com.tyba.consequences.SeeThatItemsIn;
import com.tyba.models.ExampleData;
import com.tyba.models.User;
import com.tyba.tasks.AddItemsTo;
import com.tyba.tasks.FinishPayment;
import com.tyba.tasks.NavigateTo;
import com.tyba.tasks.RegisterUser;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.tyba.factories.DataFactory.getDataByKey;
import static com.tyba.factories.UsersFactory.getUserWithRandomInfo;

@RunWith(SerenityRunner.class)
@Narrative(text = {"As a user of Tyba",
        "I want to be able to purchase section",
        "To be able to purchase a products"})
@WithTag("TybaExample")
public class AdvantageDemoTest extends BaseConf {

    @Test
    @WithTagValuesOf({"purchase-products:ESC:1", "smoke"})
    public void validateRegisterAnd() {
        User user = getUserWithRandomInfo(1);
        ExampleData data = getDataByKey(1);
        tybaUser.describedAs("Validate register and purchase products")
                .attemptsTo(
                        NavigateTo
                                .homePage(),
                        NavigateTo
                                .registerForm());
        tybaUser.attemptsTo(
                RegisterUser
                        .withInfo()
                        .username(user.getUserName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .confirmPassword(user.getPassword())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .phoneNumber(user.getPhoneNumber())
                        .country(user.getCountry())
                        .city(user.getCity())
                        .address(user.getAddress())
                        .state(user.getState())
                        .postalCode(user.getPostalCode())
                        .andSaveInfo(),
                NavigateTo
                        .popularItems(),
                AddItemsTo
                        .cart(data.getProducts()),
                NavigateTo
                        .menuCartOption(),
                SeeThatItemsIn
                        .cart(data.getProducts()));

        tybaUser.should(
                SeeThatInCart
                        .totalValues(data)
        );
        tybaUser.attemptsTo(
                NavigateTo
                        .checkoutCart(),
                FinishPayment
                        .process()
                        .nextStep()
                        .enterUsername(user.getUserName())
                        .enterPassword(user.getPassword())
                        .andPayNow()
        );
        tybaUser.should(
                SeeThatFinishPayment
                        .values(data)
        );
        tybaUser.should(
                SeeThatFinishPayment
                        .payment()
        );
        tybaUser.should(
                SeeThatFinishPayment
                        .values(data)
        );
    }

}
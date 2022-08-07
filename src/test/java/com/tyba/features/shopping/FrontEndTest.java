package com.tyba.features.shopping;

import com.tyba.conf.BaseConfFrontEnd;
import com.tyba.consequences.shopping.SeeThatFinishPayment;
import com.tyba.consequences.shopping.SeeThatInCart;
import com.tyba.consequences.shopping.SeeThatItemsIn;
import com.tyba.models.shopping.ExampleData;
import com.tyba.models.shopping.UserShopping;
import com.tyba.tasks.shopping.AddItemsTo;
import com.tyba.tasks.shopping.FinishPayment;
import com.tyba.tasks.shopping.NavigateTo;
import com.tyba.tasks.shopping.RegisterUser;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.tyba.factories.shopping.DataFactory.getDataByKey;
import static com.tyba.factories.shopping.UsersShoppingFactory.getUserWithRandomInfo;

@RunWith(SerenityRunner.class)
@Narrative(text = {"As a user of Tyba",
        "I want to be able to purchase section",
        "To be able to purchase a products"})
@WithTag("TybaExamplePurchase")
public class FrontEndTest extends BaseConfFrontEnd {

    @Test
    @WithTagValuesOf({"all","purchase-products:ESC:1", "regression"})
    public void validateRegisterAndPurchaseProducts() {
        UserShopping user = getUserWithRandomInfo(1);
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
                        .userData(user)
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
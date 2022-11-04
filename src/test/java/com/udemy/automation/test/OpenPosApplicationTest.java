package com.udemy.automation.test;

import com.udemy.automation.application.components.browser.OpenBrowserPos;
import com.udemy.automation.application.components.pos.questions.*;
import com.udemy.automation.application.components.pos.tasks.*;
import com.udemy.automation.application.config.ApplicationConfig;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

public class OpenPosApplicationTest extends AbstractTest {
    @Autowired
    private ApplicationConfig applicationConfig;
    private Actor actor=Actor.named("Enrique");
    private OpenBrowserPos openBrowserPos;
    private HeaderWelcomeAppTitleExists headerWelcomeAppTitleExists;
    private InsertCredentialLogin insertCredentialLogin;
    private HeaderWelcomeTestingYesExists headerWelcomeTestingYesExists;
    private ChooseItem chooseItem;
    private ProductNameExists productNameExists;
    private AddToCart addToCart;
    private HeaderCartContentExist headerCartContentExist;
    private Checkout checkout;
    private HeaderCheckoutShipping headerCheckoutShipping;
    private Continue aContinue;
    private CheckoutPaymentHeadingExists checkoutPaymentHeading;
    private CheckoutConfirmDefaultHeading checkoutConfirmDefaultHeading;
    private ConfirmOrder confirmOrder;

    @Before
    public void setup(){
        initializeActor(actor);
        openBrowserPos=taskInstance(OpenBrowserPos.class);
        headerWelcomeAppTitleExists=questionInstance(HeaderWelcomeAppTitleExists.class);
        insertCredentialLogin=taskInstance(InsertCredentialLogin.class);
        insertCredentialLogin.setEmail(applicationConfig.getUserPos());
        insertCredentialLogin.setPassword(applicationConfig.getPasswordPos());
        headerWelcomeTestingYesExists=questionInstance(HeaderWelcomeTestingYesExists.class);
        chooseItem=taskInstance(ChooseItem.class);
        productNameExists=questionInstance(ProductNameExists.class);
        addToCart=taskInstance(AddToCart.class);
        headerCartContentExist= questionInstance(HeaderCartContentExist.class);
        checkout=taskInstance(Checkout.class);
        headerCheckoutShipping=questionInstance(HeaderCheckoutShipping.class);
        aContinue=taskInstance(Continue.class);
        checkoutPaymentHeading=questionInstance(CheckoutPaymentHeadingExists.class);
        checkoutConfirmDefaultHeading=questionInstance(CheckoutConfirmDefaultHeading.class);
        confirmOrder=taskInstance(ConfirmOrder.class);
    }

    @WithTag
    @Test
    public void openPosApplication(){
        givenThat(actor).attemptsTo(openBrowserPos);
        then(actor).should(seeThat(headerWelcomeAppTitleExists));
        when(actor).attemptsTo(insertCredentialLogin);
        then(actor).should(seeThat(headerWelcomeTestingYesExists));
        when(actor).attemptsTo(chooseItem);
        then(actor).should(seeThat(productNameExists));
        when(actor).attemptsTo(addToCart);
        then(actor).should(seeThat(headerCartContentExist));
        when(actor).attemptsTo(checkout);
        then(actor).should(seeThat(headerCheckoutShipping));
        when(actor).attemptsTo(aContinue);
        then(actor).should(seeThat(checkoutPaymentHeading));
        when(actor).attemptsTo(aContinue);
        then(actor).should(seeThat(checkoutConfirmDefaultHeading));
        when(actor).attemptsTo(confirmOrder);


    }
}

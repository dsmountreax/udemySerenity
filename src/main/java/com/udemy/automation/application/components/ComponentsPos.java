package com.udemy.automation.application.components;

import com.udemy.automation.application.framework.context.PrototypeScope;
import lombok.Getter;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.annotation.PostConstruct;

@PrototypeScope
public class ComponentsPos {

    @Getter
    private Target titleWelcome;

    @Getter
    private Target loginEmail;

    @Getter
    private Target loginPassword;

    @Getter
    private Target linkLogin;

    @Getter
    private Target buttonLogin;

    @Getter
    private Target titleDefaultHeading;

    @Getter
    private Target titleWelcomeYes;

    @Getter
    private Target item;

    @Getter
    private Target productName;

    @Getter
    private  Target buttonAddTo;

    @Getter
    private  Target cartDefaultHeading;

    @Getter
    private Target buttonCheckout;

    @Getter
    private Target continueButton;

    @Getter
    private Target checkoutShippingHeading;

    @Getter
    private Target checkoutPaymentHeading;

    @Getter
    private Target checkoutConfirmDefaultHeading;

    @Getter
    private Target buttonConfirmOrder;

    public Performable clickOnButtonConfirmOrder(){
        return Click.on(buttonConfirmOrder);
    }

    public Performable clickOnButtonContinue(){
        return Click.on(continueButton);
    }

    public Performable clickOnButtonCheckout(){
        return Click.on(buttonCheckout);
    }
    public Performable clickOnButtonAddToCart(){
        return Click.on(buttonAddTo);
    }

    public Performable clickLinkLogin() {
        return Click.on(linkLogin);
    }

    public Performable enterEmail(String email){
        return Enter.theValue(email).into(loginEmail).thenHit(Keys.TAB);
    }

    public Performable enterPassword(String password){

        return Enter.theValue(password).into(loginPassword).thenHit(Keys.TAB);
    }

    public Performable clickOnButtonSubmit(){
        return Click.on(buttonLogin);
    }

    public Performable clickOnItem()
    {
        return Click.on(item);
    }

    @PostConstruct
    void onPostConstruct() {
        titleWelcome=Target.the(ConstantsPos.TITLE_WELCOME).located(By.cssSelector(ConstantsPos.TITLE_WELCOME));
        loginEmail=Target.the(ConstantsPos.INPUT_LOGIN_EMAIL).located(By.cssSelector(ConstantsPos.INPUT_LOGIN_EMAIL));
        loginPassword=Target.the(ConstantsPos.INPUT_LOGIN_PASSWORD).located(By.cssSelector(ConstantsPos.INPUT_LOGIN_PASSWORD));
        linkLogin=Target.the(ConstantsPos.LINK_LOGIN).located(By.xpath(ConstantsPos.LINK_LOGIN));
        buttonLogin=Target.the(ConstantsPos.BUTTON_LOGIN).located(By.cssSelector(ConstantsPos.BUTTON_LOGIN));
        titleDefaultHeading= Target.the(ConstantsPos.TITLE_WELCOME_DEFAULT).located(By.cssSelector(ConstantsPos.TITLE_WELCOME_DEFAULT));
        titleWelcomeYes=Target.the(ConstantsPos.TITLE_WELCOME_DEFAULT).located(By.cssSelector(ConstantsPos.TITLE_WELCOME_DEFAULT));
        item=Target.the(ConstantsPos.ITEM_TOMATOES).located(By.cssSelector(ConstantsPos.ITEM_TOMATOES));
        productName=Target.the(ConstantsPos.PRODUCT_NAME).located(By.cssSelector(ConstantsPos.PRODUCT_NAME));
        buttonAddTo=Target.the(ConstantsPos.BUTTON_ADD_TO_CART).located(By.xpath(ConstantsPos.BUTTON_ADD_TO_CART));
        cartDefaultHeading=Target.the(ConstantsPos.CART_DEFAULT_HEADING).located(By.cssSelector(ConstantsPos.CART_DEFAULT_HEADING));
        buttonCheckout=Target.the(ConstantsPos.BUTTON_CHECKOUT).located(By.cssSelector(ConstantsPos.BUTTON_CHECKOUT));
        continueButton=Target.the(ConstantsPos.BUTTON_CONTINUE).located(By.xpath(ConstantsPos.BUTTON_CONTINUE));
        checkoutShippingHeading=Target.the(ConstantsPos.CHECKOUT_SHIPPING_HEADING).located(By.cssSelector(ConstantsPos.CHECKOUT_SHIPPING_HEADING));
        checkoutPaymentHeading=Target.the(ConstantsPos.CHECKOUT_PAYMENT_HEADING).located(By.cssSelector(ConstantsPos.CHECKOUT_PAYMENT_HEADING));
        checkoutConfirmDefaultHeading=Target.the(ConstantsPos.CHECKOUT_CONFIRM_DEFAULT_HEADING).located(By.cssSelector(ConstantsPos.CHECKOUT_CONFIRM_DEFAULT_HEADING));
        buttonConfirmOrder=Target.the(ConstantsPos.BUTTON_CONFIRM_ORDER).located(By.xpath(ConstantsPos.BUTTON_CONFIRM_ORDER));
    }

}

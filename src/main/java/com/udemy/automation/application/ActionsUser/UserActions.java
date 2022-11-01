package com.udemy.automation.application.ActionsUser;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.actions.WithChainableActions;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.Paths;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

/**
 * @autor: Henry J. Calani A.
 **/
public class UserActions {

    /********************************************************
     * Is the action to make Click in a target
     **********************************************************/
    public static Performable on(Target target) {
        WaitUntil.the(target, isCurrentlyVisible()).forNoMoreThan(15).seconds();
        WaitUntil.the(target, isClickable());
        return net.serenitybdd.screenplay.actions.Click.on(target);
    }

    /********************************************************
     * Is the action to make DoubleClickActions in a target
     **********************************************************/
    public static Performable doubles(Target target) {
        return DoubleClick.on(target);
    }

    /********************************************************
     * Is the action to make ProlongedClickActions in a target
     **********************************************************/
    public static void prolonged(Actor actor, WebDriver webDriver, Target target) {
        Actions actions = new Actions(webDriver);
        actions.clickAndHold(target.resolveFor(actor)).build().perform();
    }

    /********************************************************
     * Is the action is boolean methods
     **********************************************************/
    public static Boolean isPresent(Target target, Actor actor) {
        return Presence.of(target).viewedBy(actor).resolve();
    }

    /********************************************************
     * Is the action is boolean methods
     **********************************************************/
    public static WaitUntilTargetIsReady isVisible(Target target) {
        return WaitUntil.the(target, isCurrentlyVisible());
    }

    /********************************************************
     * Is the action is boolean methods
     **********************************************************/
    public static String isTextPresent(Target target, Actor actor) {
        return Text.of(target).viewedBy(actor).resolve();
    }

    /********************************************************
     Add a wait
     **********************************************************/
    public static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            throw new UnsupportedOperationException("Unable to add a sleep");
        }
    }


    /********************************************************
     * Is the action to enter a value in a field
     **********************************************************/
    public static Performable text(String value, Target target) {
        return Enter.theValue(value).into(target);
    }

    /********************************************************
     * Is the action to enter a file in a field
     *
     * @param target
     * @param value
     **********************************************************/
    public static Performable file(String value, Target target) {
        return Upload.theFile(Paths.get(value)).to(target);
    }


    /********************************************************
     * Is the action move mouse to locator
     **********************************************************/
    public static WithChainableActions to(Target target) {
        WaitUntil.the(target, isCurrentlyVisible()).forNoMoreThan(10).seconds();
        return net.serenitybdd.screenplay.actions.MoveMouse.to(target);
    }


    /********************************************************
     * Is the action to select a locator by ID
     **********************************************************/
    public static Target byID(String constant) {
        return Target.the(constant).located(By.id(constant));
    }

    /********************************************************
     * Is the action to select a locator by ID
     **********************************************************/
    public static Target byCSS(String constant) {
        return Target.the(constant).located(By.cssSelector(constant));
    }

}

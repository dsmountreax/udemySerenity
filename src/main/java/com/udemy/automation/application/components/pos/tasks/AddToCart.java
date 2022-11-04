package com.udemy.automation.application.components.pos.tasks;

import com.udemy.automation.application.components.ComponentsPos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.springframework.beans.factory.annotation.Autowired;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToCart implements Task {

    @Autowired
    private ComponentsPos component;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(component.getProductName(),isVisible()).forNoMoreThan(30).seconds(),
                component.clickOnButtonAddToCart());

    }
}

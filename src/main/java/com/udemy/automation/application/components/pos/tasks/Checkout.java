package com.udemy.automation.application.components.pos.tasks;

import com.udemy.automation.application.components.ComponentsPos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.springframework.beans.factory.annotation.Autowired;

public class Checkout implements Task {

    @Autowired
    private ComponentsPos component;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(component.clickOnButtonCheckout());
    }
}

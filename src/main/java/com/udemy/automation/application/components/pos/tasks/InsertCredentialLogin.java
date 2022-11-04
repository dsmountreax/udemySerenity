package com.udemy.automation.application.components.pos.tasks;

import com.udemy.automation.application.components.ComponentsPos;
import lombok.Setter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.springframework.beans.factory.annotation.Autowired;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class InsertCredentialLogin implements Task {

    @Autowired
    private ComponentsPos component;

    @Setter
    private String email;

    @Setter
    private  String password;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(component.getTitleDefaultHeading(),isVisible()).forNoMoreThan(30).seconds(),
                component.clickLinkLogin(),
                WaitUntil.the(component.getTitleWelcome(),isVisible()).forNoMoreThan(30).seconds(),
                component.enterEmail(email),
                component.enterPassword(password),
                component.clickOnButtonSubmit());

    }
}

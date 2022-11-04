package com.udemy.automation.application.components.pos.questions;

import com.udemy.automation.application.ActionsUser.UserActions;
import com.udemy.automation.application.components.ComponentsPos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.springframework.beans.factory.annotation.Autowired;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HeaderWelcomeTestingYesExists implements Question<Boolean> {

    @Autowired
    private ComponentsPos component;

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(component.getTitleWelcomeYes(),isVisible()).forNoMoreThan(30).seconds());
        return UserActions.isPresent(component.getTitleWelcomeYes(),actor);
    }

}

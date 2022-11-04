package com.udemy.automation.application.components.pos.questions;

import com.udemy.automation.application.ActionsUser.UserActions;
import com.udemy.automation.application.components.ComponentsPos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckoutConfirmDefaultHeading implements Question<Boolean> {

    @Autowired
    private ComponentsPos component;

    @Override
    public Boolean answeredBy(Actor actor) {
        return UserActions.isPresent(component.getCheckoutConfirmDefaultHeading(),actor);
    }

}

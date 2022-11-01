package com.udemy.automation.application.components.google.questions;

import com.udemy.automation.application.ActionsUser.UserActions;
import com.udemy.automation.application.components.google.ComponentGoogle;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.springframework.beans.factory.annotation.Autowired;

public class ImageLogoExists implements Question<Boolean> {

    @Autowired
    private ComponentGoogle component;

    @Override
    public Boolean answeredBy(Actor actor) {
        return UserActions.isPresent(component.getIconGoogle(), actor);
    }
}

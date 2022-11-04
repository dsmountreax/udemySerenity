package com.udemy.automation.application.components.pos.questions;

import com.udemy.automation.application.ActionsUser.UserActions;
import com.udemy.automation.application.components.ComponentsPos;
import lombok.Getter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Target;

public class HeaderWelcomeAppTitleExists implements Question<Boolean> {

    @Autowired
    private ComponentsPos component;

    @Getter
    private Target welcomeAppTitle;

    @Override
    public Boolean answeredBy(Actor actor) {
        return UserActions.isPresent(component.getTitleDefaultHeading(),actor);
    }

}

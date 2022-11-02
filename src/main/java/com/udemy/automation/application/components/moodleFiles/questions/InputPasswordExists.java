package com.udemy.automation.application.components.moodleFiles.questions;

import com.udemy.automation.application.components.moodleFiles.ComponentMoodle;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.springframework.beans.factory.annotation.Autowired;

public class InputPasswordExists implements Question<Boolean> {
    @Autowired
    ComponentMoodle component;

    @Override
    public Boolean answeredBy(Actor actor)
    {
        return com.udemy.automation.application.ActionsUser.UserActions.isPresent(component.getInputPassword(), actor);
    }
}

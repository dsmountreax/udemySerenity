package com.udemy.automation.application.components.moodleFiles.questions;

import com.udemy.automation.application.ActionsUser.UserActions;
import com.udemy.automation.application.components.moodleFiles.ComponentMoodle;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.springframework.beans.factory.annotation.Autowired;

public class DashboardExists implements Question<Boolean> {
    @Autowired
    ComponentMoodle component;

    @Override
    public Boolean answeredBy(Actor actor){
        return UserActions.isPresent(component.getDashboard(),actor);
    }
}
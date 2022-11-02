package com.udemy.automation.application.components.moodleFiles.questions;

import com.udemy.automation.application.ActionsUser.UserActions;
import com.udemy.automation.application.components.moodleFiles.ComponentMoodle;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.springframework.beans.factory.annotation.Autowired;

public class CalendarExists  implements Question<String> {
    @Autowired
    ComponentMoodle componentMoodle;

    @Override
    public String answeredBy(Actor actor){
        return UserActions.isTextPresent(componentMoodle.getCalendar(),actor);
    }
}

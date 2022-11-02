package com.udemy.automation.application.components.moodleFiles.tasks;

import com.udemy.automation.application.components.moodleFiles.ComponentMoodle;
import lombok.Setter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.springframework.beans.factory.annotation.Autowired;

public class InsertCredentialsMoodle implements Task {

    @Setter
    private String userName;

    @Setter
    private String password;

    @Autowired
    private ComponentMoodle component;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(component.enterUserValue(userName),
                         component.enterPasswordValue(password),
                         component.clickOnButtonLogin());
    }
}

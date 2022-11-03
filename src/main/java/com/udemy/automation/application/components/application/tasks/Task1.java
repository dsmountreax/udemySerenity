package com.udemy.automation.application.components.application.tasks;

import com.udemy.automation.application.components.Components;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.springframework.beans.factory.annotation.Autowired;

public class Task1 implements Task {

    @Autowired
    private Components component;

    @Override
    public <T extends Actor> void performAs(T actor) {

    }
}

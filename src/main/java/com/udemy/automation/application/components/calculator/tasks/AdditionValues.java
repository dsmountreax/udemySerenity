package com.udemy.automation.application.components.calculator.tasks;

import com.udemy.automation.application.ActionsUser.UserActions;
import com.udemy.automation.application.components.calculator.ComponentCalculator;
import lombok.Setter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.springframework.beans.factory.annotation.Autowired;

public class AdditionValues implements Task {

    @Setter
    private String firstValue;

    @Setter
    private String secondValue;

    @Autowired
    ComponentCalculator componentCalculator;

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
        UserActions.isVisible(componentCalculator.getTitleLabel()),
        componentCalculator.putFirstValue(firstValue),
        componentCalculator.selectAddition(),
        componentCalculator.putSecondValue(secondValue),
        componentCalculator.pushButtonSubmit());
    }
}

package com.udemy.automation.application.components.calculator.questions;

import com.udemy.automation.application.ActionsUser.UserActions;
import com.udemy.automation.application.components.calculator.ComponentCalculator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.springframework.beans.factory.annotation.Autowired;

public class HistoryCalculatorExists implements Question<String> {
    @Autowired
    private ComponentCalculator componentCalculator;

    @Override
    public String answeredBy(Actor actor){
        UserActions.isVisible(componentCalculator.getHistoryLabel());
        return UserActions.isTextPresent(componentCalculator.getHistoryLabel(),actor);
    }
}

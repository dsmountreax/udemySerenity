package com.udemy.automation.application.components.calculator.questions;

import com.udemy.automation.application.ActionsUser.UserActions;
import com.udemy.automation.application.components.calculator.ComponentCalculator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.springframework.beans.factory.annotation.Autowired;

public class TitleCalculatorExists implements Question<Boolean> {
    @Autowired
    private ComponentCalculator componentCalculator;

    @Override
    public Boolean answeredBy(Actor actor){
        UserActions.isVisible(componentCalculator.getTitleLabel());
        return UserActions.isPresent(componentCalculator.getTitleLabel(),actor);
    }
}

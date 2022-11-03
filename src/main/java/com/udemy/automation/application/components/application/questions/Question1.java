package com.udemy.automation.application.components.application.questions;

import com.udemy.automation.application.components.Components;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.springframework.beans.factory.annotation.Autowired;

public class Question1 implements Question<String> {

    @Autowired
    private Components component;

    @Override
    public String answeredBy(Actor actor) {
        return "reponse";
    }

}

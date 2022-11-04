package com.udemy.automation.application.components.pos.questions;

import com.udemy.automation.application.components.ComponentsPos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.springframework.beans.factory.annotation.Autowired;

public class Question1 implements Question<String> {

    @Autowired
    private ComponentsPos component;

    @Override
    public String answeredBy(Actor actor) {
        return "reponse";
    }

}

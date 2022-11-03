package com.udemy.automation.application.components.calculator;

import com.udemy.automation.application.framework.context.PrototypeScope;
import lombok.Getter;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.annotation.PostConstruct;


@PrototypeScope
public class ComponentCalculator {

    @Getter
    private Target titleLabel;

    @Getter
    private Target historyLabel;

    @Getter
    private Target timeLabel;

    @Getter
    private Target expressionLabel;

    @Getter
    private Target resultLabel;

    @Getter
    private Target firstValue;

    @Getter
    private Target secondValue;

    @Getter
    private Target operatorAdd;

    @Getter
    private  Target operatorSubstraction;

    @Getter
    private Target operatorMultiply;

    @Getter
    private  Target operatorDivision;

    @Getter
    private  Target operatorModule;

    @Getter
    private  Target operator;

    @Getter
    private Target buttonSubmit;

    @Getter
    private Target resultOperations;

    public Performable putFirstValue(String firstValue){
      return Enter.theValue(firstValue).into(this.firstValue).thenHit(Keys.TAB);
    }

    public Performable putSecondValue(String secondValue){
        return Enter.theValue(secondValue).into(this.secondValue).thenHit(Keys.TAB);
    }

    public Performable selectAddition()
    {
        return Click.on(operatorAdd);
    }

    public Performable selectMultiplication()
    {
        return Click.on(operatorMultiply);
    }
    public Performable selectSubtraction()
    {
        return Click.on(operatorSubstraction);
    }
    public Performable selectDivision()
    {
        return Click.on(operatorDivision);
    }

    public Performable selectModule()
    {
        return Click.on(operatorModule);
    }

    public Performable pushButtonSubmit()
    {
        return Click.on(buttonSubmit);
    }

    @PostConstruct
    void onPostConstruct() {
        titleLabel= Target.the(ConstantsCalculator.TITLE_LABEL).located(By.xpath(ConstantsCalculator.TITLE_LABEL));
        historyLabel=Target.the(ConstantsCalculator.HISTORY_LABEl).located(By.xpath(ConstantsCalculator.HISTORY_LABEl));
        timeLabel=Target.the(ConstantsCalculator.TIME_LABEL).located(By.xpath(ConstantsCalculator.TIME_LABEL));
        expressionLabel=Target.the(ConstantsCalculator.EXPRESSION_LABEL).located(By.xpath(ConstantsCalculator.EXPRESSION_LABEL));
        resultLabel=Target.the(ConstantsCalculator.RESULT_LABEL).located(By.xpath(ConstantsCalculator.RESULT_LABEL));
        firstValue=Target.the(ConstantsCalculator.FIRST_VALUE).located(By.cssSelector(ConstantsCalculator.FIRST_VALUE));
        secondValue=Target.the(ConstantsCalculator.SECOND_VALUE).located(By.cssSelector(ConstantsCalculator.SECOND_VALUE));
        buttonSubmit=Target.the(ConstantsCalculator.BUTTON_GO).located(By.cssSelector(ConstantsCalculator.BUTTON_GO));
        operatorAdd=Target.the(ConstantsCalculator.OPTION_ADDITION).located(By.cssSelector(ConstantsCalculator.OPTION_ADDITION));
        operatorSubstraction=Target.the(ConstantsCalculator.OPTION_SUBTRACTION).located(By.cssSelector(ConstantsCalculator.OPTION_SUBTRACTION));
        operatorMultiply=Target.the(ConstantsCalculator.OPTION_MULTIPLICATION).located(By.cssSelector(ConstantsCalculator.OPTION_MULTIPLICATION));
        operatorDivision=Target.the(ConstantsCalculator.OPTION_DIVISION).located(By.cssSelector(ConstantsCalculator.OPTION_DIVISION));
        operatorModule=Target.the(ConstantsCalculator.OPTION_MODULE).located(By.cssSelector(ConstantsCalculator.OPTION_MODULE));
        operator=Target.the(ConstantsCalculator.OPERATOR).located(By.cssSelector(ConstantsCalculator.OPERATOR));
        resultOperations=Target.the(ConstantsCalculator.RESULT_OPERATIONS).located(By.cssSelector(ConstantsCalculator.RESULT_OPERATIONS));
    }
}

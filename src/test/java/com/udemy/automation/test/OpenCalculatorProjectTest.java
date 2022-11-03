package com.udemy.automation.test;

import com.udemy.automation.application.ActionsUser.UserActions;
import com.udemy.automation.application.components.browser.OpenBrowserCalculator;
import com.udemy.automation.application.components.calculator.ConstantsCalculator;
import com.udemy.automation.application.components.calculator.questions.HistoryCalculatorExists;
import com.udemy.automation.application.components.calculator.questions.ResultValueCalculatorExists;
import com.udemy.automation.application.components.calculator.questions.TimeCalculatorExists;
import com.udemy.automation.application.components.calculator.questions.TitleCalculatorExists;
import com.udemy.automation.application.components.calculator.tasks.AdditionValues;
import com.udemy.automation.application.config.ApplicationConfig;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.is;

public class OpenCalculatorProjectTest extends AbstractTest {

    @Autowired
    private ApplicationConfig applicationConfig;
    private Actor actor = Actor.named("Enrique");
    private OpenBrowserCalculator openBrowserCalculator;
    private TitleCalculatorExists titleCalculatorExists;
    private HistoryCalculatorExists historyCalculatorExists;
    private TimeCalculatorExists timeCalculatorExists;
    private AdditionValues additionValues;
    private ResultValueCalculatorExists resultValueCalculatorExists;


    @Before
    public void setup() {
        initializeActor(actor);
        openBrowserCalculator = taskInstance(OpenBrowserCalculator.class);
        titleCalculatorExists = questionInstance(TitleCalculatorExists.class);
        historyCalculatorExists = questionInstance(HistoryCalculatorExists.class);
        timeCalculatorExists = questionInstance(TimeCalculatorExists.class);
        additionValues = taskInstance(AdditionValues.class);
        additionValues.setSecondValue(applicationConfig.getSecondValue());
        additionValues.setFirstValue(applicationConfig.getFirstValue());
        resultValueCalculatorExists=questionInstance(ResultValueCalculatorExists.class);

    }

    @WithTag
    @Test
    public void openCalculatorProjectTest() {
        givenThat(actor).attemptsTo(openBrowserCalculator);
        then(actor).should(seeThat(titleCalculatorExists));
        then(actor).should(seeThat(timeCalculatorExists));
            if (titleCalculatorExists.answeredBy(actor)) {
                then(actor).attemptsTo(additionValues);
            }
        UserActions.sleep();
        then(actor).should(seeThat(resultValueCalculatorExists,is(ConstantsCalculator.RESULT_ADD)));
    }
}

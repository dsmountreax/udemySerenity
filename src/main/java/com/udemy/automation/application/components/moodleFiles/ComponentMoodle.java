package com.udemy.automation.application.components.moodleFiles;

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
public class ComponentMoodle {

    @Getter
    private Target imageIntro;

    @Getter
    private Target inputUser;

    @Getter
    private Target inputPassword;

    @Getter
    private Target buttonAcceder;

    @Getter
    private Target checkboxRemember;

    @Getter
    private Target labelRemember;

    @Getter
    private Target dashboard;

    @Getter
    private Target siteHome;

    @Getter
    private Target calendar;

    @Getter
    private Target privateFiles;

    @Getter
    private Target myCourses;



    public Performable enterUserValue(String value){
        return Enter.theValue(value).into(inputUser).thenHit(Keys.TAB);
    }

    public Performable enterPasswordValue(String value){
        return Enter.theValue(value).into(inputPassword);
    }

    public Performable clickOnButtonLogin()
    {
        return Click.on(buttonAcceder);
    }

    @PostConstruct
    void onPostConstruct(){
        imageIntro=Target.the(ConstantsMoodle.LOGO_MOODLE).located(By.cssSelector(ConstantsMoodle.LOGO_MOODLE));
        inputUser=Target.the(ConstantsMoodle.USERNAME).located(By.cssSelector(ConstantsMoodle.USERNAME));
        inputPassword=Target.the(ConstantsMoodle.PASSWORD).located(By.cssSelector(ConstantsMoodle.PASSWORD));
        buttonAcceder=Target.the(ConstantsMoodle.LOGIN_BUTTON).located(By.cssSelector(ConstantsMoodle.LOGIN_BUTTON));
        checkboxRemember=Target.the(ConstantsMoodle.REMEMBER_USERNAME).located(By.cssSelector(ConstantsMoodle.REMEMBER_USERNAME));
        labelRemember=Target.the(ConstantsMoodle.LABEL_REMEMBER).located(By.cssSelector(ConstantsMoodle.LABEL_REMEMBER));
        dashboard=Target.the(ConstantsMoodle.DASHBOARD).located(By.cssSelector(ConstantsMoodle.DASHBOARD));
        siteHome=Target.the(ConstantsMoodle.SITE_HOME).located(By.xpath(ConstantsMoodle.SITE_HOME));
        calendar=Target.the(ConstantsMoodle.CALENDAR).located(By.xpath(ConstantsMoodle.CALENDAR));
        privateFiles=Target.the(ConstantsMoodle.PRIVATE_FILES).located(By.xpath(ConstantsMoodle.PRIVATE_FILES));
        myCourses=Target.the(ConstantsMoodle.MY_COURSES).located(By.xpath(ConstantsMoodle.MY_COURSES));


    }
}

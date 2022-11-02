package com.udemy.automation.test;

import com.udemy.automation.application.components.browser.OpenBrowserMoodle;
import com.udemy.automation.application.components.moodleFiles.ConstantsMoodle;
import com.udemy.automation.application.components.moodleFiles.questions.*;
import com.udemy.automation.application.components.moodleFiles.tasks.InsertCredentialsMoodle;
import com.udemy.automation.application.config.ApplicationConfig;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

public class OpenMoodleProject extends AbstractTest {

    @Autowired
    private ApplicationConfig config;
    private Actor actor=Actor.named("Enrique");
    private OpenBrowserMoodle openBrowserMoodle;
    private LabelRememberExists labelRememberExists;
    private InputUsernameExists inputUsernameExists;
    private ButtonAccederExists buttonAccederExists;
    private InputPasswordExists inputPasswordExists;
    private ImageLogoMoodleExists imageLogoMoodleExists;
    private InsertCredentialsMoodle insertCredentialsMoodle;
    private CalendarExists calendarExists;
    private DashboardExists dashboardExists;
    private MyCoursesExists myCoursesExists;
    private PrivateFilesExists privateFilesExists;
    private SiteHomeExists siteHomeExists;

    @Before
    public void setup(){
        initializeActor(actor);
        openBrowserMoodle =taskInstance(OpenBrowserMoodle.class);
        insertCredentialsMoodle=taskInstance(InsertCredentialsMoodle.class);
        insertCredentialsMoodle.setUserName(config.getUserNameMoodle());
        insertCredentialsMoodle.setPassword(config.getPasswordMoodle());

        labelRememberExists =questionInstance(LabelRememberExists.class);
        inputUsernameExists =questionInstance(InputUsernameExists.class);
        buttonAccederExists = questionInstance(ButtonAccederExists.class);
        imageLogoMoodleExists= questionInstance(ImageLogoMoodleExists.class);
        inputPasswordExists= questionInstance(InputPasswordExists.class);
        calendarExists=questionInstance(CalendarExists.class);
        dashboardExists=questionInstance(DashboardExists.class);
        myCoursesExists=questionInstance(MyCoursesExists.class);
        privateFilesExists=questionInstance(PrivateFilesExists.class);
        siteHomeExists=questionInstance(SiteHomeExists.class);
    }

    @WithTag
    @Test
    public void openMoodleProjectTest(){
        givenThat(actor).attemptsTo(openBrowserMoodle);
        then(actor).should(seeThat(labelRememberExists,is(ConstantsMoodle.LABEL_REMEMBER_CHECKBOX)));
        then(actor).should(seeThat(inputUsernameExists));
        then(actor).should(seeThat(ConstantsMoodle.LABEL_BUTTON_ACCEDER,buttonAccederExists));
        then(actor).should(seeThat(imageLogoMoodleExists));
        then(actor).should(seeThat(inputPasswordExists));
        when(actor).attemptsTo(insertCredentialsMoodle);
        then(actor).should(seeThat(dashboardExists,is(ConstantsMoodle.LABEL_DASHBOARD)));
        then(actor).should(seeThat(siteHomeExists,is(ConstantsMoodle.LABEL_SITE_HOME)));
        then(actor).should(seeThat(calendarExists,is(ConstantsMoodle.LABEL_CALENDAR)));
        then(actor).should(seeThat(privateFilesExists,is(ConstantsMoodle.LABEL_PRIVATE_FILES)));
        then(actor).should(seeThat(myCoursesExists,is(ConstantsMoodle.LABEL_MY_COURSES)));

    }
}

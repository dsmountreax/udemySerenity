package com.udemy.automation.test;

import com.udemy.automation.application.components.browser.OpenBrowser;
import com.udemy.automation.application.components.google.questions.BuscarGoogleExists;
import com.udemy.automation.application.components.google.questions.ButtonSuerteExists;
import com.udemy.automation.application.components.google.questions.ImageLogoExists;
import com.udemy.automation.application.config.ApplicationConfig;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static net.serenitybdd.screenplay.GivenWhenThen.*;



/**
 * @author Henry J. Calani A.
 */
@WithTag("GOOGLE")
public class OpenGoogleApplicationTest extends AbstractTest {

    @Autowired
    private ApplicationConfig config;
    private Actor actor = Actor.named("henry");
    private OpenBrowser openBrowser;
    private BuscarGoogleExists buscarGoogleExists;
    private ButtonSuerteExists buttonSuerteExists;
    private ImageLogoExists imageLogoExists;


    @Before
    public void setup(){
        initializeActor(actor);
        openBrowser = taskInstance(OpenBrowser.class);
        buscarGoogleExists = questionInstance(BuscarGoogleExists.class);
        buttonSuerteExists = questionInstance(ButtonSuerteExists.class);
        imageLogoExists = questionInstance(ImageLogoExists.class);
    }
    @WithTag
    @Test
    public void  openBrowserGoogle(){
        givenThat(actor)
                .attemptsTo(openBrowser);

        then(actor).should(
                seeThat(imageLogoExists)
        );
        then(actor).should(
                seeThat(buscarGoogleExists)
        );
        then(actor).should(
                seeThat(buttonSuerteExists)
        );

        then(actor).should();



    }

}

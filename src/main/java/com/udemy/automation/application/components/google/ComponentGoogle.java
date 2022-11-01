package com.udemy.automation.application.components.google;


import com.udemy.automation.application.framework.context.PrototypeScope;
import lombok.Getter;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.annotation.PostConstruct;

@PrototypeScope
public class ComponentGoogle {

    @Getter
    private Target iconGoogle;

    @Getter
    private Target buttonBuscarGoogle;

    @Getter
    private Target butonSuerte;

    @Getter
    private Target searchInput;

    public Performable buscarPalabra(String palabraBuscar) {
        return Enter.theValue(palabraBuscar).into(searchInput).thenHit(Keys.ENTER);

    }

    @PostConstruct
    void onPostConstruct() {
        iconGoogle = Target.the(ConstantsGoogle.LOGO_GOOGLE).located(By.cssSelector(ConstantsGoogle.LOGO_GOOGLE));
        buttonBuscarGoogle = Target.the(ConstantsGoogle.BUSCAR_GOOGLE).located(By.xpath(ConstantsGoogle.BUSCAR_GOOGLE));
        butonSuerte = Target.the(ConstantsGoogle.SIENTO_CON_SUERTE).located(By.xpath(ConstantsGoogle.SIENTO_CON_SUERTE));
        searchInput = Target.the(ConstantsGoogle.BUSCAR).located(By.cssSelector(ConstantsGoogle.BUSCAR));
    }

}

package com.sophossolutions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;



@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {


    public static final Target CATEGORIA = Target.the("Seleccionamos la categoria").locatedBy("//*[text()='{0}']");

}

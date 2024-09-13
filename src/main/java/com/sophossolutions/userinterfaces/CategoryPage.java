package com.sophossolutions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CategoryPage {


    public static Target PRODFILTRADO(String equipo) {return Target.the("producto filtrado").locatedBy("//*[text()='{0}']").of(equipo);

    }
    public static final Target PRODUCTO = Target.the("Seleccionamos el producto").locatedBy("//*[text()='{0}']");
}

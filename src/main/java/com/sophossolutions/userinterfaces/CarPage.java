package com.sophossolutions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class CarPage extends PageObject {

    public static Target ART_COMPRADO(String compra) {return Target.the("Buscar el producto comprado").locatedBy("//*[text()='{0}']").of(compra);

    }

    public static final Target CARRITO = Target.the("Ingresar al carrito de compras").locatedBy("//*[text()='Cart']");
}

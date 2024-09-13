package com.sophossolutions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class AgregProducto extends PageObject {



    public static final Target AGREGAR = Target.the("Agrega el producto al carrito").locatedBy("//*[text()='Add to cart']");

}

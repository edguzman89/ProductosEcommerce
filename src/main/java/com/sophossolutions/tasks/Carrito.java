package com.sophossolutions.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

import static com.sophossolutions.userinterfaces.AgregProducto.AGREGAR;
import static com.sophossolutions.userinterfaces.CarPage.CARRITO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Carrito implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CARRITO)
        );


    }

    public static Carrito AlCarritoShopp() {
        return instrumented(Carrito.class);
    }


}

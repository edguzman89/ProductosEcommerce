package com.sophossolutions.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sophossolutions.userinterfaces.CategoryPage.PRODUCTO;
import static com.sophossolutions.userinterfaces.HomePage.CATEGORIA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarProducto implements Task {

    private String producto;

    public AgregarProducto(String producto){
        this.producto = producto;


    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(PRODUCTO.of(producto))
        );

    }

    public static AgregarProducto conProducto(String producto) {
        return instrumented(AgregarProducto.class, producto);


    }


}

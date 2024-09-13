package com.sophossolutions.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.By;

import static com.sophossolutions.userinterfaces.HomePage.*;
import static com.sophossolutions.userinterfaces.CategoryPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CategoriaProducto implements Task {

    private String categoria;

    public CategoriaProducto(String categoria){
        this.categoria = categoria;


    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(CATEGORIA.of(categoria))
        );

    }

    public static CategoriaProducto conCategoria(String categoria) {
        return instrumented(CategoriaProducto.class, categoria);


    }


}

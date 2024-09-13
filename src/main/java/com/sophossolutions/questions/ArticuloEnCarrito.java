package com.sophossolutions.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ArticuloEnCarrito implements Question<String> {

    private Target field;

    public ArticuloEnCarrito(Target field) {
        this.field = field;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(field).answeredBy(actor);
    }
    public static ArticuloEnCarrito field(Target field){
        return new ArticuloEnCarrito(field);
    }

}
package com.sophossolutions.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionMessage implements Question<String> {

    public static ValidacionMessage field() {
        return new ValidacionMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        // Obtener el mensaje almacenado en la memoria del actor
        return actor.recall("alertMessage");
    }
}

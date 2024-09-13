package com.sophossolutions.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.sophossolutions.userinterfaces.AgregProducto.AGREGAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarAlCarrito implements Task {

    private String alertMessage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        actor.attemptsTo(Click.on(AGREGAR));

        // Esperar y manejar la alerta
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alertMessage = alert.getText(); // Obtener el texto de la alerta
            alert.accept(); // Aceptar la alerta

            // Almacenar el mensaje en la memoria del actor
            actor.remember("alertMessage", alertMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AgregarAlCarrito AlCarrito() {
        return instrumented(AgregarAlCarrito.class);
    }
}








/*package com.sophossolutions.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

import static com.sophossolutions.userinterfaces.AgregProducto.AGREGAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarAlCarrito implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AGREGAR)
        );


    }

    public static AgregarAlCarrito AlCarrito() {
        return instrumented(AgregarAlCarrito.class);
    }


}*/

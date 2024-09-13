package com.sophossolutions.steps;

import com.sophossolutions.exceptions.Diferencias;
import com.sophossolutions.questions.ArticuloEnCarrito;
import com.sophossolutions.questions.ValidacionMessage;
import com.sophossolutions.questions.ValidacionTexto;
import com.sophossolutions.tasks.AgregarAlCarrito;
import com.sophossolutions.tasks.AgregarProducto;
import com.sophossolutions.tasks.Carrito;
import com.sophossolutions.tasks.CategoriaProducto;
import com.sophossolutions.userinterfaces.HomePage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.*;

import static com.sophossolutions.userinterfaces.CarPage.ART_COMPRADO;
import static com.sophossolutions.userinterfaces.CategoryPage.PRODFILTRADO;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.junit.Assert.assertEquals;


public class ProductoTiendaStep {

    @Managed(driver = "chrome")
    private WebDriver navegador;
    private Actor actor = Actor.named("Usuario");
    private HomePage homePage = new HomePage();



    @Given("que el usuario está en la página de búsqueda de productos")
    public void queElUsuarioEstáEnLaPáginaDeBúsquedaDeProductos() {
        actor.can(BrowseTheWeb.with(navegador));
        navegador.manage().window().maximize();
        actor.wasAbleTo(Open.browserOn(homePage));
    }
    @When("^el usuario hace clic en la opcion (.+) de la seleccion de categorias$")
    public void elUsuarioHaceClicEnLaOpcionDeLaSeleccionDeCategorias(String categoria) {
        actor.wasAbleTo(
                CategoriaProducto.conCategoria(categoria)
        );
    }
    @Then("^el sistema muestra productos como un (.+) que pertenecen a la categoría seleccionada$")
    public void elSistemaMuestraProductosComoUnQuePertenecenALaCategoríaSeleccionada(String equipo) {
        actor.should(seeThat(ValidacionTexto.field(PRODFILTRADO(equipo)), equalTo(equipo))
                .orComplainWith(Diferencias.class, "El valor esperado: \"" + equipo + "\", " + " no se encontro dentro del contenido" ));
    }


    @Given("^que el usuario realiza una búsqueda por categoria (.+) y ve los resultados de productos$")
    public void queElUsuarioRealizaUnaBúsquedaPorCategoriaYVeLosResultadosDeProductos(String categoria) {
        actor.can(BrowseTheWeb.with(navegador));
        navegador.manage().window().maximize();
        actor.wasAbleTo(Open.browserOn(homePage));
        actor.wasAbleTo(CategoriaProducto.conCategoria(categoria));
    }
    @When("^el usuario hace clic sobre el producto (.+) para agregar$")
    public void elUsuarioHaceClicSobreElProductoParaAgregar(String equipo) {
        actor.wasAbleTo(AgregarProducto.conProducto(equipo));
    }
    @When("luego el usuario hace clic en el botón Agregar al carrito del producto visualizado")
    public void luegoElUsuarioHaceClicEnElBotónAgregarAlCarritoDelProductoVisualizado() {
        actor.wasAbleTo(AgregarAlCarrito.AlCarrito());
    }
    @Then("^el sistema muestra el mensaje (.+) de confirmación que el producto fue agregado exitosamente$")
    public void elSistemaMuestraElMensajeDeConfirmaciónQueElProductoFueAgregadoExitosamente(String expectedMessage) {
        // Comparar el mensaje real con el esperado utilizando ValidacionMessage
        actor.should(seeThat(
                        ValidacionMessage.field(), equalTo(expectedMessage)
                ).orComplainWith(Diferencias.class,
                        "El valor esperado: \"" + expectedMessage + "\", no se encontró dentro del contenido")
        );
    }
    @Then("^se visualiza el articulo (.+) agregado en el carrito de compras$")
    public void seVisualizaElArticuloAgregadoEnElCarritoDeCompras(String compra) {
        actor.wasAbleTo((Carrito.AlCarritoShopp()));
        actor.should(seeThat(ArticuloEnCarrito.field(ART_COMPRADO(compra)), equalTo(compra)));


    }
}

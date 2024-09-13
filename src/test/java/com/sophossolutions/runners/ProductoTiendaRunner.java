package com.sophossolutions.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/com.sophossolutions/features/ProductoTienda.feature",
        glue = "com.sophossolutions.steps",
        tags = "@Scenario1",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ProductoTiendaRunner {


}

package testClass;

import org.openqa.selenium.WebDriver;
import page.Google;
public class BusquedaAnimalesGoogle {
    private Google google;

    public void busquedaPerro(WebDriver webdriver){
        google = new Google(webdriver);
        google.ingresarBusqueda("Perro");
        google.clickBtnBuscar();
    }

    public void busquedaGato(WebDriver webdriver){
        google = new Google(webdriver);
        google.ingresarBusqueda("Gato");
        google.clickBtnBuscar();
    }
}

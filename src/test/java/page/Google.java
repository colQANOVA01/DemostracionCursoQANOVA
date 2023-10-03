package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google {
    @FindBy(className = "gLFyf")
    WebElement inputBuscador;

    @FindBy(xpath = "//textarea[@id='APjFqb']")
    WebElement btnBuscar;

    public Google (WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void ingresarBusqueda (String busqueda){
        inputBuscador.sendKeys(busqueda);
    }

    public void clickBtnBuscar(){
        btnBuscar.click();
    }
}

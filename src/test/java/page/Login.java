package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.CargaInformacion;
public class Login {
    @FindBy(id = "imUname")
    private WebElement inputNombre;

    @FindBy(id = "imPwd")
    private WebElement inputPass;

    @FindBy(xpath = "//input[@value='Ingresar a Demo']")
    WebElement btnIngresar;

    public Login (WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void ingresarUsuario (String nombre){
        inputNombre.sendKeys(nombre);
    }
    public void ingresarClave (String clave){ inputPass.sendKeys(clave); }
    public void clickBtnIngresar(){ btnIngresar.click();}
}

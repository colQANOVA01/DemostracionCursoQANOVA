package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Validaciones;

import java.time.Duration;

public class LoginPDF {
    @FindBy(xpath = "//label[@for='imUname']")
    private WebElement labelUsuario;
    @FindBy(id = "imUname")
    private WebElement inputNombre;

    @FindBy(id = "imPwd")
    private WebElement inputPass;

    @FindBy(xpath = "//input[@value='Ingresar a Demo']")
    private WebElement btnIngresar;

    WebDriverWait webDriverWait;

    public LoginPDF(){
        PageFactory.initElements(DriverContext.getDriver(), this);
        this.webDriverWait = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(30));
    }

    public void ingresarUsuario (String nombre){
        Validaciones.validarObjeto(inputNombre, "input Nombre");
        PdfQaNovaReports.addWebReportImage("Despliegue Login", "Login desplegado correctamente", EstadoPrueba.PASSED, false);
        inputNombre.sendKeys(nombre);
    }
    public void ingresarClave (String clave){
        inputPass.sendKeys(clave);
    }
    public void clickBtnIngresar(){
        PdfQaNovaReports.addWebReportImage("Datos Login", "Se ingresa usuario y clave", EstadoPrueba.PASSED, false);
        btnIngresar.click();
    }

    public void validarTextoUsuario(String texto){
        Validaciones.validarTexto(labelUsuario,texto);
    }
}

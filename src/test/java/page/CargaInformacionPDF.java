package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Validaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class CargaInformacionPDF {
    @FindBy(id = "imPgTitle")
    private WebElement titulo;
    @FindBy(xpath = "//input[@id='imObjectForm_1_2']")
    private WebElement campoTexto;
    @FindBy(xpath = "//input[@id='imObjectForm_1_3']")
    private WebElement campoCorreo;
    @FindBy(xpath = "//textarea[@id='imObjectForm_1_4']")
    private WebElement campoTextArea;
    @FindBy(xpath = "//input[@id='imObjectForm_1_5']")
    private WebElement campoFecha;
    @FindBy(id = "imObjectForm_1_6")
    private WebElement campoLista;
    @FindBy(xpath = "//input[@id='imObjectForm_1_7_0']")
    private WebElement chckbxSeleccionMultiple1;
    @FindBy(xpath = "//input[@id='imObjectForm_1_7_1']")
    private WebElement chckbxSeleccionMultiple2;
    @FindBy(xpath = "//input[@id='imObjectForm_1_7_2']")
    private WebElement chckbxSeleccionMultiple3;
    @FindBy(xpath = "//input[@id='imObjectForm_1_8_0']")
    private WebElement rdbtnCombo1;
    @FindBy(xpath = "//input[@id='imObjectForm_1_8_1']")
    private WebElement rdbtnCombo2;
    @FindBy(xpath = "//input[@id='imObjectForm_1_8_2']")
    private WebElement rdbtnCombo3;
    @FindBy(id = "imObjectForm_1_5_icon")
    private WebElement iconoCalendario;
    @FindBy(id = "imDPleft")
    private WebElement btnRetrocederMes;
    @FindBy(id = "imDPright")
    private WebElement btnAvanzarMes;
    @FindBy(xpath = "//input[@id='imObjectForm_1_submit']")
    private WebElement btnEnviar;
    @FindBy(xpath = "//input[@value='Resetear']")
    private WebElement btnResetear;


    public CargaInformacionPDF(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public String recuperarTitulo(){
        Validaciones.validarObjeto(titulo, "titulo");
        PdfQaNovaReports.addWebReportImage("Despliegue carga de informaci\u00f3n", "Carga de informaci\u00f3n desplegado correctamente", EstadoPrueba.PASSED, false);
        String texto = titulo.getText();
        return texto;
    }
    public void rellenarCampoTexto(String texto){
        campoTexto.sendKeys(texto);
    }
    public void rellenarCampoCorreo(String correo){
        campoCorreo.sendKeys(correo);
    }
    public void rellenarCampoTextArea(String textArea){
        campoTextArea.sendKeys(textArea);
    }
    public void rellenarFecha(String fecha){
        campoFecha.sendKeys(fecha);
    }
    public void rellenarLista(String valor){
        Select select = new Select(campoLista);
        select.selectByVisibleText(valor);
    }
    public void seleccionMultiple (String indicador){
        String[] indicadores = indicador.split(",");
        for(String nro:indicadores){
            int numero = Integer.parseInt(nro);
            switch (numero){
                case 1:
                    chckbxSeleccionMultiple1.click();
                    break;
                case 2:
                    chckbxSeleccionMultiple2.click();
                    break;
                case 3:
                    chckbxSeleccionMultiple3.click();
                    break;
                default:
                    System.out.println("Valor no Procesable");
            }
        }
    }

    public void seleccionRadioBoton(int indicador){
        switch (indicador){
            case 1:
                rdbtnCombo1.click();
                break;
            case 2:
                rdbtnCombo2.click();
                break;
            case 3:
                rdbtnCombo3.click();
                break;
            default:
                System.out.println("Valor no Procesable");
        }
    }

    public void seleccionarFechaCalendario (String fecha) throws ParseException {
        iconoCalendario.click();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String hoy = simpleDateFormat.format(new Date());
        Date hoyDate = simpleDateFormat.parse(hoy);
        Date fechaDate = simpleDateFormat.parse(fecha);
        long diferencia = ChronoUnit.MONTHS.between(LocalDate.parse(hoy).withMonth(1), LocalDate.parse(fecha).withDayOfMonth(1));
        int dia = Integer.parseInt(fecha.substring(fecha.length()-2));
        int meses;
        if (hoyDate.after(fechaDate)){
            meses = (int) (diferencia * -1);
            for (int x = 0; x <= meses - 1; x++){
                btnRetrocederMes.click();
            }
        } else {
            meses = (int) diferencia;
            for (int x = 0; x <= meses - 1; x++){
                btnAvanzarMes.click();
            }
        }
        PdfQaNovaReports.addWebReportImage("Seleccion fecha calendario", "Se selecciona fecha: " + fecha + " desde calendario", EstadoPrueba.PASSED, false);
        DriverContext.getDriver().findElement(By.xpath("//div[@id = 'imDPcal']//td[text() = '"+ dia +"']")).click();
    }

    public void clickBtnEnviar(){
        PdfQaNovaReports.addWebReportImage("Ingreso de Datos", "Se ingresan los datos al formulario", EstadoPrueba.PASSED, false);
        btnEnviar.click();
    }

    public void clickBtnReset(){
        btnResetear.click();
    }
}

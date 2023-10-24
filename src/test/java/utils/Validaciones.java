package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;

import java.time.Duration;

public class Validaciones {
    public static void validarObjeto(WebElement webElement, String descripcionElemento){
        WebDriverWait webDriverWait = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(3));
        String identificador;
        try{
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
            identificador = webElement.getAttribute("xpath");
            if (identificador == null){
                identificador = webElement.getAttribute("id");
            }
            System.out.println("Se despliega correctamente el elemento " + descripcionElemento + " , identificador: " + identificador);
            PdfQaNovaReports.addWebReportImage("Validaci\u00f3n Elemento: " +  descripcionElemento, "Se despliega correctamente el elemento: " + descripcionElemento + " , identificador: " + identificador, EstadoPrueba.PASSED,false);
        }catch (Exception e){
            System.out.println("No se Despliega Elemento " + descripcionElemento);
            PdfQaNovaReports.addWebReportImage("Validaci\u00f3n Elemento: " +  descripcionElemento, "No se despliega el elemento: " + descripcionElemento, EstadoPrueba.PASSED,true);

        }
    }
    public static void validarTexto(WebElement webElement, String texto){
        String textoWeb = webElement.getText();
        if (textoWeb.equals(texto)){
            PdfQaNovaReports.addReport("Comparaci\u00f3n Texto", "El texto '"+texto+"' , se encuentra correctamente en la pagina web", EstadoPrueba.PASSED, false);
        } else{
            String letraTexto, letraTextoWeb, diferencia = " ";
            for (int x = 0; x < texto.length(); x++){
                letraTexto = texto.substring(x, x+1);
                letraTextoWeb = textoWeb.substring(x, x+1);
                if (!letraTexto.equals(letraTextoWeb)){
                    System.out.println("Diferencia de textos en el caracter nro "+(x+1)+", en el texto web despliega: '"+letraTextoWeb+"', se esperaba: '"+letraTexto+"'.");
                    diferencia = diferencia + "-En el caracter "+(x+1)+", en el texto web despliega: '"+letraTextoWeb+"', se esperaba: '"+letraTexto+"'." + "\n";
                }
            }
            PdfQaNovaReports.addReport("Comparaci\u00f3n Texto", "El texto '"+texto+"' , es distinto a lo que se encuentra en la pagina web, el cual es '"+textoWeb+"' \n*Las Diferencias son las siguientes:\n"+diferencia, EstadoPrueba.FAILED, false);

        }
    }
}

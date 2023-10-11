package testClass;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import page.CargaInformacion;
import page.Login;

import java.time.Duration;

public class Logeo {
    private Login login;
    private CargaInformacion cargaInformacion;
    WebDriver webDriver;


    public Logeo(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void CasoLogin1(String usuario, String clave){
        login = new Login(webDriver);
        cargaInformacion = new CargaInformacion(webDriver);
        login.ingresarUsuario(usuario);
        login.ingresarClave(clave);
        login.clickBtnIngresar();
        cargaInformacion.recuperarTitulo();
        cargaInformacion.rellenarCampoTexto("hola");
        cargaInformacion.rellenarCampoCorreo("colave@qanova.cl");
        cargaInformacion.rellenarCampoTextArea("Este es un texto");
        cargaInformacion.rellenarFecha("05/10/2023");
        cargaInformacion.rellenarLista("valor 3");
        cargaInformacion.seleccionMultiple("1,3");
        cargaInformacion.seleccionRadioBoton(2);
        cargaInformacion.clickBtnEnviar();
    }
}

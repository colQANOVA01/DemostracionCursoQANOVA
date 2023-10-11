package testClass;


import page.CargaInformacionPDF;
import page.LoginPDF;
import page.MatrizInformacion;
import utils.DriverContext;

import java.text.ParseException;

public class LogeoPDF {
    private LoginPDF loginPDF;
    private CargaInformacionPDF cargaInformacionPDF;
    private MatrizInformacion matrizInformacion;


    public LogeoPDF(){
        DriverContext.getDriver();
    }

    public void CasoLoginPDF(String usuario, String clave) throws ParseException {
        loginPDF = new LoginPDF();
        cargaInformacionPDF = new CargaInformacionPDF();
        matrizInformacion = new MatrizInformacion();
        loginPDF.validarTextoUsuario("Nombre del usuario:");
        loginPDF.ingresarUsuario(usuario);
        loginPDF.ingresarClave(clave);
        loginPDF.clickBtnIngresar();
        cargaInformacionPDF.recuperarTitulo();
        cargaInformacionPDF.rellenarCampoTexto("hola");
        cargaInformacionPDF.rellenarCampoCorreo("colave@qanova.cl");
        cargaInformacionPDF.rellenarCampoTextArea("Este es un texto");
        //cargaInformacionPDF.seleccionarFechaCalendario("2022-03-19");
        cargaInformacionPDF.rellenarFecha("05/10/2023");
        cargaInformacionPDF.rellenarLista("valor 3");
        cargaInformacionPDF.seleccionMultiple("1,3");
        cargaInformacionPDF.seleccionRadioBoton(2);
        cargaInformacionPDF.clickBtnEnviar();
        matrizInformacion.validarDespliegue();
        matrizInformacion.validarTextoTitulo("Matriz de informaci\u00f3n");
        matrizInformacion.escribirFiltro("prueba");
        matrizInformacion.clickBtnFiltrar();
        matrizInformacion.recuperarDatosFiltrados();
    }
}

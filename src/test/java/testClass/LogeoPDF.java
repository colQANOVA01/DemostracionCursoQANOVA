package testClass;


import page.*;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;

import java.io.IOException;
import java.text.ParseException;

public class LogeoPDF {
    private LoginPDF loginPDF;
    private CargaInformacionPDF cargaInformacionPDF;
    private MatrizInformacion matrizInformacion;
    private DescargarArchivos descargarArchivos;
    private CargarArchivos cargarArchivos;
    /*private LeerJson leerJson;*/


    public LogeoPDF(){
        DriverContext.getDriver();
    }

    public void CasoLoginPDF(String usuario, String clave) throws ParseException, IOException {
        loginPDF = new LoginPDF();
        cargaInformacionPDF = new CargaInformacionPDF();
        matrizInformacion = new MatrizInformacion();
        descargarArchivos = new DescargarArchivos();
        cargarArchivos = new CargarArchivos();
        loginPDF.validarTextoUsuario("Nombre del usuario:");
        loginPDF.ingresarUsuario(usuario);
        loginPDF.ingresarClave(clave);
        loginPDF.clickBtnIngresar();
        cargaInformacionPDF.recuperarTitulo();
        //cargaInformacionPDF.rellenarCampoTexto("hola");
        //cargaInformacionPDF.rellenarCampoCorreo("colave@qanova.cl");
        //cargaInformacionPDF.rellenarCampoTextArea("Este es un texto");
        //cargaInformacionPDF.seleccionarFechaCalendario("2022-03-19");
        //cargaInformacionPDF.rellenarFecha("05/10/2023");
        //cargaInformacionPDF.rellenarLista("valor 3");
        //cargaInformacionPDF.seleccionMultiple("1,3");
        //cargaInformacionPDF.seleccionRadioBoton(2);
        //cargaInformacionPDF.clickBtnEnviar();
        //matrizInformacion.validarDespliegue();
        //matrizInformacion.validarTextoTitulo("Matriz de informaci\u00f3n");
        //matrizInformacion.escribirFiltro("prueba");
        //matrizInformacion.clickBtnFiltrar();
        //matrizInformacion.recuperarDatosFiltrados();
        //descargarArchivos.ingresarDescargarArchivos();
        //descargarArchivos.validarDespliegue();
        //descargarArchivos.validarTextoTitulo("Descarga de Archivos");
        //descargarArchivos.descargarPorBoton();
        //descargarArchivos.descargarPorLink();
        //descargarArchivos.descargarPorImagen();
        cargarArchivos.ingresarCargarArchivos();
        cargarArchivos.validarDespliegue();
        cargarArchivos.validarTextoTitulo("Carga de Archivos");
        cargarArchivos.cargarArchivo("Archivo de Prueba.pdf");
        cargarArchivos.clickBtnEnviar();
        PdfQaNovaReports.addReport("Archivo de Carga", "Se ha cargado exitosamente el archivo.", EstadoPrueba.PASSED,false);

    }

    /*public void json() throws IOException {
        LeerJson leerJson = new LeerJson();
        leerJson.recuperarJSON();
    }*/
}

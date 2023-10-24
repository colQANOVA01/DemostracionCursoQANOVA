package testSuite;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import testClass.BusquedaAnimalesGoogle;

public class prueba {
    ChromeDriver webDriver;
    String url = "https://www.google.cl/";

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "driverNavegador/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(url);
    }

    @AfterTest
    public void closeDriver(){
        webDriver.close();
    }

    @Test
    public void buscarPerroGoogle(){
        BusquedaAnimalesGoogle busquedaAnimalesGoogle = new BusquedaAnimalesGoogle();
        busquedaAnimalesGoogle.busquedaPerro(webDriver);
    }
}

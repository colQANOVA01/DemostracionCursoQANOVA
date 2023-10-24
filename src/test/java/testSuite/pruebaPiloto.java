package testSuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import testClass.Logeo;

import java.text.ParseException;

public class pruebaPiloto {
    ChromeDriver webDriver;
    String url = "https://www.qanovagroup.com/piloto";

    @BeforeTest
    public void setUp(){
        System.getProperty("webdriver.chrome.driver","driverNavegador/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(url);
    }
    @AfterTest
    public void closeDriver(){
        //webDriver.close();
    }
    @Test
    public void pruebaLogin() throws ParseException {
        Logeo logeo = new Logeo(webDriver);
        logeo.CasoLogin1("nvivas","qanova");
    }

}

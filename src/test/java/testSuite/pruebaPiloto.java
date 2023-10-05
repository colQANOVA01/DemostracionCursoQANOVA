package testSuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import testClass.Logeo;
public class pruebaPiloto {
    ChromeDriver webDriver;
    String url = "https://www.qanovagroup.com/piloto";

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "driverNavegador/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(url);
    }

    @Test
    public void pruebaLogin(){
        Logeo logeo = new Logeo(webDriver);
        logeo.CasoLogin("nvivas","qanova");
    }
    @AfterTest
    public void closeDriver(){
        webDriver.close();
    }
}

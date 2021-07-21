package testFitbank;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Fitbank {

    private static WebDriver driver = null;

    @BeforeClass
    public static void abrirBrowser(){
        System.setProperty("webdriver.chrome.driver", "/home/ue0100066b/Documentos/Chris/TestingCourse/Extraido/Chrome-Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://10.1.115.64:8380/WEB3/ingreso.html");
    }

    @Test
    public void controlDatosInicio(){
        try {
            driver.findElement(By.xpath("//*[@id='ingreso']/input[1]")).sendKeys("UE0100066B");
            driver.findElement(By.xpath("//*[@id='ingreso']/input[2]")).sendKeys("chris012345");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id='ingreso']/p[2]/input")).click();
            Thread.sleep(3000);


            driver.findElement(By.id("entorno-pt")).sendKeys("04-6003");
            Actions actions = new Actions(driver);
            Thread.sleep(3000);
            actions.moveToElement(driver.findElement(By.id("entorno-pt")));
            actions.sendKeys(Keys.ENTER);
            actions.build().perform();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void cerrarBrowser(){
        System.out.println("Test desde After Class");
        /* Cierra todas las ventanas */
        /*driver.close();*/
    }
}

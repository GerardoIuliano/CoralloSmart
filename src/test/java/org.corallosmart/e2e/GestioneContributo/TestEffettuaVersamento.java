package org.corallosmart.e2e.GestioneContributo;

import org.corallosmart.e2e.SystemTestCase;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestEffettuaVersamento extends SystemTestCase {


    private static WebDriver driver;

    @Before
    public void setup(){
        driver = SystemTestCase.driver;
    }


public void testEffettuaVersamento(){

    driver.get("http://localhost:8080/CoralloSmart/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("graziano.giu@gmail.com");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("root");
    WebElement form = driver.findElement(By.name("loginForm"));
    form.submit();


    driver.get("http://localhost:8080/CoralloSmart/index");
    WebElement sostieniciBtn=driver.findElement(By.name("sostieniciBtn"));
    sostieniciBtn.click();
    WebElement importoField = driver.findElement(By.name("importo"));
    importoField.sendKeys( "20");
    WebElement formSostienici= driver.findElement(By.name("sostieniciform"));
    formSostienici.submit();


    driver.get("http://localhost:8080/CoralloSmart/checkout");
    WebElement nameCard=driver.findElement(By.name("name-on-card"));
    nameCard.sendKeys("Graziano Giuseffi");
    WebElement cardNumber= driver.findElement(By.name("card-number"));
    cardNumber.sendKeys("5333171083897454");
    WebElement expMonth= driver.findElement(By.name("expMonth"));
    expMonth.sendKeys("July (07)");
    WebElement expYear= driver.findElement(By.name("expYear"));
    expYear.sendKeys("2024");
    WebElement cvv= driver.findElement(By.name("card-cvc"));
    cvv.sendKeys("584");
    WebElement paymentForm= driver.findElement(By.id("payment-Form"));
    paymentForm.submit();

    Boolean isOk= driver.getPageSource().contains("Operazione Completata Con Successo");
    Assert.assertTrue(isOk);
}

}

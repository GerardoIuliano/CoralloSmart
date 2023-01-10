package org.corallosmart.e2e.GestioneVoucher;

import org.corallosmart.e2e.SystemTestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestAggiuntaVoucher extends SystemTestCase
{
    private static WebDriver driver;

    @Before
    public void setup() {
        driver = SystemTestCase.driver;
    }

    @Test
    public void testAggiuntaVoucherImportoErrato()
    {
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();

        driver.get("http://localhost:8080/CoralloSmart/aggiungiVoucher");

        WebElement descrizione = driver.findElement(By.name("descrizione"));
        descrizione.sendKeys("giro in barca + cena");
        WebElement importo = driver.findElement(By.name("importo"));
        importo.sendKeys("giro in barca + cena");
        WebElement voucherForm = driver.findElement(By.name("VoucherForm"));
        voucherForm.submit();

        Boolean isOk= driver.getPageSource().contains("Importo inserito non valido! Non inserire caratteri ma solo una cifra compresa tra 5 e 150");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }
}

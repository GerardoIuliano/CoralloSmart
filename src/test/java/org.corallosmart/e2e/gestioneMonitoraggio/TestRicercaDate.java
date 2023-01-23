package org.corallosmart.e2e.gestioneMonitoraggio;

import org.corallosmart.e2e.SystemTestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Attilio Gismondi
 */

public class TestRicercaDate extends SystemTestCase
{
    private static WebDriver driver;

    @Before
    public void setup()
    {
        driver = SystemTestCase.driver;
    }

    /**
     * Controlla che facendo la ricerca senza inserire date nel form venga stampato a schermo il messaggio corretto
     */
    @Test
    public void TC_GM_1_0()
    {
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();

        driver.get("http://localhost:8080/CoralloSmart/monitoraggio");
        WebElement dateForm = driver.findElement(By.id("search-date"));
        dateForm.submit();

        Boolean isOk= driver.getPageSource().contains("Non sono state selezionate date, verranno mostrati tutti i rilevamenti");
        Assert.assertTrue(isOk);
    }

    /**
     * Controlla che inserendo la data iniziale > data odierna senza inserire la data finale nel form
     * venga stampato a schermo il messaggio di errore corretto
     */
    @Test
    public void TC_GM_1_1()
    {
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();

        driver.get("http://localhost:8080/CoralloSmart/monitoraggio");

        WebElement fromDate = driver.findElement(By.name("fromDate"));
        fromDate.sendKeys("01012024");
        WebElement dateForm = driver.findElement(By.id("search-date"));
        dateForm.submit();

        Boolean isOk= driver.getPageSource().contains("Errore! E' stata inserita data iniziale &gt; data odierna");
        Assert.assertTrue(isOk);
    }

    /**
     * Controlla che inserendo la data iniziale senza inserire la data finale nel form venga stampato a schermo il messaggio corretto
     */
    @Test
    public void TC_GM_1_2()
    {
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();

        driver.get("http://localhost:8080/CoralloSmart/monitoraggio");

        WebElement fromDate = driver.findElement(By.name("fromDate"));
        fromDate.sendKeys("01012022");
        WebElement dateForm = driver.findElement(By.id("search-date"));
        dateForm.submit();

        Boolean isOk= driver.getPageSource().contains("Ricerca effettuata con successo!");
        Assert.assertTrue(isOk);
    }
    /**
     * Controlla che inserendo la data iniziale > data finale nel form
     * venga stampato a schermo il messaggio di errore corretto
     */
    @Test
    public void TC_GM_1_3()
    {
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();

        driver.get("http://localhost:8080/CoralloSmart/monitoraggio");

        WebElement fromDate = driver.findElement(By.name("fromDate"));
        fromDate.sendKeys("01012023");
        WebElement toDate = driver.findElement(By.name("toDate"));
        toDate.sendKeys("01012022");
        WebElement dateForm = driver.findElement(By.id("search-date"));
        dateForm.submit();

        Boolean isOk= driver.getPageSource().contains("Errore! E' stata inserita data iniziale &gt; data finale");
        Assert.assertTrue(isOk);
    }

    /**
     * Controlla che inserendo la data iniziale e la data finale nel form
     * venga stampato a schermo il messaggio corretto
     */
    @Test
    public void TC_GM_1_4()
    {
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();

        driver.get("http://localhost:8080/CoralloSmart/monitoraggio");

        WebElement fromDate = driver.findElement(By.name("fromDate"));
        fromDate.sendKeys("01012022");
        WebElement toDate = driver.findElement(By.name("toDate"));
        toDate.sendKeys("01012023");
        WebElement dateForm = driver.findElement(By.id("search-date"));
        dateForm.submit();

        Boolean isOk= driver.getPageSource().contains("Ricerca effettuata con successo!");
        Assert.assertTrue(isOk);
    }

    /**
     * Controlla che inserendo la data finale senza inserire la data iniziale nel form venga stampato a schermo il messaggio corretto
     */
    @Test
    public void TC_GM_1_5()
    {
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();

        driver.get("http://localhost:8080/CoralloSmart/monitoraggio");

        WebElement toDate = driver.findElement(By.name("toDate"));
        toDate.sendKeys("01012023");
        WebElement dateForm = driver.findElement(By.id("search-date"));
        dateForm.submit();

        Boolean isOk= driver.getPageSource().contains("Ricerca effettuata con successo!");
        Assert.assertTrue(isOk);
    }

}

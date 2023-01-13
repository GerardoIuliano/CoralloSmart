package org.corallosmart.e2e.GestioneMonitoraggio;

import org.corallosmart.e2e.SystemTestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestRicercaDate extends SystemTestCase
{
    private static WebDriver driver;

    @Before
    public void setup()
    {
        driver = SystemTestCase.driver;
    }

    @Test
    public void testRicercaDateInizioFine()
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

    @Test
    public void testRicercaDateInizioFineErrato()
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

    @Test
    public void testRicercaDateSenzaDate()
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

    @Test
    public void testRicercaDateDataInizio()
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

    @Test
    public void testRicercaDateDataInizioErrato()
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

        Boolean isOk= driver.getPageSource().contains("Errore! E' stata inserita data iniziale &gt; data finale");
        Assert.assertTrue(isOk);
    }

    @Test
    public void testRicercaDateDataFine()
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

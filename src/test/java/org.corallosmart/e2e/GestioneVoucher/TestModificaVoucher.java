package org.corallosmart.e2e.GestioneVoucher;

import org.corallosmart.e2e.SystemTestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestModificaVoucher extends SystemTestCase {

    private static WebDriver driver;

    @Before
    public void setup(){
        driver = SystemTestCase.driver;
    }


    @Test
    public void testModificaVoucherSuccess(){
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("giu.adi@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("milan");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();


        driver.get("http://localhost:8080/CoralloSmart/gestioneVoucher");
        WebElement descrizione=driver.findElement(By.name("descrizione"));
        descrizione.sendKeys("Giro in barca piu cena a domicilio");
        WebElement importo=driver.findElement(By.name("importo"));
        importo.sendKeys(String.valueOf(45.0));
        WebElement modificaForm = driver.findElement(By.name("modificaForm2"));
        modificaForm.submit();

        Boolean isOk= driver.getPageSource().contains("Modifica effettuata con successo");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }

    @Test
    public void testModificaVoucherDescriptionTooLong(){
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("giu.adi@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("milan");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();


        driver.get("http://localhost:8080/CoralloSmart/gestioneVoucher");
        WebElement descrizione=driver.findElement(By.name("descrizione"));
        descrizione.sendKeys("Giro in barca piu cena a domicilio con annesso spettacolo di parkour in strada");
        WebElement importo=driver.findElement(By.name("importo"));
        importo.sendKeys(String.valueOf(45.0));
        WebElement modificaForm = driver.findElement(By.name("modificaForm2"));
        modificaForm.submit();

        Boolean isOk= driver.getPageSource().contains("Errore, la descrizione deve essere minore di 50 caratteri!");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }

    @Test
    public void testModificaVoucherDescriptionTooSmall(){
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("giu.adi@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("milan");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();


        driver.get("http://localhost:8080/CoralloSmart/gestioneVoucher");
        WebElement descrizione=driver.findElement(By.name("descrizione"));
        descrizione.sendKeys("Giro");
        WebElement importo=driver.findElement(By.name("importo"));
        importo.sendKeys(String.valueOf(45.0));
        WebElement modificaForm = driver.findElement(By.name("modificaForm2"));
        modificaForm.submit();

        Boolean isOk= driver.getPageSource().contains("Errore, la descrizione deve essere almeno di 10 caratteri!");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }

    @Test
    public void testModificaVoucherImportNotOk(){
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("giu.adi@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("milan");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();


        driver.get("http://localhost:8080/CoralloSmart/gestioneVoucher");
        WebElement descrizione=driver.findElement(By.name("descrizione"));
        descrizione.sendKeys("Giro in barca piu cena a domicilio");
        WebElement importo=driver.findElement(By.name("importo"));
        importo.sendKeys("ciao");
        WebElement modificaForm = driver.findElement(By.name("modificaForm2"));
        modificaForm.submit();

        Boolean isOk= driver.getPageSource().contains("Importo non corretto, inserisci un numero!");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }
}

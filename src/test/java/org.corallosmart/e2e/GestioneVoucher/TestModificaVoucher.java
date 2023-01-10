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
    public void test_TC_GV_M_1_0(){
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();


        driver.get("http://localhost:8080/CoralloSmart/gestioneVoucher");
        WebElement descrizione=driver.findElement(By.name("descrizione2"));
        descrizione.sendKeys("Barca");
        WebElement modificaForm = driver.findElement(By.name("modificaForm2"));
        modificaForm.submit();

        Boolean isOk= driver.getPageSource().contains("Errore, la descrizione deve essere almeno di 10 caratteri!");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }

    @Test
    public void test_TC_GV_M_1_1(){
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();


        driver.get("http://localhost:8080/CoralloSmart/gestioneVoucher");
        WebElement descrizione=driver.findElement(By.name("descrizione2"));
        descrizione.sendKeys("12345678910");
        WebElement modificaForm = driver.findElement(By.name("modificaForm2"));
        modificaForm.submit();

        Boolean isOk= driver.getPageSource().contains("Errore, la descrizione non puo contenere numeri!");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }

    @Test
    public void test_TC_GV_M_1_2(){
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();


        driver.get("http://localhost:8080/CoralloSmart/gestioneVoucher");
        WebElement descrizione=driver.findElement(By.name("descrizione2"));
        descrizione.sendKeys("Giro in barca con immersione");
        WebElement modificaForm = driver.findElement(By.name("modificaForm2"));
        modificaForm.submit();

        Boolean isOk= driver.getPageSource().contains("Modifica effettuata con successo");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }

    @Test
    public void test_TC_GV_M_1_3(){
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();

        driver.get("http://localhost:8080/CoralloSmart/gestioneVoucher");
        WebElement descrizione=driver.findElement(By.name("descrizione2"));
        descrizione.sendKeys("Giro in barca con immersione");
        WebElement importo=driver.findElement(By.name("importo2"));
        importo.sendKeys("Cinquanta euro");
        WebElement modificaForm = driver.findElement(By.name("modificaForm2"));
        modificaForm.submit();

        Boolean isOk= driver.getPageSource().contains("Importo non corretto, inserisci un numero!");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }

    @Test
    public void test_TC_GV_M_1_4(){
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();


        driver.get("http://localhost:8080/CoralloSmart/gestioneVoucher");
        WebElement descrizione=driver.findElement(By.name("descrizione2"));
        descrizione.sendKeys("Giro in barca con immersione");
        WebElement importo=driver.findElement(By.name("importo2"));
        importo.sendKeys("200.0");
        WebElement modificaForm = driver.findElement(By.name("modificaForm2"));
        modificaForm.submit();

        Boolean isOk= driver.getPageSource().contains("Errore, l'importo deve essere massimo di 150 euro");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }

    @Test
    public void test_TC_GV_M_1_5(){
        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("ersi.petre@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();


        driver.get("http://localhost:8080/CoralloSmart/gestioneVoucher");
        WebElement descrizione=driver.findElement(By.name("descrizione2"));
        descrizione.sendKeys("Giro in barca con immersione");
        WebElement importo=driver.findElement(By.name("importo2"));
        importo.sendKeys("100.0");
        WebElement modificaForm = driver.findElement(By.name("modificaForm2"));
        modificaForm.submit();

        Boolean isOk= driver.getPageSource().contains("Modifica effettuata con successo");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }
}

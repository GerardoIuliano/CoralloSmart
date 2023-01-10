package org.corallosmart.e2e.gestioneVoucher;

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
    public void testAggiuntaVoucherImportoBasso()
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
        importo.sendKeys("2");
        WebElement voucherForm = driver.findElement(By.name("VoucherForm"));
        voucherForm.submit();

        Boolean isOk= driver.getPageSource().contains("Importo inserito non valido! Inserire un importo maggiore o uguale a 5 e minore o uguale di 150");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }

    @Test
    public void testAggiuntaVoucherImportoAlto()
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
        importo.sendKeys("151");
        WebElement voucherForm = driver.findElement(By.name("VoucherForm"));
        voucherForm.submit();

        Boolean isOk= driver.getPageSource().contains("Importo inserito non valido! Inserire un importo maggiore o uguale a 5 e minore o uguale di 150");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }

    @Test
    public void testAggiuntaVoucherDescrizioneCorta()
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
        descrizione.sendKeys("Cena");
        WebElement importo = driver.findElement(By.name("importo"));
        importo.sendKeys("120");
        WebElement voucherForm = driver.findElement(By.name("VoucherForm"));
        voucherForm.submit();

        Boolean isOk= driver.getPageSource().contains("Descrizione inserita non valida! " +
                "Inserire una descrizione di lunghezza compresa tra i 10 e i 50 caratteri");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }

    @Test
    public void testAggiuntaVoucherDescrizioneLunga()
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
        descrizione.sendKeys("giro in barca + cenagiro in barca + cenagiro in barca + cenagiro in barca + cenagiro in barca" +
                " + cenagiro in barca + cenagiro in barca + cena");
        WebElement importo = driver.findElement(By.name("importo"));
        importo.sendKeys("120");
        WebElement voucherForm = driver.findElement(By.name("VoucherForm"));
        voucherForm.submit();

        Boolean isOk= driver.getPageSource().contains("Descrizione inserita non valida! " +
                "Inserire una descrizione di lunghezza compresa tra i 10 e i 50 caratteri");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
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

    @Test
    public void testAggiuntaVoucherDescrizioneErrata()
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
        descrizione.sendKeys("2313454effsdf4d5645");
        WebElement importo = driver.findElement(By.name("importo"));
        importo.sendKeys("120");
        WebElement voucherForm = driver.findElement(By.name("VoucherForm"));
        voucherForm.submit();

        Boolean isOk= driver.getPageSource().contains("Descrizione inserita non valida! Non inserire numeri solo lettere");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }

    @Test
    public void testAggiuntaVoucherCorretto()
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
        importo.sendKeys("120");
        WebElement voucherForm = driver.findElement(By.name("VoucherForm"));
        voucherForm.submit();

        Boolean isOk= driver.getPageSource().contains("Voucher aggiunto correttamente");
        System.out.println(isOk);
        Assert.assertTrue(isOk);
    }
}

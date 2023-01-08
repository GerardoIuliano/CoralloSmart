package org.corallosmart.e2e.gestioneUtente;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.corallosmart.e2e.SystemTestCase;

public class TestModificaProfilo extends SystemTestCase {
    private static WebDriver driver;

    @Before
    public void setup(){
        driver = SystemTestCase.driver;
    }

    @Test
    public void testModificaProfiloOk(){
        driver.get("http://localhost:8080/CoralloSmart/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");

        WebElement formLogin = driver.findElement(By.name("loginForm"));
        formLogin.submit();

        driver.get("http://localhost:8080/CoralloSmart/modificaProfilo");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("testUsername");

        WebElement formModificaProfilo = driver.findElement(By.name("registrationForm"));
        formModificaProfilo.submit();
        String url = driver.getCurrentUrl();

        Assert.assertEquals(url, "http://localhost:8080/CoralloSmart/checkModificaProfilo");
    }

    @Test
    public void testModificaProfiloUsernameNotOk(){
        driver.get("http://localhost:8080/CoralloSmart/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");

        WebElement formLogin = driver.findElement(By.name("loginForm"));
        formLogin.submit();

        driver.get("http://localhost:8080/CoralloSmart/modificaProfilo");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("b");

        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost:8080/CoralloSmart/modificaProfilo");
    }
}
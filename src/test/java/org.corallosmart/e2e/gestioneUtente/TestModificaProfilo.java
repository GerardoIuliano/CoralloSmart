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
        passwordField.sendKeys("P4ssword");

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
        passwordField.sendKeys("P4ssword");

        WebElement formLogin = driver.findElement(By.name("loginForm"));
        formLogin.submit();

        driver.get("http://localhost:8080/CoralloSmart/modificaProfilo");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("a");

        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost:8080/CoralloSmart/modificaProfilo");
    }

    @Test
    public void testModificaProfiloPasswordNotOk(){
        driver.get("http://localhost:8080/CoralloSmart/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement formLogin = driver.findElement(By.name("loginForm"));
        formLogin.submit();

        driver.get("http://localhost:8080/CoralloSmart/modificaProfilo");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("testUsername");

        passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("password");

        WebElement passwordConfirmField = driver.findElement(By.name("passwordConferma"));
        passwordConfirmField.sendKeys("password");

        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost:8080/CoralloSmart/modificaProfilo");
    }

    @Test
    public void testModificaProfiloPasswordNotEqual(){
        driver.get("http://localhost:8080/CoralloSmart/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement formLogin = driver.findElement(By.name("loginForm"));
        formLogin.submit();

        driver.get("http://localhost:8080/CoralloSmart/modificaProfilo");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("testUsername");

        passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement passwordConfirmField = driver.findElement(By.name("passwordConferma"));
        passwordConfirmField.sendKeys("password");

        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost:8080/CoralloSmart/modificaProfilo");
    }

    @Test
    public void testModificaEmailNotOk(){
        driver.get("http://localhost:8080/CoralloSmart/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement formLogin = driver.findElement(By.name("loginForm"));
        formLogin.submit();

        driver.get("http://localhost:8080/CoralloSmart/modificaProfilo");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("testUsername");

        passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement passwordConfirmField = driver.findElement(By.name("passwordConferma"));
        passwordConfirmField.sendKeys("P4ssword");

        emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi");

        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost:8080/CoralloSmart/modificaProfilo");
    }

    @Test
    public void testModificaNomeNotOk(){
        driver.get("http://localhost:8080/CoralloSmart/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement formLogin = driver.findElement(By.name("loginForm"));
        formLogin.submit();

        driver.get("http://localhost:8080/CoralloSmart/modificaProfilo");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("testUsername");

        passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement passwordConfirmField = driver.findElement(By.name("passwordConferma"));
        passwordConfirmField.sendKeys("P4ssword");

        emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys(" ");

        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost:8080/CoralloSmart/modificaProfilo");
    }

    @Test
    public void testModificaCognomeNotOk(){
        driver.get("http://localhost:8080/CoralloSmart/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement formLogin = driver.findElement(By.name("loginForm"));
        formLogin.submit();

        driver.get("http://localhost:8080/CoralloSmart/modificaProfilo");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("testUsername");

        passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement passwordConfirmField = driver.findElement(By.name("passwordConferma"));
        passwordConfirmField.sendKeys("P4ssword");

        emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("giuseppe");

        WebElement surnameField = driver.findElement(By.name("cognome"));
        surnameField.sendKeys(" ");

        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost:8080/CoralloSmart/modificaProfilo");
    }

    @Test
    public void testModificaCodiceFiscaleNotOk(){
        driver.get("http://localhost:8080/CoralloSmart/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement formLogin = driver.findElement(By.name("loginForm"));
        formLogin.submit();

        driver.get("http://localhost:8080/CoralloSmart/modificaProfilo");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("testUsername");

        passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement passwordConfirmField = driver.findElement(By.name("passwordConferma"));
        passwordConfirmField.sendKeys("P4ssword");

        emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("Giuseppe");

        WebElement surnameField = driver.findElement(By.name("cognome"));
        surnameField.sendKeys("Adinolfi");

        WebElement codiceFiscaleField = driver.findElement(By.name("codiceFiscale"));
        codiceFiscaleField.sendKeys("RSSMRA30A01H501");

        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost:8080/CoralloSmart/modificaProfilo");
    }

    @Test
    public void testModificaTelefonoNotOk(){
        driver.get("http://localhost:8080/CoralloSmart/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement formLogin = driver.findElement(By.name("loginForm"));
        formLogin.submit();

        driver.get("http://localhost:8080/CoralloSmart/modificaProfilo");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("testUsername");

        passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement passwordConfirmField = driver.findElement(By.name("passwordConferma"));
        passwordConfirmField.sendKeys("P4ssword");

        emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("Giuseppe");

        WebElement surnameField = driver.findElement(By.name("cognome"));
        surnameField.sendKeys("Adinolfi");

        WebElement codiceFiscaleField = driver.findElement(By.name("codiceFiscale"));
        codiceFiscaleField.sendKeys("RSSMRA30A01H501I");

        WebElement telefonoField = driver.findElement(By.name("telefono"));
        telefonoField.sendKeys("250555019");

        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost:8080/CoralloSmart/modificaProfilo");
    }

    @Test
    public void testModificaAllOk(){
        driver.get("http://localhost:8080/CoralloSmart/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement formLogin = driver.findElement(By.name("loginForm"));
        formLogin.submit();

        driver.get("http://localhost:8080/CoralloSmart/modificaProfilo");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("testUsername");

        passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("P4ssword");

        WebElement passwordConfirmField = driver.findElement(By.name("passwordConferma"));
        passwordConfirmField.sendKeys("P4ssword");

        emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("giu.adi@gmail.com");

        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("Giuseppe");

        WebElement surnameField = driver.findElement(By.name("cognome"));
        surnameField.sendKeys("Adinolfi");

        WebElement codiceFiscaleField = driver.findElement(By.name("codiceFiscale"));
        codiceFiscaleField.sendKeys("RSSMRA30A01H501I");

        WebElement telefonoField = driver.findElement(By.name("telefono"));
        telefonoField.sendKeys("2505550199");

        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost:8080/CoralloSmart/checkModificaProfilo");
    }
}
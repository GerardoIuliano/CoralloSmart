package org.corallosmart.e2e.gestioneUtente;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.corallosmart.e2e.SystemTestCase;

/**
 * @author Ersilio
 */
public class ModificaProfiloTest extends SystemTestCase {
    private static WebDriver driver;

    @Before
    public void setup(){
        driver = SystemTestCase.driver;
    }

    /**
     * inserisce
     * un username sbagliato
     * e verifica se i controlli impediscono di proseguire con l'operazione
     */
    @Test
    public void test_TC_GU_2_0(){
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

    /**
     * inserisce
     * un username corretto
     * una password sbagliata
     * una password ripetuta corretta
     * e verifica se i controlli impediscono di proseguire con l'operazione
     */
    @Test
    public void test_TC_GU_2_1(){
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

    /**
     * inserisce
     * un username corretto
     * una password corretta
     * una password ripetuta sbagliata
     * e verifica se i controlli impediscono di proseguire con l'operazione
     */
    @Test
    public void test_TC_GU_2_2(){
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

    /**
     * inserisce
     * un username corretto
     * una password corretta
     * una password ripetuta corretta
     * una email sbagliata
     * e verifica se i controlli impediscono di proseguire con l'operazione
     */
    @Test
    public void test_TC_GU_2_3(){
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

    /**
     * inserisce
     * un username corretto
     * una password corretta
     * una password ripetuta corretta
     * una email corretta
     * un nome vuoto
     * e verifica se i controlli impediscono di proseguire con l'operazione
     */
    @Test
    public void test_TC_GU_2_4(){
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

    /**
     * inserisce
     * un username corretto
     * una password corretta
     * una password ripetuta corretta
     * una email corretta
     * un nome corretto
     * un cognome vuoto
     * e verifica se i controlli impediscono di proseguire con l'operazione
     */
    @Test
    public void test_TC_GU_2_5(){
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

    /**
     * inserisce
     * un username corretto
     * una password corretta
     * una password ripetuta corretta
     * una email corretta
     * un nome corretto
     * un cognome corretto
     * un codice fiscale errato
     * e verifica se i controlli impediscono di proseguire con l'operazione
     */
    @Test
    public void test_TC_GU_2_6(){
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

    /**
     * inserisce
     * un username corretto
     * una password corretta
     * una password ripetuta corretta
     * una email corretta
     * un nome corretto
     * un cognome corretto
     * un codice fiscale corretto
     * un numero di telefono errato
     * e verifica se i controlli impediscono di proseguire con l'operazione
     */
    @Test
    public void test_TC_GU_2_7(){
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

    /**
     * inserisce
     * un username corretto
     * una password corretta
     * una password ripetuta corretta
     * una email corretta
     * un nome corretto
     * un cognome corretto
     * un codice fiscale corretto
     * un numero di telefono corretto
     * e verifica se i controlli permettono di proseguire con l'operazione
     */
    @Test
    public void test_TC_GU_2_8(){
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
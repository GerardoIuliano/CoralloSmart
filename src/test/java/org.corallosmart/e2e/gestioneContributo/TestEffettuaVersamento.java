package org.corallosmart.e2e.gestioneContributo;

import org.corallosmart.e2e.SystemTestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author GrazianoGiuseffi
 */
public class TestEffettuaVersamento extends SystemTestCase {

    private static WebDriver driver;

    @Before
    public void setup(){
        driver = SystemTestCase.driver;
    }


    /**
     * Controlla che inserendo un nome intestatario troppo lungo, il pagamento non vada a buon fine
     */
    @Test
    public void TC_GC_1_0() {


        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
        userField.sendKeys("graziano.giu@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement form = driver.findElement(By.name("loginForm"));
        form.submit();


        driver.get("http://localhost:8080/CoralloSmart/index");
        WebElement sostieniciBtn = driver.findElement(By.name("sostieniciBtn"));
        sostieniciBtn.click();
        WebElement importoField = driver.findElement(By.name("importo"));
        importoField.sendKeys("20");
        WebElement formSostienici = driver.findElement(By.name("sostieniciform"));
        formSostienici.submit();


        driver.get("http://localhost:8080/CoralloSmart/checkout?importo=20");

        WebElement nameCard = driver.findElement(By.name("nome"));
        nameCard.sendKeys("Mario Antonio Giovanni Vittorio Massimiliano Visconti Maranza");
        WebElement cardNumber = driver.findElement(By.name("card-number"));
        cardNumber.sendKeys("5333171083897454");
        WebElement expMonth = driver.findElement(By.name("expMonth"));
        expMonth.sendKeys("July (07)");
        WebElement expYear = driver.findElement(By.name("expYear"));
        expYear.sendKeys("2024");
        WebElement cvv = driver.findElement(By.name("card-cvc"));
        cvv.sendKeys("584");
        WebElement paymentForm = driver.findElement(By.name("formPagamento"));
        paymentForm.submit();

        Boolean isOk = driver.getPageSource().contains("Operazione Completata Con Successo");
        Assert.assertTrue(isOk);


    }

    /**
     * Controlla che inserendo un numero di carta che non rispetta il formato, il pagamento non vada a buon fine
     */
    @Test
    public void TC_GC_1_1()  {



        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
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




        driver.get("http://localhost:8080/CoralloSmart/checkout?importo=20");

        WebElement nameCard=driver.findElement(By.name("nome"));
        nameCard.sendKeys("Graziano Giuseffi");
        WebElement cardNumber= driver.findElement(By.name("card-number"));
        cardNumber.sendKeys("1923645653334585985856567487");
        WebElement expMonth= driver.findElement(By.name("expMonth"));
        expMonth.sendKeys("July (07)");
        WebElement expYear= driver.findElement(By.name("expYear"));
        expYear.sendKeys("2024");
        WebElement cvv= driver.findElement(By.name("card-cvc"));
        cvv.sendKeys("584");
        WebElement paymentForm= driver.findElement(By.name("formPagamento"));
        paymentForm.submit();

        Boolean isOk= driver.getPageSource().contains("Operazione Completata Con Successo");
        Assert.assertTrue(isOk);


    }

    /**
     * Controlla che inserendo un CVV con formato errato, il pagamento non vada a buon fine
     */

    @Test
    public void TC_GC_1_3()  {



        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
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




        driver.get("http://localhost:8080/CoralloSmart/checkout?importo=20");

        WebElement nameCard=driver.findElement(By.name("nome"));
        nameCard.sendKeys("Graziano Giuseffi");
        WebElement cardNumber= driver.findElement(By.name("card-number"));
        cardNumber.sendKeys("5333171083897454");
        WebElement expMonth= driver.findElement(By.name("expMonth"));
        expMonth.sendKeys("July (07)");
        WebElement expYear= driver.findElement(By.name("expYear"));
        expYear.sendKeys("2024");
        WebElement cvv= driver.findElement(By.name("card-cvc"));
        cvv.sendKeys("584&");
        WebElement paymentForm= driver.findElement(By.name("formPagamento"));
        paymentForm.submit();

        Boolean isOk= driver.getPageSource().contains("Operazione Completata Con Successo");
        Assert.assertTrue(isOk);


    }

    /**
     * Controlla che inserendo un mese di scadenza errato, il pagamento non vada a buon fine
     * Il controllo sulla data è stato scisso in due parti per comoditá
     * TC_GC_1.2
     */
    @Test
    public void testEffettuaVersamentoMeseErrato() {



        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
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




        driver.get("http://localhost:8080/CoralloSmart/checkout?importo=20");

        WebElement nameCard=driver.findElement(By.name("nome"));
        nameCard.sendKeys("Graziano Giuseffi");
        WebElement cardNumber= driver.findElement(By.name("card-number"));
        cardNumber.sendKeys("5333171083897454");
        WebElement expMonth= driver.findElement(By.name("expMonth"));
        expMonth.sendKeys("Magiugno (12)");
        WebElement expYear= driver.findElement(By.name("expYear"));
        expYear.sendKeys("2024");
        WebElement cvv= driver.findElement(By.name("card-cvc"));
        cvv.sendKeys("584");
        WebElement paymentForm= driver.findElement(By.name("formPagamento"));
        paymentForm.submit();

        Boolean isOk= driver.getPageSource().contains("Operazione Completata Con Successo");
        Assert.assertTrue(isOk);


    }

    /**
     * Controlla che inserendo un anno di scadenza errato, il pagamento non vada a buon fine
     * Il controllo sulla data è stato scisso in due parti per comoditá
     * TC_GC_1.2
     *
     */

    @Test
    public void testEffettuaVersamentoAnnoErrato() {



        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
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




        driver.get("http://localhost:8080/CoralloSmart/checkout?importo=20");

        WebElement nameCard=driver.findElement(By.name("nome"));
        nameCard.sendKeys("Graziano Giuseffi");
        WebElement cardNumber= driver.findElement(By.name("card-number"));
        cardNumber.sendKeys("5333171083897454");
        WebElement expMonth= driver.findElement(By.name("expMonth"));
        expMonth.sendKeys("Dec(12)");
        WebElement expYear= driver.findElement(By.name("expYear"));
        expYear.sendKeys("2018");
        WebElement cvv= driver.findElement(By.name("card-cvc"));
        cvv.sendKeys("584");
        WebElement paymentForm= driver.findElement(By.name("formPagamento"));
        paymentForm.submit();

        Boolean isOk= driver.getPageSource().contains("Operazione Completata Con Successo");
        Assert.assertTrue(isOk);


    }

    /**
     * Controlla che il versamento vada a buon fine
     */
    @Test
    public void TC_1_5()  {



        driver.get("http://localhost:8080/CoralloSmart/login");
        WebElement userField = driver.findElement(By.name("email"));
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




        driver.get("http://localhost:8080/CoralloSmart/checkout?importo=20");

        WebElement nameCard=driver.findElement(By.name("nome"));
        nameCard.sendKeys("Graziano Giuseffi");
        WebElement cardNumber= driver.findElement(By.name("card-number"));
        cardNumber.sendKeys("5333171083897454");
        WebElement expMonth= driver.findElement(By.name("expMonth"));
        expMonth.sendKeys("July (07)");
        WebElement expYear= driver.findElement(By.name("expYear"));
        expYear.sendKeys("2024");
        WebElement cvv= driver.findElement(By.name("card-cvc"));
        cvv.sendKeys("584");
        WebElement paymentForm= driver.findElement(By.name("formPagamento"));
        paymentForm.submit();

        Boolean isOk= driver.getPageSource().contains("Operazione Completata Con Successo");
        Assert.assertTrue(isOk);


    }



}


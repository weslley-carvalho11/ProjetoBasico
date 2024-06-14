package br.ce.weslley.suites;

import br.ce.weslley.core.DriverFactory;
import br.ce.weslley.page.LoginPage;
import br.ce.weslley.test.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTeste.class,
        MovimentacaoTeste.class,
        RemoverMovimentacaoTeste.class,
        SaldoTeste.class,
        ResumoTeste.class
})
public class SuiteTeste {
    private static LoginPage loginPage = new LoginPage();

    @BeforeClass
    public static void reset(){
        loginPage.acessarTela();
        loginPage.setEmail("contato.weslley.carvalho@gmail.com");
        loginPage.setSenha("abelhaAzulTurquesa23");
        loginPage.entrar();

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("reset")));

        loginPage.reset();

        DriverFactory.killDriver();
    }
}

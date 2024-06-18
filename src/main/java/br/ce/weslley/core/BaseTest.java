package br.ce.weslley.core;

import br.ce.weslley.page.AdicionarContaPage;
import br.ce.weslley.page.LoginPage;
import br.ce.weslley.page.MenuPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    private LoginPage loginPage = new LoginPage();

    @Before
    public void iniciar() {
        loginPage.acessarTela();
        loginPage.setEmail("e-mail");
        loginPage.setSenha("senha");
        loginPage.entrar();
    }

    @After
    public void finalizar() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getDriver();
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".png"));

        if (Propriedades.fechar_browser) {
            DriverFactory.killDriver();
        }
    }
}

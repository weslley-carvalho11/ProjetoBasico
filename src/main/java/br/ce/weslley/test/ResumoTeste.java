package br.ce.weslley.test;

import br.ce.weslley.core.BaseTest;
import br.ce.weslley.core.DriverFactory;
import br.ce.weslley.page.MenuPage;
import br.ce.weslley.page.ResumoMensalPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ResumoTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();

    private ResumoMensalPage resumoMensalPage = new ResumoMensalPage();

    @Test
    public void test1RemoverMovimentacao2() {
        menuPage.acessarResumoMensal();
        resumoMensalPage.clicarExcluirApenasPrimeiroRegistro();
        Assert.assertEquals("Movimentação removida com sucesso!", resumoMensalPage.coletarUmaMenssagemDeSucesso());

    }

    @Test
    public void test2ResumoMensal() {
        menuPage.acessarResumoMensal();
        Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());

        resumoMensalPage.selecionarAno("2023");
        resumoMensalPage.buscar();
        List<WebElement> elementosEncontrados = DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
        Assert.assertEquals(0, elementosEncontrados.size());
    }
}

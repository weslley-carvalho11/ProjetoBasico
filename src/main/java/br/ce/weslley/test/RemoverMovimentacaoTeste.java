package br.ce.weslley.test;

import br.ce.weslley.core.BaseTest;
import br.ce.weslley.core.DriverFactory;
import br.ce.weslley.page.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RemoverMovimentacaoTeste extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private ResumoMensalPage resumoMensalPage = new ResumoMensalPage();

    @Test
    public void testExcluirMovimentcao() {
        menuPage.acessarResumoMensal();
        resumoMensalPage.clicarBotaoExcluir("Movimentacao para exclusao");
        Assert.assertEquals("Movimentação removida com sucesso!", resumoMensalPage.coletarUmaMenssagemDeSucesso());
    }
}

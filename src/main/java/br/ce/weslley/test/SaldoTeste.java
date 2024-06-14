package br.ce.weslley.test;

import br.ce.weslley.core.BaseTest;
import br.ce.weslley.core.Propriedades;
import br.ce.weslley.page.HomePage;
import br.ce.weslley.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();

    private HomePage homePage = new HomePage();

    @Test
    public void verificarSaldo(){
        menuPage.acessarHome();
        Assert.assertEquals("534.00", homePage.obterSaldo("Conta para saldo"));
    }
}

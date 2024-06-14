package br.ce.weslley.test;

import br.ce.weslley.core.BaseTest;
import br.ce.weslley.core.Propriedades;
import br.ce.weslley.page.AdicionarContaPage;
import br.ce.weslley.page.ListarContasPage;
import br.ce.weslley.page.MenuPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


public class ContaTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AdicionarContaPage adicionarContaPage = new AdicionarContaPage();
    private ListarContasPage listarConta = new ListarContasPage();

    @Test
    public void test1AdicionarConta() {
        menuPage.acessarTelaAdicionarConta();
        adicionarContaPage.setNome("Conta 1");
        adicionarContaPage.salvar();
        Assert.assertEquals("Conta adicionada com sucesso!", adicionarContaPage.obterMenssagemDeSucesso());
    }

    @Test
    public void test2AlterarConta() {
        menuPage.acessarTelaListarConta();
        listarConta.clicarBotaoEditar("Conta para alterar");
        listarConta.alterarNome("Conta alterada");
        listarConta.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", listarConta.obterMensagemDeSucesso());
    }

    @Test
    public void test3AdicionarContaComMesmoNome() {
        menuPage.acessarTelaAdicionarConta();
        adicionarContaPage.setNome("Conta mesmo nome");
        adicionarContaPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", adicionarContaPage.obterMenssagemDeErro());
    }
}
//Instanciei as classes na Base Test para que toda classe tenha acesso a todas classes, porém, nem todas as classes
//serã usadas em toda classe
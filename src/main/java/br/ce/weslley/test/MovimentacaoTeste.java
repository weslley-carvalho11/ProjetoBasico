package br.ce.weslley.test;

import br.ce.weslley.core.BaseTest;
import br.ce.weslley.core.Propriedades;
import br.ce.weslley.page.CriarMovimentacaoPage;
import br.ce.weslley.page.MenuPage;
import br.ce.weslley.page.ResumoMensalPage;
import br.ce.weslley.utils.DataUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MovimentacaoTeste extends BaseTest {
    private MenuPage menuPage = new MenuPage();

    private CriarMovimentacaoPage movimentacaoPage = new CriarMovimentacaoPage();

    @Test
    public void test1InserirMovimentacao() {
        menuPage.acessarTelaCriarMovimentacao();
        movimentacaoPage.selecionarTipoDeMovimentacao("Despesa");
        movimentacaoPage.setDataDaMovimentacao(DataUtils.obterDataFormatada(new Date()));
        movimentacaoPage.setDataDoPagamento(DataUtils.obterDataFormatada(new Date()));
        movimentacaoPage.setDescricao("Esse é o aluguel de Março");
        movimentacaoPage.setInteressado("Sr. Barriga");
        movimentacaoPage.setValor("850.00");
        movimentacaoPage.selecionarConta("Conta para movimentacoes");
        movimentacaoPage.setPago();
        movimentacaoPage.salvar();
        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemDeSucesso());
    }

    @Test
    public void test2CamposObrigatorios() {
        menuPage.acessarTelaCriarMovimentacao();

        movimentacaoPage.clicarBotaoPorTexto("Salvar");
        List<String> erros = movimentacaoPage.obterErros();


        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório",
                "Data do pagamento é obrigatório",
                "Descrição é obrigatório",
                "Interessado é obrigatório",
                "Valor é obrigatório",
                "Valor deve ser um número"
        )));

        Assert.assertEquals(6, erros.size());

    }

    @Test
    public void test3InserirMovimentoFuturo() {
        menuPage.acessarTelaCriarMovimentacao();

        movimentacaoPage.selecionarTipoDeMovimentacao("Receita");
        Date dataFutura = DataUtils.obterDataComDiferencaDeDias(4);
        movimentacaoPage.setDataDaMovimentacao(DataUtils.obterDataFormatada(dataFutura));
        movimentacaoPage.setDataDoPagamento(DataUtils.obterDataFormatada(dataFutura));
        movimentacaoPage.setDescricao("Isso é um teste.");
        movimentacaoPage.setInteressado("Sr.Barriga");
        movimentacaoPage.setValor("400");
        movimentacaoPage.selecionarConta("Conta para movimentacoes");
        movimentacaoPage.setPago();
        movimentacaoPage.salvar();

        List<String> erros = movimentacaoPage.obterErros();

        Assert.assertTrue(erros.contains(
                "Data da Movimentação deve ser menor ou igual à data atual"
        ));
        Assert.assertEquals(1, erros.size());
    }
}

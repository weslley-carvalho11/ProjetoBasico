package br.ce.weslley.page;

import br.ce.weslley.core.BasePage;
import br.ce.weslley.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CriarMovimentacaoPage extends BasePage {

    public void selecionarTipoDeMovimentacao(String valor) {
        selecionarCombo("tipo", valor);
    }

    public void setDataDaMovimentacao(String data) {
        escrever(By.id("data_transacao"), data);
    }

    public void setDataDoPagamento(String data) {
        escrever(By.id("data_pagamento"), data);
    }

    public void setDescricao(String descricao) {
        escrever(By.id("descricao"), descricao);
    }

    public void setInteressado(String interessado) {
        escrever(By.id("interessado"), interessado);
    }

    public void setValor(String valor) {
        escrever(By.id("valor"), valor);
    }

    public void selecionarConta(String valor) {
        selecionarCombo("conta", valor);
    }

    public void setPago() {
        clicarRadio(By.id("status_pago"));
    }

    public void setPendente() {
        clicarRadio(By.id("status_pendente"));
    }

    public void salvar() {
        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemDeSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public List<String> obterErros() {
        List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@Class='alert alert-danger']//li"));
        List<String> listaErros = new ArrayList<String>();

        for (WebElement erro : erros) {
            listaErros.add(erro.getText());
        }
        return listaErros;
    }
}

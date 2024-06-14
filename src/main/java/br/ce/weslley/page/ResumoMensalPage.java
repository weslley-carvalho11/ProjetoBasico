package br.ce.weslley.page;

import br.ce.weslley.core.BasePage;
import org.openqa.selenium.By;

public class ResumoMensalPage extends BasePage {

    public void selecionarMes(String mes) {
        selecionarCombo("mes", mes);
    }

    public void selecionarAno(String ano) {
        selecionarCombo("ano", ano);
    }


    public void buscar() {
        clicarBotao(By.xpath("//input[@value='Buscar']"));
    }


    public void clicarBotaoExcluir(String valor) {
        obterCelula("Descrição", valor, "Ações", "tabelaExtrato").findElement(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }

    public void clicarExcluirApenasPrimeiroRegistro() {
        clicarBotao(By.xpath("//span[@Class='glyphicon glyphicon-remove-circle']"));
    }

    public String coletarUmaMenssagemDeSucesso() {
        return obterTexto(By.xpath("//div[@Class='alert alert-success']"));
    }
}

package br.ce.weslley.page;

import br.ce.weslley.core.BasePage;
import br.ce.weslley.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListarContasPage extends BasePage {

    public void clicarBotaoEditar(String valor) {
        obterCelula("Conta", valor, "Ações", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }

    public void alterarNome(String novo_nome) {
        escrever(By.id("nome"), novo_nome);
    }

    public void salvar() {
        clicarBotao(By.xpath("//button[.='Salvar']"));
    }

    public String obterMensagemDeSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}

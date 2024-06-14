package br.ce.weslley.page;

import br.ce.weslley.core.BasePage;
import org.openqa.selenium.By;

public class AdicionarContaPage extends BasePage {


    MenuPage menuPage = new MenuPage(); //Adicionado para fazer a inserção de várias contas

    public void setNome(String conta) {
        escrever("nome", conta);
    }

    public void salvar() {
        clicarBotao(By.xpath("//button[.='Salvar']"));
    }

    public String obterMenssagemDeSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public String obterMenssagemDeErro() {
        return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }

    // Extra
    public void adicionarConta(String conta) {
        setNome(conta);
        salvar();
        obterMenssagemDeSucesso();
    }

    public void cadastrarVariasContas(int quantidadeContas) {
        for (int i = 1; i <= quantidadeContas; i++) {
            menuPage.acessarTelaAdicionarConta();
            setNome("Conta " + i);
            salvar();
        }
    }
}

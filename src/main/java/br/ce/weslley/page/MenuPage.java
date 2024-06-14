package br.ce.weslley.page;

import br.ce.weslley.core.BasePage;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {

    public void acessarHome() {
        clicarBotao(By.linkText("Home"));
    }

    public void acessarTelaAdicionarConta() {
        clicarBotao(By.linkText("Contas"));
        clicarBotao(By.linkText("Adicionar"));
    }

    public void acessarTelaListarConta() {
        clicarBotao(By.linkText("Contas"));
        clicarBotao(By.linkText("Listar"));
    }

    public void acessarTelaCriarMovimentacao() {
        clicarBotao(By.linkText("Criar Movimentação"));
    }

    public void acessarResumoMensal() {
        clicarBotao(By.linkText("Resumo Mensal"));
    }
}
//Inicialmente tinha colocado o nome de homepage, porém, a navegação do menu não é exclusiva da tela home
//todas as outras tela tem a mesma navegação.
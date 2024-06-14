package br.ce.weslley.page;

import br.ce.weslley.core.BasePage;
import br.ce.weslley.core.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public void acessarTela(){
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/logout");
    }

    public void setEmail(String email) {
        escrever("email", email);
    }

    public void setSenha(String senha) {
        escrever("senha", senha);
    }

    public void entrar() {
        clicarBotao(By.xpath("//button[.='Entrar']"));
    }

    public void logar(String email, String senha) {
        setEmail(email);
        setSenha(senha);
        entrar();
    }

    public MenuPage testEntrar(String nomeUsuario) {

        Assert.assertEquals("Bem vindo, " + nomeUsuario + "!", obterTexto(By.xpath("//div[@class='alert alert-success']")));
        return new MenuPage();
    }

    public void reset(){
        clicarLink("reset");
    }
}

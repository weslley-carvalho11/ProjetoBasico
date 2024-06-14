package br.ce.weslley.page;

import br.ce.weslley.core.BasePage;

public class HomePage extends BasePage {

    public String obterSaldo(String valor) {
        return obterCelula("Conta", valor, "Saldo", "tabelaSaldo").getText();
    }
}

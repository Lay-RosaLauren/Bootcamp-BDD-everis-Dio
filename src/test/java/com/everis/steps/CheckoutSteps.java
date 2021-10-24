package com.everis.steps;

import com.everis.pages.CarrinhoPage;
import com.everis.pages.CheckoutPage;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class CheckoutSteps {

    @E("^realiza o login usando o email \"(.*)\" e a senha \"(.*)\"$")
    public void realizarLogin(String email, String senha) {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.realizarLogin(email, senha);
    }

    @E("^confirma o endereco de entrega$")
    public void confirmarEndereco() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.confirmarEndereco();
    }

    @E("^escolhe a forma de transporte$")
    public void escolherFormaDeTransporte() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.escolherFormaDeTransporte();
    }

    @Quando("^o pagamento for confirmado$")
    public void realizarPagamento() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.realizarPagamento();
    }

    @Entao("^deve ser apresentado a mensagem \"(.*)\"$")
    public void aMensagemFoiExibidaNaPagina(String mensagem) {
        CheckoutPage checkoutPage = new CheckoutPage();
        Assert.assertTrue("A mensagem \"" + mensagem + "\" deveria ter sido exibida na página",
                checkoutPage.aMensagemFoiExibidaNaPagina(mensagem));
    }
	
}
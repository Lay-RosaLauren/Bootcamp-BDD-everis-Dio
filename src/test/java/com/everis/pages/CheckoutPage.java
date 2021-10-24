package com.everis.pages;

import com.everis.util.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    @FindBy(css = "#email")
    protected WebElement campoEmail;

    @FindBy(css = "#passwd")
    protected WebElement campoSenha;

    @FindBy(css = "#SubmitLogin")
    protected WebElement botaoEntrar;

    @FindBy(name = "processAddress")
    protected WebElement botaoProcessarEndereco;

    @FindBy(css = "#cgv")
    protected WebElement checkboxTermos;

    @FindBy(name = "processCarrier")
    protected WebElement botaoProcessarTransporte;

    @FindBy(css = ".bankwire")
    protected WebElement botaoPagamentoPorTransferenciaBancaria;

    @FindBy(xpath = "//*[text()='I confirm my order']")
    protected WebElement botaoConfirmarPedido;

    public CheckoutPage() {
        PageFactory.initElements(Hooks.getDriver(), this);
    }

    public void realizarLogin(String email, String senha) {
        campoEmail.sendKeys(email);
        campoSenha.sendKeys(senha);
        botaoEntrar.click();
        log("Realizou login");
    }

    public void confirmarEndereco() {
        botaoProcessarEndereco.click();
        log("Confirmou endereço");
    }

    public void escolherFormaDeTransporte() {
        if (!checkboxTermos.isSelected()) {
            checkboxTermos.click();
        }
        botaoProcessarTransporte.click();
        log("Escolheu forma de transporte");
    }

    public void realizarPagamento() {
        botaoPagamentoPorTransferenciaBancaria.click();
        botaoConfirmarPedido.click();
        log("O pagamento foi realizado");
    }

    public boolean aMensagemFoiExibidaNaPagina(String mensagem) {
        WebElement mensagemPedido = driver.findElement(By.cssSelector("p.cheque-indent > strong"));
        boolean aMensagemFoiExibidaNaPagina = mensagem.equals(mensagemPedido.getText());
        if (aMensagemFoiExibidaNaPagina) {
            log("A mensagem esperada foi exibida na página");
            return true;
        }
        logFail("A mensagem " + mensagem + " não foi exibida na página");
        return false;
    }
}

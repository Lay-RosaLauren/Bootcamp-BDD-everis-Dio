package com.everis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.everis.util.Hooks;

public class CarrinhoPage extends BasePage {

	@FindBy(css = ".standard-checkout")
	protected WebElement botaoProsseguir;
	
	public CarrinhoPage() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}
	
	public boolean apresentouProdutoEsperadoNoCarrinho(String nomeProduto) {
		boolean apresentouProdutoEsperadoNoCarrinho = isElementDisplayed(By.xpath("//*[contains(@class,'cart_item')]//a[text()='" + nomeProduto + "']"));
		if (apresentouProdutoEsperadoNoCarrinho) {
			log("Apresentou o produto [" + nomeProduto + "] no carrinho conforme esperado.");
			return true;
		}
		logFail("Deveria ter apresentado o produto [" + nomeProduto + "] no carrinho.");
		return false;
	}

	public boolean oProdutoApresentouQuantidadeEsperada(String nomeProduto, String quantidadeEsperada) {
		WebElement quantidadeProduto = driver.findElement(By.xpath(
				"//*[text()='" + nomeProduto + "']" +
				"//ancestor::*[contains(@class, 'cart_item')]" +
				"//*[contains(@class, 'cart_quantity_input')]"));
		boolean oProdutoApresentouQuantidadeEsperada = quantidadeEsperada.equals(quantidadeProduto.getAttribute("value"));

		if (oProdutoApresentouQuantidadeEsperada) {
			log("Apresentou quantidade do produto conforme esperado.");
			return true;
		}
		logFail("Não apresentou a quantidade do produto esperada");
		return false;
	}

	public void acessarCheckout() {
		botaoProsseguir.click();
		log("Acesso à página de checkout");
	}
}
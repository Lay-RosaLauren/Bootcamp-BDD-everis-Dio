package com.everis.pages;

import com.everis.util.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetalhesProdutoPage extends BasePage {

	@FindBy(xpath = "//*[text()='Add to cart']")
	protected WebElement botaoAdicionarAoCarrinho;

	@FindBy(css = ".icon-plus")
	protected WebElement botaoAumentarQuantidade;

	public DetalhesProdutoPage() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}

	public void adicionarProdutoAoCarrinho(String nomeProduto) {
		WebElement nomeProdutoTela = driver.findElement(By.xpath(".//*[@itemprop='name']/*[contains(text(), '" +
				nomeProduto + "')] | .//*[@itemprop='name'][text()='" + nomeProduto + "']"));
		moveToElement(nomeProdutoTela);
		botaoAdicionarAoCarrinho.click();
		log("Adicionou o produto [" + nomeProduto + "] ao carrinho");
	}

	public void aumentarQuantidadeProduto() {
		botaoAumentarQuantidade.click();
		log("Aumentou a quantidade do produto");
	}
}
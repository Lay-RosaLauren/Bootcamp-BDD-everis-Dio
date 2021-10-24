package com.everis.steps;

import com.everis.pages.DetalhesProdutoPage;
import com.everis.pages.ResultadoPesquisaPage;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;

public class DetalhesProdutoSteps {

	@E("^aumenta a quantidade produto$")
	public void aumentarQuantidadeProduto() {
		DetalhesProdutoPage detalhesProdutoPage = new DetalhesProdutoPage();
		detalhesProdutoPage.aumentarQuantidadeProduto();
	}

}
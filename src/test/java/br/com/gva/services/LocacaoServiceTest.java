package br.com.gva.services;


import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;

import br.com.gva.entidades.Filme;
import br.com.gva.entidades.Locacao;
import br.com.gva.entidades.Usuario;
import br.com.gva.utils.DataUtils;

public class LocacaoServiceTest {

    @Test
	public void teste() {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//verificacao - Troquei o CoreMatchers.assertThat() pela classe MatcherAssert.assertThat(), visto que o anterior está depreciado
		//Fluid Interface usando alguns método de CoreMatcher para deixar a leitura do código masi fluida
		MatcherAssert.assertThat(locacao.getValor(), CoreMatchers.is(5.0));
		MatcherAssert.assertThat(locacao.getValor(), CoreMatchers.is(CoreMatchers.not(6.0)));

		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
    
}
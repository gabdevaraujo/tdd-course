package br.com.gva.services;


import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.com.gva.entidades.Filme;
import br.com.gva.entidades.Locacao;
import br.com.gva.entidades.Usuario;
import br.com.gva.utils.DataUtils;

public class LocacaoServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();

    @Test
	public void teste() {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//Usando o método checkThat() da classe ErrorCollector temos uma pilha de erros, mesmo em um único método
		error.checkThat(locacao.getValor(), CoreMatchers.is(5.0));
		error.checkThat(locacao.getValor(), CoreMatchers.is(CoreMatchers.not(6.0)));

		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), CoreMatchers.is(false));
	}
    
}
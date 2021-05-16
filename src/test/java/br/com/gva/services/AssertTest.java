package br.com.gva.services;

import org.junit.Assert;
import org.junit.Test;

import br.com.gva.entidades.Usuario;

public class AssertTest {

    @Test
    public void test(){
        Assert.assertTrue(true);
        Assert.assertFalse(false);

        Assert.assertEquals(1, 1);

        //Esse tipo de comparação está depreciado.
        //Comparações em valores de ponto flutuante precisam de um delta para parametrizar
        //A quantidade de casas decimais que serão comparadas.
        //Assert.assertEquals(0.51, 0.51);

        //Com o delta 0.01 o teste entende que vai comparar duas casas decimais
        Assert.assertEquals(0.51, 0.51, 0.01);

        //Com o delta 0.001 o teste entende que vai comparar três casas decimais
        Assert.assertEquals(0.512, 0.512, 0.001);

        //Comparação no assertEquals não podem ser feitos entre tipos primitivos e Wrappers diretamente
        //Tem que ser feita a conversão
        int i = 5;
        Integer i2 = 5;
        Assert.assertEquals(i, i2.intValue());

        //Comparação simples de Strings
        Assert.assertEquals("Erro: " + "bola", "bola");

        //Essa comparação vai gerar um false. Para resolver, temos que utilizar os métodos do Wrapper String para isso.
        //Assert.assertEquals("bola", "Bola");
        
        //Usando um método da classe String podemos fazer o teste ignorando o case
        Assert.assertTrue("bola".equalsIgnoreCase("Bola"));

        //Ou ainda, verificar se a String começa com alguma junção de caracteres específicas
        Assert.assertTrue("bola".startsWith("bo"));

        Usuario u1 = new Usuario("Usuario 1");
        Usuario u2 = new Usuario("Usuario 1");

        Assert.assertEquals(u1, u2);


        //Verificar se um objeto é da mesma instancia que o outro
        Assert.assertSame(u1,u2);
        Assert.assertNotSame(u1,u2);

        //Verificar nulo
        Assert.assertNull(u1);

        //Verificar não nulo(Depreciado)
        Assert.assertNotNull(u1);
    }
    
}
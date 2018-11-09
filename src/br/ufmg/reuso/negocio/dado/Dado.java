/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.dado;

/**
 * @author Michael David
 *
 */

import java.util.Random;

public class Dado 
{
	private static Dado instance = null;


	protected Dado() {
		// it is necessary to have a constructor.
	}

	public static Dado getInstance() {
		if(instance == null) {
			instance = new Dado();
		}

		return instance;
	}
		
	public int sortearValor()
	{
		int valorSorteado = 0;
		Random sorteio = new Random();
		valorSorteado = sorteio.nextInt(6)+1;
		return valorSorteado;
	}
	
	public int contarPontos()
	{
		return sortearValor();
	}
}

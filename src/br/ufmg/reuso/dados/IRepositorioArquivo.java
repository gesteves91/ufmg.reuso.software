package br.ufmg.reuso.dados;

import java.util.Properties;

public interface IRepositorioArquivo {
	Properties getArquivoProperties(String nome);
	String[] getNomeArquivosPasta(String nome);
}

package br.com.caelum.eventos.infra;

import static br.com.caelum.eventos.dominio.TempoDeDuracao.LIGHTING_STRING;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import br.com.caelum.eventos.dominio.ListaDePalestras;
import br.com.caelum.eventos.dominio.Palestra;
import br.com.caelum.eventos.dominio.TempoDeDuracao;

public class LeitorDePalestras {

	private final File arquivoDePalestras;
	
	public LeitorDePalestras(File arquivoDePalestras) {
		this.arquivoDePalestras = arquivoDePalestras;
	}

	public ListaDePalestras lerPalestras() throws FileNotFoundException {
		Set<Palestra> ret = new HashSet<>();
		try(Scanner scanner = new Scanner(arquivoDePalestras)){
			while(scanner.hasNextLine()){
				Palestra palestra = lerPalestra(scanner);
				ret.add(palestra);
			}
		}
		return new ListaDePalestras(ret);
	}

	private Palestra lerPalestra(Scanner scanner) {
		String linha = scanner.nextLine();
		int indiceDaDivisaoEntreNomeETempo = linha.lastIndexOf(' ');

		TempoDeDuracao duracao = LIGHTING_STRING.contains(lerTempoDeDuracaoDaPalestra(linha, indiceDaDivisaoEntreNomeETempo + 1, linha.length() - 3))
				? TempoDeDuracao.LIGHTING
				: new TempoDeDuracao(Integer.valueOf(lerTempoDeDuracaoDaPalestra(linha, indiceDaDivisaoEntreNomeETempo + 1, linha.length() - 3)));

		return new Palestra(lerNomeDaPalestra(linha, indiceDaDivisaoEntreNomeETempo, 0), duracao);
	}

	private String lerTempoDeDuracaoDaPalestra(String linha, int i, int i2) {
		return linha.substring(i, i2);
	}

	private String lerNomeDaPalestra(String linha, int indiceDaDivisaoEntreNomeETempo, int i) {
		return lerTempoDeDuracaoDaPalestra(linha, i, indiceDaDivisaoEntreNomeETempo);
	}

}

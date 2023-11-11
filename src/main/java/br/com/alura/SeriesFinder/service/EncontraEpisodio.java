package br.com.alura.SeriesFinder.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import br.com.alura.SeriesFinder.model.DadosTemporadas;
import br.com.alura.SeriesFinder.model.Episodios;

public class EncontraEpisodio {
    Scanner scanner = new Scanner(System.in);
    BuscaSerie buscaSerie = new BuscaSerie();

    public void retornaEpisodioEspecifico(List<DadosTemporadas> temporadas, List<Episodios> episodios) {
        System.out.println("Informe um trecho de titulo de algum episódio desejado");

        var trechoTitulo = scanner.nextLine();
        Optional<Episodios> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
                .findFirst();

        if (episodioBuscado.isPresent()) {
            System.out.println("Episódio encontrado!");
            System.out.println("Temporada: " + episodioBuscado.get().getNumeroTemporadas() +
                    "\nTitulo: " + episodioBuscado.get().getTitulo());
        } else {
            System.out.println("Episódio não encontrado!");
        }
    }
}

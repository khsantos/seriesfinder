package br.com.alura.SeriesFinder.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.SeriesFinder.model.DadosEpisodios;
import br.com.alura.SeriesFinder.model.DadosTemporadas;

public class TemporadaTopEpisodios {

    public void retornaTopEpisodios(List<DadosTemporadas> temporadas) {

        List<DadosEpisodios> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("\nTop 10 episodios");
         dadosEpisodios.stream().filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodios::avaliacao).reversed()).limit(10)
                .map(e -> e.titulo().toUpperCase())
                .forEach(System.out::println);

    }
}

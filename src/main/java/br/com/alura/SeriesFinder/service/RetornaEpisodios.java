package br.com.alura.SeriesFinder.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.SeriesFinder.model.DadosTemporadas;
import br.com.alura.SeriesFinder.model.Episodios;

public class RetornaEpisodios {

    public List<Episodios> retornaTodosEpisodios(List<DadosTemporadas> temporadas) {
        List<Episodios> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodios(t.numeroTemporada(), d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        return episodios;
    }
}

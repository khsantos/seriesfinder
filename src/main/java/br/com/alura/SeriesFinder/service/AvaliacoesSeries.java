package br.com.alura.SeriesFinder.service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.alura.SeriesFinder.model.Episodios;

public class AvaliacoesSeries {
    public void avaliacoesSumario(List<Episodios> episodios) {

        Map<Integer, Double> avaliacoesPorTemporada = episodios.stream().filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(
                        Episodios::getNumeroTemporadas,
                        Collectors.averagingDouble(Episodios::getAvaliacao)));

        System.out.println(avaliacoesPorTemporada);

        DoubleSummaryStatistics est = episodios.stream().filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodios::getAvaliacao));

        System.out.println("Média: " + est.getAverage() + "\nMelhor episódio "
                + est.getMax() + "\nPior episódio: " + est.getMin() + "\nQuantidade episódios: "
                + est.getCount());

    }
}

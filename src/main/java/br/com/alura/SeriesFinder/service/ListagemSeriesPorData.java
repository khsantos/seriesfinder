package br.com.alura.SeriesFinder.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import br.com.alura.SeriesFinder.model.Episodios;

public class ListagemSeriesPorData {
    Scanner scanner = new Scanner(System.in);

    public void listagemSeries(List<Episodios> episodios) {
        System.out.println("A partir de qual ano você deseja ver os episódios?");
        var ano = scanner.nextInt();
        scanner.nextLine();

        LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

        episodios.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
                .forEach(e -> System.out.println("Temporada:" + e.getNumeroTemporadas() +
                        "\nEpisódio: " + e.getTitulo() + "\nData de lançamento: "
                        + e.getDataLancamento().format(formatter)));

    }
}

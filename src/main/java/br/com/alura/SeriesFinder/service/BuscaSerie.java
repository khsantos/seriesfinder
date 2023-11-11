package br.com.alura.SeriesFinder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.SeriesFinder.model.DadosSeries;
import br.com.alura.SeriesFinder.model.DadosTemporadas;

public class BuscaSerie {
    Scanner scanner = new Scanner(System.in);

        private final String ENDERECO = "https://www.omdbapi.com/?t=";
        private final String API_KEY = "&apikey=ce99f97a";
        private ConsumoAPI consumo = new ConsumoAPI();
        private ConverteDados conversor = new ConverteDados();

    public List<DadosTemporadas> retornaSerie(String nomeSerie) {

                var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

                DadosSeries dados = conversor.obterDados(json, DadosSeries.class);
                System.out.println(dados);

                List<DadosTemporadas> temporadas = new ArrayList<>();

                for (int i = 1; i <= dados.totalTemporadas(); i++) {
                        json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
                        DadosTemporadas dadosTemporada = conversor.obterDados(json, DadosTemporadas.class);
                        temporadas.add(dadosTemporada);
                }

                return temporadas;
    }
}

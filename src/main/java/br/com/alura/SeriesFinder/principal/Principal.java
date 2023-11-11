package br.com.alura.SeriesFinder.principal;

import java.util.List;

import java.util.Scanner;

import br.com.alura.SeriesFinder.model.DadosTemporadas;
import br.com.alura.SeriesFinder.model.Episodios;
import br.com.alura.SeriesFinder.service.AvaliacoesSeries;
import br.com.alura.SeriesFinder.service.BuscaSerie;
import br.com.alura.SeriesFinder.service.EncontraEpisodio;
import br.com.alura.SeriesFinder.service.ListagemSeriesPorData;
import br.com.alura.SeriesFinder.service.RetornaEpisodios;
import br.com.alura.SeriesFinder.service.TemporadaTopEpisodios;

public class Principal {
        Scanner scanner = new Scanner(System.in);
        BuscaSerie buscaSerie = new BuscaSerie();
        TemporadaTopEpisodios temporadaTopEpisodios = new TemporadaTopEpisodios();
        RetornaEpisodios retornaEpisodios = new RetornaEpisodios();
        EncontraEpisodio encontraEpisodio = new EncontraEpisodio();
        AvaliacoesSeries avaliacoesSeries = new AvaliacoesSeries();
        ListagemSeriesPorData listagem = new ListagemSeriesPorData();
        String nomeSerie = null;
        int opcao;

        public void exibeMenu() {

                for (int i = 0; i < 100; i++) {
                        if(i > 0) {
                                System.out.println("(1) Escolher outra serie" + "\n(2) Sair");
                                opcao = scanner.nextInt();
                                if(opcao == 2) {
                                        break;
                                }
                        }

                        System.out.println("Digite o nome da série:");
                        nomeSerie = scanner.nextLine();

                        List<DadosTemporadas> temporadas = buscaSerie.retornaSerie(nomeSerie);
                        List<Episodios> episodios = retornaEpisodios.retornaTodosEpisodios(temporadas);
                        
                        while (true) {

                                System.out.println("Selecione alguma opção:" + "\n(1) Mostra Top 10 Episódios" +
                                                "\n(2) Mostra todos os episódios da série" +
                                                "\n(3) Encontra episódio específico da temporada" +
                                                "\n(4) Lista episódios por ano"
                                                + "\n(5) Mostra avaliações da temporada total e de episódios"
                                                + "\n(6) Voltar");

                                Integer opcaoSerie = scanner.nextInt();
                                if (opcaoSerie == 6) {
                                        scanner.nextLine();
                                        break;
                                }

                                switch (opcaoSerie) {
                                        case 1:
                                                temporadaTopEpisodios.retornaTopEpisodios(temporadas);
                                                System.out.println("\n");
                                                break;
                                        case 2:
                                                retornaEpisodios.retornaTodosEpisodios(temporadas);
                                                System.out.println("\n");
                                                break;
                                        case 3:
                                                encontraEpisodio.retornaEpisodioEspecifico(temporadas,
                                                                episodios);
                                                System.out.println("\n");
                                                break;
                                        case 4:
                                                listagem.listagemSeries(episodios);
                                                System.out.println("\n");
                                                break;
                                        case 5:
                                                avaliacoesSeries.avaliacoesSumario(episodios);
                                                System.out.println("\n");
                                                break;
                                        default:
                                                System.out.println("Opção não encontrada.");
                                                break;
                                }
                        }
                }
        }

}

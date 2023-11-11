package br.com.alura.SeriesFinder.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodios {
    private Integer numeroTemporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDate dataLancamento;
    
    public Episodios(Integer temporada, DadosEpisodios dadosEpisodio) {
        this.numeroTemporada = temporada;
        this.titulo = dadosEpisodio.titulo();
        this.numeroEpisodio = dadosEpisodio.numeroEpisodio();

        try {
            this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao());
        } catch (NumberFormatException e) {
            this.avaliacao = 0.0;
        }

        try {
            this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento());
        } catch (DateTimeParseException e) {
            this.dataLancamento = null;
        }
        
    }

    public Integer getNumeroTemporadas() {
        return numeroTemporada;
    }

    public void setNumeroTemporadas(Integer numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return "Episodios Temporada=" + numeroTemporada + ", Titulo=" + titulo + ", Numero do episódio="
                + numeroEpisodio + ", Avaliação=" + avaliacao + ", Data de Lançamento=" + dataLancamento + "";
    }

    
}

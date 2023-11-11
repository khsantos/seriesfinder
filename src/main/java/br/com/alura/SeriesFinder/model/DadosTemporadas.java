package br.com.alura.SeriesFinder.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporadas(@JsonAlias("Season") Integer numeroTemporada, 
                                  @JsonAlias("Episodes") List<DadosEpisodios> episodios) {     
}

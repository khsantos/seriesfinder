package br.com.alura.SeriesFinder.repository;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}

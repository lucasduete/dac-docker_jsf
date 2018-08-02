package io.github.dac.dao;

import io.github.dac.models.Contato;

import java.util.List;

public interface ContatoDaoInterface {

    public boolean salvar(Contato contato);
    public boolean remover(Contato contato);
    public boolean atualizar(Contato contato);
    public List<Contato> listar();
    public List<Contato> listarOrdemAlfabetica();
    public List<Contato> recuperarByNome(String nome);
}
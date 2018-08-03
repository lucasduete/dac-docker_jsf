package io.github.dac.services;

import io.github.dac.dao.ContatoDao;
import io.github.dac.dao.ContatoDaoInterface;
import io.github.dac.models.Contato;

import java.sql.SQLException;
import java.util.List;

public class ContatoService implements ContatoDaoInterface{
    
    private ContatoDao dao;

    public ContatoService() {
        try {
            this.dao = new ContatoDao();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean salvar(Contato contato) {
        return this.dao.salvar(contato);
    }

    @Override
    public boolean remover(Contato contato) {
        return  this.dao.remover(contato);
    }

    @Override
    public boolean atualizar(Contato contato) {
        return this.dao.atualizar(contato);
    }

    @Override
    public List<Contato> listar() {
        return this.dao.listar();
    }

    @Override
    public List<Contato> listarPorLetra(String nome) {
        return this.dao.listarPorLetra(nome);
    }

    @Override
    public List<Contato> recuperarByNome(String nome) {
        return  this.dao.recuperarByNome(nome);
    }

}

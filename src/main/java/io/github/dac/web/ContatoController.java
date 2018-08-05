package io.github.dac.web;

import io.github.dac.models.Contato;
import io.github.dac.services.ContatoService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ContatoController implements Serializable {

    private String busca;
    private String inicial;
    private Contato contato;
    private List<Contato> contatos;
    private ContatoService service;
    private List<Contato> contatosLetra;
    private boolean modoEditando = false;

    @PostConstruct
    public void init() {
        this.contato = new Contato();
        this.contatos = new ArrayList<>();
        this.contatosLetra = new ArrayList<>();
        this.service = new ContatoService();
    }

    public String salvar() {

        this.service.salvar(this.contato);
        this.contato = new Contato();

        return "";
    }

    public String remover(Contato contato) {
        this.service.remover(contato);

        return "";
    }

    public String atualizar() {
        if(this.service.atualizar(contato)) {
            this.modoEditando = false;
            this.contato = new Contato();
        }

        return "";
    }

    public List<Contato> listarTodos() {
        return service.listar();
    }

    public List<Contato> listarPorNome() {
        contatos = this.service.recuperarByNome(busca);
        return contatos;
    }

    public List<Contato> listarPorIncial() {
        contatosLetra = this.service.listarPorLetra(inicial);
        return contatosLetra;

    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
        this.modoEditando = true;
    }

    public boolean isModoEditando() {
        return modoEditando;
    }

    public void setModoEditando(boolean modoEditando) {
        this.modoEditando = modoEditando;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    } 

    public List<Contato> getContatosLetra() {
        return contatosLetra;
    }

    public void setContatosLetra(List<Contato> contatosLetra) {
        this.contatosLetra = contatosLetra;
    }
}

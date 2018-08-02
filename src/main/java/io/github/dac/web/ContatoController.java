package io.github.dac.web;

import io.github.dac.models.Contato;
import io.github.dac.services.ContatoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ContatoController implements Serializable {

    private ContatoService service;
    private Contato contato;
    private boolean modoEditando = false;
    private List<Contato> contatos;
    private String busca;

    @PostConstruct
    public void init() {
        contatos = new ArrayList<>();
    }

    public String salvar() {
        this.service.salvar(contato);

        //limpando
        contato.setNome("");
        contato.setEmail("");
        contato.setTelefone("");
        return "";
    }

    public String remover() {
        this.service.remover(contato);

        return "";
    }

    public String atulizar() {
        this.service.atualizar(contato);

        return "";
    }

    public List<Contato> listarTodos() {
        return service.listar();
    }

    public List<Contato> listarPorNome() {
        contatos = this.service.recuperarByNome(busca);
        return contatos;
    }

    public List<Contato> listarPorIncial(String inicial) {
        return this.service.listarPorLetra(inicial);

    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
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

}

package io.github.dac.web;

import io.github.dac.models.Contato;
import io.github.dac.services.ContatoService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ContatoController {

    private String busca;
    private Contato contato;
    private List<Contato> contatos;
    private ContatoService service;
    private boolean modoEditando = false;

    @PostConstruct
    public void init() {
        this.contato = new Contato();
        this.contatos = new ArrayList<>();
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

    public String atulizar() {
        this.service.atualizar(contato);
        this.modoEditando = false;

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

}

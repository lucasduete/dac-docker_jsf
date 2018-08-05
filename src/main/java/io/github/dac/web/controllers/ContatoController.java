package io.github.dac.web.controllers;

import io.github.dac.models.Contato;
import io.github.dac.services.ContatoService;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class ContatoController implements Serializable {
//as
    //as
    //as
    private String busca;
    private String inicial;
    private String username;
    private String password;

    private Contato contato;

    private ContatoService service;

    private List<Contato> contatos;
    private List<Contato> contatosLetra;

    private boolean loggado;
    private boolean modoEditando;

    @PostConstruct
    public void init() {
        this.contato = new Contato();

        this.service = new ContatoService();

        this.contatos = new ArrayList<>();
        this.contatosLetra = new ArrayList<>();

        this.loggado = false;
        this.modoEditando = false;
    }

    public String salvar() {
        if (loggado) {
            this.service.salvar(this.contato);
            this.contato = new Contato();

            return "";
        } else {

            return "login.xhtml";
        }

    }

    public String remover(Contato contato) {
        if(loggado) {

            this.service.remover(contato);
            return "";
        } else {

            return "index.xhtml";
        }
    }

    public String atualizar() {
        if (loggado) {
            if(this.service.atualizar(contato)) {
                this.modoEditando = false;
                this.contato = new Contato();
            }

            return "";
        } else {

            return "index.xhtml";
        }
    }

    public List<Contato> listarTodos() {
        if (loggado) {

            return service.listar();
        } else {

            return Collections.emptyList();
        }
    }

    public List<Contato> listarPorNome() {
        if (loggado) {

            contatos = this.service.recuperarByNome(busca);
            return contatos;
        } else {

            return Collections.emptyList();
        }
    }

    public List<Contato> listarPorIncial() {
        if (loggado) {

            contatosLetra = this.service.listarPorLetra(inicial);
            return contatosLetra;
        } else {

            return Collections.emptyList();
        }

    }

    public String login() {
        if (this.username.equals("admin") && this.password.equals("admin")) {

            this.loggado = true;
            return "index.xhtml";
        } else {

            this.loggado = false;
            return "login.xhtml";
        }
    }

    public void logout() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        session.invalidate();

        try {
            externalContext.redirect("login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggado() {
        return loggado;
    }

    public void setLoggado(boolean loggado) {
        this.loggado = loggado;
    }
}

package io.github.dac.models;

import java.time.LocalDate;

public class Contato {

    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;

    public Contato() {

    }

    public Contato(String nome, String email, String telefone, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contato contato = (Contato) o;

        if (nome != null ? !nome.equals(contato.nome) : contato.nome != null) return false;
        if (email != null ? !email.equals(contato.email) : contato.email != null) return false;
        if (telefone != null ? !telefone.equals(contato.telefone) : contato.telefone != null) return false;
        return dataNascimento != null ? dataNascimento.equals(contato.dataNascimento) : contato.dataNascimento == null;
    }

    @Override
    public int hashCode() {

        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("Contato{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", telefone='").append(telefone).append('\'');
        sb.append(", dataNascimento=").append(dataNascimento);
        sb.append('}');
        return sb.toString();
    }
}

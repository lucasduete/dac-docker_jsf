package io.github.dac.dao;

import io.github.dac.factories.Conexao;
import io.github.dac.models.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ContatoDao implements ContatoDaoInterface {

    private final Connection conn;

    public ContatoDao() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConnection();
    }

    @Override
    public boolean salvar(Contato contato) {
        String sql = "INSERT INTO Contato(Nome, Email, Telefone, dataNascimento) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getTelefone());
            stmt.setObject(4, contato.getDataNascimento());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remover(Contato contato) {
        String sql = "DELETE FROM Contato WHERE Id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contato.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean atualizar(Contato contato) {
        return false;
    }

    @Override
    public List<Contato> listar() {
        return null;
    }

    @Override
    public List<Contato> listarOrdemAlfabetica() {
        return null;
    }

    @Override
    public List<Contato> recuperarByNome(String nome) {
        return null;
    }

}
